/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.mechanicalQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.mechanicalQuantities.AbstractDensity;
import com.schneide.quantity.mechanicalQuantities.KilogramPerCubicmeter;



/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class DensityHandler {

	/**
	 * Constructor for DensityHandler.
	 */
	public DensityHandler() {
		super();
	}
	
	public static KilogramPerCubicmeter changeToKilogramPerCubicmeter(AbstractDensity abstractDensity) {
		KilogramPerCubicmeter result = new KilogramPerCubicmeter(0);
		result.add(abstractDensity);
		return result;
	}
	
    public static KilogramPerCubicmeter changeToKilogramPerCubicmeter(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilogramPerCubicmeter());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        KilogramPerCubicmeter result = new KilogramPerCubicmeter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
	
}
