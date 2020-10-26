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
public class CubicMeter extends AbstractVolume {

	/**
	 * Constructor for CubicMeter.
	 * @param value
	 */
	public CubicMeter(double value) {
		super(value, FrequentlyUsedUnits.getCubicMeter());
	}

    /**
     * Method CubicMeter.
     * @param value
     * @param power
     */
    public CubicMeter(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getCubicMeter());
    }
    
    /**
	 * Constructor for CubicMeter.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public CubicMeter(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getCubicMeter());
		return result;
	}
	
	public static CubicMeter add(AbstractVolume quantity1, AbstractVolume quantity2) {
		AbstractVolume preResult = (AbstractVolume) Quantity.add(quantity1, quantity2);
		CubicMeter result = VolumeHandler.changeToCubicMeter(preResult);
		return result;	
	}
	
	public static CubicMeter substract(AbstractVolume quantity1, AbstractVolume quantity2) {
		AbstractVolume preResult = (AbstractVolume) Quantity.substract(quantity1, quantity2);
		CubicMeter result = VolumeHandler.changeToCubicMeter(preResult);
		return result;
	}

}
