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
public class EnergyHandler {

	/**
	 * Constructor for EnergyHandler.
	 */
	public EnergyHandler() {
		super();
	}
	
	public static Megajoule changeToMegajoule(AbstractEnergy abstractEnergy) {
		Megajoule result = new Megajoule(0);
		result.add(abstractEnergy);
		return result;
	}	
	
	public static Kilojoule changeToKilojoule(AbstractEnergy abstractEnergy) {
		Kilojoule result = new Kilojoule(0);
		result.add(abstractEnergy);
		return result;
	}
	
	public static Joule changeToJoule(AbstractEnergy abstractEnergy) {
		Joule result = new Joule(0);
		result.add(abstractEnergy);
		return result;
	}
	
	public static Newtonmeter changeToNewtonmeter(AbstractEnergy abstractEnergy) {
		Newtonmeter result = new Newtonmeter(0);
		result.add(abstractEnergy);
		return result;
	}
		
	public static Millijoule changeToMillijoule(AbstractEnergy abstractEnergy) {
		Millijoule result = new Millijoule(0);
		result.add(abstractEnergy);
		return result;
	}

	public static Microjoule changeToMicrojoule(AbstractEnergy abstractEnergy) {
		Microjoule result = new Microjoule(0);
		result.add(abstractEnergy);
		return result;
	}

    public static Megajoule changeToMegajoule(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMegajoule());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Megajoule result = new Megajoule(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Kilojoule changeToKilojoule(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilojoule());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kilojoule result = new Kilojoule(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Joule changeToJoule(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getJoule());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Joule result = new Joule(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Newtonmeter changeToNewtonmeter(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getNewtonmeter());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Newtonmeter result = new Newtonmeter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Millijoule changeToMillijoule(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMillijoule());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Millijoule result = new Millijoule(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Microjoule changeToMicrojoule(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrojoule());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microjoule result = new Microjoule(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
