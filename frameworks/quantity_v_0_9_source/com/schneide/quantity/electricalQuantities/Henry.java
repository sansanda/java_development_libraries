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
import com.schneide.quantity.electricalQuantities.handlers.InductanceHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Henry extends AbstractInductance {

	/**
	 * Constructor for Henry.
	 * @param value
	 */
	public Henry(double value) {
		super(value, FrequentlyUsedUnits.getHenry());
	}

    /**
     * Method Henry.
     * @param value
     * @param power
     */
    public Henry(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getHenry());
    }

	/**
	 * Constructor for Henry.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Henry(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getHenry());
		return result;
	}
	
	public static Henry add(AbstractInductance quantity1, AbstractInductance quantity2) {
		AbstractInductance preResult = (AbstractInductance) Quantity.add(quantity1, quantity2);
		Henry result = InductanceHandler.changeToHenry(preResult);
		return result;	
	}
	
	public static Henry substract(AbstractInductance quantity1, AbstractInductance quantity2) {
		AbstractInductance preResult = (AbstractInductance) Quantity.substract(quantity1, quantity2);
		Henry result = InductanceHandler.changeToHenry(preResult);
		return result;
	}

}
