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
public class InductanceHandler {

	/**
	 * Constructor for InductanceHandler.
	 */
	public InductanceHandler() {
		super();
	}

    public static Henry changeToHenry(AbstractInductance abstractInductance) {
        Henry result = new Henry(0);
        result.add(abstractInductance);
        return result;
    }   	

    public static Millihenry changeToMillihenry(AbstractInductance abstractInductance) {
        Millihenry result = new Millihenry(0);
        result.add(abstractInductance);
        return result;
    }       

	public static Microhenry changeToMicrohenry(AbstractInductance abstractInductance) {
		Microhenry result = new Microhenry(0);
		result.add(abstractInductance);
		return result;
	}	

    public static Henry changeToHenry(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getHenry());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Henry result = new Henry(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Millihenry changeToMillihenry(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMillihenry());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Millihenry result = new Millihenry(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Microhenry changeToMicrohenry(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrohenry());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microhenry result = new Microhenry(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
