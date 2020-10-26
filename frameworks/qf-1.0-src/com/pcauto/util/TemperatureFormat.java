/*
 * $Id: TemperatureFormat.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is TemperatureFormat.java
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
 * <CODE>TemperatureFormat</CODE> provides several mechanisms to use
 * {@link Temperature} objects:
 * <li> to display temperature values in dynamically selected units
 * <li> to create and load values into {@link Temperature} objects
 * <p>
 * Locale based constructors use a default scale of 2. The parse and format
 * methods are used to generate and format {@link Temperature}
 * objects respectively.
 *
 * @author $Author: genec $
 * @version $Revision: 1.5 $
 */

public class TemperatureFormat extends QuantityFormat {
    
    /** Creates new <CODE>TemperatureFormat</CODE> instance based on default
     * <CODE>Locale</CODE>.
     *
     * @return new <CODE>TemperatureFormat</CODE> instance
     */
    public TemperatureFormat() {
        this(Locale.getDefault());
    }
    
    /** Creates new <CODE>TemperatureFormat</CODE> instance based on supplied
     * <CODE>Locale</CODE>
     *
     * @param loc <CODE>Locale</CODE> to set correct temperature units
     * @return new <CODE>TemperatureFormat</CODE> instance
     */
    public TemperatureFormat(Locale loc) {
        if (loc.equals(Locale.CANADA)) setUnits(TemperatureUnits.CELCIUS);
        else if (loc.equals(Locale.US)) setUnits(TemperatureUnits.FAHRENHEIT);
        else {
            System.out.println("TemperatureFormat: Warning: Unsupported locale. Assuming CANADA");
            this.setUnits(TemperatureUnits.CELCIUS);
        }
    }
    
    /** Constructs new <CODE>TemperatureFormat</CODE> with units set to
     * <CODE>int</CODE> units and scale set to <CODE>int</CODE> scale.
     *
     * @param <CODE>TemperatureUnits</CODE> new units
     * @param <CODE>int</CODE> new scale value
     */
    public TemperatureFormat(TemperatureUnits units, int scale) {
        setUnits(units);
        setScale(scale);
    }
    
    /** Returns <CODE>String</CODE> with supplied {@link Temperature}
     * quantity formatted in units.
     *
     * @return <CODE>String</CODE> temperature in current units
     * @param tp {@link Temperature} object from which to format value
     */
    public String formatTemperature(Temperature tp) {
        return format(tp, new StringBuffer(),
        new FieldPosition(0)).toString();
    }
    
    /** Returns <CODE>StringBuffer</CODE> with supplied {@link Temperature}
     * quantity formatted in units.
     *
     * @return <CODE>StringBuffer</CODE> temperature in current units
     * @param obj {@link Temperature} object from which to format value
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if (toAppendTo == null || pos == null) throw new NullPointerException();
        if (obj == null) throw new NullPointerException("temperature is null");
        if (obj instanceof Temperature) {
            Temperature tp = (Temperature)obj;
            BigDecimal retVal =  new BigDecimal(units.convertFrom(tp.getQuantity(), tp.getUnit()));
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(scale);
            nf.setMaximumFractionDigits(scale);
            nf.setGroupingUsed(groupingUsed);
            return toAppendTo.append(nf.format(retVal));
        }
        else throw new IllegalArgumentException("Object to format must be of type com.pcauto.util.Temperature");
    }
    
    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Temperature} object.
     *
     * @param value <CODE>String</CODE> to be converted to
     * {@link Temperature} object
     * @return {@link Temperature} holding a value specified
     * in input <CODE>String</CODE>
     */
    public Temperature parseTemperature(String value){
        return (Temperature)parseObject(value, new java.text.ParsePosition(0));
    }
    
    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Temperature} object.
     *
     * @throws <CODE>NumberFormatException</CODE> on non-numeric
     * <CODE>String</CODE> input
     * @param value <CODE>String</CODE> to be converted to
     * {@link Temperature} object
     * @param pos <CODE>ParsePosition</CODE> ignored in this implementation
     * @return {@link Temperature} holding a value specified
     * in input <CODE>String</CODE>
     */
    public Object parseObject(String source, java.text.ParsePosition pos) {
        if (source == null) {
            pos.setIndex(1);
            return null;
        }
        if (isGroupingUsed()) {
            NumberFormat nf = NumberFormat.getInstance();
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
            catch (ParseException ex1){
            }
        }
        try {
            pos.setIndex(source.length()+1);
            return new Temperature(Double.parseDouble(source), getUnits());
        }
        catch ( NumberFormatException e) {
            System.out.println("TemperatureFormat:parse() NumberFormatException on String ["+source+"]");
            throw e;
        }
    }
    
    /** Creates new <CODE>TemperatureFormat</CODE> object based on this
     * <CODE>TemperatureFormat</CODE>.
     *
     * @return new <CODE>TemperatureFormat</CODE> object
     */
    public Object clone(){
        return new TemperatureFormat(getUnits(), scale);
    }
    
    /** Sets value for measurement units.
     *
     * @param  <CODE>TemperatureUnits</CODE> units new value for measurement units
     */
    public void setUnits(TemperatureUnits units){
        this.units = units;
    }
    
    /** Gets value for measurement unit.
     *
     * @return <CODE>TemperatureUnits</CODE> value of current measurement units
     */
    public TemperatureUnits getUnits(){
        return (TemperatureUnits)units;
    }
    
}