/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.miscQuantities;

import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.Quantity;
import com.schneide.quantity.WrongUnitException;
import com.schneide.quantity.miscQuantities.handlers.LuminousIntensityHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Candela extends AbstractLuminousIntensity {

	/**
	 * Constructor for Ampere.
	 * @param value
	 */
	public Candela(double value) {
		super(value, FrequentlyUsedUnits.getCandela());
	}

    /**
     * Method Ampere.
     * @param value
     * @param power
     */
    public Candela(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getCandela());
    }

	/**
	 * Constructor for Ampere.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Candela(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getCandela());
		return result;
	}
	
	public static Candela add(AbstractLuminousIntensity quantity1, AbstractLuminousIntensity quantity2) {
		AbstractLuminousIntensity preResult = (AbstractLuminousIntensity) Quantity.add(quantity1, quantity2);
		Candela result = LuminousIntensityHandler.changeToCandela(preResult);
		return result;	
	}
	
	public static Candela substract(AbstractLuminousIntensity quantity1, AbstractLuminousIntensity quantity2) {
		AbstractLuminousIntensity preResult = (AbstractLuminousIntensity) Quantity.substract(quantity1, quantity2);
		Candela result = LuminousIntensityHandler.changeToCandela(preResult);
		return result;
	}

}
