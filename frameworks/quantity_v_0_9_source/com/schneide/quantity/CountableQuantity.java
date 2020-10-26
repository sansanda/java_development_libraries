/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public abstract class CountableQuantity extends AbstractQuantity {

    /**
     * @param value
     */
    public CountableQuantity(double value) {
        super(value, FrequentlyUsedUnits.getDimensionlessUnit());
		compoundUnit.setUnitName(this.getUnitAbbreviation());
    }

    /**
     * @param value
     * @param power
     */
    public CountableQuantity(double value, int power) {
        super(value, power, FrequentlyUsedUnits.getDimensionlessUnit());
        compoundUnit.setUnitName(this.getUnitAbbreviation());
    }

    /**
     * @return
     */
    abstract protected String getUnitAbbreviation();

    /**
     * @param recreationableString
     * @throws WrongUnitException
     */
    public CountableQuantity(String recreationableString)
        throws WrongUnitException {
        super(recreationableString);
    }

    protected boolean isUnitCorrect() {
        return true;
    }

    public void add(CountableQuantity toAdd) throws WrongUnitException {
    	if (toAdd.getClass().getName().equals(this.getClass().getName())) {
			super.add(toAdd);
    	} else {
    		throw new WrongUnitException("Can not add " + toAdd.getUnitAbbreviation() + " to " + this.getUnitAbbreviation());
    	}
    }

	public void substract(CountableQuantity substractThis) throws WrongUnitException {
		if (substractThis.getClass().getName().equals(this.getClass().getName())) {
			super.substract(substractThis);
		} else {
			throw new WrongUnitException("Can not substract " + substractThis.getUnitAbbreviation() + " from " + this.getUnitAbbreviation());
		}
	}

    protected void divide(CountableQuantity divisor) {
        super.divide(divisor);
    }

    protected void multiply(CountableQuantity multiplicator) {
        super.multiply(multiplicator);
    }

    public String getUnitString() {
        return this.getUnitAbbreviation();
    }

}
