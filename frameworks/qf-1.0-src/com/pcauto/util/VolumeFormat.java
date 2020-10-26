/*
 * $Id: VolumeFormat.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is VolumeFormat.java
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
 * <CODE>VolumeFormat</CODE> provides several mechanisms to use {@link Volume}
 * objects:
 * <li> to display volume values in dynamically selected units
 * <li> to create and load values into {@link Volume} objects
 * <p>
 * Locale based constructors use a default scale of 2. The parse and format
 * methods are used to generate and format {@link Volume} objects respectively.
 *
 * @author $Author: genec $
 * @version $Revision: 1.6 $
 */

public class VolumeFormat extends QuantityFormat {
    
    /** Constructs new <CODE>VolumeFormat</CODE> instance based on default
     * <CODE>Locale</CODE>.
     */
    public VolumeFormat() {
        this(Locale.getDefault());
    }
    
    /** Constructs new <CODE>VolumeFormat</CODE> instance based on supplied
     * <CODE>Locale</CODE>.
     *
     * @param loc <CODE>Locale</CODE> to set correct measurement units
     */
    public VolumeFormat(Locale loc){
        if (loc.equals(Locale.CANADA)) setUnits(VolumeUnits.CUBIC_METRE);
        else if (loc.equals(Locale.US)) setUnits(VolumeUnits.CUBIC_YARD);
        else {
            System.out.println("VolumeFormat: Warning: Unsupported locale. Assuming CANADA");
            this.setUnits(VolumeUnits.CUBIC_METRE);
        }
    }
    
    /** Constructs new <CODE>VolumeFormat</CODE> with units set to
     * <CODE>VolumeUnits</CODE> units and scale set to <CODE>int</CODE> scale.
     *
     * @param units <CODE>VolumeUnits</CODE> to set units
     * @param scale <CODE>int</CODE> to set scale
     */
    public VolumeFormat(VolumeUnits units, int scale) {
        setUnits(units);
        setScale(scale);
    }
    
    /** Returns <CODE>String</CODE> with supplied {@link Volume}
     * quantity formatted in units.
     *
     * @return <CODE>String</CODE> volume in current units
     * @param vol {@link Volume} object from which to format value
     */
    public String formatVolume(Volume vol){
        return format(vol, new StringBuffer(), new FieldPosition(0)).toString();
    }
    
    /** Returns <CODE>StringBuffer</CODE> with supplied {@link Volume}
     * quantity formatted in units.
     *
     * @return <CODE>StringBuffer</CODE> volume in current units
     * @param obj {@link Object} object from which to format value
     * @param toAppendTo (@link StringBuffer} buffer to append value to
     * @param pos {@link FieldPosition} ignored in this implementation
     * @throws <CODE>IllegalArgumentException</CODE> if obj is not of type
     * <CODE>Volume</CODE>.
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        
        if (toAppendTo == null || pos == null)
            throw new NullPointerException();
        if (obj == null) throw new NullPointerException("volume is null");
        if (obj instanceof Volume) {
            Volume vol = (Volume)obj;
            BigDecimal retVal =  new BigDecimal(units.convertFrom(vol.getQuantity(), vol.getUnit()));
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(scale);
            nf.setMaximumFractionDigits(scale);
            nf.setGroupingUsed(groupingUsed);
            return toAppendTo.append(nf.format(retVal));
        }
        else throw new IllegalArgumentException("Object to format must be of type com.pcauto.util.Volume");
    }
    
    /** Parses <CODE>String</CODE> based on units to return
     * a {@link Volume} object.
     *
     * @throws <CODE>NumberFormatException</CODE> on non-numeric
     * <CODE>String</CODE> input
     * @param value <CODE>String</CODE> to be converted
     * to {@link Volume} object
     * @return {@link Volume} holding a value specified in
     * input <CODE>String</CODE>
     */
    public Volume parseVolume(String value){
        return (Volume)parseObject(value, new java.text.ParsePosition(0));
    }
    
    /** Parses <CODE>String</CODE> based on units to return
     * a {@link Volume} object as an {@link Object}.
     *
     * @throws <CODE>NumberFormatException</CODE> on non-numeric
     * <CODE>String</CODE> input
     * @param source <CODE>String</CODE> to be converted
     * to {@link Volume} object
     * @param pos ignored in this implementation
     * @return {@link Volume} holding a value specified in
     * input <CODE>String</CODE>
     */
    public Object parseObject(String source, java.text.ParsePosition pos) {
        
        if( source == null ) {
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
            return new Volume(Double.parseDouble(source), getUnits());
        } catch( NumberFormatException e ) {
            System.out.println(
            "VolumeFormat:parse() NumberFormatException on String ["+source+"]");
            throw e;
        }
    }
    
    /** Sets value for measurement units.
     *
     * @param units <CODE>VolumeUnits</CODE> new value for measurement units
     */
    public void setUnits(VolumeUnits units){
        this.units = units;
    }
    
    /** Gets value for measurement units.
     *
     * @return <CODE>VolumeUnits</CODE> value of current measurement units
     */
    public VolumeUnits getUnits(){
        return (VolumeUnits)units;
    }
    
}