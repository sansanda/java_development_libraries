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
public class CapacityHandler {

	/**
	 * Constructor for CapacityHandler.
	 */
	public CapacityHandler() {
		super();
	}

    public static Megafarad changeToMegafarad(AbstractCapacity abstractCapacity) {
        Megafarad result = new Megafarad(0);
        result.add(abstractCapacity);
        return result;
    }       

    public static Kilofarad changeToKilofarad(AbstractCapacity abstractCapacity) {
        Kilofarad result = new Kilofarad(0);
        result.add(abstractCapacity);
        return result;
    }       

    public static Farad changeToFarad(AbstractCapacity abstractCapacity) {
        Farad result = new Farad(0);
        result.add(abstractCapacity);
        return result;
    }       

    public static Millifarad changeToMillifarad(AbstractCapacity abstractCapacity) {
        Millifarad result = new Millifarad(0);
        result.add(abstractCapacity);
        return result;
    }       

	public static Microfarad changeToMicrofarad(AbstractCapacity abstractCapacity) {
		Microfarad result = new Microfarad(0);
		result.add(abstractCapacity);
		return result;
	}	


    public static Megafarad changeToMegafarad(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMegafarad());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Megafarad result = new Megafarad(resultValue.getValue(), resultValue.getPower());
        return result;
    }       

    public static Kilofarad changeToKilofarad(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilofarad());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kilofarad result = new Kilofarad(resultValue.getValue(), resultValue.getPower());
        return result;
    }       

    public static Farad changeToFarad(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getFarad());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Farad result = new Farad(resultValue.getValue(), resultValue.getPower());
        return result;
    }       

    public static Millifarad changeToMillifarad(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMillifarad());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Millifarad result = new Millifarad(resultValue.getValue(), resultValue.getPower());
        return result;
    }       

	public static Microfarad changeToMicrofarad(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrofarad());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microfarad result = new Microfarad(resultValue.getValue(), resultValue.getPower());
        return result;
	}	
}
