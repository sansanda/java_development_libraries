/*
 * $Id: Volume.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is Volume.java
 *
 * The Initial Developer of the Original Code is PC Automation.
 * Portions created by PC Automation are Copyright (C) 2003.
 * All Rights Reserved.
 *
 * Contributor(s):
 *
 */

package com.pcauto.util;

import java.util.Locale;
import java.math.BigDecimal;

/** <CODE>Volume</CODE> objects used to hold volume information.  Objects
 * <CODE>Volume</CODE> can only be instantiated using the {@link VolumeFormat}
 * class. A <CODE>Volume</CODE> object's concept of unit is hidden from class
 * users, and instead inferred from the formatter class at instantiation.
 * <p>
 * The baseUnit is used to store the unit with which <CODE>Volume</CODE>
 * objects will be  printed using the overrided toString() method.
 * <p>
 * A set of arithmetic operations have been included to compare, add, subtract,
 * divide and multiply <CODE>Volume</CODE> objects. Arithmetic operations
 * have been designed to be <CODE>null</CODE> safe.
 *
 * @author $Author: genec $
 * @version $Revision: 1.2 $
 */

public class Volume extends Quantity {
    
    protected static VolumeUnits baseUnit = VolumeUnits.CUBIC_METRE;
    
    /** Gets base unit with which <CODE>this</CODE> volume is printed.
     *
     * @return <CODE>VolumeUnits</CODE> unit with which volumes are printed.
     */
    public static VolumeUnits getBaseUnit() {
        return baseUnit;
    }
    
    /** Sets the "toString" representation of any <CODE>Volume</CODE> objects
     * to be of type <CODE>unit</CODE>.
     *
     * @param <CODE>VolumeUnits</CODE> unit base unit in which all <CODE>Volume</CODE>
     * objects will be printed.
     */
    public static void setBaseUnit(VolumeUnits unit) {
        baseUnit = unit;
    }
    
    /** Instance of <CODE>Volume</CODE> with zero value.
     */
    public static final Volume ZERO = new Volume(0, baseUnit);
    
    /** Creates new <CODE>Volume</CODE> with an initial value <CODE>double</CODE>
     * value and <CODE>VolumeUnits</CODE> unit.
     *
     * @param quantity <CODE>double</CODE> volume
     * @param unit <CODE>VolumeUnits</CODE>
     */
    protected Volume(double quantity, VolumeUnits unit){
        super(quantity, unit);
        setZERO(ZERO);
    }
    
    /** Creates new <CODE>Volume</CODE> identical to <CODE>this</CODE>
     * <CODE>Volume</CODE>.
     *
     * @return new <CODE>Volume</CODE> object
     */
    public Object clone() {
        return new Volume(quantity, (VolumeUnits)unit);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Volume</CODE> to the specified
     * <CODE>Volume</CODE>.
     * The result is <CODE>true</CODE> if and only if the argument is not
     * <CODE>null</CODE> and is a <CODE>Volume</CODE> object that has the same
     * value. <CODE>Null</CODE> parameter returns false.
     *
     * @return <CODE>true</CODE> if Volumes are equivalent;
     * <CODE>false</CODE> othewise.
     * @param quant <CODE>Volume</CODE> with which to compare
     */
    public boolean equals(Volume quant) {
        return super.equals(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Volume</CODE> with the specified
     * <CODE>Volume</CODE>. <CODE>Null</CODE> parameter returns 1.
     *
     * @param quant <CODE>Volume</CODE> object with which to compare.
     * @return 0 if they are equal. 1 if <CODE>this</CODE> <CODE>Volume</CODE> is
     * larger. -1 if <CODE>this</CODE> <CODE>Volume</CODE> is smaller.
     */
    public int compareTo(Volume quant){
        return super.compareTo(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Volume</CODE> to the specified
     * <CODE>Volume</CODE>.
     *
     * @param quant <CODE>Volume</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is greater
     * than <CODE>quant</CODE>;
     * <CODE>false</CODE> otherwise
     */
    public boolean greaterThan(Volume quant){
        return super.greaterThan(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Volume</CODE> to the specified
     * <CODE>Volume</CODE>.
     *
     * @param quant <CODE>Volume</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is less
     * than <CODE>quant</CODE>; <CODE>false</CODE> otherwise
     */
    public boolean lessThan(Volume quant){
        return super.lessThan(quant);
    }
    
    /** Determines if two <CODE>Volume</CODE> objects passed
     * to the fuction are equal. Two <CODE>null</CODE> are considered equal.
     *
     * @param <CODE>Volume</CODE> val1 first value to be compared
     * @param <CODE>Volume</CODE> val2 second value to be compared
     * @return true if equal, false otherwise
     */
    public static boolean areEqual(Volume quant1, Volume quant2){
        return Quantity.areEqual(quant1,quant2);
    }
    
    /** Adds <CODE>this</CODE> <CODE>Volume</CODE> to the supplied
     *  <CODE>Volume</CODE>.
     * <CODE>Null</CODE> parameter is considered equal to <CODE>Volume</CODE>
     * with ZERO quantity.
     *
     * @param quant <CODE>Volume</CODE> object to add
     * @return <CODE>Volume</CODE> object resulting from addition operation
     */
    public Volume add(Volume quant){
        return (Volume)super.add(quant);
    }
    
    /** Adds supplied <CODE>Volume</CODE> to other supplied
     * <CODE>Volume</CODE>. <CODE>Null</CODE> parameter(s) is considered
     * to be equal to ZERO quantity.
     *
     * @param a first <CODE>Volume</CODE> object
     * @param b second <CODE>Volume</CODE> object
     * @return <CODE>Volume</CODE> object resulting from addition of a
     * and b in <CODE>Volume</CODE> a's unit
     */
    public static Volume add( Volume a, Volume b ) {
        Volume retVal = (Volume)Quantity.add(a,b);
        if (retVal==null){
            retVal=ZERO;
        }
        return retVal;
    }
    
    /** Subtracts supplied <CODE>Volume</CODE> from
     * <CODE>this</CODE> <CODE>Volume</CODE>.
     * <CODE>Null</CODE> parameter is considered equal to <CODE>Volume</CODE>
     * with zero quantity
     *
     * @param quant <CODE>Volume</CODE> object to subtract
     * @return <CODE>Volume</CODE> object resulting from subtraction
     * operation in <CODE>this</CODE> unit
     */
    public Volume subtract(Volume quant){
        return (Volume)super.subtract(quant);
    }
    
    /** Divides <CODE>this</CODE> <CODE>Volume</CODE> by supplied
     * <CODE>Volume</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>Volume</CODE> object to divide by
     * @return <CODE>BigDecimal</CODE> object resulting from division operation
     */
    public BigDecimal divide(Volume quant){
        return super.divide(quant);
    }
    
    /** Multiplies <CODE>this</CODE> <CODE>Volume</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the
     * attempt to multiply by <CODE>null</CODE>
     * @param quant <CODE>BigDecimal</CODE> object to multiply by
     * @return <CODE>Volume</CODE> object resulting from multiplication operation
     */
    public Volume multiply(BigDecimal multiplier){
        return (Volume)super.myMultiply(multiplier);
    }
    
    /** Divides <CODE>this</CODE> <CODE>Volume</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>BigDecimal</CODE> object to devide by
     * @return <CODE>Volume</CODE> object resulting from division operation
     */
    public Volume divide(BigDecimal divisor){
        return (Volume)super.myDivide(divisor);
    }
}