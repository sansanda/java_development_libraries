/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.miscQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.miscQuantities.AbstractAmountOfSubstance;
import com.schneide.quantity.miscQuantities.Mole;



/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class AmountOfSubstanceHandler {

	/**
	 * Constructor for AmountOfSubstanceHandler.
	 */
	public AmountOfSubstanceHandler() {
		super();
	}
	
	public static Mole changeToMole(AbstractAmountOfSubstance abstractAmountOfSubstance) {
		Mole result = new Mole(0);
		result.add(abstractAmountOfSubstance);
		return result;
	}	


    public static Mole changeToMole(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMole());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Mole result = new Mole(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
