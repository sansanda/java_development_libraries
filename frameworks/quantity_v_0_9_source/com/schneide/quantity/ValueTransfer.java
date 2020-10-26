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
public class ValueTransfer {

	private double value = 1.0d;
	private int power = 0;
	/**
	 * Constructor for ValueTransfer.
	 */
	public ValueTransfer(double value, int power) {
		this.value = value;
		this.power = power;
	}
	
	public ValueTransfer() {
		this.value = 1.0d;
		this.power = 0;
	}
	

	/**
	 * Returns the potence.
	 * @return int
	 */
	public int getPower() {
		return power;
	}

	/**
	 * Returns the value.
	 * @return double
	 */
	public double getValue() {
		return value;
	}
	
	void multiply(ValueTransfer mult) {
		this.power += mult.power;
		this.value *= mult.value;
	}
	


    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
		String result = value + " * 10^" + power;
		return result;
    }
    
	/**
	 * Method toPower.
	 * @param exponent
	 */
	public void toPower(int exponent) {
		this.value = Math.pow(this.value, exponent);
		this.power *= exponent;
	}

}
