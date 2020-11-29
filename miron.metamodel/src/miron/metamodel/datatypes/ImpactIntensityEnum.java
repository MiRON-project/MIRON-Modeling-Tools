/**
 */
package miron.metamodel.datatypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Impact Intensity Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see miron.metamodel.datatypes.DatatypesPackage#getImpactIntensityEnum()
 * @model
 * @generated
 */
public enum ImpactIntensityEnum implements Enumerator {
	/**
	 * The '<em><b>NEGATIVE HIGH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEGATIVE_HIGH_VALUE
	 * @generated
	 * @ordered
	 */
	NEGATIVE_HIGH(0, "NEGATIVE_HIGH", "NEGATIVE_HIGH"),

	/**
	 * The '<em><b>NEGATIVE MEDIUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEGATIVE_MEDIUM_VALUE
	 * @generated
	 * @ordered
	 */
	NEGATIVE_MEDIUM(1, "NEGATIVE_MEDIUM", "NEGATIVE_MEDIUM"),

	/**
	 * The '<em><b>NEGATIVE LOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEGATIVE_LOW_VALUE
	 * @generated
	 * @ordered
	 */
	NEGATIVE_LOW(2, "NEGATIVE_LOW", "NEGATIVE_LOW"),

	/**
	 * The '<em><b>NEUTRAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEUTRAL_VALUE
	 * @generated
	 * @ordered
	 */
	NEUTRAL(3, "NEUTRAL", "NEUTRAL"),

	/**
	 * The '<em><b>POSITIVE LOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSITIVE_LOW_VALUE
	 * @generated
	 * @ordered
	 */
	POSITIVE_LOW(4, "POSITIVE_LOW", "POSITIVE_LOW"),

	/**
	 * The '<em><b>POSITIVE MEDIUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSITIVE_MEDIUM_VALUE
	 * @generated
	 * @ordered
	 */
	POSITIVE_MEDIUM(5, "POSITIVE_MEDIUM", "POSITIVE_MEDIUM"),

	/**
	 * The '<em><b>POSITIVE HIGH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSITIVE_HIGH_VALUE
	 * @generated
	 * @ordered
	 */
	POSITIVE_HIGH(6, "POSITIVE_HIGH", "POSITIVE_HIGH");

	/**
	 * The '<em><b>NEGATIVE HIGH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEGATIVE HIGH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEGATIVE_HIGH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEGATIVE_HIGH_VALUE = 0;

	/**
	 * The '<em><b>NEGATIVE MEDIUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEGATIVE MEDIUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEGATIVE_MEDIUM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEGATIVE_MEDIUM_VALUE = 1;

	/**
	 * The '<em><b>NEGATIVE LOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEGATIVE LOW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEGATIVE_LOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEGATIVE_LOW_VALUE = 2;

	/**
	 * The '<em><b>NEUTRAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEUTRAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEUTRAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEUTRAL_VALUE = 3;

	/**
	 * The '<em><b>POSITIVE LOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POSITIVE LOW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POSITIVE_LOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POSITIVE_LOW_VALUE = 4;

	/**
	 * The '<em><b>POSITIVE MEDIUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POSITIVE MEDIUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POSITIVE_MEDIUM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POSITIVE_MEDIUM_VALUE = 5;

	/**
	 * The '<em><b>POSITIVE HIGH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POSITIVE HIGH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POSITIVE_HIGH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POSITIVE_HIGH_VALUE = 6;

	/**
	 * An array of all the '<em><b>Impact Intensity Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ImpactIntensityEnum[] VALUES_ARRAY =
		new ImpactIntensityEnum[] {
			NEGATIVE_HIGH,
			NEGATIVE_MEDIUM,
			NEGATIVE_LOW,
			NEUTRAL,
			POSITIVE_LOW,
			POSITIVE_MEDIUM,
			POSITIVE_HIGH,
		};

	/**
	 * A public read-only list of all the '<em><b>Impact Intensity Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ImpactIntensityEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Impact Intensity Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImpactIntensityEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImpactIntensityEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Impact Intensity Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImpactIntensityEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImpactIntensityEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Impact Intensity Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImpactIntensityEnum get(int value) {
		switch (value) {
			case NEGATIVE_HIGH_VALUE: return NEGATIVE_HIGH;
			case NEGATIVE_MEDIUM_VALUE: return NEGATIVE_MEDIUM;
			case NEGATIVE_LOW_VALUE: return NEGATIVE_LOW;
			case NEUTRAL_VALUE: return NEUTRAL;
			case POSITIVE_LOW_VALUE: return POSITIVE_LOW;
			case POSITIVE_MEDIUM_VALUE: return POSITIVE_MEDIUM;
			case POSITIVE_HIGH_VALUE: return POSITIVE_HIGH;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ImpactIntensityEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ImpactIntensityEnum
