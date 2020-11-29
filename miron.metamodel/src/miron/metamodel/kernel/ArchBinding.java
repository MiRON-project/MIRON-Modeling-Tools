/**
 */
package miron.metamodel.kernel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arch Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.kernel.ArchBinding#getParameterSetRepository <em>Parameter Set Repository</em>}</li>
 *   <li>{@link miron.metamodel.kernel.ArchBinding#getParameterSet <em>Parameter Set</em>}</li>
 *   <li>{@link miron.metamodel.kernel.ArchBinding#getComponent <em>Component</em>}</li>
 *   <li>{@link miron.metamodel.kernel.ArchBinding#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.kernel.KernelPackage#getArchBinding()
 * @model
 * @generated
 */
public interface ArchBinding extends Binding {
	/**
	 * Returns the value of the '<em><b>Parameter Set Repository</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Set Repository</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Set Repository</em>' attribute.
	 * @see #setParameterSetRepository(String)
	 * @see miron.metamodel.kernel.KernelPackage#getArchBinding_ParameterSetRepository()
	 * @model
	 * @generated
	 */
	String getParameterSetRepository();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.ArchBinding#getParameterSetRepository <em>Parameter Set Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Set Repository</em>' attribute.
	 * @see #getParameterSetRepository()
	 * @generated
	 */
	void setParameterSetRepository(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Set</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Set</em>' attribute.
	 * @see #setParameterSet(String)
	 * @see miron.metamodel.kernel.KernelPackage#getArchBinding_ParameterSet()
	 * @model
	 * @generated
	 */
	String getParameterSet();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.ArchBinding#getParameterSet <em>Parameter Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Set</em>' attribute.
	 * @see #getParameterSet()
	 * @generated
	 */
	void setParameterSet(String value);

	/**
	 * Returns the value of the '<em><b>Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' attribute.
	 * @see #setComponent(String)
	 * @see miron.metamodel.kernel.KernelPackage#getArchBinding_Component()
	 * @model
	 * @generated
	 */
	String getComponent();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.ArchBinding#getComponent <em>Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' attribute.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(String value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' attribute.
	 * @see #setParameter(String)
	 * @see miron.metamodel.kernel.KernelPackage#getArchBinding_Parameter()
	 * @model
	 * @generated
	 */
	String getParameter();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.ArchBinding#getParameter <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' attribute.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(String value);

} // ArchBinding
