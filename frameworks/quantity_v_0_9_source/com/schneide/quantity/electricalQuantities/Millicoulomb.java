/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.electricalQuantities;

import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.Quantity;
import com.schneide.quantity.WrongUnitException;
import com.schneide.quantity.electricalQuantities.handlers.ChargeHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Millicoulomb extends AbstractCharge {

	/**
	 * Constructor for Millicoulomb.
	 * @param value
	 */
	public Millicoulomb(double value) {
		super(value, FrequentlyUsedUnits.getMillicoulomb());
	}

    /**
     * Method Millicoulomb.
     * @param value
     * @param power
     */
    public Millicoulomb(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMillicoulomb());
    }

	/**
	 * Constructor for Millicoulomb.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Millicoulomb(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMillicoulomb());
		return result;
	}
	
	public static Millicoulomb add(AbstractCharge quantity1, AbstractCharge quantity2) {
		AbstractCharge preResult = (AbstractCharge) Quantity.add(quantity1, quantity2);
		Millicoulomb result = ChargeHandler.changeToMillicoulomb(preResult);
		return result;	
	}
	
	public static Millicoulomb substract(AbstractCharge quantity1, AbstractCharge quantity2) {
		AbstractCharge preResult = (AbstractCharge) Quantity.substract(quantity1, quantity2);
		Millicoulomb result = ChargeHandler.changeToMillicoulomb(preResult);
		return result;
	}

}
