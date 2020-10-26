/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.unit;

/**
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, 
 * <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class DimensionlessUnit extends Unit {
	

	/**
	 * Constructor for DimensionlessUnit.
	 * @param scaleExponent
	 */
	public DimensionlessUnit(int scaleExponent) {
		super(new AtomarDimensionlessUnit(), 1, scaleExponent);
	}

	public DimensionlessUnit(){
		super(new AtomarDimensionlessUnit());
	}
	
	/**
	 * @see com.schneide.quantity.unit.Unit#getExponent()
	 */
	public int getExponent() {
		return 1;
	}

}
