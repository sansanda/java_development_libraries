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
import com.schneide.quantity.mechanicalQuantities.handlers.PowerHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Terawatt extends AbstractPower {

	/**
	 * Constructor for Terawatt.
	 * @param value
	 */
	public Terawatt(double value) {
		super(value, FrequentlyUsedUnits.getTerawatt());
	}

    /**
     * Method Terawatt.
     * @param value
     * @param power
     */
    public Terawatt(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getTerawatt());
    }

	/**
	 * Constructor for Terawatt.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Terawatt(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getTerawatt());
		return result;
	}
	
	public static Terawatt add(AbstractPower quantity1, AbstractPower quantity2) {
		AbstractPower preResult = (AbstractPower) Quantity.add(quantity1, quantity2);
		Terawatt result = PowerHandler.changeToTerawatt(preResult);
		return result;	
	}
	
	public static Terawatt substract(AbstractPower quantity1, AbstractPower quantity2) {
		AbstractPower preResult = (AbstractPower) Quantity.substract(quantity1, quantity2);
		Terawatt result = PowerHandler.changeToTerawatt(preResult);
		return result;
	}

}
