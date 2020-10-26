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
public class PressureHandler {

	/**
	 * Constructor for PressureHandler.
	 */
	public PressureHandler() {
		super();
	}
	
	public static Kilopascal changeToKilopascal(AbstractPressure abstractPressure) {
		Kilopascal result = new Kilopascal(0);
		result.add(abstractPressure);
		return result;
	}

	public static Pascal changeToPascal(AbstractPressure abstractPressure) {
		Pascal result = new Pascal(0);
		result.add(abstractPressure);
		return result;
	}	
	
	public static Millipascal changeToMillipascal(AbstractPressure abstractPressure) {
		Millipascal result = new Millipascal(0);
		result.add(abstractPressure);
		return result;
	}
	
	public static Micropascal changeToMicropascal(AbstractPressure abstractPressure) {
		Micropascal result = new Micropascal(0);
		result.add(abstractPressure);
		return result;
	}


    public static Kilopascal changeToKilopascal(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilopascal());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kilopascal result = new Kilopascal(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Pascal changeToPascal(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getPascal());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Pascal result = new Pascal(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Millipascal changeToMillipascal(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMillipascal());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Millipascal result = new Millipascal(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Micropascal changeToMicropascal(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicropascal());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Micropascal result = new Micropascal(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
