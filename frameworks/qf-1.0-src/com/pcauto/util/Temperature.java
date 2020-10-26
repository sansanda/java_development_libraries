/*
 * $Id: Temperature.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is Temperature.java
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

/** <CODE>Temperature</CODE> objects used to hold temperature information.
 * Objects can only be instantiated using the {@link TemperatureFormat} class.
 * A <CODE>Temperature</CODE> object's concept of unit is hidden from class
 * users, and instead inferred from the formatter class at instantiation.
 * <p>
 * The baseUnit is used to store the unit with which <CODE>Temperature</CODE>
 * objects will be printed using the overrided toString() method.
 * <p>
 * A set of arithmetic operations have been included to compare, add, subtract,
 * divide and multiply currency objects. Arithmetic operations have been
 * designed to be <CODE>null</CODE> safe.
 *
 * @author $Author: genec $
 * @version $Revision: 1.2 $
 */

public class Temperature extends Quantity {
    
    protected static TemperatureUnits baseUnit = TemperatureUnits.KELVIN;
    
    /** Gets base unit with <CODE>this</CODE> temperature is printed.
     *
     * @return <CODE>TemperatureUnits</CODE> unit with which temperatures are stored.
     */
    public static TemperatureUnits getBaseUnit() {
        return baseUnit;
    }
    
    /** Sets the "toString" representation of any <CODE>Temperature</CODE> objects
     * to be of type <CODE>unit</CODE>.
     *
     * @param <CODE>TemperatureUnits</CODE> unit base unit in which all
     * <CODE>Temperature</CODE> objects will be printed.
     */
    public static void setBaseUnit(TemperatureUnits unit) {
        baseUnit = unit;
    }
    
    /** Instance of <CODE>Temperature</CODE> with zero value.
     */
    public static final Temperature ZERO = new Temperature(0, baseUnit);
    
    /** Creates new <CODE>Temperature</CODE> with an initial value
     * <CODE>double</CODE> value and <CODE>int</CODE> unit.
     *
     * @param quantity <CODE>double</CODE> temperature
     * @param unit <CODE>TemperatureUnits</CODE>
     */
    protected Temperature(double quantity, TemperatureUnits unit){
        super(quantity, unit);
        setZERO(ZERO);
    }
    
    /** Creates new <CODE>Temperature</CODE> identical to <CODE>this</CODE>
     * <CODE>Temperature</CODE>
     *
     * @return new <CODE>Temperature</CODE> object
     */
    public Object clone() {
        return new Temperature(quantity, (TemperatureUnits)unit);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Temperature</CODE> to the specified
     * <CODE>Temperature</CODE>.
     * The result is <CODE>true</CODE> if and only if the argument is not
     * <CODE>null</CODE> and is a <CODE>Temperature</CODE> object that
     * has the same value. <CODE>Null</CODE> parameter returns false.
     *
     * @return <CODE>true</CODE> if Currencies are equivalent;
     * <CODE>false</CODE> othewise.
     * @param quant <CODE>Temperature</CODE> with which to compare
     */
    public boolean equals(Temperature quant) {
        return super.equals(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Temperature</CODE> with the specified
     * <CODE>Temperature</CODE>. <CODE>Null</CODE> parameter returns 1.
     *
     * @param quant <CODE>Temperature</CODE> object with which to compare.
     * @return 0 if they are equal. 1 if <CODE>this</CODE>
     * <CODE>Temperature</CODE> is larger.
     * -1 if <CODE>this</CODE> <CODE>Temperature</CODE> is smaller.
     */
    public int compareTo(Temperature quant){
        return super.compareTo(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Temperature</CODE> to the specified
     * <CODE>Temperature</CODE>.
     *
     * @param quant <CODE>Temperature</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is greater
     * than <CODE>quant</CODE>;
     * <CODE>false</CODE> otherwise
     */
    public boolean greaterThan(Temperature quant){
        return super.greaterThan(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Temperature</CODE> to the specified
     * <CODE>Temperature</CODE>.
     *
     * @param quant <CODE>Temperature</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is less
     * than <CODE>quant</CODE>; <CODE>false</CODE> otherwise
     */
    public boolean lessThan(Temperature quant){
        return super.lessThan(quant);
    }
    
    /** Determines if two <CODE>Temperature</CODE> objects passed
     * to the fuction are equal. Two <CODE>null</CODE> are considered equal.
     *
     * @param val1 first value to be compared
     * @param val2 second value to be compared
     * @return true if equal, false otherwise
     */
    public static boolean areEqual(Temperature quant1, Temperature quant2){
        return Quantity.areEqual(quant1, quant2);
    }
    
    /** Adds <CODE>this</CODE> <CODE>Temperature</CODE> to the supplied
     *  <CODE>Temperature</CODE>.
     * <CODE>Null</CODE> parameter is considered equal to
     * <CODE>Temperature</CODE> with ZERO quantity.
     *
     * @param quant <CODE>Temperature</CODE> object to add
     * @return <CODE>Temperature</CODE> object resulting from addition operation
     */
    public Temperature add(Temperature quant){
        return (Temperature)super.add(quant);
    }
    
    /** Adds supplied <CODE>Temperature</CODE> to other supplied
     * <CODE>Temperature</CODE>. <CODE>Null</CODE> parameter(s) is
     * considered to be equal to ZERO quantity.
     *
     * @param a first <CODE>Temperature</CODE> object
     * @param b second <CODE>Temperature</CODE> object
     * @return <CODE>Temperature</CODE> object resulting from addition of a
     * and b in <CODE>Temperature</CODE> a's unit
     */
    public static Temperature add(Temperature a, Temperature b) {
        Temperature retVal = (Temperature)Quantity.add(a, b);
        if (retVal == null) retVal=ZERO;
        return retVal;
    }
    
    /** Subtracts supplied <CODE>Temperature</CODE> from
     * <CODE>this</CODE> <CODE>Temperature</CODE>.
     * <CODE>Null</CODE> parameter is considered equal to
     * <CODE>Temperature</CODE> with zero quantity
     *
     * @param quant <CODE>Temperature</CODE> object to subtract
     * @return <CODE>Temperature</CODE> object resulting from subtraction
     * operation in <CODE>this</CODE> unit
     */
    public Temperature subtract(Temperature quant){
        return (Temperature)super.subtract(quant);
    }
    
    /** Divides <CODE>this</CODE> <CODE>Temperature</CODE> by supplied
     * <CODE>Temperature</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>Temperature</CODE> object to divide by
     * @return <CODE>BigDecimal</CODE> object resulting from division operation
     */
    public BigDecimal divide(Temperature quant){
        return super.divide(quant);
    }
    
    /** Multiplies <CODE>this</CODE> <CODE>Temperature</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to multiply by <CODE>null</CODE>
     * @param quant <CODE>BigDecimal</CODE> object to multiply by
     * @return <CODE>Temperature</CODE> object resulting
     * from multiplication operation
     */
    public Temperature multiply(BigDecimal multiplier){
        return (Temperature)super.myMultiply(multiplier);
    }
    
    /** Divides <CODE>this</CODE> <CODE>Temperature</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>BigDecimal</CODE> object to devide by
     * @return <CODE>Temperature</CODE> object resulting from division operation
     */
    public Temperature divide(BigDecimal divisor){
        return (Temperature)super.myDivide(divisor);
    }
}