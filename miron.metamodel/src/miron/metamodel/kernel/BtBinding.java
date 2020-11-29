/**
 */
package miron.metamodel.kernel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bt Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.kernel.BtBinding#getXpath <em>Xpath</em>}</li>
 *   <li>{@link miron.metamodel.kernel.BtBinding#getInsertionType <em>Insertion Type</em>}</li>
 *   <li>{@link miron.metamodel.kernel.BtBinding#getTargets <em>Targets</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.kernel.KernelPackage#getBtBinding()
 * @model
 * @generated
 */
public interface BtBinding extends Binding {
	/**
	 * Returns the value of the '<em><b>Xpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xpath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xpath</em>' attribute.
	 * @see #setXpath(String)
	 * @see miron.metamodel.kernel.KernelPackage#getBtBinding_Xpath()
	 * @model
	 * @generated
	 */
	String getXpath();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.BtBinding#getXpath <em>Xpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xpath</em>' attribute.
	 * @see #getXpath()
	 * @generated
	 */
	void setXpath(String value);

	/**
	 * Returns the value of the '<em><b>Insertion Type</b></em>' attribute.
	 * The default value is <code>"IN"</code>.
	 * The literals are from the enumeration {@link miron.metamodel.kernel.InsertionTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insertion Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insertion Type</em>' attribute.
	 * @see miron.metamodel.kernel.InsertionTypeEnum
	 * @see #setInsertionType(InsertionTypeEnum)
	 * @see miron.metamodel.kernel.KernelPackage#getBtBinding_InsertionType()
	 * @model default="IN"
	 * @generated
	 */
	InsertionTypeEnum getInsertionType();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.BtBinding#getInsertionType <em>Insertion Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insertion Type</em>' attribute.
	 * @see miron.metamodel.kernel.InsertionTypeEnum
	 * @see #getInsertionType()
	 * @generated
	 */
	void setInsertionType(InsertionTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see miron.metamodel.kernel.KernelPackage#getBtBinding_Targets()
	 * @model
	 * @generated
	 */
	EList<EObject> getTargets();

} // BtBinding
