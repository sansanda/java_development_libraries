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
import com.schneide.quantity.mechanicalQuantities.handlers.WeightHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Kilogram extends AbstractWeight {

	/**
	 * Constructor for Kilogram.
	 * @param value
	 */
	public Kilogram(double value) {
		super(value, FrequentlyUsedUnits.getKilogram());
	}

    /**
     * Method Kilogram.
     * @param value
     * @param power
     */
    public Kilogram(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKilogram());
    }

	/**
	 * Constructor for Kilogram.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Kilogram(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKilogram());
		return result;
	}
	
	public static Kilogram add(AbstractWeight quantity1, AbstractWeight quantity2) {
		AbstractWeight preResult = (AbstractWeight) Quantity.add(quantity1, quantity2);
		Kilogram result = WeightHandler.changeToKilogram(preResult);
		return result;	
	}
	
	public static Kilogram substract(AbstractWeight quantity1, AbstractWeight quantity2) {
		AbstractWeight preResult = (AbstractWeight) Quantity.substract(quantity1, quantity2);
		Kilogram result = WeightHandler.changeToKilogram(preResult);
		return result;
	}

}
