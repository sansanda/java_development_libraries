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
public class Microohm extends AbstractResistance {

	/**
	 * Constructor for Microohm.
	 * @param value
	 */
	public Microohm(double value) {
		super(value, FrequentlyUsedUnits.getMicroohm());
	}

    /**
     * Method Microohm.
     * @param value
     * @param power
     */
    public Microohm(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMicroohm());
    }

	/**
	 * Constructor for Microohm.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Microohm(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMicroohm());
		return result;
	}
	
	public static Microohm add(AbstractResistance quantity1, AbstractResistance quantity2) {
		AbstractResistance preResult = (AbstractResistance) Quantity.add(quantity1, quantity2);
		Microohm result = ResistanceHandler.changeToMicroohm(preResult);
		return result;	
	}
	
	public static Microohm substract(AbstractResistance quantity1, AbstractResistance quantity2) {
		AbstractResistance preResult = (AbstractResistance) Quantity.substract(quantity1, quantity2);
		Microohm result = ResistanceHandler.changeToMicroohm(preResult);
		return result;
	}

}
