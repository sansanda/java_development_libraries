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
public class Pascal extends AbstractPressure {

	/**
	 * Constructor for Pascal.
	 * @param value
	 */
	public Pascal(double value) {
		super(value, FrequentlyUsedUnits.getPascal());
	}

    /**
     * Method Pascal.
     * @param value
     * @param power
     */
    public Pascal(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getPascal());
    }

	/**
	 * Constructor for Pascal.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Pascal(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getPascal());
		return result;
	}
	
	public static Pascal add(AbstractPressure quantity1, AbstractPressure quantity2) {
		AbstractPressure preResult = (AbstractPressure) Quantity.add(quantity1, quantity2);
		Pascal result = PressureHandler.changeToPascal(preResult);
		return result;	
	}
	
	public static Pascal substract(AbstractPressure quantity1, AbstractPressure quantity2) {
		AbstractPressure preResult = (AbstractPressure) Quantity.substract(quantity1, quantity2);
		Pascal result = PressureHandler.changeToPascal(preResult);
		return result;
	}

}
