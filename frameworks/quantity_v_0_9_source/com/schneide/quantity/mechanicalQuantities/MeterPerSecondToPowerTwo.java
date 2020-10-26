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
import com.schneide.quantity.mechanicalQuantities.handlers.AccelerationHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class MeterPerSecondToPowerTwo extends AbstractAcceleration {

	/**
	 * Constructor for MeterPerSecondToPowerTwo.
	 * @param value
	 */
	public MeterPerSecondToPowerTwo(double value) {
		super(value, FrequentlyUsedUnits.getMeterPerSecondToPowerTwo());
	}

    /**
     * Method MeterPerSecondToPowerTwo.
     * @param value
     * @param power
     */
    public MeterPerSecondToPowerTwo(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMeterPerSecondToPowerTwo());
    }

	/**
	 * Constructor for MeterPerSecondToPowerTwo.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public MeterPerSecondToPowerTwo(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMeterPerSecondToPowerTwo());
		return result;
	}
	
	public static MeterPerSecondToPowerTwo add(AbstractAcceleration quantity1, AbstractAcceleration quantity2) {
		AbstractAcceleration preResult = (AbstractAcceleration) Quantity.add(quantity1, quantity2);
		MeterPerSecondToPowerTwo result = AccelerationHandler.changeToMeterPerSecondToPowerTwo(preResult);
		return result;	
	}
	
	public static MeterPerSecondToPowerTwo substract(AbstractAcceleration quantity1, AbstractAcceleration quantity2) {
		AbstractAcceleration preResult = (AbstractAcceleration) Quantity.substract(quantity1, quantity2);
		MeterPerSecondToPowerTwo result = AccelerationHandler.changeToMeterPerSecondToPowerTwo(preResult);
		return result;
	}

}
