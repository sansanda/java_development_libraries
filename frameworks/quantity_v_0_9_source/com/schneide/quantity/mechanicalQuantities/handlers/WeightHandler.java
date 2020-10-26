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
public class WeightHandler {

	/**
	 * Constructor for LengthHandler.
	 */
	public WeightHandler() {
		super();
	}
	
	public static Kilogram changeToKilogram(AbstractWeight abstractWeight) {
		Kilogram result = new Kilogram(0);
		result.add(abstractWeight);
		return result;
	}
	
	public static Gram changeToGram(AbstractWeight abstractWeight) {
		Gram result = new Gram(0);
		result.add(abstractWeight);
		return result;
	}
	
	public static Milligram changeToMilligram(AbstractWeight abstractWeight) {
		Milligram result = new Milligram(0);
		result.add(abstractWeight);
		return result;
	}
	
	public static Microgram changeToMicrogram(AbstractWeight abstractWeight) {
		Microgram result = new Microgram(0);
		result.add(abstractWeight);
		return result;
	}	

	
    public static Kilogram changeToKilogram(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilogram());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kilogram result = new Kilogram(resultValue.getValue(), resultValue.getPower());
        return result;
    }       

    public static Gram changeToGram(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getGram());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Gram result = new Gram(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Milligram changeToMilligram(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMilligram());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Milligram result = new Milligram(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Microgram changeToMicrogram(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrogram());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microgram result = new Microgram(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
