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
import com.schneide.quantity.mechanicalQuantities.handlers.PressureHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Micropascal extends AbstractPressure {

	/**
	 * Constructor for Micropascal.
	 * @param value
	 */
	public Micropascal(double value) {
		super(value, FrequentlyUsedUnits.getMicropascal());
	}

    /**
     * Method Micropascal.
     * @param value
     * @param power
     */
    public Micropascal(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMicropascal());
    }

	/**
	 * Constructor for Micropascal.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Micropascal(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMicropascal());
		return result;
	}
	
	public static Micropascal add(AbstractPressure quantity1, AbstractPressure quantity2) {
		AbstractPressure preResult = (AbstractPressure) Quantity.add(quantity1, quantity2);
		Micropascal result = PressureHandler.changeToMicropascal(preResult);
		return result;	
	}
	
	public static Micropascal substract(AbstractPressure quantity1, AbstractPressure quantity2) {
		AbstractPressure preResult = (AbstractPressure) Quantity.substract(quantity1, quantity2);
		Micropascal result = PressureHandler.changeToMicropascal(preResult);
		return result;
	}

}
