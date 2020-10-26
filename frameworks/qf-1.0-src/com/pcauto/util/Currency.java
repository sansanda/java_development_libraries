/*
 * $Id: Currency.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is Currency.java
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

/** <CODE>Currency</CODE> objects used to hold currency information.  Objects
 * can only be instantiated using the {@link CurrencyFormat} class.
 * A <CODE>Currency</CODE> object's concept of unit is hidden from class 
 * users, and instead inferred from the formatter class at instantiation.
 * <p>
 * The baseUnit is used to store the unit with which <CODE>Currency</CODE>
 * objects will be printed using the overrided toString() method.
 * <p>
 * A set of arithmetic operations have been included to compare, add, subtract,
 * divide and multiply currency objects. All arithmetic operations have been
 * designed to be <CODE>null</CODE> safe.
 *
 * @author $Author: genec $
 * @version $Revision: 1.2 $
 */
public class Currency extends Quantity {
  
  protected static CurrencyUnits baseUnit = CurrencyUnits.CAN_DOLLARS;
  
  /** Instance of <CODE>Currency</CODE> with zero value.
   */
  public static final Currency ZERO = new Currency(0, baseUnit);
  
    /** Gets base unit with which <CODE>this</CODE> currency is printed.
   *
   * @return <CODE>CurrencyUnits</CODE> unit with which currencies are printed.
   */
  public static CurrencyUnits getBaseUnit(){
    return baseUnit;
  }
  
  /** Sets the "toString" representation of any <CODE>Currency</CODE> objects
   * to be of type <CODE>unit</CODE>.
   *
   * @param <CODE>int</CODE> unit base unit in which all 
   * <CODE>Currency</CODE> objects will be printed.
   */
  public static void setBaseUnit(CurrencyUnits unit) {
      baseUnit = unit;
  }  
  
  /** Creates new <CODE>Currency</CODE> with an initial value
   * <CODE>double</CODE> value and <CODE>int</CODE> unit.
   *
   * @param quantity <CODE>double</CODE> currency
   * & @param unit <CODE>CurrencyUnits</CODE>
   */
  protected Currency(double quantity, CurrencyUnits unit) {
    super(quantity, unit);
    setZERO(ZERO);
  }
  
  /** Creates new <CODE>Currency</CODE> using an instance 
   * of <CODE>Currency</CODE>.
   *
   * @param tmp <CODE>Currency</CODE> object to copy values from
   */
  public Object clone() {
    return new Currency(quantity, (CurrencyUnits)unit);
  }
  
  /** Compares <CODE>this</CODE> <CODE>Currency</CODE> to the specified
   * <CODE>Currency</CODE>.
   * The result is <CODE>true</CODE> if and only if the argument is not 
   * <CODE>null</CODE> and is a <CODE>Currency</CODE> object that has 
   * the same value. <CODE>null</CODE> parameter returns false.
   *
   * @return <CODE>true</CODE> if Currencies are equivalent;
   * <CODE>false</CODE> othewise.
   * @param quant <CODE>Currency</CODE> with which to compare
   */
  public boolean equals(Currency quant) {
    return super.equals(quant);
  }
  
  /** Compares <CODE>this</CODE> <CODE>Currency</CODE> with the specified
   * <CODE>Currency</CODE>. <CODE>null</CODE> parameter returns 1.
   *
   * @param quant <CODE>Currency</CODE> object with which to compare.
   * @return 0 if they are equal. 1 if <CODE>this</CODE>
   * <CODE>Currency</CODE> is larger.
   * -1 if <CODE>this</CODE> <CODE>Currency</CODE> is smaller.
   */
  public int compareTo(Currency quant){
    return super.compareTo(quant);
  }
  
  /** Compares <CODE>this</CODE> <CODE>Currency</CODE> to the specified
   * <CODE>Currency</CODE>.
   *
   * @param quant <CODE>Currency</CODE> object with which to compare.
   * @return <CODE>true</CODE> if <CODE>this</CODE> is greater
   * than <CODE>quant</CODE>;
   * <CODE>false</CODE> otherwise
   */
  public boolean greaterThan(Currency quant){
    return super.greaterThan(quant);
  }
  
