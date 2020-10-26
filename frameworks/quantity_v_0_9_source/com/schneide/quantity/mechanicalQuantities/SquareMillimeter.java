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
public class SquareMillimeter extends AbstractArea {

	/**
	 * Constructor for SquareMillimeter.
	 * @param value
	 */
	public SquareMillimeter(double value) {
		super(value, FrequentlyUsedUnits.getSquareMillimeter());
	}

    /**
     * Method SquareMillimeter.
     * @param value
     * @param power
     */
    public SquareMillimeter(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getSquareMillimeter());
    }

	/**
	 * Constructor for SquareMillimeter.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public SquareMillimeter(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getSquareMillimeter());
		return result;
	}
	
	public static SquareMillimeter add(AbstractArea quantity1, AbstractArea quantity2) {
		AbstractArea preResult = (AbstractArea) Quantity.add(quantity1, quantity2);
		SquareMillimeter result = AreaHandler.changeToSquareMillimeter(preResult);
		return result;	
	}
	
	public static SquareMillimeter substract(AbstractArea quantity1, AbstractArea quantity2) {
		AbstractArea preResult = (AbstractArea) Quantity.substract(quantity1, quantity2);
		SquareMillimeter result = AreaHandler.changeToSquareMillimeter(preResult);
		return result;
	}

}
