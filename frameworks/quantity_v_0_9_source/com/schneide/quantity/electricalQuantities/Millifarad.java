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
import com.schneide.quantity.electricalQuantities.handlers.CapacityHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Millifarad extends AbstractCapacity {

	/**
	 * Constructor for Millifarad.
	 * @param value
	 */
	public Millifarad(double value) {
		super(value, FrequentlyUsedUnits.getMillifarad());
	}

    /**
     * Method Millifarad.
     * @param value
     * @param power
     */
    public Millifarad(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMillifarad());
    }

	/**
	 * Constructor for Millifarad.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Millifarad(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMillifarad());
		return result;
	}
	
	public static Millifarad add(AbstractCapacity quantity1, AbstractCapacity quantity2) {
		AbstractCapacity preResult = (AbstractCapacity) Quantity.add(quantity1, quantity2);
		Millifarad result = CapacityHandler.changeToMillifarad(preResult);
		return result;	
	}
	
	public static Millifarad substract(AbstractCapacity quantity1, AbstractCapacity quantity2) {
		AbstractCapacity preResult = (AbstractCapacity) Quantity.substract(quantity1, quantity2);
		Millifarad result = CapacityHandler.changeToMillifarad(preResult);
		return result;
	}

}
