/*
 * $Id: WeightFormat.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is WeightFormat.java
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
import java.text.ParsePosition;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.lang.Double;

/**
 * <CODE>WeightFormat</CODE> provides several mechanisms to use {@link Weight}
 * objects:
 * <li> to display weight values in dynamically selected units
 * <li> to create and load values into {@link Weight} objects
 * <p>
 * Locale based constructors use a default scale of 2. The parse and format
 * methods are used to generate and format {@link Weight} objects respectively.
 *
 * @author $Author: genec $
 * @version $Revision: 1.7 $
 */

public class WeightFormat  extends QuantityFormat {
    
    /** Constructs new <CODE>WeightFormat</CODE> instance based on default
     * <CODE>Locale</CODE>.
     */
    public WeightFormat() {
        this(Locale.getDefault());
    }
    
    /** Constructs new <CODE>WeightFormat</CODE> instance based on supplied
     * <CODE>Locale</CODE>.
     *
     * @param loc <CODE>Locale</CODE> to set correct measurement units
     */
    public WeightFormat(Locale loc){
        if (loc.equals(Locale.CANADA)) setUnits(WeightUnits.KILOGRAM);
        else if (loc.equals(Locale.US)) setUnits(WeightUnits.POUND);
        else {
            System.out.println("WeightFormat: Warning: Unsupported locale. Assuming CANADA");
            setUnits(WeightUnits.KILOGRAM);
        }
    }
    
    /** Constructs new <CODE>WeightFormat</CODE> with units set to
     * <CODE>WeightUnits</CODE> units and scale set to <CODE>int</CODE> scale.
     *
     * @param units <CODE>WeightUnits</CODE> to set units
     * @param scale <CODE>int</CODE> to set scale
     */
    public WeightFormat(WeightUnits units, int scale) {
        setUnits(units);
        setScale(scale);
    }
    
    /** Returns <CODE>String</CODE> with supplied {@link Weight}
     * quantity formatted in units.
     *
     * @return <CODE>String</CODE> weight in current units
     * @param wt {@link Weight} object from which to format value
     */
    public String formatWeight(Weight wt){
        return format(wt, new StringBuffer(), new FieldPosition(0)).toString();
    }
    
    /** Returns <CODE>StringBuffer</CODE> with supplied {@link Weight}
     * quantity formatted in units.
     *
     * @return <CODE>StringBuffer</CODE> weight in current units
     * @param obj {@link Object} object from which to format value
     * @param toAppendTo {@link StringBuffer} string buffer to append to
     * @param pos {@link java.text.FieldPosition} ignored but can't be null
     * @throws <CODE>IllegalArguementException</CODE> if obj is not a
     * <CODE>Weight</CODE>.
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if (toAppendTo == null || pos == null) throw new NullPointerException();
        
        if (obj == null) throw new NullPointerException("weight is null");
        
        if (obj instanceof Weight) {
            Weight wt = (Weight)obj;
            BigDecimal retVal = new BigDecimal(units.convertFrom(wt.getQuantity(), wt.getUnit()));
            NumberFormat nf =NumberFormat.getInstance();
            nf.setMinimumFractionDigits(scale);
            nf.setMaximumFractionDigits(scale);
            nf.setGroupingUsed(groupingUsed);
            return toAppendTo.append(nf.format(retVal));
        }
        else throw new IllegalArgumentException("Object to format must be of type com.pcauto.util.Weight");
    }
    
    
    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Weight} object.
     *
     * @param value <CODE>String</CODE> to be converted
     * to {@link Weight} object
     * @return {@link Weight} holding a value specified
     * in input <CODE>String</CODE>
     */
    public Weight parseWeight(String value) {
        return (Weight)parseObject(value, new ParsePosition(0));
    }
    
    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Weight} object.
     *
     * @throws <CODE>NumberFormatException</CODE> on
     * non-numeric <CODE>String</CODE> input
     * @param source <CODE>String</CODE> to be converted
     * to {@link Weight} object
     * @param pos <CODE>ParsePosition</CODE> (can't be null)
     * @return {@link Object} a <CODE>Weight</CODE> holding a value specified
     * in input <CODE>String</CODE>
     */
    public Object parseObject(String source, ParsePosition pos) {
        if (source == null) {
            pos.setIndex(1);
            return null;
        }
        if (isGroupingUsed()) {
            NumberFormat nf =NumberFormat.getInstance();
            nf.setMinimumFractionDigits(scale);
            nf.setMaximumFractionDigits(scale);
            nf.setGroupingUsed(isGroupingUsed());
            NumberFormat nf1 = NumberFormat.getInstance();
            nf1.setMinimumFractionDigits(scale);
            nf1.setMaximumFractionDigits(scale);
            nf1.setGroupingUsed(false);
            try {
                String temp = nf1.format(nf.parse(source));
                source = new String(temp);
            }
            catch (ParseException ex1) {
            }
        }
        try {
            pos.setIndex(source.length()+1);
            return new Weight(Double.parseDouble(source), getUnits());
        }
        catch (NumberFormatException e) {
            System.out.println("WeightFormat:parse() NumberFormatException on String ["+source+"]");
            throw e;
        }
        
    }
    
    /** Creates new <CODE>WeightFormat</CODE> object based on this
     * <CODE>WeightFormat</CODE>.
     *
     *@returns new <CODE>WeightFormat</CODE> object
     */
    public Object clone() {
        return new WeightFormat(getUnits(), scale);
    }
    
    /** Sets value for measurement units.
     *
     * @param <CODE>WeightUnits</CODE> new value for measurement units
     */
    public void setUnits(WeightUnits units) {
        this.units = units;
    }
    
    /** Gets value for measurement units.
     *
     * @return <CODE>WeightUnits</CODE> value of current measurement units
     */
    public WeightUnits getUnits() {
        return (WeightUnits)units;
    }
    
}