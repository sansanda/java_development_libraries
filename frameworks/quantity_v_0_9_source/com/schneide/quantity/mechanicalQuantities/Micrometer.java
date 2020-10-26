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
public class Micrometer extends AbstractLength {

	/**
	 * Constructor for Micrometer.
	 * @param value
	 */
	public Micrometer(double value) {
		super(value, FrequentlyUsedUnits.getMicrometer());
	}

    /**
     * Method Micrometer.
     * @param value
     * @param power
     */
    public Micrometer(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMicrometer());
    }

	/**
	 * Constructor for Micrometer.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Micrometer(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMicrometer());
		return result;
	}
	
	public static Micrometer add(AbstractLength quantity1, AbstractLength quantity2) {
		AbstractLength preResult = (AbstractLength) Quantity.add(quantity1, quantity2);
		Micrometer result = LengthHandler.changeToMicrometer(preResult);
		return result;	
	}
	
	public static Micrometer substract(AbstractLength quantity1, AbstractLength quantity2) {
		AbstractLength preResult = (AbstractLength) Quantity.substract(quantity1, quantity2);
		Micrometer result = LengthHandler.changeToMicrometer(preResult);
		return result;
	}

}
