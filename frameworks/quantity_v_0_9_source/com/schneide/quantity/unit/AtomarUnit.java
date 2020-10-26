/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.unit;

import com.schneide.quantity.ConversionFactor;

/**
 *The <code>AtomarUnit</code> is the part of the {@link com.schneide.quantity.unit.Unit}, which knows
 *all facts about the unit like name of the unit and its {@link com.schneide.quantity.unit.AtomarSignature}<br>
 *To get to know more about the use of units see {@link com.schneide.quantity.unit.Unit}.
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, 
 * <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public abstract class AtomarUnit {

	AtomarSignature atomarSignature = null;
	
	/**
	 * Constructor for AtomarUnit.
	 * @param atomarSignature
	 */
	protected AtomarUnit(AtomarSignature atomarSignature) {
		super();
		this.atomarSignature = atomarSignature;
	}
	
	/**
	 * This method returns the full name of the referenced compoundUnit.<br>
	 * For example if the compoundUnit represents a meter, the return value of this method is
	 * "meter".
	 * @see #getUnitAbbreviation()
	 * @return String
	 */
	abstract public String getUnitName();		
	
	/**
	 * This method returns the abbreviation of the referenced compoundUnit.<br>
	 * For example, if the compoundUnit represents a meter, the return value
	 * of this method is "m".
	 * @return String
	 */
	abstract public String getUnitAbbreviation();
	
	/**
	 * Returns the conversion factor the value of this AtomarUnit needs to be
	 * multiplied with to get the value for the appropriate reference compoundUnit.
	 * For example, if the reference compoundUnit is a second, and this
	 * AtomarUnit is an hour, the return value is 0.277777777778*10^(-3).
	 * @see ConversionFactor
	 * @return ConversionFactor
	 */
	abstract public ConversionFactor getConversionFactorToReferenceUnit();

	/**
	 * Returns the signatures.
	 * @return AtomarSignature
	 */
	public AtomarSignature getAtomarSignature() {
		return atomarSignature;
	}

	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean result = false;
		AtomarUnit object = null; 
		try{
			object = (AtomarUnit) obj;
			if (this.atomarSignature.equals(object.atomarSignature)
					&& this.getConversionFactorToReferenceUnit().equals(object.getConversionFactorToReferenceUnit())){
				result = true;				
			}
		} catch (ClassCastException e){
			result = false;
		} 
		return result;
	}

}
