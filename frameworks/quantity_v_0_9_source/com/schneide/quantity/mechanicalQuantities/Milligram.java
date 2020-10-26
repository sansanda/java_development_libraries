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
public class Milligram extends AbstractWeight {

	/**
	 * Constructor for Milligram.
	 * @param value
	 */
	public Milligram(double value) {
		super(value, FrequentlyUsedUnits.getMilligram());
	}

    /**
     * Method Milligram.
     * @param value
     * @param power
     */
    public Milligram(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMilligram());
    }

	/**
	 * Constructor for Milligram.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Milligram(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMilligram());
		return result;
	}
	
	public static Milligram add(AbstractWeight quantity1, AbstractWeight quantity2) {
		AbstractWeight preResult = (AbstractWeight) Quantity.add(quantity1, quantity2);
		Milligram result = WeightHandler.changeToMilligram(preResult);
		return result;	
	}
	
	public static Milligram substract(AbstractWeight quantity1, AbstractWeight quantity2) {
		AbstractWeight preResult = (AbstractWeight) Quantity.substract(quantity1, quantity2);
		Milligram result = WeightHandler.changeToMilligram(preResult);
		return result;
	}

}
