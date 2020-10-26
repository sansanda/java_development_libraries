/*
 * $Id: DistanceFormat.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is DistanceFormat.java
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
import java.text.ParseException;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.lang.Double;

/**
 * <CODE>DistanceFormat</CODE> provides several mechanisms to use
 * {@link Distance} objects: <li> to display distance values in dynamically
 * selected units <li> to create and load values into {@link Distance}
 * objects
 * <p>
 * Locale based constructors use a default scale of 2. The parse and format
 * methods are used to generate and format {@link Distance} objects respectively
 *
 * @author $Author: genec $
 * @version $Revision: 1.6 $
 */

public class DistanceFormat extends QuantityFormat {
    
    /** Constructs new <CODE>DistanceFormat</CODE> instance based on
     * default <CODE>Locale</CODE>
     */
    public DistanceFormat() {
        this(Locale.getDefault());
    }
    
    /** Constructs new <CODE>DistanceFormat</CODE> instance based on locale.
     *
     * @param loc <CODE>Locale</CODE> to set correct measurement units
     */
    public DistanceFormat(Locale loc) {
        if (loc.equals(Locale.CANADA)) setUnits(DistanceUnits.KILOMETRE);
        else if (loc.equals(Locale.US)) setUnits(DistanceUnits.MILE);
        else {
            System.out.println("DistanceFormat: Warning: Unsupported locale. Assuming CANADA");
            this.setUnits(DistanceUnits.KILOMETRE);
        }
    }
    
    /** Constructs new <CODE>DistanceFormat</CODE> instance with units set to
     * <CODE>DistanceUnits</CODE> units and scale set to <CODE>int</CODE> scale.
     *
     * @param unit <CODE>DistanceUnits</CODE> to set units
     * @param scale <CODE>int</CODE> to set scale
     */
    public DistanceFormat(DistanceUnits units, int scale) {
        setUnits(units);
        setScale(scale);
    }
    
    /** Returns <CODE>String</CODE> with supplied {@link Distance}
     * quantity formatted in units
     *
     * @param dist {@link Distance} object from which to format value
     * @return <CODE>String</CODE> distance in current units
     */
    public String formatDistance(Distance dist){
        return format(dist, new StringBuffer(), new FieldPosition(0)).toString();
    }
    
    /** Returns <CODE>StringBuffer</CODE> with supplied {@link Distance}
     * quantity formatted in units
     *
     * @param dist {@link Distance} object from which to format value
     * @return <CODE>String</CODE> distance in current units
     * @throws <CODE>IllegalArgumentException</CODE> if obj is not of type
     * <CODE>Distance</CODE>
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if (toAppendTo == null || pos == null)
            throw new NullPointerException();
        if (obj == null) throw new NullPointerException("distance is null");
        if (obj instanceof Distance) {
            Distance dist = (Distance)obj;
            BigDecimal retVal =  new BigDecimal(units.convertFrom(dist.getQuantity(), dist.getUnit()));
            NumberFormat nf =NumberFormat.getInstance();
            nf.setMinimumFractionDigits(scale);
            nf.setMaximumFractionDigits(scale);
            nf.setGroupingUsed(groupingUsed);
            return toAppendTo.append(nf.format(retVal));
        }
        else throw new IllegalArgumentException("Object to format must be of type com.pcauto.util.Distance");
    }
    
    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Distance} object.
     *
     * @param value <CODE>String</CODE> to be converted to {@link Distance} object
     * @return {@link Distance} holding a value specified
     * in input <CODE>String</CODE>
     */
    public Distance parseDistance(String value){
        return (Distance)parseObject(value, new java.text.ParsePosition(0));
    }
    
    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Distance} object.
     *
     * @throws <CODE>NumberFormatException</CODE> on non-numeric
     * <CODE>String</CODE> input
     * @param source <CODE>String</CODE> to be converted to {@link Distance} object
     * @param pos <CODE>ParsePosition</CODE> ignored in this implementation
     * @return {@link Distance} holding a value specified
     * in input <CODE>String</CODE>
     */
    public Object parseObject(String source, java.text.ParsePosition pos){
        if ( source == null ) {
            pos.setIndex(1);
            return null;
        }
        if (isGroupingUsed()){
            NumberFormat nf =NumberFormat.getInstance();
            nf.setMinimumFractionDigits(scale);
            nf.setMaximumFractionDigits(scale);
            nf.setGroupingUsed(isGroupingUsed());
            NumberFormat nf1 = NumberFormat.getInstance();
            nf1.setMinimumFractionDigits(scale);
            nf1.setMaximumFractionDigits(scale);
            nf1.setGroupingUsed(false);
            try{
                String temp = nf1.format(nf.parse(source));
                source = new String(temp);
            }catch(ParseException ex1){
            }
        }
        try {
            pos.setIndex(source.length()+1);
            return new Distance(Double.parseDouble(source), getUnits());
        } catch ( NumberFormatException e ) {
            System.out.println(
            "WeightFormat:parse() NumberFormatException on String ["+source+"]");
            throw e;
        }
    }
    
    /** Creates new <CODE>DistanceFormat<CODE> object based on this
     * <CODE>DistanceFormat</CODE>.
     *
     * @returns new <CODE>DistanceFormat</CODE> object
     */
    public Object clone() {
        return new DistanceFormat(getUnits(), scale);
    }
    
    /** Sets value for measurement units.
     *
     * @param <CODE>DistanceUnits</CODE> units new value for measurement units
     */
    public void setUnits(DistanceUnits units){
        this.units = units;
    }
    
    /** Gets value for measurement units.
     *
     * @return <CODE>DistanceUnits</CODE> value of current measurement units
     */
    public DistanceUnits getUnits(){
        return (DistanceUnits)units;
    }
    
}