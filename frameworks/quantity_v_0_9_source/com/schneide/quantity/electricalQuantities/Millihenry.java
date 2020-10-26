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
public class Millihenry extends AbstractInductance {

	/**
	 * Constructor for Millihenry.
	 * @param value
	 */
	public Millihenry(double value) {
		super(value, FrequentlyUsedUnits.getMillihenry());
	}

    /**
     * Method Millihenry.
     * @param value
     * @param power
     */
    public Millihenry(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMillihenry());
    }

	/**
	 * Constructor for Millihenry.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Millihenry(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMillihenry());
		return result;
	}
	
	public static Millihenry add(AbstractInductance quantity1, AbstractInductance quantity2) {
		AbstractInductance preResult = (AbstractInductance) Quantity.add(quantity1, quantity2);
		Millihenry result = InductanceHandler.changeToMillihenry(preResult);
		return result;	
	}
	
	public static Millihenry substract(AbstractInductance quantity1, AbstractInductance quantity2) {
		AbstractInductance preResult = (AbstractInductance) Quantity.substract(quantity1, quantity2);
		Millihenry result = InductanceHandler.changeToMillihenry(preResult);
		return result;
	}

}
