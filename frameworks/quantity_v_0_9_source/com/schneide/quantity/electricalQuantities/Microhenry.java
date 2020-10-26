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
public class Microhenry extends AbstractInductance {

	/**
	 * Constructor for Microhenry.
	 * @param value
	 */
	public Microhenry(double value) {
		super(value, FrequentlyUsedUnits.getMicrohenry());
	}

    /**
     * Method Microhenry.
     * @param value
     * @param power
     */
    public Microhenry(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMicrohenry());
    }

	/**
	 * Constructor for Microhenry.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Microhenry(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMicrohenry());
		return result;
	}
	
	public static Microhenry add(AbstractInductance quantity1, AbstractInductance quantity2) {
		AbstractInductance preResult = (AbstractInductance) Quantity.add(quantity1, quantity2);
		Microhenry result = InductanceHandler.changeToMicrohenry(preResult);
		return result;	
	}
	
	public static Microhenry substract(AbstractInductance quantity1, AbstractInductance quantity2) {
		AbstractInductance preResult = (AbstractInductance) Quantity.substract(quantity1, quantity2);
		Microhenry result = InductanceHandler.changeToMicrohenry(preResult);
		return result;
	}

}
