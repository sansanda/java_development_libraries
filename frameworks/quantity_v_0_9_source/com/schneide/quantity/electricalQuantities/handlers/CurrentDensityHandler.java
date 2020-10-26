/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.electricalQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.electricalQuantities.AbstractCurrentDensity;
import com.schneide.quantity.electricalQuantities.AmperePerSquareMeter;





/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class CurrentDensityHandler {

	/**
	 * Constructor for CurrentHandler.
	 */
	public CurrentDensityHandler() {
		super();
	}

    public static AmperePerSquareMeter changeToAmperePerSquareMeter(AbstractCurrentDensity abstractCurrentDensity) {
        AmperePerSquareMeter result = new AmperePerSquareMeter(0);
        result.add(abstractCurrentDensity);
        return result;
    }   
    
    public static AmperePerSquareMeter changeToAmperePerSquareMeter(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getAmperePerSquareMeter());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        AmperePerSquareMeter result = new AmperePerSquareMeter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
