/**
 */
package miron.metamodel.datatypes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qo SProfiled Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.datatypes.QoSProfiledValue#getImpacts <em>Impacts</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.datatypes.DatatypesPackage#getQoSProfiledValue()
 * @model abstract="true"
 * @generated
 */
public interface QoSProfiledValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Impacts</b></em>' containment reference list.
	 * The list contents are of type {@link miron.metamodel.datatypes.ImpactOnQuality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Impacts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Impacts</em>' containment reference list.
	 * @see miron.metamodel.datatypes.DatatypesPackage#getQoSProfiledValue_Impacts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImpactOnQuality> getImpacts();

} // QoSProfiledValue
