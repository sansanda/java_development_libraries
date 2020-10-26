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
public class Microfarad extends AbstractCapacity {

	/**
	 * Constructor for Microfarad.
	 * @param value
	 */
	public Microfarad(double value) {
		super(value, FrequentlyUsedUnits.getMicrofarad());
	}

    /**
     * Method Microfarad.
     * @param value
     * @param power
     */
    public Microfarad(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMicrofarad());
    }

	/**
	 * Constructor for Microfarad.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Microfarad(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMicrofarad());
		return result;
	}
	
	public static Microfarad add(AbstractCapacity quantity1, AbstractCapacity quantity2) {
		AbstractCapacity preResult = (AbstractCapacity) Quantity.add(quantity1, quantity2);
		Microfarad result = CapacityHandler.changeToMicrofarad(preResult);
		return result;	
	}
	
	public static Microfarad substract(AbstractCapacity quantity1, AbstractCapacity quantity2) {
		AbstractCapacity preResult = (AbstractCapacity) Quantity.substract(quantity1, quantity2);
		Microfarad result = CapacityHandler.changeToMicrofarad(preResult);
		return result;
	}

}
