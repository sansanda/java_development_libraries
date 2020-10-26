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
public class MeterPerSecond extends AbstractSpeed {

	/**
	 * Constructor for MeterPerSecond.
	 * @param value
	 */
	public MeterPerSecond(double value) {
		super(value, FrequentlyUsedUnits.getMeterPerSecond());
	}

    /**
     * Method MeterPerSecond.
     * @param value
     * @param power
     */
    public MeterPerSecond(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMeterPerSecond());
    }

	/**
	 * Constructor for MeterPerSecond.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public MeterPerSecond(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMeterPerSecond());
		return result;
	}
	
	public static MeterPerSecond add(AbstractSpeed quantity1, AbstractSpeed quantity2) {
		AbstractSpeed preResult = (AbstractSpeed) Quantity.add(quantity1, quantity2);
		MeterPerSecond result = SpeedHandler.changeToMeterPerSecond(preResult);
		return result;	
	}
	
	public static MeterPerSecond substract(AbstractSpeed quantity1, AbstractSpeed quantity2) {
		AbstractSpeed preResult = (AbstractSpeed) Quantity.substract(quantity1, quantity2);
		MeterPerSecond result = SpeedHandler.changeToMeterPerSecond(preResult);
		return result;
	}

}
