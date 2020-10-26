/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.electricalQuantities;

import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.Quantity;
import com.schneide.quantity.WrongUnitException;
import com.schneide.quantity.electricalQuantities.handlers.CurrentDensityHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class AmperePerSquareMeter extends AbstractCurrentDensity {

	/**
	 * Constructor for AmperePerSquareMeter.
	 * @param value
	 */
	public AmperePerSquareMeter(double value) {
		super(value, FrequentlyUsedUnits.getAmperePerSquareMeter());
	}

    /**
     * Method AmperePerSquareMeter.
     * @param value
     * @param power
     */
    public AmperePerSquareMeter(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getAmperePerSquareMeter());
    }

	/**
	 * Constructor for AmperePerSquareMeter.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public AmperePerSquareMeter(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getAmperePerSquareMeter());
		return result;
	}
	
	public static AmperePerSquareMeter add(AbstractCurrentDensity quantity1, AbstractCurrentDensity quantity2) {
		AbstractCurrentDensity preResult = (AbstractCurrentDensity) Quantity.add(quantity1, quantity2);
		AmperePerSquareMeter result = CurrentDensityHandler.changeToAmperePerSquareMeter(preResult);
		return result;	
	}
	
	public static AmperePerSquareMeter substract(AbstractCurrentDensity quantity1, AbstractCurrentDensity quantity2) {
		AbstractCurrentDensity preResult = (AbstractCurrentDensity) Quantity.substract(quantity1, quantity2);
		AmperePerSquareMeter result = CurrentDensityHandler.changeToAmperePerSquareMeter(preResult);
		return result;
	}

}
