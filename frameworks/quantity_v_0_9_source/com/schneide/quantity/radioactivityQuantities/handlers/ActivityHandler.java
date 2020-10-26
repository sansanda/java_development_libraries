/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.radioactivityQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.radioactivityQuantities.*;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class ActivityHandler {

    /**
     * Constructor for ActivityHandler.
     */
    public ActivityHandler() {
        super();
    }

    public static Terabequerel changeToTerabequerel(AbstractActivity abstractActivity) {
        Terabequerel result = new Terabequerel(0);
        result.add(abstractActivity);
        return result;
    }

    public static Gigabequerel changeToGigabequerel(AbstractActivity abstractActivity) {
        Gigabequerel result = new Gigabequerel(0);
        result.add(abstractActivity);
        return result;
    }

    public static Megabequerel changeToMegabequerel(AbstractActivity abstractActivity) {
        Megabequerel result = new Megabequerel(0);
        result.add(abstractActivity);
        return result;
    }

    public static Kilobequerel changeToKilobequerel(AbstractActivity abstractActivity) {
        Kilobequerel result = new Kilobequerel(0);
        result.add(abstractActivity);
        return result;
    }

    public static Bequerel changeToBequerel(AbstractActivity abstractActivity) {
        Bequerel result = new Bequerel(0);
        result.add(abstractActivity);
        return result;
    }

    public static Millibequerel changeToMillibequerel(AbstractActivity abstractActivity) {
        Millibequerel result = new Millibequerel(0);
        result.add(abstractActivity);
        return result;
    }


    public static Terabequerel changeToTerabequerel(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getTerabequerel());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Terabequerel result = new Terabequerel(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Gigabequerel changeToGigabequerel(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getGigabequerel());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Gigabequerel result = new Gigabequerel(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Megabequerel changeToMegabequerel(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMegabequerel());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Megabequerel result = new Megabequerel(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Kilobequerel changeToKilobequerel(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKilobequerel());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kilobequerel result = new Kilobequerel(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Bequerel changeToBequerel(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getBequerel());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Bequerel result = new Bequerel(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Millibequerel changeToMillibequerel(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMillibequerel());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Millibequerel result = new Millibequerel(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
