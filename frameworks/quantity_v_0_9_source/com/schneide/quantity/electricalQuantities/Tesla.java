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
import com.schneide.quantity.electricalQuantities.handlers.ElectromagneticInductionHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Tesla extends AbstractElectromagneticInduction {

	/**
	 * Constructor for Tesla.
	 * @param value
	 */
	public Tesla(double value) {
		super(value, FrequentlyUsedUnits.getTesla());
	}

    /**
     * Method Tesla.
     * @param value
     * @param power
     */
    public Tesla(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getTesla());
    }

	/**
	 * Constructor for Tesla.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Tesla(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getTesla());
		return result;
	}
	
	public static Tesla add(AbstractElectromagneticInduction quantity1, AbstractElectromagneticInduction quantity2) {
		AbstractElectromagneticInduction preResult = (AbstractElectromagneticInduction) Quantity.add(quantity1, quantity2);
		Tesla result = ElectromagneticInductionHandler.changeToTesla(preResult);
		return result;	
	}
	
	public static Tesla substract(AbstractElectromagneticInduction quantity1, AbstractElectromagneticInduction quantity2) {
		AbstractElectromagneticInduction preResult = (AbstractElectromagneticInduction) Quantity.substract(quantity1, quantity2);
		Tesla result = ElectromagneticInductionHandler.changeToTesla(preResult);
		return result;
	}

}
