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
public class Kilometer extends AbstractLength {

	/**
	 * Constructor for Kilometer.
	 * @param value
	 */
	public Kilometer(double value) {
		super(value, FrequentlyUsedUnits.getKilometer());
	}

    /**
     * Method Kilometer.
     * @param value
     * @param power
     */
    public Kilometer(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKilometer());
    }

	/**
	 * Constructor for Kilometer.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Kilometer(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKilometer());
		return result;
	}
	
	public static Kilometer add(AbstractLength quantity1, AbstractLength quantity2) {
		AbstractLength preResult = (AbstractLength) Quantity.add(quantity1, quantity2);
		Kilometer result = LengthHandler.changeToKilometer(preResult);
		return result;	
	}
	
	public static Kilometer substract(AbstractLength quantity1, AbstractLength quantity2) {
		AbstractLength preResult = (AbstractLength) Quantity.substract(quantity1, quantity2);
		Kilometer result = LengthHandler.changeToKilometer(preResult);
		return result;
	}

}
