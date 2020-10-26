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
public class EnergyDoseHandler {

    /**
     * Constructor for EnergyDoseHandler.
     */
    public EnergyDoseHandler() {
        super();
    }

    public static Gray changeToGray(AbstractEnergyDose abstractEnergyDose) {
        Gray result = new Gray(0);
        result.add(abstractEnergyDose);
        return result;
    }

    public static Gray changeToGray(Sievert sievert, double qualityFactor, double distributionFactor) {
        Gray result = new Gray(sievert.getValue() / ( qualityFactor * distributionFactor));
        return result;
    }

    public static Milligray changeToMilligray(AbstractEnergyDose abstractEnergyDose) {
        Milligray result = new Milligray(0);
        result.add(abstractEnergyDose);
        return result;
    }

    public static Microgray changeToMicrogray(AbstractEnergyDose abstractEnergyDose) {
        Microgray result = new Microgray(0);
        result.add(abstractEnergyDose);
        return result;
    }

    public static Sievert changeToSievert(AbstractEnergyDose abstractEnergyDose, double qualityFactor, double distributionFactor) {
        Gray helpResult = EnergyDoseHandler.changeToGray(abstractEnergyDose);
        Sievert result = new Sievert(helpResult.getValue() * qualityFactor * distributionFactor);
        return result;
    }

    public static Gray changeToGray(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getGray());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Gray result = new Gray(resultValue.getValue(), resultValue.getPower());
        return result;
    }       

    public static Milligray changeToMilligray(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMilligray());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Milligray result = new Milligray(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
    public static Microgray changeToMicrogray(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getMicrogray());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Microgray result = new Microgray(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
	
}
