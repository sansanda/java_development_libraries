/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.mechanicalQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.mechanicalQuantities.AbstractAcceleration;
import com.schneide.quantity.mechanicalQuantities.MeterPerSecondToPowerTwo;



/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class AccelerationHandler {

	/**
	 * Constructor for AccelerationHandler.
	 */
	public AccelerationHandler() {
		super();
	}
	
	public static MeterPerSecondToPowerTwo changeToMeterPerSecondToPowerTwo(AbstractAcceleration abstractAcceleration) {
		MeterPerSecondToPowerTwo result = new MeterPerSecondToPowerTwo(0);
		result.add(abstractAcceleration);
		return result;
	}	
	
	public static MeterPerSecondToPowerTwo changeToMeterPerSecondToPowerTwo(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMeterPerSecondToPowerTwo());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        MeterPerSecondToPowerTwo result = new MeterPerSecondToPowerTwo(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	

}
