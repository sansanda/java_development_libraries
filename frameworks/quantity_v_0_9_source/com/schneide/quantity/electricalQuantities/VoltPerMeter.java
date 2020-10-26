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
import com.schneide.quantity.electricalQuantities.handlers.ElectricFieldStrengthHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class VoltPerMeter extends AbstractElectricFieldStrength {

	/**
	 * Constructor for VoltPerMeter.
	 * @param value
	 */
	public VoltPerMeter(double value) {
		super(value, FrequentlyUsedUnits.getVoltPerMeter());
	}

    /**
     * Method VoltPerMeter.
     * @param value
     * @param power
     */
    public VoltPerMeter(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getVoltPerMeter());
    }

	/**
	 * Constructor for VoltPerMeter.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public VoltPerMeter(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getVoltPerMeter());
		return result;
	}
	
	public static VoltPerMeter add(AbstractElectricFieldStrength quantity1, AbstractElectricFieldStrength quantity2) {
		AbstractElectricFieldStrength preResult = (AbstractElectricFieldStrength) Quantity.add(quantity1, quantity2);
		VoltPerMeter result = ElectricFieldStrengthHandler.changeToVoltPerMeter(preResult);
		return result;	
	}
	
	public static VoltPerMeter substract(AbstractElectricFieldStrength quantity1, AbstractElectricFieldStrength quantity2) {
		AbstractElectricFieldStrength preResult = (AbstractElectricFieldStrength) Quantity.substract(quantity1, quantity2);
		VoltPerMeter result = ElectricFieldStrengthHandler.changeToVoltPerMeter(preResult);
		return result;
	}

}
