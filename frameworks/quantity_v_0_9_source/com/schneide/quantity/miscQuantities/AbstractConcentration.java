/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.miscQuantities;

import com.schneide.quantity.AbstractQuantity;
import com.schneide.quantity.CompoundUnit;
import com.schneide.quantity.WrongUnitException;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
*/
public abstract class AbstractConcentration extends AbstractQuantity {

	/**
	 * Constructor for AbstractAmountOfSubstance.
	 * @param value
    * @param unit
	 */
	public AbstractConcentration(double value, CompoundUnit unit) {
		super(value, unit);
	}

    /**
     * Constructor for AbstractAmountOfSubstance.
     * @param value
     * @param power
    * @param unit
     */
    public AbstractConcentration(double value, int power, CompoundUnit unit) {
        super(value, power, unit);
    }

	/**
	 * Constructor for AbstractAmountOfSubstance.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public AbstractConcentration(String recreationableString)
		throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @param toAdd
	 * @throws WrongUnitException
	 */
	public void add(AbstractConcentration toAdd) throws WrongUnitException {
		super.add(toAdd);
	}

	/**
	 * @param subtractThis
	 * @throws WrongUnitException
	 */
	public void substract(AbstractConcentration subtractThis)
		throws WrongUnitException {
		super.substract(subtractThis);
	}
	
}
