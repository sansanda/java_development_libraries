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
import com.schneide.quantity.mechanicalQuantities.handlers.ForceHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Newton extends AbstractForce {

	/**
	 * Constructor for Newton.
	 * @param value
	 */
	public Newton(double value) {
		super(value, FrequentlyUsedUnits.getNewton());
	}

    /**
     * Method Newton.
     * @param value
     * @param power
     */
    public Newton(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getNewton());
    }

	/**
	 * Constructor for Newton.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Newton(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getNewton());
		return result;
	}
	
	public static Newton add(AbstractForce quantity1, AbstractForce quantity2) {
		AbstractForce preResult = (AbstractForce) Quantity.add(quantity1, quantity2);
		Newton result = ForceHandler.changeToNewton(preResult);
		return result;	
	}
	
	public static Newton substract(AbstractForce quantity1, AbstractForce quantity2) {
		AbstractForce preResult = (AbstractForce) Quantity.substract(quantity1, quantity2);
		Newton result = ForceHandler.changeToNewton(preResult);
		return result;
	}

}
