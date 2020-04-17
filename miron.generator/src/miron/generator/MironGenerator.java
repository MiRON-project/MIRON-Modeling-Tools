package miron.generator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;
import org.xtext.behaviortree.BehaviorTreeStandaloneSetup;
import org.xtext.miron.MIRoNStandaloneSetup;
import com.google.inject.Injector;

import miron.generator.tools.MironBtWeaver;
import miron.generator.tools.MironXpathResolver;
import miron.metamodel.datatypes.MironModel;
import miron.editor.ui.internal.EditorActivator;


public class MironGenerator {
	
	public static final MironGenerator INSTANCE = new MironGenerator();
	
	private final String MIRON_FILE_EXT = "miron";
	private final String BT_FILE_EXT = "bt";
	
	private final Injector INJECTOR;// = EditorActivator.getInstance().getInjector(
			//EditorActivator.ORG_XTEXT_MIRON_MIRON);
	
	private MironGenerator() {
		MIRoNStandaloneSetup.doSetup();
		INJECTOR = new BehaviorTreeStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	public void resolveXpathRef(IFile selectedFile) {
	
		if(selectedFile.getFileExtension().equalsIgnoreCase(MIRON_FILE_EXT)) {
			
			String selectedFilePath = selectedFile.getLocationURI().toString();
			
			XtextResourceSet resourceSet = INJECTOR.getInstance(XtextResourceSet.class);
			resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
			
			Resource mironResource = resourceSet.getResource(
				    URI.createURI(selectedFilePath), true);
				
			MironModel mironModel = (MironModel) mironResource.getContents().get(0);
			MironXpathResolver resolver = new MironXpathResolver();
			
			//.process() //TODO
		}
	}
	
	public void generateBehaviorTree(IFile selectedFile) {

		if(selectedFile.getFileExtension().equalsIgnoreCase(MIRON_FILE_EXT)) {
		
			String selectedFilePath = selectedFile.getLocationURI().toString();
			
			IFolder outputFolder = createFolder("output", selectedFile.getProject());
			IFile outputFile = outputFolder.getFile(selectedFile.getName() + "." + BT_FILE_EXT);
			
			XtextResourceSet resourceSet = INJECTOR.getInstance(XtextResourceSet.class);
			//resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
			
			/*Resource res1 = resourceSet.getResource(
				    URI.createURI("file:/Users/jfingles/Documents/RoQME/workspace/runtime-EclipseXtext/test/base.bt"), true);
			
			Resource res2 = resourceSet.getResource(
				    URI.createURI("file:/Users/jfingles/Documents/RoQME/workspace/runtime-EclipseXtext/test/variants.bt"), true);*/
			
			Resource mironResource = resourceSet.getResource(
				    URI.createURI(selectedFilePath), true);
			
			EcoreUtil.resolveAll(mironResource);
			
			MironModel mironModel = (MironModel) mironResource.getContents().get(0);
			
			
			/*
			ISerializer serializer = INJECTOR.getInstance(ISerializer.class);
			
			String extendedBtCode = serializer.serialize(
					(EObject) (new MironBtWeaver().process(mironModel)));

			InputStream source = new ByteArrayInputStream(
					extendedBtCode.getBytes(Charset.forName("UTF8")));
			
			try {
				if(outputFile.exists()) {
					outputFile.setCharset("UTF8", null);
					outputFile.setContents(source, true, false, null);
				}
				else {
					outputFile.create(source, true, null);
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			*/
			
			
			Resource outputBtResource = resourceSet.createResource(
					URI.createURI(outputFile.getLocationURI().toString()));
			
			outputBtResource.getContents()
					.add((new MironBtWeaver()).process(mironModel));
			
			try {
				outputBtResource.save(new HashMap<Object, Object>());
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
			
			refresh(outputFolder);
			openFileInEditor(outputFolder, outputFile.getName());
			
		}
	}	
	
	private IFolder createFolder(String name, IResource destination) {
		IFolder folder = null;
		
		try {
			IProgressMonitor progressMonitor = new NullProgressMonitor();

			if(destination != null) {
				if(destination.getType() == IFolder.FOLDER) {
					folder = ((IFolder)destination).getFolder(name);
				}
				else if(destination.getType() == IProject.PROJECT) {
					folder = ((IProject)destination).getFolder(name);
				}

				if(folder != null && !folder.exists()) {
					folder.create(true, true, progressMonitor);
				}
				//folder.setDerived(true, progressMonitor);
			}
		} 
		catch (CoreException e) {
			e.printStackTrace();
		}
		return folder;
	}
	
	private void refresh(IResource resource) {
		
		IResource resToUpdate = resource != null ? resource 
				: ResourcesPlugin.getWorkspace().getRoot();

		try {
			// If the resource is a project, we close and open it because
			// sometimes it is not enough refreshing it
			if(resToUpdate instanceof IProject) {
				IProgressMonitor monitor = new NullProgressMonitor();
				((IProject) resToUpdate).close(monitor);
				((IProject) resToUpdate).open(monitor);
			}
			resToUpdate.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} 
		catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	private void openFileInEditor(IResource resource, String fileName) {
	
		IResource resourceToOpen = resource.getType() == IResource.PROJECT ? 
				((IProject) resource).findMember(fileName) :
				resource.getType() == IResource.FOLDER ?
				((IFolder) resource).findMember(fileName) : null;

		if(resourceToOpen != null && resourceToOpen.getType() == IResource.FILE) {
			IFile fileToOpen = (IFile) resourceToOpen;
			
			// Get the active page
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			
			// Figure out the default editor for the file type based on extension
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(fileToOpen.getName());
		
			if(desc != null) {
				try {
					page.openEditor(new FileEditorInput(fileToOpen), desc.getId());
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