  /** Compares <CODE>this</CODE> <CODE>Currency</CODE> to the specified
   * <CODE>Currency</CODE>.
   *
   * @param quant <CODE>Currency</CODE> object with which to compare.
   * @return <CODE>true</CODE> if <CODE>this</CODE> is less
   * than <CODE>quant</CODE>; <CODE>false</CODE> otherwise
   */
  public boolean lessThan(Currency quant){
    return super.lessThan(quant);
  }
  
  /** Determines if two <CODE>Currency</CODE> objects passed
   * to the fuction are equal. Two <CODE>null</CODE> are considered equal.
   *
   * @param val1 first value to be compared
   * @param val2 second value to be compared
   * @return true if equal, false otherwise
   */
  public static boolean areEqual(Currency quant1, Currency quant2){
    return Quantity.areEqual(quant1,quant2);
  }
  
  /** Adds <CODE>this</CODE> <CODE>Currency</CODE> to the supplied
   *  <CODE>Currency</CODE>.
   * <CODE>null</CODE> parameter is considered equal 
   * to <CODE>Currency</CODE> with ZERO quantity.
   *
   * @param quant <CODE>Currency</CODE> object to add
   * @return <CODE>Currency</CODE> object resulting from addition operation
   */
  public Currency add(Currency quant){
    return (Currency)super.add(quant);
  }
  
  /** Adds supplied <CODE>Currency</CODE> to other supplied
   * <CODE>Currency</CODE>. <CODE>null</CODE> parameter(s) is considered 
   * to be equal to ZERO quantity.
   *
   * @param a first <CODE>Currency</CODE> object
   * @param b second <CODE>Currency</CODE> object
   * @return <CODE>Currency</CODE> object resulting from addition of a
   * and b in <CODE>Currency</CODE> a's unit
   */
  public static Currency add( Currency a, Currency b ) {
    Currency retVal = (Currency)Quantity.add(a,b);
    if (retVal==null){
      retVal=ZERO;
    }
    return retVal;
  }
  
  /** Subtracts supplied <CODE>Currency</CODE> from
   * <CODE>this</CODE> <CODE>Currency</CODE>.
   * <CODE>null</CODE> parameter is considered equal 
   * to <CODE>Currency</CODE> with zero quantity
   *
   * @param quant <CODE>Currency</CODE> object to subtract
   * @return <CODE>Currency</CODE> object resulting from subtraction
   * operation in <CODE>this</CODE> unit
   */
  public Currency subtract(Currency quant){
    return (Currency)super.subtract(quant);
  }
  
  /** Divides <CODE>this</CODE> <CODE>Currency</CODE> by supplied
   * <CODE>Currency</CODE>.
   *
   * @throws <CODE>ArithmeticException</CODE> on the attempt to divide 
   * by <CODE>null</CODE> or zero
   * @param quant <CODE>Currency</CODE> object to divide by
   * @return <CODE>BigDecimal</CODE> object resulting from division operation
   */
  public BigDecimal divide(Currency quant){
    return super.divide(quant);
  }
  
  /** Multiplies <CODE>this</CODE> <CODE>Currency</CODE> by supplied
   * <CODE>BigDecimal</CODE>.
   *
   * @throws <CODE>ArithmeticException</CODE> on the attempt 
   * to multiply by <CODE>null</CODE>
   * @param quant <CODE>BigDecimal</CODE> object to multiply by
   * @return <CODE>Currency</CODE> object resulting 
   * from multiplication operation
   */
  public Currency multiply(BigDecimal multiplier){
    return (Currency)super.myMultiply(multiplier);
  }
  
  /** Divides <CODE>this</CODE> <CODE>Currency</CODE> by supplied
   * <CODE>BigDecimal</CODE>.
   *
   * @throws <CODE>ArithmeticException</CODE> on the attempt 
   * to divide by <CODE>null</CODE> or zero
   * @param quant <CODE>BigDecimal</CODE> object to devide by
   * @return <CODE>Currency</CODE> object resulting from division operation
   */
  public Currency divide(BigDecimal divisor){
    return (Currency)super.myDivide(divisor);
  }
}