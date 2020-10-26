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
public class Megabequerel extends AbstractActivity {

	/**
	 * Constructor for Megabequerel.
	 * @param value
	 */
	public Megabequerel(double value) {
		super(value, FrequentlyUsedUnits.getMegabequerel());
	}

    /**
     * Method Megabequerel.
     * @param value
     * @param power
     */
    public Megabequerel(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getMegabequerel());
    }

	/**
	 * Constructor for Megabequerel.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Megabequerel(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMegabequerel());
		return result;
	}
	
	public static Megabequerel add(AbstractActivity quantity1, AbstractActivity quantity2) {
		AbstractActivity preResult = (AbstractActivity) Quantity.add(quantity1, quantity2);
		Megabequerel result = ActivityHandler.changeToMegabequerel(preResult);
		return result;	
	}
	
	public static Megabequerel substract(AbstractActivity quantity1, AbstractActivity quantity2) {
		AbstractActivity preResult = (AbstractActivity) Quantity.substract(quantity1, quantity2);
		Megabequerel result = ActivityHandler.changeToMegabequerel(preResult);
		return result;
	}

}
