/*
 * $Id: Quantity.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is Quantity.java
 *
 * The Initial Developer of the Original Code is PC Automation.
 * Portions created by PC Automation are Copyright (C) 2003.
 * All Rights Reserved.
 *
 * Contributor(s): genec
 *
 */

package com.pcauto.util;

import java.util.Locale;
import java.math.BigDecimal;

/** <CODE>Quantity</CODE> objects used to hold quantity information.
 * Objects can only be instantiated using the {@link QuantityFormat} class.
 * A <CODE>Quantity</CODE> object's concept of unit is hidden from
 * class users, and instead inferred from the formatter class at instantiation.
 * <p>
 * The baseUnit is used to store the unit with which
 * <CODE>Quantity</CODE> objects will be printed using
 * the overrided toString() method.
 * <p>
 * A set of arithmetic operations have been included to compare, add, subtract,
 * divide and multiply quantity objects. All arithmetic operations have
 * been designed to be <CODE>null</CODE> safe.
 *
 * @author $Author: genec $
 * @version $Revision: 1.1 $
 */
public abstract class Quantity extends Object implements java.io.Serializable, Comparable {
    
    /** Creates new <CODE>Quantity</CODE> with an initial value
     * <CODE>double</CODE> value and <CODE>int</CODE> unit.
     *
     * @param quantity <CODE>double</CODE> quantity
     * & @param unit <CODE>int</CODE> unit
     */
    protected Quantity() {
    }
    
    /** Creates new <CODE>Quantity</CODE> with an initial
     * value <CODE>double</CODE> value and <CODE>int</CODE> unit.
     *
     * @param quantity <CODE>double</CODE> quantity
     * & @param unit <CODE>Units</CODE>
     */
    protected Quantity(double quantity, Units n_unit) {
        this.quantity = quantity;
        this.unit = n_unit;
    }
    
    /** Creates new <CODE>Quantity</CODE> with an initial
     * value <CODE>double</CODE> value and <CODE>int</CODE> unit.
     *
     * @return new <CODE>Quantity</CODE> object
     */
    public abstract Object clone();
    
    /** Sets specific <CODE>Quantity</CODE> ZERO
     * implementation for internal use
     *
     * @param <CODE>Quantity</CODE> quantity ZERO implementation
     */
    protected static void setZERO(Quantity n_zero){
        ZERO = n_zero;
    }
    
    /** Gets raw numeric value of stored quantity.  This numeric value
     * should not be used without consideration of the base unit.
     *
     * @return <CODE>double</CODE> numeric quantity value in base units
     */
    protected double getQuantity(){
        return quantity;
    }
    
    /** Sets quantity of <CODE>this</CODE> quantity to numeric value
     * contained by supplied <CODE>double</CODE>.
     *
     * @param <CODE>double</CODE> quantity value of quantity as expressed
     * in base unit
     */
    protected void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    /** Gets unit of <CODE>this</CODE> <CODE>Quantity</CODE>.
     *
     * @return unit <CODE>Units</CODE>
     */
    protected Units getUnit(){
        return unit;
    }
    
    /** Sets unit of <CODE>this</CODE> <CODE>Quantity</CODE>.
     *
     * @param unit <CODE>Units</CODE> for
     * <CODE>this</CODE> <CODE>Quantity</CODE>
     */
    protected void setUnit(Units unit) {
        this.unit = unit;
    }
    
    /** Compares <CODE>this</CODE> <CODE>Quantity</CODE> to the specified
     * <CODE>Quantity</CODE>.
     * The result is <CODE>true</CODE> if and only if the argument is not
     * <CODE>null</CODE> and is a <CODE>Quantity</CODE> object that
     * has the same value. <CODE>null</CODE> parameter returns false.
     *
     * @return <CODE>true</CODE> if AbstractQuantities are equivalent;
     * <CODE>false</CODE> othewise.
     * @param quant <CODE>Quantity</CODE> with which to compare
     */
    protected boolean equals(Quantity quant) {
        if (quant == null) {
            return false;
        }
        return (quantity == unit.convertFrom(quant.quantity, quant.unit));
    }
    
    public boolean equals(Object obj) {
        try {
            return equals((Quantity)obj);
        }
        catch (ClassCastException ccex) {
            return false;
        }
    }
    
