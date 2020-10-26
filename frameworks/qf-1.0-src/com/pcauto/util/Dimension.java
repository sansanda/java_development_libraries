/*
 * Dimension.java
 *
 * Created on October 29, 2003, 9:57 AM
 */

package com.pcauto.util;

import java.math.BigDecimal;

/** <CODE>Dimension</CODE> objects used to hold dimension information.
 * Objects can only be instantiated using the {@link DimensionFormat} class.
 * A <CODE>Dimension</CODE> object's concept of unit is hidden from class 
 * users, and instead inferred from the formatter class at instantiation.
 * <p>
 * The baseUnit is used to store the unit with which <CODE>Dimension</CODE>
 * objects will be printed using the overrided toString() method.
 * <p>
 * A set of arithmetic operations have been included to compare, add, subtract,
 * divide and multiply currency objects. Arithmetic operations have been
 * designed to be <CODE>null</CODE> safe.
 *
 * @author  $Author $
 * @version $Revision $
 */
public class Dimension extends Quantity {
    
    protected static DimensionUnits baseUnit = DimensionUnits.INCH;
    
    /** Gets base unit with which <CODE>this</CODE> dimension is printed.
     *
     * @return <CODE>DimensionUnits</CODE> unit with which dimensions are stored.
     */
    public static DimensionUnits getBaseUnit() {
        return baseUnit;
    }
  
    /** Sets the "toString" representation of any <CODE>Dimension</CODE> objects
     * to be of type <CODE>unit</CODE>.
     *
     * @param <CODE>int</CODE> unit base unit in which all 
     * <CODE>Dimension</CODE> objects will be printed.
     */
    public static void setBaseUnit(DimensionUnits unit) {
        baseUnit = unit;
    }
  
    /** Instance of <CODE>Currency</CODE> with zero value.
     */
    public static final Dimension ZERO = new Dimension(0, baseUnit);

    /** Castor needs this, unfortunately
     */
    protected Dimension() {
        this(ZERO.getQuantity(), (DimensionUnits)ZERO.getUnit());
    }

    /** Creates new <CODE>Dimension</CODE> with an initial
     * <CODE>double</CODE> value and <CODE>int</CODE> unit.
     *
     * @param quantity <CODE>double</CODE> dimension
     * @param unit <CODE>DimensionUnits</CODE> 
     */
    protected Dimension(double quantity, DimensionUnits unit){
        super(quantity, unit);
        setZERO(ZERO);
    }
  
    /** Creates new <CODE>Dimension</CODE> identical to <CODE>this</CODE>
     * <CODE>Dimension</CODE>
     *
     * @return new <CODE>Dimension</CODE> object
     */
    public Object clone() {
        return new Dimension(quantity, (DimensionUnits)unit);
    }

    /** Compares <CODE>this</CODE> <CODE>Dimension</CODE> to the specified
     * <CODE>Dimension</CODE>.
     * The result is <CODE>true</CODE> if and only if the argument is not 
     * <CODE>null</CODE> and is a <CODE>Dimension</CODE> object that 
     * has the same value. <CODE>Null</CODE> parameter returns false.
     *
     * @return <CODE>true</CODE> if Dimensions are equivalent;
     * <CODE>false</CODE> othewise.
     * @param quant <CODE>Dimension</CODE> with which to compare
     */
    public boolean equals(Dimension quant) {
        return super.equals(quant);
    }
  
    /** Compares <CODE>this</CODE> <CODE>Dimension</CODE> with the specified
     * <CODE>Dimension</CODE>. <CODE>Null</CODE> parameter returns 1.
     *
     * @param quant <CODE>Dimension</CODE> object with which to compare.
     * @return 0 if they are equal. 1 if <CODE>this</CODE> 
     * <CODE>Dimension</CODE> is larger.
     * -1 if <CODE>this</CODE> <CODE>Dimension</CODE> is smaller.
     */
    public int compareTo(Dimension quant){
        return super.compareTo(quant);
    }

