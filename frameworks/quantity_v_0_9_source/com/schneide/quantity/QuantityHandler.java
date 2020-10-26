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
public class QuantityHandler {

	/**
	 * Constructor for QuantityHandler.
	 */
	public QuantityHandler() {
		super();
	}

    public static Quantity changeToQuantity(AbstractQuantity abstractQuantity) {
        Quantity result = new Quantity(0, (CompoundUnit) abstractQuantity.getCompoundUnit().clone());
        result.add(abstractQuantity);
        return result;
    }   	
}
