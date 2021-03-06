/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.radioactivityQuantities;

import com.schneide.quantity.AbstractQuantity;
import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.WrongUnitException;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Sievert extends AbstractQuantity {

    /**
     * Constructor for Sievert.
     * @param value
     */
    public Sievert(double value) {
        super(value, FrequentlyUsedUnits.getSievert());
    }

    /**
     * Constructor for Sievert.
     * @param recreationableString
     * @throws WrongUnitException
     */
    public Sievert(String recreationableString) throws WrongUnitException {
        super(recreationableString);
    }

    /**
     * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
     */
    protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getSievert());
		return result;
    }

}
