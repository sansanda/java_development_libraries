/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.mechanicalQuantities;

import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.Quantity;
import com.schneide.quantity.WrongUnitException;
import com.schneide.quantity.mechanicalQuantities.handlers.DensityHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class KilogramPerCubicmeter extends AbstractDensity {

	/**
	 * Constructor for KilogramPerCubicmeter.
	 * @param value
	 */
	public KilogramPerCubicmeter(double value) {
		super(value, FrequentlyUsedUnits.getKilogramPerCubicmeter());
	}

    /**
     * Method KilogramPerCubicmeter.
     * @param value
     * @param power
     */
    public KilogramPerCubicmeter(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKilogramPerCubicmeter());
    }

	/**
	 * Constructor for KilogramPerCubicmeter.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public KilogramPerCubicmeter(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKilogramPerCubicmeter());
		return result;
	}
	
	public static KilogramPerCubicmeter add(AbstractDensity quantity1, AbstractDensity quantity2) {
		AbstractDensity preResult = (AbstractDensity) Quantity.add(quantity1, quantity2);
		KilogramPerCubicmeter result = DensityHandler.changeToKilogramPerCubicmeter(preResult);
		return result;	
	}
	
	public static KilogramPerCubicmeter substract(AbstractDensity quantity1, AbstractDensity quantity2) {
		AbstractDensity preResult = (AbstractDensity) Quantity.substract(quantity1, quantity2);
		KilogramPerCubicmeter result = DensityHandler.changeToKilogramPerCubicmeter(preResult);
		return result;
	}

}
