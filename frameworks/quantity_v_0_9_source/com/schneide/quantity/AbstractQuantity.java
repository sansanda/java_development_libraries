/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;




/**
 * The AbstractQuantity is the superclass of all Quantity classes. It contains all the functionality to 
 * calculate and transform between quantities. It is tightly coupled with the class 
 * {@link CompoundUnit}. Together the class <code>AbstractQuantity</code> and 
 * <code>CompoundUnit</code> contain the functionality of the framework. Inherited
 * classes bring the functionality to the user in form of specialized quantities.
 * <p>
 * A <em>Quantity</em> combines a value with a unit. More specific, a Quantity of the
 * library <code>com.schneide.quantity</code> contains 3 members called <code>value</code>,
 * <code>power</code> and <code>compoundUnit</code> which together represent a
 * Quantity in the form of 
 * <pre>
 * 	value * 10^power compoundUnit
 * </pre>
 * See class {@link com.schneide.quantity.CompoundUnit} for details of the unit part
 * and {@link com.schneide.quantity.unit.AtomarSignature} for explanation
 * of the term <em>signature</em> to understand how this framework operates.
 * <p>
 * To get to know all about the use and the architekture of the quantity framework have a
 * look on our <a href="http://www.Softwareschneiderei.de/quantity.html">Homepage</a>. 
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, 
 * <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
abstract public class AbstractQuantity implements Cloneable, Comparable {
	public static final String VERSION = "QuantityVersion0.9";
	
//	/**
//	 * the value difference allowed for two AbstractQuantities to get a 
//	 * <code>true</code> when calling the <code>AbstractQuantity.equalsWit
//	 * hEpsilon(Object obj)</code> method. Note that with this method you will
//	 * get different results for:
//	 * Meter tenMicrometer = new Meter(0.000001d);
//	 */
	private static final double EPSILON = 0.00001d;

	protected double value = 0.0d; 
	protected int power = 0;
	protected CompoundUnit compoundUnit = null;

	/**
	 * Constructor for AbstractQuantity.
	 */
	protected AbstractQuantity(double value, CompoundUnit unit) {
		super();
		this.value = value;
		this.compoundUnit = unit;
	}
	
	protected AbstractQuantity(double value, int power, CompoundUnit unit) {
		this.value = value;
		this.power = power;
		this.compoundUnit = unit;
	}
	

