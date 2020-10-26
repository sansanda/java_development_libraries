/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.mechanicalQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.mechanicalQuantities.AbstractForce;
import com.schneide.quantity.mechanicalQuantities.Newton;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class ForceHandler {

	/**
	 * Constructor for ForceHandler.
	 */
	public ForceHandler() {
		super();
	}

	public static Newton changeToNewton(AbstractForce abstractForce) {
		Newton result = new Newton(0);
		result.add(abstractForce);
		return result;
	}

    public static Newton changeToNewton(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getNewton());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Newton result = new Newton(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
