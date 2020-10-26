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
public class SquareMeter extends AbstractArea {

	/**
	 * Constructor for SquareMeter.
	 * @param value
	 */
	public SquareMeter(double value) {
		super(value, FrequentlyUsedUnits.getSquareMeter());
	}

    /**
     * Method SquareMeter.
     * @param value
     * @param power
     */
    public SquareMeter(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getSquareMeter());
    }

	/**
	 * Constructor for SquareMeter.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public SquareMeter(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getSquareMeter());
		return result;
	}
	
	public static SquareMeter add(AbstractArea quantity1, AbstractArea quantity2) {
		AbstractArea preResult = (AbstractArea) Quantity.add(quantity1, quantity2);
		SquareMeter result = AreaHandler.changeToSquareMeter(preResult);
		return result;	
	}
	
	public static SquareMeter substract(AbstractArea quantity1, AbstractArea quantity2) {
		AbstractArea preResult = (AbstractArea) Quantity.substract(quantity1, quantity2);
		SquareMeter result = AreaHandler.changeToSquareMeter(preResult);
		return result;
	}

}
