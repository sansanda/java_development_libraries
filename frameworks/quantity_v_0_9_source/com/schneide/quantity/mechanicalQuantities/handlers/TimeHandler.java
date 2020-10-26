/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.mechanicalQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.mechanicalQuantities.*;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class TimeHandler {

	/**
	 * Constructor for LengthHandler.
	 */
	public TimeHandler() {
		super();
	}
	
	public static Hour changeToHour(AbstractTime abstractTime) {
		Hour result = new Hour(0);
		result.add(abstractTime);
		return result;
	}

    public static Minute changeToMinute(AbstractTime abstractTime) {
        Minute result = new Minute(0);
        result.add(abstractTime);
        return result;
    }
    
	public static Second changeToSecond(AbstractTime abstractTime) {
		Second result = new Second(0);
		result.add(abstractTime);
		return result;
	}
	
	public static Millisecond changeToMillisecond(AbstractTime abstractTime) {
		Millisecond result = new Millisecond(0);
		result.add(abstractTime);
		return result;
	}

	public static Microsecond changeToMicrosecond(AbstractTime abstractTime) {
		Microsecond result = new Microsecond(0);
		result.add(abstractTime);
		return result;
	}


    public static Hour changeToHour(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getHour());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Hour result = new Hour(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Minute changeToMinute(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMinute());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Minute result = new Minute(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Second changeToSecond(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getSecond());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Second result = new Second(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Millisecond changeToMillisecond(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMillisecond());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Millisecond result = new Millisecond(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Microsecond changeToMicrosecond(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrosecond());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microsecond result = new Microsecond(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
