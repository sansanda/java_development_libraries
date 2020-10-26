/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.miscQuantities;

import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.Quantity;
import com.schneide.quantity.WrongUnitException;
import com.schneide.quantity.miscQuantities.handlers.AmountOfSubstanceHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Mole extends AbstractAmountOfSubstance {

	/**
	 * Constructor for Ampere.
	 * @param value
	 */
	public Mole(double value) {
		super(value, FrequentlyUsedUnits.getMole());
	}

    /**
     * Method Ampere.
     * @param value
     * @param power
     */
    public Mole(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMole());
    }

	/**
	 * Constructor for Ampere.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Mole(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMole());
		return result;
	}
	
	public static Mole add(AbstractAmountOfSubstance quantity1, AbstractAmountOfSubstance quantity2) {
		AbstractAmountOfSubstance preResult = (AbstractAmountOfSubstance) Quantity.add(quantity1, quantity2);
		Mole result = AmountOfSubstanceHandler.changeToMole(preResult);
		return result;	
	}
	
	public static Mole substract(AbstractAmountOfSubstance quantity1, AbstractAmountOfSubstance quantity2) {
		AbstractAmountOfSubstance preResult = (AbstractAmountOfSubstance) Quantity.substract(quantity1, quantity2);
		Mole result = AmountOfSubstanceHandler.changeToMole(preResult);
		return result;
	}

}
