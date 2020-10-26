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
import com.schneide.quantity.mechanicalQuantities.handlers.EnergyHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Kilojoule extends AbstractEnergy {

	/**
	 * Constructor for Kilojoule.
	 * @param value
	 */
	public Kilojoule(double value) {
		super(value, FrequentlyUsedUnits.getKilojoule());
	}

    /**
     * Method Kilojoule.
     * @param value
     * @param power
     */
    public Kilojoule(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKilojoule());
    }

	/**
	 * Constructor for Kilojoule.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Kilojoule(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKilojoule());
		return result;
	}
	
	public static Kilojoule add(AbstractEnergy quantity1, AbstractEnergy quantity2) {
		AbstractEnergy preResult = (AbstractEnergy) Quantity.add(quantity1, quantity2);
		Kilojoule result = EnergyHandler.changeToKilojoule(preResult);
		return result;	
	}
	
	public static Kilojoule substract(AbstractEnergy quantity1, AbstractEnergy quantity2) {
		AbstractEnergy preResult = (AbstractEnergy) Quantity.substract(quantity1, quantity2);
		Kilojoule result = EnergyHandler.changeToKilojoule(preResult);
		return result;
	}

}
