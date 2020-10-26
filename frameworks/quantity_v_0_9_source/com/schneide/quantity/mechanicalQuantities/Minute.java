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
public class Minute extends AbstractTime {

	/**
	 * Constructor for Minute.
	 * @param value
	 */
	public Minute(double value) {
		super(value, FrequentlyUsedUnits.getMinute());
	}

    /**
     * Method Minute.
     * @param value
     * @param power
     */
    public Minute(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMinute());
    }

	/**
	 * Constructor for Minute.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Minute(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMinute());
		return result;
	}
	
	public static Minute add(AbstractTime quantity1, AbstractTime quantity2) {
		AbstractTime preResult = (AbstractTime) Quantity.add(quantity1, quantity2);
		Minute result = TimeHandler.changeToMinute(preResult);
		return result;	
	}
	
	public static Minute substract(AbstractTime quantity1, AbstractTime quantity2) {
		AbstractTime preResult = (AbstractTime) Quantity.substract(quantity1, quantity2);
		Minute result = TimeHandler.changeToMinute(preResult);
		return result;
	}

}
