/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.radioactivityQuantities;

import com.schneide.quantity.FrequentlyUsedUnits;
import com.schneide.quantity.Quantity;
import com.schneide.quantity.WrongUnitException;
import com.schneide.quantity.radioactivityQuantities.handlers.ActivityHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Kilobequerel extends AbstractActivity {

	/**
	 * Constructor for Kilobequerel.
	 * @param value
	 */
	public Kilobequerel(double value) {
		super(value, FrequentlyUsedUnits.getKilobequerel());
	}

    /**
     * Method Kilobequerel.
     * @param value
     * @param power
     */
    public Kilobequerel(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getKilobequerel());
    }

	/**
	 * Constructor for Kilobequerel.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Kilobequerel(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getKilobequerel());
		return result;
	}
	
	public static Kilobequerel add(AbstractActivity quantity1, AbstractActivity quantity2) {
		AbstractActivity preResult = (AbstractActivity) Quantity.add(quantity1, quantity2);
		Kilobequerel result = ActivityHandler.changeToKilobequerel(preResult);
		return result;	
	}
	
	public static Kilobequerel substract(AbstractActivity quantity1, AbstractActivity quantity2) {
		AbstractActivity preResult = (AbstractActivity) Quantity.substract(quantity1, quantity2);
		Kilobequerel result = ActivityHandler.changeToKilobequerel(preResult);
		return result;
	}

}
