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
import com.schneide.quantity.electricalQuantities.handlers.MagneticFieldStrengthHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class AmperePerMeter extends AbstractMagneticFieldStrength {

	/**
	 * Constructor for AmperePerMeter.
	 * @param value
	 */
	public AmperePerMeter(double value) {
		super(value, FrequentlyUsedUnits.getAmperePerMeter());
	}

    /**
     * Method AmperePerMeter.
     * @param value
     * @param power
     */
    public AmperePerMeter(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getAmperePerMeter());
    }

	/**
	 * Constructor for AmperePerMeter.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public AmperePerMeter(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getAmperePerMeter());
		return result;
	}
	
	public static AmperePerMeter add(AbstractMagneticFieldStrength quantity1, AbstractMagneticFieldStrength quantity2) {
		AbstractMagneticFieldStrength preResult = (AbstractMagneticFieldStrength) Quantity.add(quantity1, quantity2);
		AmperePerMeter result = MagneticFieldStrengthHandler.changeToAmperePerMeter(preResult);
		return result;	
	}
	
	public static AmperePerMeter substract(AbstractMagneticFieldStrength quantity1, AbstractMagneticFieldStrength quantity2) {
		AbstractMagneticFieldStrength preResult = (AbstractMagneticFieldStrength) Quantity.substract(quantity1, quantity2);
		AmperePerMeter result = MagneticFieldStrengthHandler.changeToAmperePerMeter(preResult);
		return result;
	}

}
