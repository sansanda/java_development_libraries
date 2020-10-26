/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.radioactivityQuantities;

import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.Quantity;
import com.schneide.quantity.WrongUnitException;
import com.schneide.quantity.radioactivityQuantities.handlers.EnergyDoseHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Milligray extends AbstractEnergyDose {

	/**
	 * Constructor for Milligray.
	 * @param value
	 */
	public Milligray(double value) {
		super(value, FrequentlyUsedUnits.getMilligray());
	}

    /**
     * Method Milligray.
     * @param value
     * @param power
     */
    public Milligray(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMilligray());
    }

	/**
	 * Constructor for Milligray.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Milligray(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMilligray());
		return result;
	}
	
	public static Milligray add(AbstractEnergyDose quantity1, AbstractEnergyDose quantity2) {
		AbstractEnergyDose preResult = (AbstractEnergyDose) Quantity.add(quantity1, quantity2);
		Milligray result = EnergyDoseHandler.changeToMilligray(preResult);
		return result;	
	}
	
	public static Milligray substract(AbstractEnergyDose quantity1, AbstractEnergyDose quantity2) {
		AbstractEnergyDose preResult = (AbstractEnergyDose) Quantity.substract(quantity1, quantity2);
		Milligray result = EnergyDoseHandler.changeToMilligray(preResult);
		return result;
	}

}
