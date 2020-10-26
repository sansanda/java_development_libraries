/*
 * DensityFormat.java
 *
 * Created on October 29, 2003, 11:10 AM
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
 * <CODE>DensityFormat</CODE> provides several mechanisms to use
 * {@link Density} objects:
 * <li> to display density values in dynamically selected units
 * <li> to create and load values into {@link Density} objects
 * <p>
 * Locale based constructors use a default scale of 2. The parse and format
 * methods are used to generate and format {@link Density}
 * objects respectively.
 *
 * @author  $Author $
 * @version $Revision $
 */

public class DensityFormat extends QuantityFormat {

    /** Creates new <CODE>DensityFormat</CODE> instance based on default
     * <CODE>Locale</CODE>.
     *
     * @return new <CODE>DensityFormat</CODE> instance
     */
    public DensityFormat() {
        this(Locale.getDefault());
    }
    
    /** Creates new <CODE>DensityFormat</CODE> instance based on supplied
     * <CODE>Locale</CODE>
     *
     * @param loc <CODE>Locale</CODE> to set correct density units
     * @return new <CODE>DensityFormat</CODE> instance
     */
    public DensityFormat(Locale loc) {
        if (loc.equals(Locale.CANADA)) setUnits(DensityUnits.CHARS_INCH);
        else if (loc.equals(Locale.US)) setUnits(DensityUnits.CHARS_INCH);
        else {
            System.out.println("DensityFormat: Warning: Unsupported locale. Assuming CANADA");
            this.setUnits(DensityUnits.CHARS_INCH);
        }
    }
    
    /** Constructs new <CODE>DensityFormat</CODE> with units set to
     * <CODE>int</CODE> units and scale set to <CODE>int</CODE> scale.
     *
     * @param <CODE>DensityUnits</CODE> new units
     * @param <CODE>int</CODE> new scale value
     */
    public DensityFormat(DensityUnits units, int scale) {
        setUnits(units);
        setScale(scale);
    }
    
    /** Gets value for measurement unit.
     *
     * @return <CODE>DensityUnits</CODE> value of current measurement units
     */
    public DensityUnits getUnits(){
        return (DensityUnits)units;
    }
    
    /** Sets value for measurement units.
     *
     * @param  <CODE>int</CODE> units new value for measurement units
     */
    public void setUnits(DensityUnits units){
        this.units = units;
    }

    /** Returns <CODE>String</CODE> with supplied {@link Density}
     * quantity formatted in units.
     *
     * @return <CODE>String</CODE> density in current units
     * @param dim {@link Density} object from which to format value
     */
    public String formatDensity(Density den) {
        return format(den, new StringBuffer(), new FieldPosition(0)).toString();
    }

    /** Returns <CODE>StringBuffer</CODE> with supplied {@link Density}
     * quantity formatted in units.
     *
     * @return <CODE>StringBuffer</CODE> density in current units
     * @param obj {@link Density} object from which to format value
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if (toAppendTo == null || pos == null) throw new NullPointerException();
        if (obj == null) throw new NullPointerException("density is null");
        if (obj instanceof Density) {
            Density den = (Density)obj;
            BigDecimal retVal =  new BigDecimal(units.convertFrom(den.getQuantity(), den.getUnit()));
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(scale);
            nf.setMaximumFractionDigits(scale);
            nf.setGroupingUsed(groupingUsed);
            return toAppendTo.append(nf.format(retVal));
        }
        else throw new IllegalArgumentException("Object to format must be of type com.pcauto.util.Density");
    }

    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Density} object.
     *
     * @param value <CODE>String</CODE> to be converted to
     * {@link Density} object
     * @return {@link Density} holding a value specified
     * in input <CODE>String</CODE>
     */
    public Density parseDensity(String value){
        return (Density)parseObject(value, new ParsePosition(0));
    }
    
    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Density} object.
     *
     * @throws <CODE>NumberFormatException</CODE> on non-numeric
     * <CODE>String</CODE> input
     * @param value <CODE>String</CODE> to be converted to
     * {@link Density} object
     * @param pos <CODE>ParsePosition</CODE> ignored in this implementation
     * @return {@link Density} holding a value specified
     * in input <CODE>String</CODE>
     */
    public Object parseObject(String source, java.text.ParsePosition pos) {
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
            try{
                String temp = nf1.format(nf.parse(source));
                source = new String(temp);
            } catch(ParseException ex1) {
            }
        }
        try {
            pos.setIndex(source.length() + 1);
            return new Density(Double.parseDouble(source), getUnits());
        } catch (NumberFormatException e) {
            System.out.println("DensityFormat:parse() NumberFormatException on String [" + source + "]");
            throw e;
        }
    }
    
    /** Creates new <CODE>DensityFormat</CODE> object based on this
     * <CODE>DensityFormat</CODE>.
     *
     * @return new <CODE>DensityFormat</CODE> object
     */
    public Object clone(){
        return new DensityFormat(getUnits(), scale);
    }
}
