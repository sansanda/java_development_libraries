/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity;

import java.util.*;

import com.schneide.quantity.unit.*;

/**
 *The <code>CompoundUnit</code> manages the different {@link com.schneide.quantity.unit.Unit}. 
 *Every {@link com.schneide.quantity.unit.AtomarSignature} is unique. To learn more about
 *the use of <code>CompoundUnits</code> see "HowTo" on 
 *<a href="http://www.Softwareschneiderei.de/quantity.html">Homepage</a>
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, 
 * <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class CompoundUnit implements Cloneable {
	private static String SERIALIZING_DELIMITER = ":";
	
	/**
	 * The signature the compound compoundUnit carries is a 
	 * map containing AtomarSignature objects as key and 
	 * Unit objects as value.
	 */
	protected Map signature = null;
	protected String unitName = null;
	
	/**
	 * Constructor for CompoundUnit.
	 */
	public CompoundUnit() {
		super();
		signature = new HashMap();
		AtomarSignature key = new DimensionlessSignature();
		Unit value = new DimensionlessUnit();
		signature.put(key, value);
	}

	/**
	 * Constructor CompoundUnit.
	 * @param recreationableString
	 */
	public CompoundUnit(String recreationableString) {
		super();
		signature = new HashMap();
		
		StringTokenizer tokenizer = new StringTokenizer(recreationableString, SERIALIZING_DELIMITER);
		this.unitName = tokenizer.nextToken();
		if (this.unitName.equals("null")) {
			this.unitName = null;
		}
		while (tokenizer.hasMoreTokens()) {
			Unit value = new Unit(tokenizer.nextToken());
			AtomarSignature key = value.getAtomarSignature();
			signature.put(key, value);
		}
	}

	/**
	 * Puts the compoundUnit to the hashmap containing the 
	 * signature. If an entry of the same atomar signature
	 * already exists, it is overwritten.
	 * @param unit
	 */
	public void extendSignature(Unit unit){
		signature.put(unit.getAtomarUnit().getAtomarSignature(), unit);
	}

	/**
	 * returns the conversion factor from targetUnit to sourceUnit 
	 * @param target holds the targetUnit
	 * @param source holds the sourceUnit
	 * @return ValueTransfer the factor you need to multiply to source
	 * to get target
	 */
	private ValueTransfer calculateValueTransfer(Unit target, Unit source){
		ValueTransfer result = null;
		if (target.getAtomarSignature().equals(source.getAtomarSignature())) {
			if (target.getExponent() == source.getExponent()) {
				ConversionFactor conversionFactor = calculateConversionFactor(
						target.getAtomarUnit(),	source.getAtomarUnit());
				double changeValue = conversionFactor.getValue();
				int changePower = conversionFactor.getPower()
							 - target.getScaleExponent() 
							 + source.getScaleExponent();
				result = new ValueTransfer(changeValue, changePower);
                result.toPower(source.getExponent());
			} else {
				throw new WrongUnitException("target und source needs same exponent");
			} 
		} else {
			throw new WrongUnitException("target und source needs same signature");
		} 
		return result;
	}


    /**
     * Method calculateConversionFactor calculate the factor to get target
     * from source
     * @param targetUnit
     * @param sourceUnit
     * @return ConversionFactor the factor you need to multiply to source
	 * to get target
     */
    private ConversionFactor calculateConversionFactor(
        					AtomarUnit targetUnit,
        					AtomarUnit sourceUnit) {
        ConversionFactor result = sourceUnit.getConversionFactorToReferenceUnit();
        result.multiply(targetUnit.getConversionFactorToReferenceUnit().invert());
        return result;
    }

	/**
	 * Method multiply.
	 * @param compoundUnit
	 */
	public ValueTransfer multiply(CompoundUnit compoundUnit) {
		ValueTransfer result = new ValueTransfer();
		for (Iterator iter = compoundUnit.signature.keySet().iterator(); iter.hasNext();) {
            AtomarSignature element = (AtomarSignature) iter.next();
            Unit currentUnit = (Unit) this.signature.get(element);
            if (currentUnit == null) {
            	this.extendSignature((Unit)compoundUnit.signature.get(element));
            } else {
				/* speaking mathematically:
				 * transferUnit = (10^b * unit1)^k
				 * sourceUnit = (10^a * unit2)^n = (10^b * c * 10^d * unit1)^n
				 * 
				 * transferUnit * sourceUnit  
				 * = (10^b * unit1)^k * (10^b * unit1 * c * 10^d)^n
				 * = (c * 10^d)^n * (10^b * unit1)^(n+k)
				 * 
				 * where unitValueTransfer = (c * 10^d)^(n) 
				 */
            	Unit sourceUnit = (Unit)compoundUnit.signature.get(element);
            	Unit transferUnit = new Unit(currentUnit.getAtomarUnit(), 
            							sourceUnit.getExponent(), 
            							currentUnit.getScaleExponent());
            	
				int exponent = currentUnit.getExponent() + sourceUnit.getExponent();
            	ValueTransfer unitValueTransfer = calculateValueTransfer(transferUnit, sourceUnit);
				result.multiply(unitValueTransfer);
				currentUnit.setExponent(exponent);
            }
        }
		return result;
	}
	
