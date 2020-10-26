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
import com.schneide.quantity.electricalQuantities.handlers.CurrentHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Microampere extends AbstractCurrent {

	/**
	 * Constructor for Microampere.
	 * @param value
	 */
	public Microampere(double value) {
		super(value, FrequentlyUsedUnits.getMicroampere());
	}

    /**
     * Method Microampere.
     * @param value
     * @param power
     */
    public Microampere(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMicroampere());
    }

	/**
	 * Constructor for Microampere.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Microampere(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMicroampere());
		return result;
	}
	
	public static Microampere add(AbstractCurrent quantity1, AbstractCurrent quantity2) {
		AbstractCurrent preResult = (AbstractCurrent) Quantity.add(quantity1, quantity2);
		Microampere result = CurrentHandler.changeToMicroampere(preResult);
		return result;	
	}
	
	public static Microampere substract(AbstractCurrent quantity1, AbstractCurrent quantity2) {
		AbstractCurrent preResult = (AbstractCurrent) Quantity.substract(quantity1, quantity2);
		Microampere result = CurrentHandler.changeToMicroampere(preResult);
		return result;
	}

}
