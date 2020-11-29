package org.xtext.miron.scoping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import roqme.metamodel.datatypes.EnumLiteral;
import roqme.metamodel.datatypes.RoqmeModel;
import roqme.metamodel.datatypes.TypedVariable;

import org.xtext.roqme.naming.RoQMEQualifiedName;
import org.xtext.roqme.naming.RoQMEQualifiedName.QualifiedNameTypeEnum;
import org.xtext.roqme.naming.RoQMEQualifiedNameConverter;


/**
 * This class wraps an IResourceDescription object and adds new information that is necessary when building
 * references using the imported namespace.
 * 
 * @author Juan F. Ingles Romero
 *
 */
public class ResourceDescriptionWrapper implements IResourceDescription {

	/**
	 * Wrapped resource description instance.
	 */
	private IResourceDescription resourceDescription;
	
	/**
	 * Imported namespace.
	 */
	private String namespace;
	
	/**
	 * Auxiliary constant.
	 */
	private final Iterable<IEObjectDescription> WITHOUT_RESULTS = new ArrayList<IEObjectDescription>();
	
	/**
	 * Creates an instance passing the object to wrap and the import EObject.
	 * @param resourceDescription instance to be wrapped.
	 */
	public ResourceDescriptionWrapper(IResourceDescription resourceDescription, String alias) {

		this.resourceDescription = resourceDescription;
		
		if(alias != null) {
			namespace = alias;
		}
		else {
			namespace = getImportedNameSpace();
		}
	}
	
	@Override
	public boolean isEmpty() {
		return resourceDescription.isEmpty();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type,
			QualifiedName name, boolean ignoreCase) {

		Iterable<IEObjectDescription> result = WITHOUT_RESULTS;
		
		if(namespace != null) {
			if(name.getFirstSegment().equals(namespace)) {
				result = wrapElements(resourceDescription.getExportedObjects(type, name.skipFirst(1), ignoreCase));
			}
		} 
		else {
			result = resourceDescription.getExportedObjects(type, name, ignoreCase);
		}
		return result;
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(
			EClass type) {

		Iterable<IEObjectDescription> result = null;
		
		if(namespace != null)
			result = wrapElements(resourceDescription.getExportedObjectsByType(type));
		else 
			result = resourceDescription.getExportedObjectsByType(type);
		
		return result;
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(
			EObject object) {

		Iterable<IEObjectDescription> result = null;
		
		if(namespace != null)
			result = wrapElements(resourceDescription.getExportedObjectsByObject(object));
		else 
			result = resourceDescription.getExportedObjectsByObject(object);
		
		return result;
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		
		Iterable<IEObjectDescription> result = null;
		
		if(namespace != null)
			result = wrapElements(resourceDescription.getExportedObjects());
		else 
			result = resourceDescription.getExportedObjects();
		
		return result;
	}

	@Override
	public Iterable<QualifiedName> getImportedNames() {
		return resourceDescription.getImportedNames();
	}

	@Override
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return resourceDescription.getReferenceDescriptions();
	}

	@Override
	public URI getURI() {
		return resourceDescription.getURI();
	}
	
	/**
	 * Auxiliary method for wrapping IObjectDescription instances with EObjectDescriptionWrapper.
	 * @param elements instances to be wrapped.
	 * @return collection of wrapped elements (which are instances of EObjectDescriptionWrapper).
	 */
	protected Iterable<IEObjectDescription> wrapElements(Iterable<IEObjectDescription> elements) {
		
		List<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		Iterator<IEObjectDescription> it = elements.iterator();
		
		while(it.hasNext()) {
			result.add(new EObjectDescriptionWrapper(it.next(), namespace));
		}
		return result;
	}

	/**
	 * This method allows getting the imported namespace.
	 * @return imported namespace.
	 */
	protected String getImportedNameSpace() {
		
		String result = null;
		IEObjectDescription aux;

		Iterator<IEObjectDescription> it 
			= resourceDescription.getExportedObjects().iterator();
	
		boolean found = false;
		
		while(!found && it.hasNext()) {
			aux = it.next();

			if(found=(aux.getEObjectOrProxy() instanceof TypedVariable)) {
				result = ((RoqmeModel)aux.getEObjectOrProxy().eContainer()).getNamespace();
			}
		}
		return (result!=null && !result.isEmpty()) ? result : null;
	}
	
	/**
	 * This class wraps an IEObjectDescription object and adds new information that 
	 * is necessary when building references using the imported namespace.
	 * 
	 * @author Juan F. Ingles Romero
	 *
	 */
	protected class EObjectDescriptionWrapper implements IEObjectDescription {
	
		/**
		 * Wrapped eobject description instance.
		 */
		private IEObjectDescription eobjectDescription;
		
		/**
		 * Imported namespace.
		 */
		private String namespace;
		
		/**
		 * This converter supports the conversion between String and QualifiedNames
		 */
		private IQualifiedNameConverter qualifiedNameConverter;
		
		/**
		 * Creates an instance passing the object to wrap and the imported namespace.
		 * @param eobjectDescription object to wrap.
		 * @param namespace imported namespace.
		 */
		protected EObjectDescriptionWrapper(IEObjectDescription eobjectDescription, String namespace) {
			this.eobjectDescription = eobjectDescription;
			this.qualifiedNameConverter = new RoQMEQualifiedNameConverter();
			this.namespace = namespace;
		}
		
		@Override
		public QualifiedName getName() {
			QualifiedName result = eobjectDescription.getName();

			if(namespace != null) {
				result = qualifiedNameConverter
						.toQualifiedName(namespace)
						.append(result);
			}	
			if(eobjectDescription.getEObjectOrProxy() instanceof EnumLiteral) {
				result = new RoQMEQualifiedName(result, QualifiedNameTypeEnum.LITERAL);
			}
			return result;		
		}
	
		@Override
		public QualifiedName getQualifiedName() {
			QualifiedName result = eobjectDescription.getQualifiedName();

			if(namespace != null) {
				result = qualifiedNameConverter
						.toQualifiedName(namespace)
						.append(result);
			}
			if(eobjectDescription.getEObjectOrProxy() instanceof EnumLiteral) {
				result = new RoQMEQualifiedName(result, QualifiedNameTypeEnum.LITERAL);
			}
			return result;
		}
	
		@Override
		public EObject getEObjectOrProxy() {
			return eobjectDescription.getEObjectOrProxy();
		}
	
		@Override
		public URI getEObjectURI() {
			return eobjectDescription.getEObjectURI();
		}
	
		@Override
		public EClass getEClass() {
			return eobjectDescription.getEClass();
		}
	
		@Override
		public String getUserData(String key) {
			return eobjectDescription.getUserData(key);
		}
	
		@Override
		public String[] getUserDataKeys() {
			return eobjectDescription.getUserDataKeys();
		}
		
		public String toString() {
			return getQualifiedName().toString();
		}	
	}
	
}
