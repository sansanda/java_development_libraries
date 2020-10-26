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
public class Kilohertz extends AbstractFrequency {

	/**
	 * Constructor for Kilohertz.
	 * @param value
	 */
	public Kilohertz(double value) {
		super(value, FrequentlyUsedUnits.getKilohertz());
	}

    /**
     * Method Kilohertz.
     * @param value
     * @param power
     */
    public Kilohertz(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKilohertz());
    }

	/**
	 * Constructor for Kilohertz.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Kilohertz(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKilohertz());
		return result;
	}
	
	public static Kilohertz add(AbstractFrequency quantity1, AbstractFrequency quantity2) {
		AbstractFrequency preResult = (AbstractFrequency) Quantity.add(quantity1, quantity2);
		Kilohertz result = FrequencyHandler.changeToKilohertz(preResult);
		return result;	
	}
	
	public static Kilohertz substract(AbstractFrequency quantity1, AbstractFrequency quantity2) {
		AbstractFrequency preResult = (AbstractFrequency) Quantity.substract(quantity1, quantity2);
		Kilohertz result = FrequencyHandler.changeToKilohertz(preResult);
		return result;
	}

}
