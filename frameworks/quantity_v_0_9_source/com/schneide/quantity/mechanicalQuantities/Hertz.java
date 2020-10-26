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
import com.schneide.quantity.mechanicalQuantities.handlers.FrequencyHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Hertz extends AbstractFrequency {

	/**
	 * Constructor for Hertz.
	 * @param value
	 */
	public Hertz(double value) {
		super(value, FrequentlyUsedUnits.getHertz());
	}

    /**
     * Method Hertz.
     * @param value
     * @param power
     */
    public Hertz(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getHertz());
    }

	/**
	 * Constructor for Hertz.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Hertz(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getHertz());
		return result;
	}
	
	public static Hertz add(AbstractFrequency quantity1, AbstractFrequency quantity2) {
		AbstractFrequency preResult = (AbstractFrequency) Quantity.add(quantity1, quantity2);
		Hertz result = FrequencyHandler.changeToHertz(preResult);
		return result;	
	}
	
	public static Hertz substract(AbstractFrequency quantity1, AbstractFrequency quantity2) {
		AbstractFrequency preResult = (AbstractFrequency) Quantity.substract(quantity1, quantity2);
		Hertz result = FrequencyHandler.changeToHertz(preResult);
		return result;
	}

}
