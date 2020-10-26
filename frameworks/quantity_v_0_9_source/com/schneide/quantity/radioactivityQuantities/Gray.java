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
public class Gray extends AbstractEnergyDose {

	/**
	 * Constructor for Gray.
	 * @param value
	 */
	public Gray(double value) {
		super(value, FrequentlyUsedUnits.getGray());
	}

    /**
     * Method Gray.
     * @param value
     * @param power
     */
    public Gray(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getGray());
    }

	/**
	 * Constructor for Gray.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Gray(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getGray());
		return result;
	}
	
	public static Gray add(AbstractEnergyDose quantity1, AbstractEnergyDose quantity2) {
		AbstractEnergyDose preResult = (AbstractEnergyDose) Quantity.add(quantity1, quantity2);
		Gray result = EnergyDoseHandler.changeToGray(preResult);
		return result;	
	}
	
	public static Gray substract(AbstractEnergyDose quantity1, AbstractEnergyDose quantity2) {
		AbstractEnergyDose preResult = (AbstractEnergyDose) Quantity.substract(quantity1, quantity2);
		Gray result = EnergyDoseHandler.changeToGray(preResult);
		return result;
	}

}