//	/**
//	 * Method AbstractQuantity.
//	 * Recreates a quantity you saved as a String someplace.
//	 * @param recreationableString the String of which the AbstractQuantity can be
//	 * recreated. You can get this String via the method <code>toRecreationalbeString()</code>
//	 */
	public AbstractQuantity(String recreationableString) throws WrongUnitException{
		final int CHECKVERSION = 0;
		final int GETQUANTITYVALUES = 1;
		final int GETUNIT = 3;
		final int END = 100;

		StringTokenizer tokenizer = new StringTokenizer(recreationableString, "#");

		try {
			int state = CHECKVERSION;
			while (state < END) {
				switch (state) {
					case CHECKVERSION: 
						String version = tokenizer.nextToken();
						if (isCompatibleVersion(version)) {
							state = GETQUANTITYVALUES;
						} else {
							throw new WrongUnitException("This is Version " + AbstractQuantity.VERSION + ". It cannot restore Quantities of version " + version);
						}
						break;
					case GETQUANTITYVALUES:
						this.value = Double.parseDouble(tokenizer.nextToken());
						this.power = Integer.parseInt(tokenizer.nextToken());
						state = GETUNIT;
						break;
					case GETUNIT:
						this.compoundUnit = new CompoundUnit(tokenizer.nextToken());
						state = END;
						break;
				}
			}
		} catch (NumberFormatException e) {
			throw new WrongUnitException("Syntax broken in in stored AbstractQuantity " + recreationableString);
		}
		if (!this.isUnitCorrect()) {
			throw new WrongUnitException("Falsche CompoundUnit ");
		}
	}
	/**
	 * Method isCompatibleVersion.
	 * @param version
	 * @return boolean
	 */
	private boolean isCompatibleVersion(String version) {
		boolean result = false;
		if (AbstractQuantity.VERSION.equals(version)) {
			result = true;
		} else if ("QuantityVersion0.9rc1".equals(version)) {
			result = true;
		} else if ("QuantityVersion0.9rc2".equals(version)) {
			result = true;
		} else if ("QuantityVersion0.9".equals(version)) {
			result = true;
		}
		return result;
	}
	
	public void multiply(double scalar, int power) {
		this.value *= scalar;
		this.power += power;
	}
	
	public void multiply(double scalar) {
		this.multiply(scalar, 0);
	}
	
	protected void multiply(AbstractQuantity multiplicator) {
		ValueTransfer vtransfer = this.compoundUnit.multiply(multiplicator.compoundUnit);
		this.value *= multiplicator.value * vtransfer.getValue();
		this.power += multiplicator.power + vtransfer.getPower();
		this.compoundUnit.setUnitName(null);
		
	}
	
	protected void divide(AbstractQuantity divisor) {
		AbstractQuantity divisorClone= (AbstractQuantity) divisor.clone();
		divisorClone.getCompoundUnit().invert();
		divisorClone.power *= -1;
		divisorClone.value = 1.0d/divisorClone.value;
		this.multiply(divisorClone);
	}
	
	protected void add(AbstractQuantity toAdd) throws WrongUnitException{
		AbstractQuantity helperQuantity = (AbstractQuantity) toAdd.clone();
		helperQuantity.changeToUnit(this.compoundUnit);
		if (this.power != helperQuantity.power) {
			int helperPower = this.power - helperQuantity.power;
			this.power = helperQuantity.power;
			this.value *= Math.pow(10,helperPower);
		}
		this.value += helperQuantity.value;
	}

	protected void substract(AbstractQuantity substractThis) throws WrongUnitException{
        AbstractQuantity substractClone = (AbstractQuantity) substractThis.clone();
		double value = substractClone.value;
		substractClone.value = -1 * value;
		this.add(substractClone);
	}

	protected void changeToUnit(CompoundUnit targetUnit) throws WrongUnitException {
		if (!this.compoundUnit.isSameUnitAs(targetUnit)) {
			if (this.compoundUnit.hasEqualAtomarSignatureSet(targetUnit)) {
				ValueTransfer valueTransfer = this.compoundUnit.transformTo(targetUnit);
				this.value *= valueTransfer.getValue();
				this.power += valueTransfer.getPower();
				this.compoundUnit = (CompoundUnit) targetUnit.clone();
			} else {
				throw new WrongUnitException("Trying to add units " + this.compoundUnit.toString() + " and " + targetUnit.toString());
			}
		} 
	}
	
	public String toString() {
		String result = null;
		double preResult = value * Math.pow(10,power);
		result = preResult + " " + compoundUnit.toString();
	 	return result;	
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		AbstractQuantity result = null;
		try {
			result = (AbstractQuantity) super.clone();
			result.compoundUnit = (CompoundUnit) this.compoundUnit.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("CloneNotSupportedException in AbstractQuantity.clone");
		}
		return result;
	}

	/**
	 * Returns the compoundUnit.
	 * @return CompoundUnit
	 */
	CompoundUnit getCompoundUnit() {
		return compoundUnit;
	}
	
	/**
	 * @return String returns the compoundUnit String only. This may look like <br>
	 * m, m/s, km/s^2 etc.
	 */
	public String getUnitString() {
		String result = compoundUnit.toString();
		return result;
	}

	/**
	 * Returns the value.
	 * @return double
	 */
	public double getValue() {
		double result = this.value * Math.pow(10, this.power);
		return result;
	}
    
    public String getValueString(DecimalFormat format) {
        double result = getValue();
        return format.format(result);
    }
	
	public ValueTransfer getValueWithPower() {
		ValueTransfer result = new ValueTransfer(this.value, this.power);
		return result;
	}
	
	/**
	 * Creates a String with which another
	 * instance of this exact quantity can be created.
	 * @return returns a String of the kind:
	 * <Version>#<value>#<exponetn>#<CompoundUnit.toRecreateionableString()>
	 */
	public String toRecreationableString() {
		String result = null;
		result = AbstractQuantity.VERSION + "#" + this.value + "#" + this.power 
				 + "#" + this.compoundUnit.toRecreationableString();
		return result;
	}
	
	/**
	 * Checks whether the unit really contains the unit described
	 * by the name. It is called after a <code>Quantity</code> 
	 * was restored using the constructor 
	 * <code>AbstractQuantity(String toRecreationableString)</code>
	 * to make sure the right Quantity was restored in the object.
	 * A typical implementation looks like:
	 * <pre>
	 * protected boolean isUnitCorrect() {
	 *	boolean result = this.compoundUnit.isSameUnitAs(FrequentlyUsedUnits.getMinute());
	 *	return result;
	 * }
	 * </pre>
	 * where the method <code>FrequentlyUsedUnits.getMinute()</code> would
	 * be the call to the factory that creates the appropriate
	 * <code>CompoundUnit</code>.
	 * 
	 * @return returns true if the current field <code>compoundUnit</code>
	 * contains the <code>CompoundUnit.signature</code> this object
	 * represents.
	 */
	protected boolean isUnitCorrect() {
		boolean result = true;
		Class[] classParameters = {double.class};
		Object[] objectParameters = {new Double(1.0d)};
		Constructor doubleConstructor;
		AbstractQuantity compareQuantity = null;
		try {
			doubleConstructor = this.getClass().getConstructor(classParameters);
			compareQuantity = (AbstractQuantity) doubleConstructor.newInstance(objectParameters);
			result = this.compoundUnit.equals(compareQuantity.compoundUnit);
		} catch (SecurityException e) {
			result = false;
		} catch (IllegalArgumentException e) {
			result = false;
		} catch (NoSuchMethodException e) {
			result = false;
		} catch (InstantiationException e) {
			result = false;
		} catch (IllegalAccessException e) {
			result = false;
		} catch (InvocationTargetException e) {
			result = false;
		}
		return result;		
	}
	
	
	/**
	 * calls <code>this.equalsWithEpsilon((AbstractQuantity) obj, 0.0d)</code>
	 */
	public boolean equals(Object obj) {
		boolean result = true;
		try {
			result = this.equalsWithEpsilon((AbstractQuantity) obj, 0.0d);
		} catch(ClassCastException e) {
			result = false;
		}
		return result;
	}
	
	/**
	 * substracts <code>compareQuantity</code> from <code>this</code>
	 * and checks wether the result is smaller than <code>epsilon</code>
	 * This allows the comparison of two almost-equal quantities which
	 * may result due to rounding errors.
	 * 
	 * @param compareQuantity the AbstractQuantity to compare with
	 * @param epsilon a double value for the difference allowed between the two 
	 * AbstractQuantities
	 * @return boolean returns true if <code>this.value - compareQuantity.value
	 * > epsilon</code> and no errors occur during substraction.
	 */
	public boolean equalsWithEpsilon(AbstractQuantity compareQuantity, double epsilon) {
		boolean result = true;
		try {
			AbstractQuantity thisClone = (AbstractQuantity) this.clone();
			thisClone.substract(compareQuantity);
			if (Math.abs(thisClone.value) > epsilon) {
				result = false;	
			}
		} catch (RuntimeException e) {
			result = false;
		}
		return result;
			
	}
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Object toCompare) throws WrongUnitException {
//        // Just to catch any objects different from AbstractQuantity
//        AbstractQuantity classCastTest = (AbstractQuantity) toCompare;
//        
//        // if the compare parameter is of class Quantity, delegate 
//        // the comparison
//        if (toCompare instanceof Quantity) {
//            ((Quantity)toCompare).compareTo(this);
//        }
//         
//        int result = Integer.MIN_VALUE;
//        Class thisClass = this.getClass();
//        Class toCompareClass = toCompare.getClass();
//        // find first common superClass
//        // in the worst case up to class Object 
//        while (!thisClass.isAssignableFrom(toCompareClass)) {
//            thisClass = thisClass.getSuperclass();
//        }
//        // comparable ?
//        if (thisClass.getSuperclass() != null 
//            && AbstractQuantity.class.isAssignableFrom(thisClass.getSuperclass())) {
//            Class[] parameters = {double.class};
//            Constructor doubleConstructor;
//            try {
//                doubleConstructor = this.getClass().getConstructor(parameters);
//            } catch (SecurityException e) {
//                e.printStackTrace();
//                throw new WrongUnitException("Could not compare Objects: no double Constructor");
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//                throw new WrongUnitException("Could not compare Objects: no double Constructor");
//            }
//            Object[] parameterValue = {new Double(0)};
//            AbstractQuantity alignedToCompare;
//            try {
//                alignedToCompare =
//                    (AbstractQuantity) doubleConstructor.newInstance(
//                        parameterValue);
//            } catch (IllegalArgumentException e1) {
//                e1.printStackTrace();
//                throw new WrongUnitException("Could not compare Objects: Instantiation of alignedToCompare failed");
//            } catch (InstantiationException e1) {
//                e1.printStackTrace();
//                throw new WrongUnitException("Could not compare Objects: Instantiation of alignedToCompare failed");
//            } catch (IllegalAccessException e1) {
//                e1.printStackTrace();
//                throw new WrongUnitException("Could not compare Objects: Instantiation of alignedToCompare failed");
//            } catch (InvocationTargetException e1) {
//                e1.printStackTrace();
//                throw new WrongUnitException("Could not compare Objects: Instantiation of alignedToCompare failed");
//            }
//            alignedToCompare.add((AbstractQuantity) toCompare);
//            if (alignedToCompare.equalsWithEpsilon(this, EPSILON)) {
//                result = 0;
//            } else if (this.getValue() < alignedToCompare.getValue()) {
//                result = -1;
//            } else if (this.getValue() > alignedToCompare.getValue()) {
//                result = 1;
//            }
//        } else {
//            throw new WrongUnitException("Quantities " + this.toString() + 
//                " and " + toCompare.toString() + " are not comparable.");
//        }
		AbstractQuantity compareQuantity = (AbstractQuantity) toCompare;
		AbstractQuantity thisQuantity = (AbstractQuantity) this.clone();
		try {
            thisQuantity.substract(compareQuantity);
        } catch (WrongUnitException e) {
            throw new WrongUnitException("Quantities " + this.toString() + 
                " and " + toCompare.toString() + " are not comparable.");
        }
		int result = Integer.MIN_VALUE;
		if (Math.abs(thisQuantity.getValue()) < EPSILON) {
			  result = 0;
		  } else if (thisQuantity.getValue() < 0) {
			  result = -1;
		  } else if (thisQuantity.getValue() > 0) {
			  result = 1;
		  }
        return result;
    }

    public boolean isLesserThan(AbstractQuantity toCompare) throws WrongUnitException {
        return (this.compareTo(toCompare) < 0);
    }

    public boolean isGreaterThan(AbstractQuantity toCompare) throws WrongUnitException {
        return (this.compareTo(toCompare) > 0);
    }

    public boolean isLesserOrEqualWith(AbstractQuantity toCompare) throws WrongUnitException {
        return (this.compareTo(toCompare) <= 0);
    }

    public boolean isGreaterOrEqualWith(AbstractQuantity toCompare) throws WrongUnitException {
        return (this.compareTo(toCompare) >= 0);
    }

}
