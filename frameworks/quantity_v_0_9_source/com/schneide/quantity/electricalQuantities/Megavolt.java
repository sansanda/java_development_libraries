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
public class Megavolt extends AbstractVoltage {

	/**
	 * Constructor for Megavolt.
	 * @param value
	 */
	public Megavolt(double value) {
		super(value, FrequentlyUsedUnits.getMegavolt());
	}

    /**
     * Method Megavolt.
     * @param value
     * @param power
     */
    public Megavolt(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMegavolt());
    }

	/**
	 * Constructor for Megavolt.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Megavolt(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMegavolt());
		return result;
	}
	
	public static Megavolt add(AbstractVoltage quantity1, AbstractVoltage quantity2) {
		AbstractVoltage preResult = (AbstractVoltage) Quantity.add(quantity1, quantity2);
		Megavolt result = VoltageHandler.changeToMegavolt(preResult);
		return result;	
	}
	
	public static Megavolt substract(AbstractVoltage quantity1, AbstractVoltage quantity2) {
		AbstractVoltage preResult = (AbstractVoltage) Quantity.substract(quantity1, quantity2);
		Megavolt result = VoltageHandler.changeToMegavolt(preResult);
		return result;
	}

}
