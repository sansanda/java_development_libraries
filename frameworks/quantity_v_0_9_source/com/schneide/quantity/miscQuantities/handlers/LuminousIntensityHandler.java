/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.miscQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.miscQuantities.AbstractLuminousIntensity;
import com.schneide.quantity.miscQuantities.Candela;



/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class LuminousIntensityHandler {

	/**
	 * Constructor for CurrentHandler.
	 */
	public LuminousIntensityHandler() {
		super();
	}
	
	public static Candela changeToCandela(AbstractLuminousIntensity abstractLuminousIntensity) {
		Candela result = new Candela(0);
		result.add(abstractLuminousIntensity);
		return result;
	}	


    public static Candela changeToCandela(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getCandela());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Candela result = new Candela(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
