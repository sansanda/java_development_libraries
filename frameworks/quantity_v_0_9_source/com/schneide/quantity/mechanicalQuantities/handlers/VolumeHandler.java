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
public class VolumeHandler {

	/**
	 * Constructor for VolumeHandler.
	 */
	public VolumeHandler() {
		super();
	}
	

	public static CubicKilometer changeToCubicKilometer(AbstractVolume abstractVolume) {
		CubicKilometer result = new CubicKilometer(0);
		result.add(abstractVolume);
		return result;
	}	
	
	public static CubicMeter changeToCubicMeter(AbstractVolume abstractVolume) {
		CubicMeter result = new CubicMeter(0);
		result.add(abstractVolume);
		return result;
	}
	
	public static CubicMillimeter changeToCubicMillimeter(AbstractVolume abstractVolume) {
		CubicMillimeter result = new CubicMillimeter(0);
		result.add(abstractVolume);
		return result;
	}
	
	public static CubicMicrometer changeToCubicMicrometer(AbstractVolume abstractVolume) {
		CubicMicrometer result = new CubicMicrometer(0);
		result.add(abstractVolume);
		return result;
	}	

	public static CubicNanometer changeToCubicNanometer(AbstractVolume abstractVolume) {
		CubicNanometer result = new CubicNanometer(0);
		result.add(abstractVolume);
		return result;
	}	
	
	public static Liter changeToLiter(AbstractVolume abstractVolume) {
		Liter result = new Liter(0);
		result.add(abstractVolume);
		return result;
	}	
	
    public static Microliter changeToMicroliter(AbstractVolume abstractVolume) {
        Microliter result = new Microliter(0);
        result.add(abstractVolume);
        return result;
    }   
	
	public static Milliliter changeToMilliliter(AbstractVolume abstractVolume) {
		Milliliter result = new Milliliter(0);
		result.add(abstractVolume);
		return result;
	}   

    public static CubicKilometer changeToCubicKilometer(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getCubicKilometer());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        CubicKilometer result = new CubicKilometer(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static CubicMeter changeToCubicMeter(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getCubicMeter());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        CubicMeter result = new CubicMeter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static CubicMillimeter changeToCubicMillimeter(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getCubicMillimeter());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        CubicMillimeter result = new CubicMillimeter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static CubicMicrometer changeToCubicMicrometer(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getCubicMicrometer());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        CubicMicrometer result = new CubicMicrometer(resultValue.getValue(), resultValue.getPower());
        return result;
    }       

	public static CubicNanometer changeToCubicNanometer(Quantity quantity) throws WrongUnitException{
		Quantity clonedQuantity = (Quantity) quantity.clone();
		clonedQuantity.changeToUnit(FrequentlyUsedUnits.getCubicNanometer());
		ValueTransfer resultValue = clonedQuantity.getValueWithPower();
		CubicNanometer result = new CubicNanometer(resultValue.getValue(), resultValue.getPower());
		return result;
	}


	public static Liter changeToLiter(Quantity quantity) {
		Quantity clonedQuantity = (Quantity) quantity.clone();
		clonedQuantity.changeToUnit(FrequentlyUsedUnits.getLiter());
		ValueTransfer resultValue = clonedQuantity.getValueWithPower();
		Liter result = new Liter(resultValue.getValue(), resultValue.getPower());
		return result;
	}


    public static Microliter changeToMicroLiter(Quantity quantity) {
        Quantity clonedQuantity = (Quantity) quantity.clone();
        clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicroliter());
        ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microliter result = new Microliter(resultValue.getValue(), resultValue.getPower());
        return result;
    }

    public static Milliliter changeToMilliliter(Quantity quantity) {
		Quantity clonedQuantity = (Quantity) quantity.clone();
		clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMilliliter());
		ValueTransfer resultValue = clonedQuantity.getValueWithPower();
		Milliliter result = new Milliliter(resultValue.getValue(), resultValue.getPower());
		return result;
     }	
}
