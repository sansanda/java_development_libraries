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
import com.schneide.quantity.mechanicalQuantities.handlers.SpeedHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class KilometerPerHour extends AbstractSpeed {

	/**
	 * Constructor for KilometerPerHour.
	 * @param value
	 */
	public KilometerPerHour(double value) {
		super(value, FrequentlyUsedUnits.getKilometerPerHour());
	}

    /**
     * Method KilometerPerHour.
     * @param value
     * @param power
     */
    public KilometerPerHour(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKilometerPerHour());
    }

	/**
	 * Constructor for KilometerPerHour.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public KilometerPerHour(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKilometerPerHour());
		return result;
	}
	
	public static KilometerPerHour add(AbstractSpeed quantity1, AbstractSpeed quantity2) {
		AbstractSpeed preResult = (AbstractSpeed) Quantity.add(quantity1, quantity2);
		KilometerPerHour result = SpeedHandler.changeToKilometerPerHour(preResult);
		return result;	
	}
	
	public static KilometerPerHour substract(AbstractSpeed quantity1, AbstractSpeed quantity2) {
		AbstractSpeed preResult = (AbstractSpeed) Quantity.substract(quantity1, quantity2);
		KilometerPerHour result = SpeedHandler.changeToKilometerPerHour(preResult);
		return result;
	}

}
