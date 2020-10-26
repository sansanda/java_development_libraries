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
public class PowerHandler {

	/**
	 * Constructor for PowerHandler.
	 */
	public PowerHandler() {
		super();
	}
	
    public static Terawatt changeToTerawatt(AbstractPower abstractPower) {
        Terawatt result = new Terawatt(0);
        result.add(abstractPower);
        return result;
    }   
    
    public static Gigawatt changeToGigawatt(AbstractPower abstractPower) {
        Gigawatt result = new Gigawatt(0);
        result.add(abstractPower);
        return result;
    }   
    
    public static Megawatt changeToMegawatt(AbstractPower abstractPower) {
        Megawatt result = new Megawatt(0);
        result.add(abstractPower);
        return result;
    }   
    
    public static Kilowatt changeToKilowatt(AbstractPower abstractPower) {
        Kilowatt result = new Kilowatt(0);
        result.add(abstractPower);
        return result;
    }   
    
	public static Watt changeToWatt(AbstractPower abstractPower) {
		Watt result = new Watt(0);
		result.add(abstractPower);
		return result;
	}	
	
	public static Milliwatt changeToMilliwatt(AbstractPower abstractPower) {
		Milliwatt result = new Milliwatt(0);
		result.add(abstractPower);
		return result;
	}
	
	public static Microwatt changeToMicrowatt(AbstractPower abstractPower) {
		Microwatt result = new Microwatt(0);
		result.add(abstractPower);
		return result;
	}

    public static Terawatt changeToTerawatt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getTerawatt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Terawatt result = new Terawatt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Gigawatt changeToGigawatt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getGigawatt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Gigawatt result = new Gigawatt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Megawatt changeToMegawatt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMegawatt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Megawatt result = new Megawatt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Kilowatt changeToKilowatt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilowatt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kilowatt result = new Kilowatt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Watt changeToWatt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getWatt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Watt result = new Watt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Milliwatt changeToMilliwatt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMilliwatt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Milliwatt result = new Milliwatt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Microwatt changeToMicrowatt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrowatt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microwatt result = new Microwatt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
