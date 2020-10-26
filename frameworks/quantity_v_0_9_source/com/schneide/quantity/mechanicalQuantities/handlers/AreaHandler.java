/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.mechanicalQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.mechanicalQuantities.*;



/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class AreaHandler {

	/**
	 * Constructor for AreaHandler.
	 */
	public AreaHandler() {
		super();
	}
	
	public static SquareKilometer changeToSquareKilometer(AbstractArea abstractArea) {
		SquareKilometer result = new SquareKilometer(0);
		result.add(abstractArea);
		return result;
	}	
	
	public static SquareMeter changeToSquareMeter(AbstractArea abstractArea) {
		SquareMeter result = new SquareMeter(0);
		result.add(abstractArea);
		return result;
	}
	
	public static SquareMillimeter changeToSquareMillimeter(AbstractArea abstractArea) {
		SquareMillimeter result = new SquareMillimeter(0);
		result.add(abstractArea);
		return result;
	}
	
	public static SquareMicrometer changeToSquareMicrometer(AbstractArea abstractArea) {
		SquareMicrometer result = new SquareMicrometer(0);
		result.add(abstractArea);
		return result;
	}

	public static SquareNanometer changeToSquareNanometer(AbstractArea abstractArea) {
		SquareNanometer result = new SquareNanometer(0);
		result.add(abstractArea);
		return result;
	}

    public static SquareKilometer changeToSquareKilometer(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getSquareKilometer());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        SquareKilometer result = new SquareKilometer(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static SquareMeter changeToSquareMeter(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getSquareMeter());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        SquareMeter result = new SquareMeter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static SquareMillimeter changeToSquareMillimeter(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getSquareMillimeter());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        SquareMillimeter result = new SquareMillimeter(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static SquareMicrometer changeToSquareMicrometer(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getSquareMicrometer());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        SquareMicrometer result = new SquareMicrometer(resultValue.getValue(), resultValue.getPower());
        return result;
    }       

	public static SquareNanometer changeToSquareNanometer(Quantity quantity) throws WrongUnitException{
		Quantity clonedQuantity = (Quantity) quantity.clone();
		clonedQuantity.changeToUnit(FrequentlyUsedUnits.getSquareNanometer());
		ValueTransfer resultValue = clonedQuantity.getValueWithPower();
		SquareNanometer result = new SquareNanometer(resultValue.getValue(), resultValue.getPower());
		return result;
	}       
		
}
