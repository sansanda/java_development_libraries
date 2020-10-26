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
import com.schneide.quantity.electricalQuantities.handlers.VoltageHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Kilovolt extends AbstractVoltage {

	/**
	 * Constructor for Kilovolt.
	 * @param value
	 */
	public Kilovolt(double value) {
		super(value, FrequentlyUsedUnits.getKilovolt());
	}

    /**
     * Method Kilovolt.
     * @param value
     * @param power
     */
    public Kilovolt(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKilovolt());
    }

	/**
	 * Constructor for Kilovolt.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Kilovolt(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKilovolt());
		return result;
	}
	
	public static Kilovolt add(AbstractVoltage quantity1, AbstractVoltage quantity2) {
		AbstractVoltage preResult = (AbstractVoltage) Quantity.add(quantity1, quantity2);
		Kilovolt result = VoltageHandler.changeToKilovolt(preResult);
		return result;	
	}
	
	public static Kilovolt substract(AbstractVoltage quantity1, AbstractVoltage quantity2) {
		AbstractVoltage preResult = (AbstractVoltage) Quantity.substract(quantity1, quantity2);
		Kilovolt result = VoltageHandler.changeToKilovolt(preResult);
		return result;
	}

}
