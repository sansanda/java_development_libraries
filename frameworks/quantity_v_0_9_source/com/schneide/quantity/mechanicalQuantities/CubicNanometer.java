/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.mechanicalQuantities;

import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.Quantity;
import com.schneide.quantity.WrongUnitException;
import com.schneide.quantity.mechanicalQuantities.handlers.VolumeHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class CubicNanometer extends AbstractVolume {

	/**
	 * Constructor for CubicNanometer.
	 * @param value
	 */
	public CubicNanometer(double value) {
		super(value, FrequentlyUsedUnits.getCubicNanometer());
	}

    /**
     * Method CubicNanometer.
     * @param value
     * @param power
     */
    public CubicNanometer(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getCubicNanometer());
    }

	/**
	 * Constructor for CubicNanometer.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public CubicNanometer(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getCubicNanometer());
		return result;
	}
	
	public static CubicNanometer add(AbstractVolume quantity1, AbstractVolume quantity2) {
		AbstractVolume preResult = (AbstractVolume) Quantity.add(quantity1, quantity2);
		CubicNanometer result = VolumeHandler.changeToCubicNanometer(preResult);
		return result;	
	}
	
	public static CubicNanometer substract(AbstractVolume quantity1, AbstractVolume quantity2) {
		AbstractVolume preResult = (AbstractVolume) Quantity.substract(quantity1, quantity2);
		CubicNanometer result = VolumeHandler.changeToCubicNanometer(preResult);
		return result;
	}

}
