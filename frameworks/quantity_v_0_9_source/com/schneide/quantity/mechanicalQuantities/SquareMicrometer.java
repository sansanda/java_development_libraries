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
import com.schneide.quantity.mechanicalQuantities.handlers.AreaHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class SquareMicrometer extends AbstractArea {

	/**
	 * Constructor for SquareMicrometer.
	 * @param value
	 */
	public SquareMicrometer(double value) {
		super(value, FrequentlyUsedUnits.getSquareMicrometer());
	}

    /**
     * Method SquareMicrometer.
     * @param value
     * @param power
     */
    public SquareMicrometer(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getSquareMicrometer());
    }

	/**
	 * Constructor for SquareMicrometer.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public SquareMicrometer(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getSquareMicrometer());
		return result;
	}
	
	public static SquareMicrometer add(AbstractArea quantity1, AbstractArea quantity2) {
		AbstractArea preResult = (AbstractArea) Quantity.add(quantity1, quantity2);
		SquareMicrometer result = AreaHandler.changeToSquareMicrometer(preResult);
		return result;	
	}
	
	public static SquareMicrometer substract(AbstractArea quantity1, AbstractArea quantity2) {
		AbstractArea preResult = (AbstractArea) Quantity.substract(quantity1, quantity2);
		SquareMicrometer result = AreaHandler.changeToSquareMicrometer(preResult);
		return result;
	}

}
