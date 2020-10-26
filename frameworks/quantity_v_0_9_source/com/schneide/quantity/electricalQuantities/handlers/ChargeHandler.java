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
public class ChargeHandler {

	/**
	 * Constructor for QuantityHandler.
	 */
	public ChargeHandler() {
		super();
	}

    public static Coulomb changeToCoulomb(AbstractCharge abstractCharge) {
        Coulomb result = new Coulomb(0);
        result.add(abstractCharge);
        return result;
    }   	

    public static Millicoulomb changeToMillicoulomb(AbstractCharge abstractCharge) {
        Millicoulomb result = new Millicoulomb(0);
        result.add(abstractCharge);
        return result;
    }       

	public static Microcoulomb changeToMicrocoulomb(AbstractCharge abstractCharge) {
		Microcoulomb result = new Microcoulomb(0);
		result.add(abstractCharge);
		return result;
	}	


    public static Coulomb changeToCoulomb(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getCoulomb());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Coulomb result = new Coulomb(resultValue.getValue(), resultValue.getPower());
        return result;
    }       

    public static Millicoulomb changeToMillicoulomb(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMillicoulomb());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Millicoulomb result = new Millicoulomb(resultValue.getValue(), resultValue.getPower());
        return result;
    }       

    public static Microcoulomb changeToMicrocoulomb(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrocoulomb());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microcoulomb result = new Microcoulomb(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
}
