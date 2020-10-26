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
public class Microcoulomb extends AbstractCharge {

	/**
	 * Constructor for Microcoulomb.
	 * @param value
	 */
	public Microcoulomb(double value) {
		super(value, FrequentlyUsedUnits.getMicrocoulomb());
	}

    /**
     * Method Microcoulomb.
     * @param value
     * @param power
     */
    public Microcoulomb(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMicrocoulomb());
    }

	/**
	 * Constructor for Microcoulomb.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Microcoulomb(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMicrocoulomb());
		return result;
	}
	
	public static Microcoulomb add(AbstractCharge quantity1, AbstractCharge quantity2) {
		AbstractCharge preResult = (AbstractCharge) Quantity.add(quantity1, quantity2);
		Microcoulomb result = ChargeHandler.changeToMicrocoulomb(preResult);
		return result;	
	}
	
	public static Microcoulomb substract(AbstractCharge quantity1, AbstractCharge quantity2) {
		AbstractCharge preResult = (AbstractCharge) Quantity.substract(quantity1, quantity2);
		Microcoulomb result = ChargeHandler.changeToMicrocoulomb(preResult);
		return result;
	}

}
