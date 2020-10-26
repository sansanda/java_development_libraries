/*
 * $Id: Weight.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is Weight.java
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

/** <CODE>Weight</CODE> objects used to hold weight information.  Objects
 * can only be instantiated using the {@link WeightFormat} class.
 * A <CODE>Weight</CODE> object's concept of unit is hidden from class users,
 * and instead inferred from the formatter class at instantiation.
 * <p>
 * The baseUnit is used to store the unit with which <CODE>Weight</CODE> objects
 * will be printed using the overrided toString() method.
 * <p>
 * A set of arithmetic operations have been included to compare, add, subtract,
 * divide and multiply <CODE>Weight</CODE> objects. Arithmetic operations have
 * been designed to be <CODE>null</CODE> safe.
 *
 * @author $Author: genec $
 * @version $Revision: 1.3 $
 */

public class Weight  extends Quantity  {
    
    protected static WeightUnits baseUnit = WeightUnits.GRAM;
    
    /** Instance of <CODE>Weight</CODE> with zero value.
     */
    public static final Weight ZERO = new Weight(0, baseUnit);
    
    /** Sets the "toString" representation of any <CODE>Weight</CODE> objects
     * to be of type <CODE>unit</CODE>.
     *
     * @param <CODE>WeightUnits</CODE> unit base unit in which all <CODE>Weight</CODE>
     * objects will be printed.
     */
    public static void setBaseUnit(WeightUnits unit) {
        baseUnit = unit;
    }
    
    /** Gets base unit with which <CODE>this</CODE> weight is printed.
     *
     * @return <CODE>WeightUnits</CODE> unit with which weights are printed.
     */
    public static WeightUnits getBaseUnit() {
        return baseUnit;
    }
    
    /** Creates new <CODE>Weight</CODE> with an initial value
     * <CODE>double</CODE> value and <CODE>WeightUnits</CODE> unit.
     *
     * @param quantity <CODE>double</CODE> weight
     * @param unit <CODE>int</CODE>
     */
    protected Weight(double quantity, WeightUnits unit){
        super(quantity,unit);
        setZERO(ZERO);
    }
    
    /** Creates new <CODE>Weight</CODE> using an instance of <CODE>Weight</CODE>
     *
     * @param tmp <CODE>Weight</CODE> object to copy values from
     */
    public Object clone() {
        return new Weight(quantity, (WeightUnits)unit);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Weight</CODE> to the specified
     * <CODE>Weight</CODE>.
     * The result is <CODE>true</CODE> if and only if the argument is not
     * <CODE>null</CODE> and is a <CODE>Weight</CODE> object that has
     * the same value.
     * <CODE>Null</CODE> parameter returns false.
     *
     * @return <CODE>true</CODE> if weights are equivalent;
     * <CODE>false</CODE> othewise.
     * @param quant <CODE>Weight</CODE> with which to compare
     */
    public boolean equals(Weight quant) {
        return super.equals(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Weight</CODE> with the specified
     * <CODE>Weight</CODE>. <CODE>Null</CODE> parameter returns 1.
     *
     * @param quant <CODE>Weight</CODE> object with which to compare.
     * @return 0 if they are equal. 1 if <CODE>this</CODE>
     * <CODE>Weight</CODE> is larger.
     * -1 if <CODE>this</CODE> <CODE>Weight</CODE> is smaller.
     */
    public int compareTo(Weight quant){
        return super.compareTo(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Weight</CODE> to the specified
     * <CODE>Weight</CODE>.
     *
     * @param quant <CODE>Weight</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is greater
     * than <CODE>quant</CODE>;
     * <CODE>false</CODE> otherwise
     */
    public boolean greaterThan(Weight quant){
        return super.greaterThan(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Weight</CODE> to the specified
     * <CODE>Weight</CODE>.
     *
     * @param quant <CODE>Weight</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is less
     * than <CODE>quant</CODE>; <CODE>false</CODE> otherwise
     */
    public boolean lessThan(Weight quant){
        return super.lessThan(quant);
    }
    
    /** Determines if two <CODE>Weight</CODE> objects passed
     * to the fuction are equal. Two <CODE>null</CODE> are considered equal.
     *
     * @param val1 <CODE>Weight</CODE> first value to be compared
     * @param val2 <CODE>Weight</CODE> second value to be compared
     * @return true if equal, false otherwise
     */
    public static boolean areEqual(Weight quant1, Weight quant2){
        return Quantity.areEqual(quant1, quant2);
    }
    
    /** Adds <CODE>this</CODE> <CODE>Weight</CODE> to the supplied
     *  <CODE>Weight</CODE>.
     * <CODE>Null</CODE> parameter is considered equal to <CODE>Weight</CODE>
     * with ZERO quantity.
     *
     * @param quant <CODE>Weight</CODE> object to add
     * @return <CODE>Weight</CODE> object resulting from addition operation
     */
    public Weight add(Weight quant){
        return (Weight)super.add(quant);
    }
    
    /** Adds supplied <CODE>Weight</CODE> to other supplied
     * <CODE>Weight</CODE>. <CODE>Null</CODE> parameter(s) is considered
     * to be equal to ZERO quantity.
     *
     * @param a first <CODE>Weight</CODE> object
     * @param b second <CODE>Weight</CODE> object
     * @return <CODE>Weight</CODE> object resulting from addition of a
     * and b in <CODE>Weight</CODE> a's unit
     */
    public static Weight add( Weight a, Weight b ) {
        Weight retVal = (Weight)Quantity.add(a,b);
        if (retVal==null){
            retVal=ZERO;
        }
        return retVal;
    }
    
    /** Subtracts supplied <CODE>Weight</CODE> from
     * <CODE>this</CODE> <CODE>Weight</CODE>.
     * <CODE>Null</CODE> parameter is considered equal to <CODE>Weight</CODE>
     * with zero quantity
     *
     * @param quant <CODE>Weight</CODE> object to subtract
     * @return <CODE>Weight</CODE> object resulting from subtraction
     * operation in <CODE>this</CODE> unit
     */
    public Weight subtract(Weight quant){
        return (Weight)super.subtract(quant);
    }
    
    /** Divides <CODE>this</CODE> <CODE>Weight</CODE> by supplied
     * <CODE>Weight</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt to divide by
     * <CODE>null</CODE> or zero
     * @param quant <CODE>Weight</CODE> object to divide by
     * @return <CODE>BigDecimal</CODE> object resulting from division operation
     */
    public BigDecimal divide(Weight quant){
        return super.divide(quant);
    }
    
    /** Multiplies <CODE>this</CODE> <CODE>Weight</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt to
     * multiply by <CODE>null</CODE>
     * @param quant <CODE>BigDecimal</CODE> object to multiply by
     * @return <CODE>Weight</CODE> object resulting from multiplication operation
     */
    public Weight multiply(BigDecimal multiplier){
        return (Weight)super.myMultiply(multiplier);
    }
    
    /** Divides <CODE>this</CODE> <CODE>Weight</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>BigDecimal</CODE> object to devide by
     * @return <CODE>Weight</CODE> object resulting from division operation
     */
    public Weight divide(BigDecimal divisor){
        return (Weight)super.myDivide(divisor);
    }
    
    /** Returns <CODE>String</CODE> representation of quantity of
     * <CODE>Quantity</CODE> object in baseUnit.
     *
     * @return <CODE>String</CODE>
     */
    public String toString(){
        return String.valueOf(baseUnit.convertFrom(quantity, unit));
    }
    
}