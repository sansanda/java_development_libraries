/*
 * DimensionFormat.java
 *
 * Created on October 29, 2003, 10:47 AM
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
 * <CODE>DimensionFormat</CODE> provides several mechanisms to use
 * {@link Dimension} objects:
 * <li> to display dimension values in dynamically selected units
 * <li> to create and load values into {@link Dimension} objects
 * <p>
 * Locale based constructors use a default scale of 2. The parse and format
 * methods are used to generate and format {@link Dimension}
 * objects respectively.
 *
 * @author  $Author $
 * @version $Revision $
 */

public class DimensionFormat extends QuantityFormat {

    /** Creates new <CODE>DimensionFormat</CODE> instance based on default
     * <CODE>Locale</CODE>.
     *
     * @return new <CODE>DimensionFormat</CODE> instance
     */
    public DimensionFormat() {
        this(Locale.getDefault());
    }
    
    /** Creates new <CODE>DimensionFormat</CODE> instance based on supplied
     * <CODE>Locale</CODE>
     *
     * @param loc <CODE>Locale</CODE> to set correct dimension units
     * @return new <CODE>DimensionFormat</CODE> instance
     */
    public DimensionFormat(Locale loc) {
        if (loc.equals(Locale.CANADA)) setUnits(DimensionUnits.INCH);
        else if (loc.equals(Locale.US)) setUnits(DimensionUnits.INCH);
        else {
            System.out.println("DimensionFormat: Warning: Unsupported locale. Assuming CANADA");
            setUnits(DimensionUnits.INCH);
        }
    }
    
    /** Constructs new <CODE>DimensionFormat</CODE> with units set to
     * <CODE>int</CODE> units and scale set to <CODE>int</CODE> scale.
     *
     * @param <CODE>DimensionUnits</CODE> new units
     * @param <CODE>int</CODE> new scale value
     */
    public DimensionFormat(DimensionUnits units, int scale) {
        setUnits(units);
        setScale(scale);
    }
    
    /** Gets value for measurement unit.
     *
     * @return <CODE>DimensionUnits</CODE> value of current measurement units
     */
    public DimensionUnits getUnits(){
        return (DimensionUnits)units;
    }
    
    /** Sets value for measurement units.
     *
     * @param  <CODE>DimensionUnits</CODE> units new value for measurement units
     */
    public void setUnits(DimensionUnits units){
        this.units = units;
    }
    
    /** Returns <CODE>String</CODE> with supplied {@link Dimension}
     * quantity formatted in units.
     *
     * @return <CODE>String</CODE> dimension in current units
     * @param dim {@link Dimension} object from which to format value
     */
    public String formatDimension(Dimension dim){
        return format(dim, new StringBuffer(), new FieldPosition(0)).toString();
    }

    /** Returns <CODE>StringBuffer</CODE> with supplied {@link Dimension}
     * quantity formatted in units.
     *
     * @return <CODE>StringBuffer</CODE> dimension in current units
     * @param obj {@link Dimension} object from which to format value
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if (toAppendTo == null || pos == null)
            throw new NullPointerException();
        if (obj == null) throw new NullPointerException("dimension is null");
        if (obj instanceof Dimension) {
            Dimension dim = (Dimension)obj;
            BigDecimal retVal =  new BigDecimal(units.convertFrom(dim.getQuantity(), dim.getUnit()));
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(scale);
            nf.setMaximumFractionDigits(scale);
            nf.setGroupingUsed(groupingUsed);
            return toAppendTo.append(nf.format(retVal));
        } else {
            throw new IllegalArgumentException("Object to format must be of type com.pcauto.util.Dimension");
        }
    }

    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Dimension} object.
     *
     * @param value <CODE>String</CODE> to be converted to
     * {@link Dimension} object
     * @return {@link Dimension} holding a value specified
     * in input <CODE>String</CODE>
     */
    public Dimension parseDimension(String value){
        return (Dimension)parseObject(value, new java.text.ParsePosition(0));
    }
    
    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Dimension} object.
     *
     * @throws <CODE>NumberFormatException</CODE> on non-numeric
     * <CODE>String</CODE> input
     * @param value <CODE>String</CODE> to be converted to
     * {@link Dimension} object
     * @param pos <CODE>ParsePosition</CODE> ignored in this implementation
     * @return {@link Dimension} holding a value specified
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
            return new Dimension(Double.parseDouble(source), getUnits());
        } catch (NumberFormatException e) {
            System.out.println("DimensionFormat:parse() NumberFormatException on String [" + source + "]");
            throw e;
        }
    }
  
    /** Creates new <CODE>DimensionFormat</CODE> object based on this
     * <CODE>DimensionFormat</CODE>.
     *
     * @return new <CODE>DimensionFormat</CODE> object
     */
    public Object clone() {
        return new DimensionFormat(getUnits(), scale);
    }
}