    /** Compares <CODE>this</CODE> <CODE>Quantity</CODE>
     * with the specified
     * <CODE>Quantity</CODE>. <CODE>null</CODE> parameter returns 1.
     *
     * @param obj object (must be an <CODE>Quantity</CODE>) with which to compare.
     * @return 0 if they are equal. 1 if <CODE>this</CODE>
     * <CODE>Quantity</CODE> is larger
     * -1 if <CODE>this</CODE> <CODE>Quantity</CODE> is smaller.
     */
    public int compareTo( Object obj) {
        return compareTo((Quantity)obj);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Quantity</CODE>
     * with the specified
     * <CODE>Quantity</CODE>. <CODE>null</CODE> parameter returns 1.
     *
     * @param quant <CODE>Quantity</CODE> object with which to compare.
     * @return 0 if they are equal. 1 if <CODE>this</CODE>
     * <CODE>Quantity</CODE> is larger
     * -1 if <CODE>this</CODE> <CODE>Quantity</CODE> is smaller.
     */
    protected int compareTo(Quantity quant){
        if( quant == null ) {
            return 1;
        }
        double retVal = (quantity - unit.convertFrom(
        quant.quantity, quant.unit));
        if (retVal<0) {
            return -1;
        }
        if (retVal>0) {
            return 1;
        }
        return 0;
    }
    
    /** Compares <CODE>this</CODE> <CODE>Quantity</CODE> to the specified
     * <CODE>Quantity</CODE>.
     *
     * @param quant <CODE>Quantity</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is greater
     * than <CODE>quant</CODE>;
     * <CODE>false</CODE> otherwise
     */
    protected boolean greaterThan(Quantity quant){
        return this.compareTo(quant)>0;
    }
    
    /** Compares <CODE>this</CODE> <CODE>Quantity</CODE> to the specified
     * <CODE>Quantity</CODE>.
     *
     * @param quant <CODE>Quantity</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is less
     * than <CODE>quant</CODE>; <CODE>false</CODE> otherwise
     */
    protected boolean lessThan(Quantity quant){
        return this.compareTo(quant)<0;
    }
    
    /** Determines if two <CODE>Quantity</CODE> objects passed
     * to the fuction are equal. Two <CODE>null</CODE> are considered equal.
     *
     * @param val1 first value to be compared
     * @param val2 second value to be compared
     * @return true if equal, false otherwise
     */
    protected static boolean areEqual(
    Quantity firstVal, Quantity secondVal){
        if (firstVal==null ){
            if (secondVal==null ){
                return true;
            }
            return false;
        }
        if (secondVal==null ){
            return false;
        }
        return (firstVal.quantity == firstVal.unit.convertFrom(
        secondVal.quantity, secondVal.unit));
    }
    
    /** Adds <CODE>this</CODE> <CODE>Quantity</CODE> to the supplied
     *  <CODE>Quantity</CODE>.
     * <CODE>null</CODE> parameter is considered equal
     * to <CODE>Quantity</CODE> with ZERO quantity.
     *
     * @param quant <CODE>Quantity</CODE> object to add
     * @return <CODE>Quantity</CODE> object resulting
     * from addition operation
     */
    protected Quantity add(Quantity quant){
        Quantity retVal = (Quantity)clone();
        if (quant == null) {
            return retVal;
        }
        retVal.setQuantity(retVal.quantity + unit.convertFrom(
        quant.quantity, quant.unit) );
        return retVal;
    }
    
    /** Adds supplied <CODE>Quantity</CODE> to other supplied
     * <CODE>Quantity</CODE>. <CODE>null</CODE> parameter(s) is
     * considered to be equal to ZERO quantity.
     *
     * @param a first <CODE>Quantity</CODE> object
     * @param b second <CODE>Quantity</CODE> object
     * @return <CODE>Quantity</CODE> object resulting from addition of a
     * and b in <CODE>Quantity</CODE> a's unit
     */
    protected static Quantity add(
    Quantity a, Quantity b ) {
        Quantity retVal = a;
        if (retVal == null) {
            retVal = b;
        } else {
            retVal = retVal.add(b);
        }
        if (retVal == null) {
            retVal = ZERO;
        }
        return retVal;
    }
    
    /** Subtracts supplied <CODE>Quantity</CODE> from
     * <CODE>this</CODE> <CODE>Quantity</CODE>.
     * <CODE>null</CODE> parameter is considered equal
     * to <CODE>Quantity</CODE> with zero quantity
     *
     * @param quant <CODE>Quantity</CODE> object to subtract
     * @return <CODE>Quantity</CODE> object resulting from subtraction
     * operation in <CODE>Units</CODE> unit
     */
    protected Quantity subtract(Quantity quant){
        Quantity retVal = (Quantity)clone();
        if (quant == null) {
            return retVal;
        }
        retVal.quantity = (retVal.quantity - unit.convertFrom(
        quant.quantity, quant.unit));
        return retVal;
    }
    
    /** Divides <CODE>this</CODE> <CODE>Quantity</CODE> by supplied
     * <CODE>Quantity</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt to divide
     * by <CODE>null</CODE> or zero
     * @param quant <CODE>Quantity</CODE> object to divide by
     * @return <CODE>BigDecimal</CODE> object resulting from division operation
     */
    protected BigDecimal divide(Quantity quant){
        if (quant==null || quant.quantity== 0) {
            throw new ArithmeticException(
            "Quantity: Divide:  Divide by ZERO or NULL");
        }
        return new BigDecimal(String.valueOf(
        (quantity/unit.convertFrom(quant.quantity, quant.unit))) );
    }
    
    /** Multiplies <CODE>this</CODE> <CODE>Quantity</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to multiply by <CODE>null</CODE>
     * @param quant <CODE>BigDecimal</CODE> object to multiply by
     * @return <CODE>Quantity</CODE> object
     * resulting from multiplication operation
     */
    protected Quantity myMultiply(BigDecimal multiplier){
        if (multiplier==null) {
            throw new ArithmeticException(
            "Quantity: Multiply:  Multiply by NULL");
        }
        Quantity retVal=(Quantity)clone();
        retVal.quantity = quantity*multiplier.doubleValue();
        return retVal;
    }
    
    /** Divides <CODE>this</CODE> <CODE>Quantity</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>BigDecimal</CODE> object to devide by
     * @return <CODE>Quantity</CODE> object
     * resulting from division operation
     */
    protected Quantity myDivide(BigDecimal divisor){
        if (divisor == null || divisor.equals(new BigDecimal("0")) ) {
            throw new ArithmeticException(
            "Quantity: Divide:  Divide by ZERO or NULL");
        }
        Quantity retVal=(Quantity)clone();
        retVal.quantity = retVal.quantity/divisor.doubleValue();
        return retVal;
    }
    
    protected double quantity;
    protected Units unit;
    private static Quantity ZERO = null;
    
}