//	/**
//	 * Method multiplySignature.
//	 * @param compoundUnit
//	 */
//	private void multiplySignature(Unit unit) {
//	}

    /**
     * Returns the unitName.
     * @return String
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * Sets the unitName.
     * @param unitName The unitName to set
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
	
	/**
	 * inverts this CompoundUnit
	 */
	void invert() {
		for (Iterator iter = this.signature.keySet().iterator(); iter.hasNext();) {
			AtomarSignature element = (AtomarSignature) iter.next();
			((Unit) this.signature.get(element)).invert();
		}
	}
	
	/**
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		CompoundUnit result = new CompoundUnit();
		
		for (Iterator iter = this.signature.keySet().iterator(); iter.hasNext();) {
			AtomarSignature element = (AtomarSignature) iter.next();
			Unit elementUnit = (Unit) this.signature.get(element);
			result.signature.put(element.clone(), elementUnit.clone());
		}
		result.unitName = this.unitName;
		return result;
	}
	
	/**
	 * The method isSameUnitAs() checks if the signature of targetUnit
	 * is identical with the signature of this CompoundUnit.
	 * @param targetUnit
	 * @return boolean
	 */
	public boolean isSameUnitAs(CompoundUnit targetUnit) {
		return isSignatureSetEqual(targetUnit, true);
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean result = false;
		try {
			CompoundUnit object = (CompoundUnit) obj;
			if (this.signature.equals(object.signature) 
				&& ((this.unitName != null && this.unitName.equals(object.unitName)) 
					 || (this.unitName == null && object.unitName == null))) {
				result = true;						
			}
		} catch(ClassCastException e) {
			result = false;
		}
		return result;
	}

	/**
	 * Returns the signature.
	 * @return Map
	 */
	public Map getSignature() {
		return signature;
	}
	
	/**
	 * Method transformTo transforms the signature of this CompoundUnit to the
	 * signature of targetCompoundUnit and returns the conversion factor that is
	 * to be multiplied to the value of this Quantity. The signature maps must
	 * contain the same AtomarSignatures.
	 * 
	 * @param targetCompoundUnit
	 * @return ValueTransfer
	 */
	ValueTransfer transformTo(CompoundUnit targetCompoundUnit) {
		ValueTransfer result = new ValueTransfer();
		for (Iterator iter = this.signature.keySet().iterator(); iter.hasNext();) {
			AtomarSignature element = (AtomarSignature) iter.next();
			Unit elementUnit = (Unit) this.signature.get(element);
			Unit targetUnit = (Unit) targetCompoundUnit.signature.get(element);
            ValueTransfer unitValueTransfer = calculateValueTransfer(targetUnit, elementUnit);
            result.multiply(unitValueTransfer);
		}
		return result;
	}
	
	public boolean hasEqualAtomarSignatureSet(CompoundUnit compareUnit) {
		return isSignatureSetEqual(compareUnit, false);

	}
	
	/**
	 * Method isSignatureSetEqual.
	 * @param compareUnit
	 * @param b
	 * @return boolean
	 */
	private boolean isSignatureSetEqual(CompoundUnit compareUnit, boolean withValue) {
		boolean result = true;
		Set ownKeySet = this.signature.keySet();
		Set compareKeySet = compareUnit.signature.keySet();
		if (ownKeySet.size() == compareKeySet.size()) {
			for (Iterator iterator = ownKeySet.iterator(); iterator.hasNext();) {
				AtomarSignature key = (AtomarSignature) iterator.next();
				if (!compareKeySet.contains(key)) {
					result = false;		
				} else if (withValue){
					Unit thisValue = (Unit) this.signature.get(key);
					Unit compareValue = (Unit) compareUnit.signature.get(key);
					if (!thisValue.equals(compareValue)) {
						result = false;
					}
				}
			}
		} else {
			result = false; 
		}
		return result;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String result = null;
//		this.unitName = null;
		if (this.unitName != null) {
			result = this.unitName;
		} else	{
			Unit dimensionlessUnit = (Unit) (this.signature.get(new DimensionlessSignature()));
			String up = ScaleUnit.getScaleUnitString(dimensionlessUnit.getScaleExponent());
			for (Iterator iter = signature.values().iterator(); iter.hasNext();) {
				Unit element = (Unit) iter.next();
				if (element.getExponent() > 0 && !element.equals(dimensionlessUnit)) {
					String elementName = ScaleUnit.getScaleUnitString(element.getScaleExponent()) 
										+ element.getAtomarUnit().getUnitAbbreviation();
					if (up.equals("")) {
						up = elementName;
					} else {
						up = up + "*" + elementName; 						
					}
					if (element.getExponent() > 1) {
						up = up + "^" + element.getExponent();						
					}
				}
			}

			String down = "";
			for (Iterator iter = signature.values().iterator(); iter.hasNext();) {
				Unit element = (Unit) iter.next();
				if (element.getExponent() < 0) {
					String elementName = ScaleUnit.getScaleUnitString(element.getScaleExponent()) 
										+ element.getAtomarUnit().getUnitAbbreviation();
					if (down.equals("")) {
						down = elementName;
					} else {
						down = down + "*" + elementName; 						
					}
					if (element.getExponent() < -1) {
						down = down + "^" + (-1)*element.getExponent();						
					}
				} 
			}
			if (down.equals("")) {
				result = up;
			} else {
				if (up.equals("")) {
					up = "1";
				}
				result = up + "/" + down;
			}
		}
		return result;
	}
	/**
	 * Method toRecreationableString.
	 * @return String returns a string of kind: <Unit.toRecreationableString>:
	 * <Unit.toRecreationableString>:...
	 */
	public String toRecreationableString() {
		String result = new String();
		result += this.unitName;
		result += SERIALIZING_DELIMITER;
		for (Iterator iter = this.signature.values().iterator(); iter.hasNext();) {
			Unit element = (Unit) iter.next();
			result += element.toRecreationableString();
			result += SERIALIZING_DELIMITER;
		}
		return result;
	}

}
