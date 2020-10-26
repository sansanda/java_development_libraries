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
public class CubicMillimeter extends AbstractVolume {

	/**
	 * Constructor for CubicMillimeter.
	 * @param value
	 */
	public CubicMillimeter(double value) {
		super(value, FrequentlyUsedUnits.getCubicMillimeter());
	}

    /**
     * Method CubicMillimeter.
     * @param value
     * @param power
     */
    public CubicMillimeter(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getCubicMillimeter());
    }

	/**
	 * Constructor for CubicMillimeter.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public CubicMillimeter(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getCubicMillimeter());
		return result;
	}
	
	public static CubicMillimeter add(AbstractVolume quantity1, AbstractVolume quantity2) {
		AbstractVolume preResult = (AbstractVolume) Quantity.add(quantity1, quantity2);
		CubicMillimeter result = VolumeHandler.changeToCubicMillimeter(preResult);
		return result;	
	}
	
	public static CubicMillimeter substract(AbstractVolume quantity1, AbstractVolume quantity2) {
		AbstractVolume preResult = (AbstractVolume) Quantity.substract(quantity1, quantity2);
		CubicMillimeter result = VolumeHandler.changeToCubicMillimeter(preResult);
		return result;
	}

}
