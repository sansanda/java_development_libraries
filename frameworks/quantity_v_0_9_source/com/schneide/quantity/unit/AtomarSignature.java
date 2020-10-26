/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.unit;

/**
 *The <code>Signatur</code> is the characteristic which desides, which <code>Units</code> can
 *be converted to each other. If two<code>Units</code> have the same <code>Signature</code>
 *they can can be converted.<br>
 *For each Signature, you have to specify a referenceUnit. See {@link #getReferenceUnit()}.<br>
 *The <code>AtomatSignature</code> is used in the class {@link com.schneide.quantity.unit.Unit}.
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, 
 * <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public abstract class AtomarSignature implements Cloneable{

	final protected String getSignature() {
		String result = this.getClass().getName();
		return result;
	}

	/**
	 * For all units with the same <code>Signatur</code> you have to declare the conversion faktor
	 * to get the declared unit in reference unit.
	 * 
	 * @return the unit whisch is the reference for all units with same Signature  
	 */
	abstract public AtomarUnit getReferenceUnit();
	
	/**
	 * checks if two atomar signatures represent the same signatures.
	 * This does not check exponent equality.
	 * 
	 * @see #equalsSignature(AtomarSignature) 
	 * @param atomarSignature
	 * @return true if the signatures are the same.
	 */
	public boolean equalsSignature(AtomarSignature atomarSignature) {
		boolean result = false;
		if (this.getSignature().equals(atomarSignature.getSignature())) {
			result = true;
		} 
		return result; 
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean result = false;
		try{
			result = equalsSignature((AtomarSignature)obj);
		} catch(ClassCastException e) {
			result = false;
		}
		return result;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		String hashString = this.getClass().getName();
		return hashString.hashCode();
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("CloneNotSupportedException in AtomarSignature.clone");
		}
	}

}
