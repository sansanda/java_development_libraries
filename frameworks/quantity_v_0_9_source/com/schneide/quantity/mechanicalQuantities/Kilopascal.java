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
public class Kilopascal extends AbstractPressure {

	/**
	 * Constructor for Kilopascal.
	 * @param value
	 */
	public Kilopascal(double value) {
		super(value, FrequentlyUsedUnits.getKilopascal());
	}

    /**
     * Method Kilopascal.
     * @param value
     * @param power
     */
    public Kilopascal(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKilopascal());
    }

	/**
	 * Constructor for Kilopascal.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Kilopascal(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKilopascal());
		return result;
	}
	
	public static Kilopascal add(AbstractPressure quantity1, AbstractPressure quantity2) {
		AbstractPressure preResult = (AbstractPressure) Quantity.add(quantity1, quantity2);
		Kilopascal result = PressureHandler.changeToKilopascal(preResult);
		return result;	
	}
	
	public static Kilopascal substract(AbstractPressure quantity1, AbstractPressure quantity2) {
		AbstractPressure preResult = (AbstractPressure) Quantity.substract(quantity1, quantity2);
		Kilopascal result = PressureHandler.changeToKilopascal(preResult);
		return result;
	}

}
