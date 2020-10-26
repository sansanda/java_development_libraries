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
public class LengthHandler {

	/**
	 * Constructor for LengthHandler.
	 */
	public LengthHandler() {
		super();
	}
	
	public static Kilometer changeToKilometer(AbstractLength abstractSpace) {
		Kilometer result = new Kilometer(0);
		result.add(abstractSpace);
		return result;
	}

	public static Meter changeToMeter(AbstractLength abstractSpace) {
		Meter result = new Meter(0);
		result.add(abstractSpace);
		return result;
	}
	
	public static Millimeter changeToMillimeter(AbstractLength abstractSpace) {
		Millimeter result = new Millimeter(0);
		result.add(abstractSpace);
		return result;
	}
	
	public static Micrometer changeToMicrometer(AbstractLength abstractSpace) {
		Micrometer result = new Micrometer(0);
		result.add(abstractSpace);
		return result;
	}

	public static NanoMeter changeToNanometer(AbstractLength abstractSpace) {
		NanoMeter result = new NanoMeter(0);
		result.add(abstractSpace);
		return result;
	}	

    public static Kilometer changeToKilometer(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilometer());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kilometer result = new Kilometer(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Meter changeToMeter(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMeter());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Meter result = new Meter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Millimeter changeToMillimeter(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMillimeter());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Millimeter result = new Millimeter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Micrometer changeToMicrometer(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrometer());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Micrometer result = new Micrometer(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static NanoMeter changeToNanometer(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getNanometer());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        NanoMeter result = new NanoMeter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
