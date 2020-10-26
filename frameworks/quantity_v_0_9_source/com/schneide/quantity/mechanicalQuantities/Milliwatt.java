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
public class Milliwatt extends AbstractPower {

	/**
	 * Constructor for Milliwatt.
	 * @param value
	 */
	public Milliwatt(double value) {
		super(value, FrequentlyUsedUnits.getMilliwatt());
	}

    /**
     * Method Milliwatt.
     * @param value
     * @param power
     */
    public Milliwatt(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMilliwatt());
    }

	/**
	 * Constructor for Milliwatt.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Milliwatt(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMilliwatt());
		return result;
	}
	
	public static Milliwatt add(AbstractPower quantity1, AbstractPower quantity2) {
		AbstractPower preResult = (AbstractPower) Quantity.add(quantity1, quantity2);
		Milliwatt result = PowerHandler.changeToMilliwatt(preResult);
		return result;	
	}
	
	public static Milliwatt substract(AbstractPower quantity1, AbstractPower quantity2) {
		AbstractPower preResult = (AbstractPower) Quantity.substract(quantity1, quantity2);
		Milliwatt result = PowerHandler.changeToMilliwatt(preResult);
		return result;
	}

}
