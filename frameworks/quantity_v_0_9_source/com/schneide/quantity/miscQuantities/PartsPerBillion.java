/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.miscQuantities;

import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.Quantity;
import com.schneide.quantity.WrongUnitException;
import com.schneide.quantity.miscQuantities.handlers.ConcentrationHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class PartsPerBillion extends AbstractConcentration {

    /**
     * @param value
     */
    public PartsPerBillion(double value) {
        super(value, FrequentlyUsedUnits.getPartsPerBillion());
    }

    /**
     * @param value
     * @param power
     */
    public PartsPerBillion(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getPartsPerBillion());
    }

    /**
     * @param recreationableString
     * @throws WrongUnitException
     */
    public PartsPerBillion(String recreationableString)
        throws WrongUnitException {
        super(recreationableString);
    }

    /* (non-Javadoc)
     * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
     */
    protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getPartsPerBillion());
		return result;
    }

    public static PartsPerBillion add(AbstractConcentration quantity1, AbstractConcentration quantity2) {
        AbstractConcentration preResult = (AbstractConcentration) Quantity.add(quantity1, quantity2);
        PartsPerBillion result = ConcentrationHandler.changeToPartsPerBillion(preResult);
        return result;  
    }
    
    public static PartsPerBillion substract(AbstractConcentration quantity1, AbstractConcentration quantity2) {
        AbstractConcentration preResult = (AbstractConcentration) Quantity.substract(quantity1, quantity2);
        PartsPerBillion result = ConcentrationHandler.changeToPartsPerBillion(preResult);
        return result;
    }


}
