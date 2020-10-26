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
public class Gram extends AbstractWeight {

	/**
	 * Constructor for Gram.
	 * @param value
	 */
	public Gram(double value) {
		super(value, FrequentlyUsedUnits.getGram());
	}

    /**
     * Method Gram.
     * @param value
     * @param power
     */
    public Gram(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getGram());
    }

	/**
	 * Constructor for Gram.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Gram(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getGram());
		return result;
	}
	
	public static Gram add(AbstractWeight quantity1, AbstractWeight quantity2) {
		AbstractWeight preResult = (AbstractWeight) Quantity.add(quantity1, quantity2);
		Gram result = WeightHandler.changeToGram(preResult);
		return result;	
	}
	
	public static Gram substract(AbstractWeight quantity1, AbstractWeight quantity2) {
		AbstractWeight preResult = (AbstractWeight) Quantity.substract(quantity1, quantity2);
		Gram result = WeightHandler.changeToGram(preResult);
		return result;
	}

}
