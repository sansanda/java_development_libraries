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
import com.schneide.quantity.electricalQuantities.handlers.CapacityHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Kilofarad extends AbstractCapacity {

	/**
	 * Constructor for Kilofarad.
	 * @param value
	 */
	public Kilofarad(double value) {
		super(value, FrequentlyUsedUnits.getKilofarad());
	}

    /**
     * Method Kilofarad.
     * @param value
     * @param power
     */
    public Kilofarad(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKilofarad());
    }

	/**
	 * Constructor for Kilofarad.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Kilofarad(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKilofarad());
		return result;
	}
	
	public static Kilofarad add(AbstractCapacity quantity1, AbstractCapacity quantity2) {
		AbstractCapacity preResult = (AbstractCapacity) Quantity.add(quantity1, quantity2);
		Kilofarad result = CapacityHandler.changeToKilofarad(preResult);
		return result;	
	}
	
	public static Kilofarad substract(AbstractCapacity quantity1, AbstractCapacity quantity2) {
		AbstractCapacity preResult = (AbstractCapacity) Quantity.substract(quantity1, quantity2);
		Kilofarad result = CapacityHandler.changeToKilofarad(preResult);
		return result;
	}

}
