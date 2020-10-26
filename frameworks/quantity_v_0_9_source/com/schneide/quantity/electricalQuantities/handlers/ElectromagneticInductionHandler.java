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
public class ElectromagneticInductionHandler {

	/**
	 * Constructor for ElectromagneticInductionHandler.
	 */
	public ElectromagneticInductionHandler() {
		super();
	}

    public static Tesla changeToTesla(AbstractElectromagneticInduction abstractElectromagneticInduction) {
        Tesla result = new Tesla(0);
        result.add(abstractElectromagneticInduction);
        return result;
    }   	

    public static Millitesla changeToMillitesla(AbstractElectromagneticInduction abstractElectromagneticInduction) {
        Millitesla result = new Millitesla(0);
        result.add(abstractElectromagneticInduction);
        return result;
    }       

	public static Microtesla changeToMicrotesla(AbstractElectromagneticInduction abstractElectromagneticInduction) {
		Microtesla result = new Microtesla(0);
		result.add(abstractElectromagneticInduction);
		return result;
	}	

    public static Nanotesla changeToNanotesla(AbstractElectromagneticInduction abstractElectromagneticInduction) {
        Nanotesla result = new Nanotesla(0);
        result.add(abstractElectromagneticInduction);
        return result;
    }
    
    public static Picotesla changeToPicotesla(AbstractElectromagneticInduction abstractElectromagneticInduction) {
        Picotesla result = new Picotesla(0);
        result.add(abstractElectromagneticInduction);
        return result;
    }
    
    public static Tesla changeToTesla(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getTesla());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Tesla result = new Tesla(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Millitesla changeToMillitesla(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMillitesla());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Millitesla result = new Millitesla(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Microtesla changeToMicrotesla(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrotesla());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microtesla result = new Microtesla(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Nanotesla changeToNanotesla(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getNanotesla());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Nanotesla result = new Nanotesla(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Picotesla changeToPicotesla(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getPicotesla());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Picotesla result = new Picotesla(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
