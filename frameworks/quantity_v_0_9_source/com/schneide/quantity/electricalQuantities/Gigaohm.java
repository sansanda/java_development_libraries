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
import com.schneide.quantity.electricalQuantities.handlers.ResistanceHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Gigaohm extends AbstractResistance {

	/**
	 * Constructor for Gigaohm.
	 * @param value
	 */
	public Gigaohm(double value) {
		super(value, FrequentlyUsedUnits.getGigaohm());
	}

    /**
     * Method Gigaohm.
     * @param value
     * @param power
     */
    public Gigaohm(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getGigaohm());
    }

	/**
	 * Constructor for Gigaohm.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Gigaohm(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getGigaohm());
		return result;
	}
	
	public static Gigaohm add(AbstractResistance quantity1, AbstractResistance quantity2) {
		AbstractResistance preResult = (AbstractResistance) Quantity.add(quantity1, quantity2);
		Gigaohm result = ResistanceHandler.changeToGigaohm(preResult);
		return result;	
	}
	
	public static Gigaohm substract(AbstractResistance quantity1, AbstractResistance quantity2) {
		AbstractResistance preResult = (AbstractResistance) Quantity.substract(quantity1, quantity2);
		Gigaohm result = ResistanceHandler.changeToGigaohm(preResult);
		return result;
	}

}
