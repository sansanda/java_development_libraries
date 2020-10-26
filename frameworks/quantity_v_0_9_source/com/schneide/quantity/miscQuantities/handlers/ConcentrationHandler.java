/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.miscQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.miscQuantities.AbstractConcentration;
import com.schneide.quantity.miscQuantities.PartsPerBillion;



/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class ConcentrationHandler {

	/**
	 * Constructor for AmountOfSubstanceHandler.
	 */
	public ConcentrationHandler() {
		super();
	}
	
    public static PartsPerBillion changeToPartsPerBillion(AbstractConcentration abstractConcentration) {
        PartsPerBillion result = new PartsPerBillion(0);
        result.add(abstractConcentration);
        return result;
    }   

    public static PartsPerBillion changeToPartsPerBillion(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getPartsPerBillion());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
		PartsPerBillion result = new PartsPerBillion(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
