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
public class CurrentHandler {

	/**
	 * Constructor for CurrentHandler.
	 */
	public CurrentHandler() {
		super();
	}

    public static Ampere changeToAmpere(AbstractCurrent abstractCurrent) {
        Ampere result = new Ampere(0);
        result.add(abstractCurrent);
        return result;
    }   	

    public static Milliampere changeToMilliampere(AbstractCurrent abstractCurrent) {
        Milliampere result = new Milliampere(0);
        result.add(abstractCurrent);
        return result;
    }       

	public static Microampere changeToMicroampere(AbstractCurrent abstractCurrent) {
		Microampere result = new Microampere(0);
		result.add(abstractCurrent);
		return result;
	}	

    public static Nanoampere changeToNanoampere(AbstractCurrent abstractCurrent) {
        Nanoampere result = new Nanoampere(0);
        result.add(abstractCurrent);
        return result;
    }

    public static Ampere changeToAmpere(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getAmpere());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Ampere result = new Ampere(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Milliampere changeToMilliampere(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMilliampere());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Milliampere result = new Milliampere(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Microampere changeToMicroampere(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicroampere());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microampere result = new Microampere(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Nanoampere changeToNanoampere(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getNanoampere());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Nanoampere result = new Nanoampere(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
