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
import com.schneide.quantity.mechanicalQuantities.handlers.TimeHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Microsecond extends AbstractTime {

	/**
	 * Constructor for Microsecond.
	 * @param value
	 */
	public Microsecond(double value) {
		super(value, FrequentlyUsedUnits.getMicrosecond());
	}

    /**
     * Method Microsecond.
     * @param value
     * @param power
     */
    public Microsecond(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMicrosecond());
    }

	/**
	 * Constructor for Microsecond.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Microsecond(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMicrosecond());
		return result;
	}
	
	public static Microsecond add(AbstractTime quantity1, AbstractTime quantity2) {
		AbstractTime preResult = (AbstractTime) Quantity.add(quantity1, quantity2);
		Microsecond result = TimeHandler.changeToMicrosecond(preResult);
		return result;	
	}
	
	public static Microsecond substract(AbstractTime quantity1, AbstractTime quantity2) {
		AbstractTime preResult = (AbstractTime) Quantity.substract(quantity1, quantity2);
		Microsecond result = TimeHandler.changeToMicrosecond(preResult);
		return result;
	}

}
