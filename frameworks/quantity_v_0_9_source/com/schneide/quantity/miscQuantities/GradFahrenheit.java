/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.miscQuantities;

import com.schneide.quantity.AbstractQuantity;
import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.WrongUnitException;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class GradFahrenheit extends AbstractQuantity {

    /**
     * Constructor for GradFahrenheit.
     * @param value
     */
    public GradFahrenheit(double value) {
        super(value, FrequentlyUsedUnits.getGradFahrenheit());
    }

    /**
     * Constructor for GradFahrenheit.
     * @param recreationableString
     * @throws WrongUnitException
     */
    public GradFahrenheit(String recreationableString) throws WrongUnitException {
        super(recreationableString);
    }

    /**
     * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
     */
    protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getGradFahrenheit());
		return result;
    }

}
