/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.unit;

import com.schneide.quantity.ConversionFactor;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class AtomarDegreeCelsius extends AtomarUnit {

	/**
	 * Constructor for AtomarDegreeCelsius.
	 */
	public AtomarDegreeCelsius() {
		super(new DegreeCelsiusSignature());
	}

	/**
	 * @see com.schneide.quantity.unit.AtomarUnit#getUnitName()
	 */
	public String getUnitName() {
		return "degree Celsius";
	}

	/**
	 * @see com.schneide.quantity.unit.AtomarUnit#getUnitAbbreviation()
	 */
	public String getUnitAbbreviation() {
		return "?C";
	}

	/**
	 * @see com.schneide.quantity.unit.AtomarUnit#getConversionFactorToReferenceUnit()
	 */
	public ConversionFactor getConversionFactorToReferenceUnit() {
		return new ConversionFactor();
	}

}
