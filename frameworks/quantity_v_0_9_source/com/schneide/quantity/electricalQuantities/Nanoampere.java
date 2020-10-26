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
public class Nanoampere extends AbstractCurrent {

	/**
	 * Constructor for Nanoampere.
	 * @param value
	 */
	public Nanoampere(double value) {
		super(value, FrequentlyUsedUnits.getNanoampere());
	}

    /**
     * Method Nanoampere.
     * @param value
     * @param power
     */
    public Nanoampere(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getNanoampere());
    }

	/**
	 * Constructor for Nanoampere.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Nanoampere(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getNanoampere());
		return result;
	}
	
	public static Nanoampere add(AbstractCurrent quantity1, AbstractCurrent quantity2) {
		AbstractCurrent preResult = (AbstractCurrent) Quantity.add(quantity1, quantity2);
		Nanoampere result = CurrentHandler.changeToNanoampere(preResult);
		return result;	
	}
	
	public static Nanoampere substract(AbstractCurrent quantity1, AbstractCurrent quantity2) {
		AbstractCurrent preResult = (AbstractCurrent) Quantity.substract(quantity1, quantity2);
		Nanoampere result = CurrentHandler.changeToNanoampere(preResult);
		return result;
	}

}
