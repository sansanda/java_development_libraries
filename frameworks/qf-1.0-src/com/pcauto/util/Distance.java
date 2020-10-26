/*
 * $Id: Distance.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is Distance.java
 *
 * The Initial Developer of the Original Code is PC Automation.
 * Portions created by PC Automation are Copyright (C) 2003.
 * All Rights Reserved.
 *
 * Contributor(s):
 *
 */
package com.pcauto.util;

import java.math.BigDecimal;

/** <CODE>Distance</CODE> objects used to hold distance information.  Objects
 * can only be instantiated using the {@link DistanceFormat} class.
 * A <CODE>Distance</CODE> object's concept of unit is hidden from class users,
 * and instead inferred from the formatter class at instantiation.
 * <p>
 * The baseUnit is used to store the unit with which <CODE>Distance</CODE>
 * objects will be  printed using the overrided toString() method.
 * <p>
 * A set of arithmetic operations have been included to compare, add,
 * subtract, divide and multiply distance objects. Arithmetic operations have
 * been designed to be <CODE>null</CODE> safe.
 *
 * @author $Author: genec $
 * @version $Revision: 1.2 $
 */

public class Distance extends Quantity {
    
    protected static DistanceUnits baseUnit = DistanceUnits.MICROMETRE;
    
    /** Gets base unit with which <CODE>this</CODE> <CODE>Distance</CODE>
     * is printed.
     *
     * @return <CODE>DistanceUnits</CODE> unit with which <CODE>Distance</CODE>
     * objects are printed.
     */
    public static DistanceUnits getBaseUnit(){
        return baseUnit;
    }
    
    /** Sets the "toString" representation of any <CODE>Distance</CODE> objects
     * to be of type <CODE>unit</CODE>.
     *
     * @param <CODE>DistanceUnits</CODE> unit base unit in which all <CODE>Distance</CODE>
     * objects will be printed.
     */
    public static void setBaseUnit(DistanceUnits unit) {
        baseUnit = unit;
    } 
    
    /** Instance of <CODE>Distance</CODE> with zero value.
     */
    public static final Distance ZERO = new Distance(0, baseUnit);
    
    /** Creates new <CODE>Distance</CODE> with initial value <CODE>double</CODE>
     * value and <CODE>DistanceUnits</CODE> unit.
     *
     *@param quantity <CODE>double</CODE> weight
     *@param unit <CODE>DistanceUnits</CODE>
     */
    protected Distance(double quantity, DistanceUnits unit) {
        super(quantity,unit);
        setZERO(ZERO);
    }
    
    /** Creates new <CODE>Distance</CODE> identical to <CODE>this</CODE>
     * <CODE>Distance</CODE>.
     *
     * @return new <CODE>Distance</CODE> object
     */
    public Object clone() {
        return new Distance(quantity, (DistanceUnits)unit);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Distance</CODE> to the specified
     * <CODE>Distance</CODE>.
     * The result is <CODE>true</CODE> if and only if the argument is not
     * <CODE>null</CODE> and is a <CODE>Distance</CODE> object that has
     * the same value. <CODE>null</CODE> parameter returns false.
     *
     * @return <CODE>true</CODE> if <CODE>Distances</CODE> are equivalent;
     * <CODE>false</CODE> othewise.
     * @param quant <CODE>Distance</CODE> with which to compare
     */
    public boolean equals(Distance quant) {
        return super.equals(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Distance</CODE> with the specified
     * <CODE>Distance</CODE>. <CODE>null</CODE> parameter returns 1.
     *
     * @param quant <CODE>Distance</CODE> object with which to compare.
     * @return 0 if they are equal. 1 if <CODE>this</CODE>
     * <CODE>Distance</CODE> is larger.
     * -1 if <CODE>this</CODE> <CODE>Distance</CODE> is smaller.
     */
    public int compareTo(Distance quant){
        return super.compareTo(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Distance</CODE> to the specified
     * <CODE>Distance</CODE>.
     *
     * @param quant <CODE>Distance</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is greater
     * than <CODE>quant</CODE>;
     * <CODE>false</CODE> otherwise
     */
    public boolean greaterThan(Distance quant){
        return super.greaterThan(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Distance</CODE> to the specified
     * <CODE>Distance</CODE>.
     *
     * @param quant <CODE>Distance</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is less
     * than <CODE>quant</CODE>; <CODE>false</CODE> otherwise
     */
    public boolean lessThan(Distance quant){
        return super.lessThan(quant);
    }
    
    /** Determines if two <CODE>Distance</CODE> objects passed
     * to the fuction are equal. Two <CODE>null</CODE> are considered equal.
     *
     * @param val1 first value to be compared
     * @param val2 second value to be compared
     * @return true if equal, false otherwise
     */
    public static boolean areEqual(Distance quant1, Distance quant2){
        return Quantity.areEqual(quant1,quant2);
    }
    
    /** Adds <CODE>this</CODE> <CODE>Distance</CODE> to the supplied
     *  <CODE>Distance</CODE>.
     * <CODE>null</CODE> parameter is considered equal to <CODE>Distance</CODE>
     * with ZERO quantity.
     *
     * @param quant <CODE>Distance</CODE> object to add
     * @return <CODE>Distance</CODE> object resulting from addition operation
     */
    public Distance add(Distance quant){
        return (Distance)super.add(quant);
    }
    
    /** Adds supplied <CODE>Distance</CODE> to other supplied
     * <CODE>Distance</CODE>. <CODE>null</CODE> parameter(s) is considered
     * to be equal to ZERO quantity.
     *
     * @param a first <CODE>Distance</CODE> object
     * @param b second <CODE>Distance</CODE> object
     * @return <CODE>Distance</CODE> object resulting from addition of a
     * and b in <CODE>Distance</CODE> a's unit
     */
    public static Distance add( Distance a, Distance b ) {
        Distance retVal = (Distance)Quantity.add(a,b);
        if (retVal==null){
            retVal=ZERO;
        }
        return retVal;
    }
    
    /** Subtracts supplied <CODE>Distance</CODE> from
     * <CODE>this</CODE> <CODE>Distance</CODE>.
     * <CODE>null</CODE> parameter is considered equal to <CODE>Distance</CODE>
     * with zero quantity
     *
     * @param quant <CODE>Distance</CODE> object to subtract
     * @return <CODE>Distance</CODE> object resulting from subtraction
     * operation in <CODE>this</CODE> unit
     */
    public Distance subtract(Distance quant){
        return (Distance)super.subtract(quant);
    }
    
    /** Divides <CODE>this</CODE> <CODE>Distance</CODE> by supplied
     * <CODE>Distance</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>Distance</CODE> object to divide by
     * @return <CODE>BigDecimal</CODE> object resulting from division operation
     */
    public BigDecimal divide(Distance quant){
        return super.divide(quant);
    }
    
    /** Multiplies <CODE>this</CODE> <CODE>Distance</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the
     * attempt to multiply by <CODE>null</CODE>
     * @param quant <CODE>BigDecimal</CODE> object to multiply by
     * @return <CODE>Distance</CODE> object resulting
     * from multiplication operation
     */
    public Distance multiply(BigDecimal multiplier){
        return (Distance)super.myMultiply(multiplier);
    }
    
    /** Divides <CODE>this</CODE> <CODE>Distance</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>BigDecimal</CODE> object to devide by
     * @return <CODE>Distance</CODE> object resulting from division operation
     */
    public Distance divide(BigDecimal divisor){
        return (Distance)super.myDivide(divisor);
    }
}
