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
public class FrequencyHandler {

	/**
	 * Constructor for FrequencyHandler.
	 */
	public FrequencyHandler() {
		super();
	}
	
	public static Hertz changeToHertz(AbstractFrequency abstractFrequency) {
		Hertz result = new Hertz(0);
		result.add(abstractFrequency);
		return result;
	}	
	
	public static Kilohertz changeToKilohertz(AbstractFrequency abstractFrequency) {
		Kilohertz result = new Kilohertz(0);
		result.add(abstractFrequency);
		return result;
	}
	
	public static Megahertz changeToMegahertz(AbstractFrequency abstractFrequency) {
		Megahertz result = new Megahertz(0);
		result.add(abstractFrequency);
		return result;
	}
	
	public static Gigahertz changeToGigahertz(AbstractFrequency abstractFrequency) {
		Gigahertz result = new Gigahertz(0);
		result.add(abstractFrequency);
		return result;
	}
	
	public static Terahertz changeToTerahertz(AbstractFrequency abstractFrequency) {
		Terahertz result = new Terahertz(0);
		result.add(abstractFrequency);
		return result;
	}


    public static Hertz changeToHertz(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getHertz());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Hertz result = new Hertz(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Kilohertz changeToKilohertz(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilohertz());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kilohertz result = new Kilohertz(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Megahertz changeToMegahertz(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMegahertz());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Megahertz result = new Megahertz(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Gigahertz changeToGigahertz(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getGigahertz());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Gigahertz result = new Gigahertz(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Terahertz changeToTerahertz(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getTerahertz());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Terahertz result = new Terahertz(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
