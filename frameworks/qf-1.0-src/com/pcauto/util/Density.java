/*
 * Density.java
 *
 * Created on October 29, 2003, 10:41 AM
 */

package com.pcauto.util;

import java.math.BigDecimal;

/** <CODE>Density</CODE> objects used to hold density information.
 * Objects can only be instantiated using the {@link DensityFormat} class.
 * A <CODE>Density</CODE> object's concept of unit is hidden from class
 * users, and instead inferred from the formatter class at instantiation.
 * <p>
 * The baseUnit is used to store the unit with which <CODE>Density</CODE>
 * objects will be printed using the overrided toString() method.
 * <p>
 * A set of arithmetic operations have been included to compare, add, subtract,
 * divide and multiply currency objects. Arithmetic operations have been
 * designed to be <CODE>null</CODE> safe.
 *
 * @author  $Author $
 * @version $Revision $
 */
public class Density extends Quantity {
    
    protected static DensityUnits baseUnit = DensityUnits.CHARS_INCH;
    
    /** Gets base unit with which <CODE>this</CODE> density is printed.
     *
     * @return <CODE>DensityUnits</CODE> unit with which densities are stored.
     */
    public static DensityUnits getBaseUnit() {
        return baseUnit;
    }
    
    /** Sets the "toString" representation of any <CODE>Density</CODE> objects
     * to be of type <CODE>unit</CODE>.
     *
     * @param <CODE>DensityUnits</CODE> unit base unit in which all
     * <CODE>Density</CODE> objects will be printed.
     */
    public static void setBaseUnit(DensityUnits unit) {
        baseUnit = unit;
    }
    
    /** Instance of <CODE>Currency</CODE> with zero value.
     */
    public static final Density ZERO = new Density(0, baseUnit);
    
    /** Castor needs this, unfortunately
     */
    protected Density() {
        this(ZERO.getQuantity(), (DensityUnits)ZERO.unit);
    }
    
    /** Creates new <CODE>Density</CODE> with an initial
     * <CODE>double</CODE> value and <CODE>int</CODE> unit.
     *
     * @param quantity <CODE>double</CODE> density
     * @param unit <CODE>DensityUnits</CODE>
     */
    protected Density(double quantity, DensityUnits unit){
        super(quantity, unit);
        setZERO(ZERO);
    }
    
    /** Creates new <CODE>Density</CODE> identical to <CODE>this</CODE>
     * <CODE>Density</CODE>
     *
     * @return new <CODE>Density</CODE> object
     */
    public Object clone() {
        return new Density(quantity, (DensityUnits)unit);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Density</CODE> to the specified
     * <CODE>Density</CODE>.
     * The result is <CODE>true</CODE> if and only if the argument is not
     * <CODE>null</CODE> and is a <CODE>Density</CODE> object that
     * has the same value. <CODE>Null</CODE> parameter returns false.
     *
     * @return <CODE>true</CODE> if Densitys are equivalent;
     * <CODE>false</CODE> othewise.
     * @param quant <CODE>Density</CODE> with which to compare
     */
    public boolean equals(Density quant) {
        return super.equals(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Density</CODE> with the specified
     * <CODE>Density</CODE>. <CODE>Null</CODE> parameter returns 1.
     *
     * @param quant <CODE>Density</CODE> object with which to compare.
     * @return 0 if they are equal. 1 if <CODE>this</CODE>
     * <CODE>Density</CODE> is larger.
     * -1 if <CODE>this</CODE> <CODE>Density</CODE> is smaller.
     */
    public int compareTo(Density quant){
        return super.compareTo(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Density</CODE> to the specified
     * <CODE>Density</CODE>.
     *
     * @param quant <CODE>Density</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is greater
     * than <CODE>quant</CODE>;
     * <CODE>false</CODE> otherwise
     */
    public boolean greaterThan(Density quant){
        return super.greaterThan(quant);
    }
    
    /** Compares <CODE>this</CODE> <CODE>Density</CODE> to the specified
     * <CODE>Density</CODE>.
     *
     * @param quant <CODE>Density</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is less
     * than <CODE>quant</CODE>; <CODE>false</CODE> otherwise
     */
    public boolean lessThan(Density quant){
        return super.lessThan(quant);
    }
    
    /** Determines if two <CODE>Density</CODE> objects passed
     * to the fuction are equal. Two <CODE>null</CODE> are considered equal.
     *
     * @param val1 first value to be compared
     * @param val2 second value to be compared
     * @return true if equal, false otherwise
     */
    public static boolean areEqual(Density quant1, Density quant2){
        return Quantity.areEqual(quant1,quant2);
    }
    
    /** Adds <CODE>this</CODE> <CODE>Density</CODE> to the supplied
     *  <CODE>Density</CODE>.
     * <CODE>Null</CODE> parameter is considered equal to
     * <CODE>Density</CODE> with ZERO quantity.
     *
     * @param quant <CODE>Density</CODE> object to add
     * @return <CODE>Density</CODE> object resulting from addition operation
     */
    public Density add(Density quant){
        return (Density)super.add(quant);
    }
    
    /** Adds supplied <CODE>Density</CODE> to other supplied
     * <CODE>Density</CODE>. <CODE>Null</CODE> parameter(s) is
     * considered to be equal to ZERO quantity.
     *
     * @param a first <CODE>Density</CODE> object
     * @param b second <CODE>Density</CODE> object
     * @return <CODE>Density</CODE> object resulting from addition of a
     * and b in <CODE>Density</CODE> a's unit
     */
    public static Density add(Density a, Density b) {
        Density retVal = (Density)Quantity.add(a,b);
        if (retVal == null) retVal=ZERO;
        return retVal;
    }
    
    /** Subtracts supplied <CODE>Density</CODE> from
     * <CODE>this</CODE> <CODE>Density</CODE>.
     * <CODE>Null</CODE> parameter is considered equal to
     * <CODE>Density</CODE> with zero quantity
     *
     * @param quant <CODE>Density</CODE> object to subtract
     * @return <CODE>Density</CODE> object resulting from subtraction
     * operation in <CODE>this</CODE> unit
     */
    public Density subtract(Density quant){
        return (Density)super.subtract(quant);
    }
    
    /** Divides <CODE>this</CODE> <CODE>Density</CODE> by supplied
     * <CODE>Density</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>Density</CODE> object to divide by
     * @return <CODE>BigDecimal</CODE> object resulting from division operation
     */
    public BigDecimal divide(Density quant){
        return super.divide(quant);
    }
    
    /** Multiplies <CODE>this</CODE> <CODE>Density</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to multiply by <CODE>null</CODE>
     * @param quant <CODE>BigDecimal</CODE> object to multiply by
     * @return <CODE>Density</CODE> object resulting
     * from multiplication operation
     */
    public Density multiply(BigDecimal multiplier){
        return (Density)super.myMultiply(multiplier);
    }
    
    /** Divides <CODE>this</CODE> <CODE>Density</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>BigDecimal</CODE> object to devide by
     * @return <CODE>Density</CODE> object resulting from division operation
     */
    public Density divide(BigDecimal divisor){
        return (Density)super.myDivide(divisor);
    }
}