    /** Compares <CODE>this</CODE> <CODE>Dimension</CODE> to the specified
     * <CODE>Dimension</CODE>.
     *
     * @param quant <CODE>Dimension</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is greater
     * than <CODE>quant</CODE>;
     * <CODE>false</CODE> otherwise
     */
    public boolean greaterThan(Dimension quant){
        return super.greaterThan(quant);
    }

    /** Compares <CODE>this</CODE> <CODE>Dimension</CODE> to the specified
     * <CODE>Dimension</CODE>.
     *
     * @param quant <CODE>Dimension</CODE> object with which to compare.
     * @return <CODE>true</CODE> if <CODE>this</CODE> is less
     * than <CODE>quant</CODE>; <CODE>false</CODE> otherwise
     */
    public boolean lessThan(Dimension quant){
        return super.lessThan(quant);
    }

    /** Determines if two <CODE>Dimension</CODE> objects passed
     * to the fuction are equal. Two <CODE>null</CODE> are considered equal.
     *
     * @param val1 first value to be compared
     * @param val2 second value to be compared
     * @return true if equal, false otherwise
     */
    public static boolean areEqual(Dimension quant1, Dimension quant2){
        return Quantity.areEqual(quant1,quant2);
    }

    /** Adds <CODE>this</CODE> <CODE>Dimension</CODE> to the supplied
     *  <CODE>Dimension</CODE>.
     * <CODE>Null</CODE> parameter is considered equal to 
     * <CODE>Dimension</CODE> with ZERO quantity.
     *
     * @param quant <CODE>Dimension</CODE> object to add
     * @return <CODE>Dimension</CODE> object resulting from addition operation
     */
    public Dimension add(Dimension quant){
        return (Dimension)super.add(quant);
    }
  
    /** Adds supplied <CODE>Dimension</CODE> to other supplied
     * <CODE>Dimension</CODE>. <CODE>Null</CODE> parameter(s) is 
     * considered to be equal to ZERO quantity.
     *
     * @param a first <CODE>Dimension</CODE> object
     * @param b second <CODE>Dimension</CODE> object
     * @return <CODE>Dimension</CODE> object resulting from addition of a
     * and b in <CODE>Dimension</CODE> a's unit
     */
    public static Dimension add(Dimension a, Dimension b) {
        Dimension retVal = (Dimension)Quantity.add(a,b);
        if (retVal==null){
            retVal=ZERO;
        }
        return retVal;
    }
  
    /** Subtracts supplied <CODE>Dimension</CODE> from
     * <CODE>this</CODE> <CODE>Dimension</CODE>.
     * <CODE>Null</CODE> parameter is considered equal to 
     * <CODE>Dimension</CODE> with zero quantity
     *
     * @param quant <CODE>Dimension</CODE> object to subtract
     * @return <CODE>Dimension</CODE> object resulting from subtraction
     * operation in <CODE>this</CODE> unit
     */
    public Dimension subtract(Dimension quant){
        return (Dimension)super.subtract(quant);
    }

    /** Divides <CODE>this</CODE> <CODE>Dimension</CODE> by supplied
     * <CODE>Dimension</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt 
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>Dimension</CODE> object to divide by
     * @return <CODE>BigDecimal</CODE> object resulting from division operation
     */
    public BigDecimal divide(Dimension quant){
        return super.divide(quant);
    }

    /** Multiplies <CODE>this</CODE> <CODE>Dimension</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt 
     * to multiply by <CODE>null</CODE>
     * @param quant <CODE>BigDecimal</CODE> object to multiply by
     * @return <CODE>Dimension</CODE> object resulting 
     * from multiplication operation
     */
    public Dimension multiply(BigDecimal multiplier){
        return (Dimension)super.myMultiply(multiplier);
    }
  
    /** Divides <CODE>this</CODE> <CODE>Dimension</CODE> by supplied
     * <CODE>BigDecimal</CODE>.
     *
     * @throws <CODE>ArithmeticException</CODE> on the attempt 
     * to divide by <CODE>null</CODE> or zero
     * @param quant <CODE>BigDecimal</CODE> object to devide by
     * @return <CODE>Dimension</CODE> object resulting from division operation
     */
    public Dimension divide(BigDecimal divisor){
        return (Dimension)super.myDivide(divisor);
    }
}
