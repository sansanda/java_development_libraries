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
public class Terabequerel extends AbstractActivity {

	/**
	 * Constructor for Terabequerel.
	 * @param value
	 */
	public Terabequerel(double value) {
		super(value, FrequentlyUsedUnits.getTerabequerel());
	}

    /**
     * Method Terabequerel.
     * @param value
     * @param power
     */
    public Terabequerel(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getTerabequerel());
    }

	/**
	 * Constructor for Terabequerel.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Terabequerel(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getTerabequerel());
		return result;
	}
	
	public static Terabequerel add(AbstractActivity quantity1, AbstractActivity quantity2) {
		AbstractActivity preResult = (AbstractActivity) Quantity.add(quantity1, quantity2);
		Terabequerel result = ActivityHandler.changeToTerabequerel(preResult);
		return result;	
	}
	
	public static Terabequerel substract(AbstractActivity quantity1, AbstractActivity quantity2) {
		AbstractActivity preResult = (AbstractActivity) Quantity.substract(quantity1, quantity2);
		Terabequerel result = ActivityHandler.changeToTerabequerel(preResult);
		return result;
	}

}
