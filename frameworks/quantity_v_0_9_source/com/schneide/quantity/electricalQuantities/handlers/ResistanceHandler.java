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
public class ResistanceHandler {

	/**
	 * Constructor for ResistanceHandler.
	 */
	public ResistanceHandler() {
		super();
	}

    public static Gigaohm changeToGigaohm(AbstractResistance abstractResistance) {
        Gigaohm result = new Gigaohm(0);
        result.add(abstractResistance);
        return result;
    }       

    public static Megaohm changeToMegaohm(AbstractResistance abstractResistance) {
        Megaohm result = new Megaohm(0);
        result.add(abstractResistance);
        return result;
    }       

    public static Kiloohm changeToKiloohm(AbstractResistance abstractResistance) {
        Kiloohm result = new Kiloohm(0);
        result.add(abstractResistance);
        return result;
    }       

    public static Ohm changeToOhm(AbstractResistance abstractResistance) {
        Ohm result = new Ohm(0);
        result.add(abstractResistance);
        return result;
    }   	

    public static Milliohm changeToMilliohm(AbstractResistance abstractResistance) {
        Milliohm result = new Milliohm(0);
        result.add(abstractResistance);
        return result;
    }       

	public static Microohm changeToMicroohm(AbstractResistance abstractResistance) {
		Microohm result = new Microohm(0);
		result.add(abstractResistance);
		return result;
	}	

    public static Gigaohm changeToGigaohm(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getGigaohm());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Gigaohm result = new Gigaohm(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Megaohm changeToMegaohm(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMegaohm());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Megaohm result = new Megaohm(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Kiloohm changeToKiloohm(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKiloohm());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kiloohm result = new Kiloohm(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Ohm changeToOhm(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getOhm());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Ohm result = new Ohm(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Milliohm changeToMilliohm(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMilliohm());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Milliohm result = new Milliohm(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Microohm changeToMicroohm(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicroohm());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microohm result = new Microohm(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
