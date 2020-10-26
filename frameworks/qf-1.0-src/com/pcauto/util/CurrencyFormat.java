/*
 * $Id: CurrencyFormat.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is CurrencyFormat.java
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
import java.text.NumberFormat;
import java.text.FieldPosition;
import java.text.ParseException;

/** <CODE>CurrencyFormat</CODE>  provides several mechanisms to use
 * {@link Currency} objects;
 * <li> to display currency values in dynamically selected units and scale
 * <li> to create and load values into {@link Currency} objects
 * <p>
 * Locale based constructors will use a default scale of 2. The parse and format
 * methods are used to generate and format {@link Currency} objects
 * respectively. They can be used in conjunction to convert {@link Currency}
 * objects into different units.
 * <p>
 * Conversion rates have been hardcoded to Sept. 06, 2002. Use the
 * setCurrencyExchange member function to set new conversion rates.
 *
 * @author $Author: genec $
 * @version $Revision: 1.5 $
 */

public class CurrencyFormat extends QuantityFormat {
    
    /** Creates new <CODE>CurrencyFormat</CODE> instance based on default
     * <CODE>Locale</CODE>
     *
     * @return new <CODE>CurrencyFormat</CODE> instance
     */
    public CurrencyFormat() {
        this(Locale.getDefault());
    }
    
    /** Creates new <CODE>CurrencyFormat</CODE> instance based on supplied
     * <CODE>Locale</CODE>
     *
     * @param loc <CODE>Locale</CODE> to set correct currency units
     * @return new <CODE>CurrencyFormat</CODE> instance
     */
    public CurrencyFormat(Locale loc) {
        if (loc.equals(Locale.CANADA)) setUnits(CurrencyUnits.CAN_DOLLARS);
        else if (loc.equals(Locale.US)) setUnits(CurrencyUnits.US_DOLLARS);
        else {
            System.out.println("CurrencyFormat: Warning: Unsupported locale. Assuming CANADA");
            setUnits(CurrencyUnits.CAN_DOLLARS);
        }
    }
    
    /** Creates new <CODE>CurrencyFormat</CODE> instance with units set to
     * <CODE>int</CODE> units and scale set to <CODE>int</CODE> scale.
     *
     * @param unit <CODE>CurrencyUnits</CODE> to set units
     * @param scale <CODE>int</CODE> to set scale
     */
    public CurrencyFormat(CurrencyUnits units, int scale) {
        setUnits(units);
        setScale(scale);
    }
    
    /** Returns <CODE>String</CODE> with supplied {@link Currency}
     * quantity formatted in units
     *
     * @return <CODE>String</CODE> currency in current units
     * @param crn {@link Currency} object from which to format value
     */
    public String formatCurrency(Currency crn){
        return format(crn, new StringBuffer(), new FieldPosition(0)).toString();
    }
    
    /** Returns <CODE>StringBuffer</CODE> with supplied {@link Currency}
     * quantity formatted in units
     *
     * @return <CODE>StringBuffer</CODE> currency in current units
     * @param crn {@link Currency} object from which to format value
     * @param toAppendTo <CODE>StringBuffer</CODE> to append string to
     * @param pos <CODE>FieldPosition</CODE> ignored in this implementation
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos){
        if (toAppendTo == null || pos == null) throw new NullPointerException();
        if (obj == null) throw new NullPointerException("currency is null");
        if (obj instanceof Currency) {
            Currency crn = (Currency)obj;
            BigDecimal retVal = new BigDecimal(units.convertFrom(crn.getQuantity(), crn.getUnit()));
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(scale);
            nf.setMaximumFractionDigits(scale);
            nf.setGroupingUsed(groupingUsed);
            return toAppendTo.append(nf.format(retVal));
        }
        else throw new IllegalArgumentException("Object to format must be of type com.pcauto.util.Currency");
    }
    
    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Currency} object. The function will successfully parse input
     * <CODE>String</CODE>, even if it contains unit character
     * as first character ($5.33)
     * @param value <CODE>String</CODE> to be converted to {@link Currency} object
     * @return {@link Currency} holding a value specified
     * in input <CODE>String</CODE>
     */
    public Currency parseCurrency(String value){
        return (Currency)parseObject(value, new ParsePosition(0));
    }
    
    /** Parses <CODE>String</CODE> based on units to return a
     * {@link Currency} object. The function will successfully parse input
     * <CODE>String</CODE>, even if it contains unit character
     * as first character ($5.33)
     * @throws <CODE>NumberFormatException</CODE> on non-numeric
     * <CODE>String</CODE> input
     * @param value <CODE>String</CODE> to be converted to {@link Currency} object
     * @return {@link Currency} holding a value specified
     * in input <CODE>String</CODE>
     */
    public Object parseObject(String source, java.text.ParsePosition pos){
        if(source == null) {
            pos.setIndex(1);
            return null;
        }
        if (source.indexOf(units.getString())!=-1) source = (source.substring(1)).trim();
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
            }
            catch(ParseException ex1){
            }
        }
        try {
            pos.setIndex(source.length()+1);
            return new Currency(Double.parseDouble(source), (CurrencyUnits)units);
        }
        catch (NumberFormatException e) {
            System.out.println("CurrencyFormat: parse() NumberFormatException on String ["+source+"]");
            throw e;
        }
    }
    
    /** Sets exchange rate between diferent currency units.
     * This function should be used before any convertions,
     * to override the built-in conversion table.
     *
     * @param <CODE>int</CODE> srcCurrency integer source currency
     * @param <CODE>int</CODE> destCurrency integer destination currency
     * @param <CODE>double</CODE> exchangeRate double exchange Rate
     */
    public void setCurrencyExchange(CurrencyUnits srcCurrency, CurrencyUnits destCurrency, double exchangeRate){
        CurrencyUnits.convertArray[srcCurrency.getId()][destCurrency.getId()] = exchangeRate;
        CurrencyUnits.convertArray[destCurrency.getId()][srcCurrency.getId()] = 0.0;
    }
    
    /** Sets value for currency units.
     *
     * @param  <CODE>CurrencyUnits</CODE> units new value for currency units
     */
    public void setUnits(CurrencyUnits units){
        this.units = units;
    }
    
    /** Gets value for currency units.
     *
     * @return <CODE>CurrencyUnits</CODE> value of current measurement units
     */
    public CurrencyUnits getUnits(){
        return (CurrencyUnits)units;
    }
    
}