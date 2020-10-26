/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.electricalQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.electricalQuantities.AbstractMagneticFieldStrength;
import com.schneide.quantity.electricalQuantities.AmperePerMeter;





/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class MagneticFieldStrengthHandler {

	/**
	 * Constructor for MagneticFieldStrengthHandler.
	 */
	public MagneticFieldStrengthHandler() {
		super();
	}

    public static AmperePerMeter changeToAmperePerMeter(AbstractMagneticFieldStrength abstractMagneticFieldStrength) {
        AmperePerMeter result = new AmperePerMeter(0);
        result.add(abstractMagneticFieldStrength);
        return result;
    }       

    public static AmperePerMeter changeToAmperePerMeter(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getAmperePerMeter());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        AmperePerMeter result = new AmperePerMeter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
