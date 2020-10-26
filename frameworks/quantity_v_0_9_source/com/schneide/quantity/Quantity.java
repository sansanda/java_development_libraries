/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity;



/**
 * Quantity is the all round class for all values with units. You can create quantities with units we
 * haven't created up to now and you can use the Quantity as container for all arbitrary units. But if
 * you want to take care which unit your quantities have to avoid errors, you should use the specific
 * quantities like Meter. You can also create your own specific quantities, which is very easy with this
 * framework.<br>
 * To get to know more about the different possibilities to use the quantity framefork an its architekture
 * see our <a href="http://www.Softwareschneiderei.de/quantity.html">Homepage</a>.
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, 
 * <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class Quantity extends AbstractQuantity {

	/**
	 * Constructor for Quantity.
	 * @param value
	 * @param unit
	 */
	public Quantity(double value, CompoundUnit unit) {
		super(value, unit);
	}

    /**
     * Constructor for Quantity.
     * @param value
     * @param power
	 * @param unit
     */
    public Quantity(double value, int power, CompoundUnit unit) {
        super(value, power, unit);
    }


	/**
	 * Constructor for Quantity.
	 * @param recreationableString
	 * @throws WrongUnitException
	 */
	public Quantity(String recreationableString) throws WrongUnitException {
		super(recreationableString);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#isUnitCorrect()
	 */
	protected boolean isUnitCorrect() {
		return true;
	}

	/**
	 * @param toAdd
	 * @throws WrongUnitException
	 */
	public void add(AbstractQuantity toAdd) throws WrongUnitException {
		super.add(toAdd);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#changeToUnit(com.schneide.quantity.CompoundUnit)
	 */
	public void changeToUnit(CompoundUnit targetUnit) throws WrongUnitException {
		super.changeToUnit(targetUnit);
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	public Object clone()  {
		return super.clone();
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#divide(com.schneide.quantity.AbstractQuantity)
	 */
	public void divide(AbstractQuantity divisor) {
		super.divide(divisor);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#multiply(com.schneide.quantity.AbstractQuantity)
	 */
	public void multiply(AbstractQuantity multiplicator) {
		super.multiply(multiplicator);
	}

	/**
	 * @see com.schneide.quantity.AbstractQuantity#substract(com.schneide.quantity.AbstractQuantity)
	 */
	public void substract(AbstractQuantity substractThis)
		throws WrongUnitException {
		super.substract(substractThis);
	}
	
	/**
	 * if the scale units are different but are the same compoundUnit class,
	 * the resulting AbstractQuantity will have the scale units of quantity2
	 */
	public static AbstractQuantity add(AbstractQuantity quantity1, AbstractQuantity quantity2) throws WrongUnitException{
		AbstractQuantity result = null;
		result = (AbstractQuantity) quantity1.clone();
		result.add(quantity2);
		return result;
	}


	public static AbstractQuantity substract(AbstractQuantity quantity1, AbstractQuantity quantity2) throws WrongUnitException{
		AbstractQuantity result = null;
		result = (AbstractQuantity) quantity1.clone();
		result.substract(quantity2);
		return result;
	}

	public static Quantity multiply(AbstractQuantity quantity1, AbstractQuantity quantity2) {
		Quantity result = QuantityHandler.changeToQuantity((AbstractQuantity) quantity1.clone());
		result.multiply(quantity2);
		return result;
	}
	
//	public static AbstractQuantity divide(AbstractQuantity divident, AbstractQuantity divisor) {
//		AbstractQuantity result = (AbstractQuantity) divident.clone();
//		result.divide(divisor);
//		return result;
//	}

	public static Quantity divide(AbstractQuantity divident, AbstractQuantity divisor) {
		Quantity result = QuantityHandler.changeToQuantity((AbstractQuantity) divident.clone());
		result.divide(divisor);
		return result;
	}
}
