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
public class Kiloohm extends AbstractResistance {

	/**
	 * Constructor for Kiloohm.
	 * @param value
	 */
	public Kiloohm(double value) {
		super(value, FrequentlyUsedUnits.getKiloohm());
	}

    /**
     * Method Kiloohm.
     * @param value
     * @param power
     */
    public Kiloohm(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKiloohm());
    }

	/**
	 * Constructor for Kiloohm.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Kiloohm(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKiloohm());
		return result;
	}
	
	public static Kiloohm add(AbstractResistance quantity1, AbstractResistance quantity2) {
		AbstractResistance preResult = (AbstractResistance) Quantity.add(quantity1, quantity2);
		Kiloohm result = ResistanceHandler.changeToKiloohm(preResult);
		return result;	
	}
	
	public static Kiloohm substract(AbstractResistance quantity1, AbstractResistance quantity2) {
		AbstractResistance preResult = (AbstractResistance) Quantity.substract(quantity1, quantity2);
		Kiloohm result = ResistanceHandler.changeToKiloohm(preResult);
		return result;
	}

}
