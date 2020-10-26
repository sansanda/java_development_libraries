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
public class Microgray extends AbstractEnergyDose {

	/**
	 * Constructor for Microgray.
	 * @param value
	 */
	public Microgray(double value) {
		super(value, FrequentlyUsedUnits.getMicrogray());
	}

    /**
     * Method Microgray.
     * @param value
     * @param power
     */
    public Microgray(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMicrogray());
    }

	/**
	 * Constructor for Microgray.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Microgray(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMicrogray());
		return result;
	}
	
	public static Microgray add(AbstractEnergyDose quantity1, AbstractEnergyDose quantity2) {
		AbstractEnergyDose preResult = (AbstractEnergyDose) Quantity.add(quantity1, quantity2);
		Microgray result = EnergyDoseHandler.changeToMicrogray(preResult);
		return result;	
	}
	
	public static Microgray substract(AbstractEnergyDose quantity1, AbstractEnergyDose quantity2) {
		AbstractEnergyDose preResult = (AbstractEnergyDose) Quantity.substract(quantity1, quantity2);
		Microgray result = EnergyDoseHandler.changeToMicrogray(preResult);
		return result;
	}

}
