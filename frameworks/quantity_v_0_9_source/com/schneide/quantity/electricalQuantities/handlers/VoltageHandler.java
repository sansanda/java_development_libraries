/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.electricalQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.electricalQuantities.*;





/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class VoltageHandler {

	/**
	 * Constructor for VoltageHandler.
	 */
	public VoltageHandler() {
		super();
	}

    public static Megavolt changeToMegavolt(AbstractVoltage abstractVoltage) {
        Megavolt result = new Megavolt(0);
        result.add(abstractVoltage);
        return result;
    }       

    public static Kilovolt changeToKilovolt(AbstractVoltage abstractVoltage) {
        Kilovolt result = new Kilovolt(0);
        result.add(abstractVoltage);
        return result;
    }       

    public static Volt changeToVolt(AbstractVoltage abstractVoltage) {
        Volt result = new Volt(0);
        result.add(abstractVoltage);
        return result;
    }   	

    public static Millivolt changeToMillivolt(AbstractVoltage abstractVoltage) {
        Millivolt result = new Millivolt(0);
        result.add(abstractVoltage);
        return result;
    }       

	public static Microvolt changeToMicrovolt(AbstractVoltage abstractVoltage) {
		Microvolt result = new Microvolt(0);
		result.add(abstractVoltage);
		return result;
	}	


    public static Megavolt changeToMegavolt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMegavolt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Megavolt result = new Megavolt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Kilovolt changeToKilovolt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilovolt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kilovolt result = new Kilovolt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Volt changeToVolt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getVolt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Volt result = new Volt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Millivolt changeToMillivolt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMillivolt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Millivolt result = new Millivolt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Microvolt changeToMicrovolt(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrovolt());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microvolt result = new Microvolt(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
