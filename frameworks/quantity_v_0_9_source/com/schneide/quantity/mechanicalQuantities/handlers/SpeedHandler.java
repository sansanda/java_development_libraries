/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.mechanicalQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.mechanicalQuantities.AbstractSpeed;
import com.schneide.quantity.mechanicalQuantities.KilometerPerHour;
import com.schneide.quantity.mechanicalQuantities.MeterPerSecond;



/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class SpeedHandler {

	/**
	 * Constructor for SpeedHandler.
	 */
	public SpeedHandler() {
		super();
	}
	
	public static KilometerPerHour changeToKilometerPerHour(AbstractSpeed abstractSpeed) {
		KilometerPerHour result = new KilometerPerHour(0);
		result.add(abstractSpeed);
		return result;
	}	

	public static MeterPerSecond changeToMeterPerSecond(AbstractSpeed abstractSpeed) {
		MeterPerSecond result = new MeterPerSecond(0);
		result.add(abstractSpeed);
		return result;
	}	
	

    public static KilometerPerHour changeToKilometerPerHour(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilometerPerHour());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        KilometerPerHour result = new KilometerPerHour(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static MeterPerSecond changeToMeterPerSecond(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMeterPerSecond());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        MeterPerSecond result = new MeterPerSecond(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
