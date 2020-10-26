/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.unit;

import java.util.StringTokenizer;

import com.schneide.quantity.WrongUnitException;

/**
 *The class <code>Unit</code> combines an {@link com.schneide.quantity.unit.AtomarUnit} with 
 *the scale and the exponent.  The scale is usally the prefixes for powers of ten like kilo. The exponent
 *is the exponent for the unit like square (^2).
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, 
 * <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */

public class Unit implements Cloneable {
	private static final String SERIALIZING_DELIMITER = "|";
	
	protected int exponent = 1;
	protected int scaleExponent = 0;
	protected AtomarUnit atomarUnit = null;
	
	/**
	 * Standard constructor for Unit.
	 */
	public Unit(AtomarUnit atomarUnit) {
		super();
		this.atomarUnit = atomarUnit;
		this.exponent = 1;
		this.scaleExponent = 0;
	}
	
	/**
	 * Constructor Unit.
	 * @param recreationableString
	 */
	public Unit(String recreationableString) {
		final int GETEXPONENT = 0;
		final int GETSCALEEXPONENT = 1;
		final int GETUNIT = 3;
		final int END = 100;
		
		String atomarUnitClassName = new String();
		StringTokenizer tokenizer = new StringTokenizer(recreationableString, SERIALIZING_DELIMITER);

		try {
			int state = GETEXPONENT;
			while (state < END) {
				switch (state) {
					case GETEXPONENT: 
						this.exponent = Integer.parseInt(tokenizer.nextToken());
						state = GETSCALEEXPONENT;
						break;
					case GETSCALEEXPONENT:
						this.scaleExponent = Integer.parseInt(tokenizer.nextToken());
						state = GETUNIT;
						break;
					case GETUNIT:
						atomarUnitClassName = tokenizer.nextToken();
						Class atomarUnitClass;
						try {
							atomarUnitClass = Class.forName(atomarUnitClassName);
						} catch (ClassNotFoundException e) {
							throw new WrongUnitException("Class " + atomarUnitClassName + " not in CLASSPATH. Couldn't restore Quantity.");
						}
						this.atomarUnit = (AtomarUnit)atomarUnitClass.newInstance();
						state = END;
						break;
				}
			}
		} catch (NumberFormatException e) {
			throw new WrongUnitException("Syntax broken in in stored AbstractQuantity " + recreationableString);
		} catch (InstantiationException e) {
			throw new WrongUnitException("Class " + atomarUnitClassName + " couldn't be initialized.");
		} catch (IllegalAccessException e) {
			throw new WrongUnitException("IllegalAccessException for " + atomarUnitClassName + e.getMessage());
		}
	}

	/**
	 * This constructor allows in addition to an
	 * atomar compoundUnit to set an exponent and a scale exponent.
	 * For example, if you want to create a compoundUnit with
	 * (km)^2 set 
	 * <ul>
	 * <li>atomarUnit to meter, 
	 * <li>exponent to 2 and 
	 * <li>scaleExponent to ScaleUnit.KILO
	 * </ul>
	 * @param atomarUnit
	 * @param exponent
	 * @param scaleExponent
	 */
	public Unit(AtomarUnit atomarUnit, int exponent, int scaleExponent){
		super();
		this.atomarUnit = atomarUnit;
		this.exponent = exponent;
		this.scaleExponent = scaleExponent;
	}
	
	
	/**
	 * Returns the atomarSignature of its atomarUnit
	 * @return AtomarSignature
	 */
	public AtomarSignature getAtomarSignature() {
		return atomarUnit.getAtomarSignature();
	}

	/**
	 * Returns the atomarUnit.
	 * @return AtomarUnit
	 */
	public AtomarUnit getAtomarUnit() {
		return atomarUnit;
	}

	/**
	 * Returns the exponent.
	 * @return int
	 */
	public int getExponent() {
		return exponent;
	}

	/**
	 * Returns the scaleExponent.
	 * @return int
	 */
	public int getScaleExponent() {
		return scaleExponent;
	}

	/**
	 * Sets the exponent.
	 * @param exponent The exponent to set
	 */
	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	/**
	 * Sets the scaleExponent.
	 * @param scaleExponent The scaleExponent to set
	 */
	public void setScaleExponent(int scaleExponent) {
		this.scaleExponent = scaleExponent;
	}
	
	/**
	 * inverts this Unit 
	 */
	public void invert() { 
		 this.exponent *= -1;
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean result = false;
		try {
			Unit object = (Unit) obj;
			if (this.atomarUnit.equals(object.atomarUnit)
					&& this.exponent == object.exponent
					&& this.scaleExponent == object.scaleExponent) {
				result = true;						
			}
		} catch(ClassCastException e) {
			result = false;
		}
		
		return result;
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(" throws CloneNotSupportedException in Unit.clone");
		}
	}
	
	/**
	 * Method toRecreationableString.
	 * @return String returns a string of kind:
	 * <exponent>|<scaleExponent>|<atomarUnit>
	 */
	public String toRecreationableString() {
		String result = new String();
		result += this.exponent;
		result += SERIALIZING_DELIMITER;
		result += this.scaleExponent;
		result += SERIALIZING_DELIMITER;
		result += this.atomarUnit.getClass().getName();
		return result;
	}

}
