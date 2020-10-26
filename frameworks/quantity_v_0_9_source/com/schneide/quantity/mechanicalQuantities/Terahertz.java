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
public class Terahertz extends AbstractFrequency {

	/**
	 * Constructor for Terahertz.
	 * @param value
	 */
	public Terahertz(double value) {
		super(value, FrequentlyUsedUnits.getTerahertz());
	}

    /**
     * Method Terahertz.
     * @param value
     * @param power
     */
    public Terahertz(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getTerahertz());
    }

	/**
	 * Constructor for Terahertz.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Terahertz(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getTerahertz());
		return result;
	}
	
	public static Terahertz add(AbstractFrequency quantity1, AbstractFrequency quantity2) {
		AbstractFrequency preResult = (AbstractFrequency) Quantity.add(quantity1, quantity2);
		Terahertz result = FrequencyHandler.changeToTerahertz(preResult);
		return result;	
	}
	
	public static Terahertz substract(AbstractFrequency quantity1, AbstractFrequency quantity2) {
		AbstractFrequency preResult = (AbstractFrequency) Quantity.substract(quantity1, quantity2);
		Terahertz result = FrequencyHandler.changeToTerahertz(preResult);
		return result;
	}

}
