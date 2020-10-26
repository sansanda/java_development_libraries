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
import com.schneide.quantity.mechanicalQuantities.handlers.LengthHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Millimeter extends AbstractLength {

	/**
	 * Constructor for Millimeter.
	 * @param value
	 */
	public Millimeter(double value) {
		super(value, FrequentlyUsedUnits.getMillimeter());
	}

    /**
     * Method Millimeter.
     * @param value
     * @param power
     */
    public Millimeter(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMillimeter());
    }

	/**
	 * Constructor for Millimeter.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Millimeter(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMillimeter());
		return result;
	}
	
	public static Millimeter add(AbstractLength quantity1, AbstractLength quantity2) {
		AbstractLength preResult = (AbstractLength) Quantity.add(quantity1, quantity2);
		Millimeter result = LengthHandler.changeToMillimeter(preResult);
		return result;	
	}
	
	public static Millimeter substract(AbstractLength quantity1, AbstractLength quantity2) {
		AbstractLength preResult = (AbstractLength) Quantity.substract(quantity1, quantity2);
		Millimeter result = LengthHandler.changeToMillimeter(preResult);
		return result;
	}

}
