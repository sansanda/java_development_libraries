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
public class WrongUnitException extends RuntimeException {

	/**
	 * Constructor for WrongUnitException.
	 */
	public WrongUnitException() {
		super();
	}

	/**
	 * Constructor for WrongUnitException.
	 * @param arg0
	 */
	public WrongUnitException(String arg0) {
		super(arg0);
	}

	/**
	 * Constructor for WrongUnitException.
	 * @param arg0
	 * @param arg1
	 */
	public WrongUnitException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Constructor for WrongUnitException.
	 * @param arg0
	 */
	public WrongUnitException(Throwable arg0) {
		super(arg0);
	}

}
