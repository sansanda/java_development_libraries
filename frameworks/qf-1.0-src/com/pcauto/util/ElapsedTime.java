/*
 * $Id: ElapsedTime.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is ElapsedTime.java
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
import java.util.Date;

/**
 *  <CODE>ElapsedTime</CODE> is used to store  <CODE>ElapsedTime</CODE>
 * quantities.  <CODE>ElapsedTime</CODE> objects may be instantiated using
 * the {@link ElapsedTimeFormat} class, or the  <CODE>ElapsedTime</CODE>
 * constructor which is the difference of two input dates.
 * <p>
 * A set of arithmetic operations exists in order to compare, add and subtract
 * <CODE>ElapsedTime</CODE> objects. All arithmetic operations have been
 * designed to be <CODE>null</CODE> safe.
 *
 * @author $Author: genec $
 * @version $Revision: 1.3 $
 */

public class ElapsedTime  extends Quantity {
  
  /** Instance of <CODE>ElapsedTime</CODE> with zero value.
   */
  public static final ElapsedTime ZERO = new ElapsedTime(0);
  
  /** Creates new <CODE>ElapsedTime</CODE> with initial value of supplied
   * <CODE>BigDecimal</CODE>.
   *
   * @param quantity <CODE>BigDecimal</CODE>
   */
  protected ElapsedTime(double quantity){
    this.setQuantity(quantity);
    setZERO(ZERO);
  }
  
  /** Creates new <CODE>ElapsedTime</CODE> as a difference between
   * start and end dates
   *
   * @param start <CODE>Date</CODE>
   * @param end <CODE>Date</CODE>
   */
  public ElapsedTime(Date start, Date end){
    this.setQuantity(((double)(end.getTime() - start.getTime())/1000));
  }
  
  /** Creates new <CODE>ElapsedTime</CODE> identical to <CODE>this</CODE>
   * <CODE>ElaspedTime</CODE>.
   *
   * @return new  <CODE>ElapsedTime</CODE> object
   */
  public Object clone() {
    return new ElapsedTime( quantity );
  }
  
  /** Compares <CODE>this</CODE> <CODE>ElapsedTime</CODE> to the specified
   * <CODE>ElapsedTime</CODE>. The result is <CODE>true</CODE> if and only
   * if the argument is not <CODE>null</CODE> and is a  <CODE>ElapsedTime</CODE>
   * object that has the same value. Different scales for the same value will
   * return false (e.g. 2.00 equals 2 returns false).
   *
   * @return <CODE>true</CODE> if times are equivalent;
   * <CODE>false</CODE> othewise.
   * @param <CODE>ElapsedTime</CODE> Value with which to compare
   */
  public boolean equals(ElapsedTime quant) {
    return super.equals(quant);
  }
  
  /** Compares <CODE>this</CODE> <CODE>ElapsedTime</CODE> to the specified
   * <CODE>ElapsedTime</CODE>. Different scales for the same value will
   * return 0 (e.g. 2.00 compareTo 2 returns 0).
   *
   * @param time  <CODE>ElapsedTime</CODE> object with which to compare.
   * @return 0 if they are equal. 1 if <CODE>this</CODE>
   * <CODE>ElapsedTime</CODE> is larger.
   * -1 if <CODE>this</CODE> <CODE>ElapsedTime</CODE> is smaller.
   */
  public int compareTo(ElapsedTime quant){
    return super.compareTo(quant);
  }
  
  /** Compares <CODE>this</CODE> <CODE>ElapsedTime</CODE> to the specified
   * <CODE>ElapsedTime</CODE>.
   *
   * @param time  <CODE>ElapsedTime</CODE> object with which to compare.
   * @return <CODE>true</CODE> if <CODE>this</CODE> is greater
   * than <CODE>elt</CODE>; <CODE>false</CODE> otherwise
   */
  public boolean greaterThan(ElapsedTime quant){
    return super.greaterThan(quant);
  }
  
  /** Compares <CODE>this</CODE> <CODE>ElapsedTime</CODE> to the specified
   * <CODE>ElapsedTime</CODE>.
   *
   * @param time  <CODE>ElapsedTime</CODE> object with which to compare.
   * @return <CODE>true</CODE> if <CODE>this</CODE> is
   * less than <CODE>elt</CODE>; <CODE>false</CODE> otherwise
   */
  public boolean lessThan(ElapsedTime quant){
    return super.lessThan(quant);
  }
  
  /** Determines if two supplied <CODE>ElapsedTime</CODE> objects are equal.
   * <CODE>null</CODE> safe. Different scales for the same value will return
   * false (e.g. 2.00 areEqual 2 returns false).
   *
   * @param <CODE>ElapsedTime</CODE> val1 first value to be compared
   * @param <CODE>ElapsedTime</CODE> val2 second value to be compared
   * @return <CODE>true</CODE> if equal, <CODE>false</CODE> otherwise
   */
  public static boolean areEqual(ElapsedTime quant1, ElapsedTime quant2){
    return Quantity.areEqual(quant1,quant2);
  }
  
  /** Adds <CODE>this</CODE> <CODE>ElapsedTime</CODE> to the supplied
   *  <CODE>ElapsedTime</CODE>. <CODE>null</CODE> parameter is considered equal
   * to  <CODE>ElapsedTime</CODE> with zero quantity.
   *
   * @param time  <CODE>ElapsedTime</CODE> object to add
   * @return  <CODE>ElapsedTime</CODE> object resulting from addition operation
   */
  public ElapsedTime add(ElapsedTime quant){
    return (ElapsedTime)super.add(quant);
  }
  
  /** Adds supplied <CODE>ElapsedTime</CODE> to other supplied
   * <CODE>ElapsedTime</CODE>. <CODE>null</CODE> parameter is considered equal
   * to ZERO  <CODE>ElapsedTime</CODE> zero quantity.
   *
   * @param a first  <CODE>ElapsedTime</CODE> object
   * @param b second  <CODE>ElapsedTime</CODE> object
   * @return  <CODE>ElapsedTime</CODE> object resulting from addition of a and b
   */
  public static ElapsedTime add( ElapsedTime a, ElapsedTime b ) {
    return (ElapsedTime)Quantity.add(a,b);
  }
  
  /** Subtracts <CODE>this</CODE> <CODE>ElapsedTime</CODE> from supplied
   *  <CODE>ElapsedTime</CODE>. <CODE>null</CODE> parameter is considered equal
   * to  <CODE>ElapsedTime</CODE> with zero quantity.
   *
   * @param time  <CODE>ElapsedTime</CODE> object to subtract
   * @return  <CODE>ElapsedTime</CODE> object resulting
   * from subtraction operation
   */
  public ElapsedTime subtract(ElapsedTime quant){
    return (ElapsedTime)super.subtract(quant);
  }
  
  /** Returns <CODE>String</CODE> representation of quantity of
   * <CODE>ElapsedTime</CODE> object.
   *
   * @return <CODE>String</CODE>
   */
  public String toString(){
    return new BigDecimal(quantity).toString();
  }
}