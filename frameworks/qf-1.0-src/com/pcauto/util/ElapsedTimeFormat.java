/*
 * $Id: ElapsedTimeFormat.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is ElapsedTimeFormat.java
 *
 * The Initial Developer of the Original Code is PC Automation.
 * Portions created by PC Automation are Copyright (C) 2003.
 * All Rights Reserved.
 *
 * Contributor(s):
 *
 */

package com.pcauto.util;

import java.util.Vector;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.text.ParseException;

import java.util.Locale;
import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.FieldPosition;

/**
 * <CODE>ElapsedTimeFormat</CODE> is a concrete class for formatting and
 * parsing {@link ElapsedTime} objects.
 *
 * If no current pattern for the formatter is specified at instantiation, the
 * global pattern will be used to create all new
 * <CODE>ElapsedTimeFormat</CODE> objects.
 * <p>
 * The reserved letters for formatter pattern definitions, are defined below:
 * <li>w - week
 * <li>d - day
 * <li>h - hour
 * <li>m - minute
 * <li>s -second
 * <p>
 * All literals should be enclosed into single quotes '', except . and :
 * <p>
 * The smallest time unit in the pattern string can use a scale, which should
 * be specified in the pattern (for example, hh:mm.mm).
 *
 * @author $Author: genec $
 * @version $Revision: 1.6 $
 */

public class ElapsedTimeFormat extends QuantityFormat {
    
    /** Constructs new <CODE>ElapsedTimeFormat</CODE> using global pattern.
     */
    public ElapsedTimeFormat() {
        this.applyPattern(globalFormat);
    }
    
    /** Constructs new <CODE>ElapsedTimeFormat</CODE> instance
     * based on pattern specified.
     *
     * @param format <CODE>String</CODE>
     */
    public ElapsedTimeFormat(String format){
        if (format == null){
            System.out.println(
            "ElapsedTimeFormat: getInstance:  Null format detected. Using default: "+
            globalFormat);
            format=globalFormat;
        }
        this.applyPattern(format);
    }
    
    /** Sets new global pattern to be used as default for new objects.
     *
     * @param format <CODE>String</CODE>
     */
    public static void applyGlobalPattern(String format){
        if (format != null) {
            globalFormat = format;
        } else {
            System.out.println(
            "ElapsedTimeFormat: applyGlobalPattern:  "+
            "Cannot set global pattern to null");
        }
    }
    
    /** Returns current global pattern <CODE>String</CODE>.
     *
     * @return  <CODE>String</CODE> global pattern
     */
    public static String toGlobalPattern(){
        return globalFormat;
    }
    
    /** Sets new pattern for this <CODE>ElapsedTimeFormat</CODE>.
     *
     * @param format <CODE>String</CODE>
     */
    public void applyPattern(String format){
        currentFormat = format.trim();
        tokenizeFormatter(format.trim());
    }
    
    /** Returns current pattern <CODE>string</CODE>
     *
     * @return <CODE>String</CODE> pattern
     */
    public String toPattern(){
        return currentFormat;
    }
    
    /** Sets rounding mode to be used by the smallest time unit in
     * the current pattern string. The rounding modes expected are those, which
     * are used in <CODE>BigDecimal</CODE> class.
     *
     * @param roundingMode <CODE>int</CODE>
     */
    public void setRoundingMode(int roundingMode){
        this.roundingMode = roundingMode;
    }
    
    /** Get current rounding mode.
     *
     * @return <CODE>int</CODE>
     */
    public int getRoundingMode(){
        return this.roundingMode;
    }
    
    /** Parses <CODE>String</CODE> based on units to return an
     * {@link ElapsedTime} object.
     *
     * @param value <CODE>String</CODE> to be converted
     * to {@link ElapsedTime} object
     * @return {@link ElapsedTime} holding a value specified
     * in input <CODE>String</CODE>
     */
    public ElapsedTime parseElapsedTime(String value) throws ParseException{
        return (ElapsedTime)parseObject(value);
    }
    
    
    /** Parses <CODE>String</CODE> based on units to return an
     * {@link ElapsedTime} object.
     *
     * @throws <CODE>NumberFormatException</CODE> on
     * non-numeric <CODE>String</CODE> input
     * @param source <CODE>String</CODE> to be converted
     * to {@link ElapsedTime} object
     * @param pos <CODE>ParsePosition</CODE> (can't be null)
     * @return {@link Object} a <CODE>ElapsedTime</CODE> holding a value specified
     * in input <CODE>String</CODE>
     */
    public Object parseObject(String source, java.text.ParsePosition pos) {
        
        if (source == null) {
            return null;
        }
        if (source.trim().length()==0) {
            pos.setIndex(0);   // will trip ParseException in java.text.parseObject(obj)
            //throw new ParseException(
            //"ElapsedTime: parse: Not a valid String to parse.",1);
        }
        BigDecimal retVal = new BigDecimal("0");
        int offset =0;
        Iterator i = etFormats.iterator();
        if (i.hasNext()==false){
            pos.setIndex(0);
            //throw new ParseException(
            //"ElapsedTime: parse: No Formatter Pattern Specified.",1);
        }
        ETFormatObject currentFormatter = (ETFormatObject)i.next();
        ETFormatObject nextFormatter =null;
        while (true){
            if (i.hasNext()){
                nextFormatter = (ETFormatObject)i.next();
            }else {
                nextFormatter = null;
            }
            int currentLength = 0;
            if (nextFormatter == null){
                currentLength = source.length()-offset;
            }else if (nextFormatter.literal){
                currentLength = source.substring(offset).indexOf(nextFormatter.string);
                if (currentLength < 0){
                    pos.setIndex(0);
                    //throw new ParseException(
                    //"ElapsedTime: parse: Not a valid String to parse.",1);
                }
            }else {
                currentLength = currentFormatter.string.length();
            }
            if (currentFormatter.literal){
                if (source.substring(offset).indexOf(currentFormatter.string)<0){
                    pos.setIndex(0);
                    //throw new ParseException(
                    //"ElapsedTime: parse: Not a valid String to parse.",1);
                }
            }else{
                try{
                    retVal=retVal.add(currentFormatter.parse(
                    source.substring(offset,offset+currentLength).trim()));
                }catch (NumberFormatException ex){
                    pos.setIndex(0);
                    //throw new ParseException(
                    //"ElapsedTime: parse: Unable to convert to BigDecimal "
                    //+ ex.getMessage(),1);
                }
            }
            offset +=currentLength;
            if (offset > source.length()){
                pos.setIndex(0);
                //throw new ParseException(
                //"ElapsedTime: parse: Not a valid String to parse.",1);
            }
            currentFormatter = nextFormatter;
            if (currentFormatter == null){
                break;
            }
        }
        pos.setIndex(source.length()+1);
        return new ElapsedTime(retVal.doubleValue());
    }
    
    
    
    /** Returns <CODE>String</CODE> with {@link ElapsedTime} formatted in
     * current format.
     *
     * @return <CODE>String</CODE> {@link ElapsedTime} in current format
     * @param time {@link ElapsedTime} object from which to format value
     */
    public String formatElapsedTime(ElapsedTime time){
        return format(time, new StringBuffer(), new FieldPosition(0)).toString();
    }
    
    /** Returns <CODE>StringBuffer</CODE> with {@link ElapsedTime} formatted in
     * current format.
     *
     * @return <CODE>StringBuffer</CODE> {@link ElapsedTime} in current format
     * @param obj <CODE>Object</CODE> The object to format
     * @param toAppendTo <CODE>int</CODE> where the text is to be appended
     * @param pos On input: an alignment field, if desired.
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos){
        
        if (toAppendTo == null || pos == null)
            throw new NullPointerException();
        if (obj == null) throw new NullPointerException("elapsed time is null");
        
        if (obj instanceof ElapsedTime) {
            ElapsedTime time = (ElapsedTime)obj;
            BigDecimal quantity= new BigDecimal(time.getQuantity());
            StringBuffer retVal = new StringBuffer();
            for (int i=0; i<etFormats.size(); i++){
                retVal.append(((ETFormatObject)etFormats.get(i)).format(quantity));
            }
            return toAppendTo.append(retVal.toString());
        }
        else
            throw new IllegalArgumentException("Object to format must be " +
            "of type com.pcauto.util.ElapsedTime");
    }
    
    
    private void tokenizeFormatter(String n_format){
        //parse out literals
        StringTokenizer st= new StringTokenizer(n_format,"'",true);
        Vector rawTokens = new Vector();
        while (st.hasMoreTokens()) {
            rawTokens.add(st.nextToken());
        }
        Vector v1 = new Vector();
        boolean literalMode = false;
        String tok = new String();
        Iterator it = rawTokens.iterator();
        
        while (it.hasNext()){
            String temp= (String)it.next();
            if (literalMode == false){
                tok = temp;
                if (temp.equals("'")){
                    literalMode = true;
                }else{
                    v1.add(tok);
                }
            }else{
                tok +=  temp;
                if (temp.equals("'")){
                    literalMode =false;
                    v1.add(tok);
                }
            }
        }
        
        //break into weeks, days ... seconds
        Vector tokens = new Vector();
        it = v1.iterator();
        while (it.hasNext()){
            String str = ((String)it.next()).trim();
            if (str.indexOf("'")>=0){
                //this is literal
                tokens.add(str);
            }else{
                char strArr[] = str.toCharArray();
                char mask = strArr[0];
                if (mask=='.'){
                    mask = strArr[1];
                }
                str = new String();
                for (int i= 0; i<strArr.length; i++){
                    char testCh= strArr[i];
                    if (testCh==mask || testCh=='.'){
                        str += testCh;
                    }else{
                        //add already finished substring
                        if (str.equals(":")){
                            str="':'";
                        }
                        tokens.add(str);
                        mask = testCh;
                        str=new String();
                        str+=testCh;
                    }
                }
                tokens.add(str);
            }
        }
        etFormats=new Vector();
        it= tokens.iterator();
        ETFormatObject etf = null;
        while (it.hasNext()){
            String temp= (String)it.next();
            etf= getETFormat(temp);
            if (etf == null){
                System.out.println("ElapsedTimeFormat: tokenizeFormatter: "+
                "Invalid Token: "+ temp);
                break;
            }
            etFormats.add(etf);
        }
        
        smallestUnit = ETFormatObject.TYPE_WEEK;
        largestUnit = ETFormatObject.TYPE_SECOND;
        //Set smallest and largest time unit
        it = etFormats.iterator();
        while (it.hasNext()){
            ETFormatObject temp= (ETFormatObject)it.next();
            if (temp.unitType< smallestUnit && !temp.literal){
                smallestUnit=temp.unitType;
            }
            if (temp.unitType> largestUnit ){
                largestUnit=temp.unitType;
            }
        }
        
        //Check to see that precision is set only in smallest time unit
        it = etFormats.iterator();
        while (it.hasNext()){
            ETFormatObject temp= (ETFormatObject)it.next();
            if (temp.unitType > smallestUnit && temp.precision != 0){
                System.out.println("ElapsedTimeFormat: tokenezeFormatter: "+
                "Precision Specified Not in the Smallest Time Unit");
                etFormats=new Vector();
            }
        }
    }
    
    private ETFormatObject getETFormat(String formatter){
        ETFormatObject retVal = new ETFormatObject();
        retVal.string = formatter;
        //set unitType of format
        if (formatter.indexOf('\'')==0){
            retVal.string = retVal.string.substring(retVal.string.indexOf('\'')+1,
            retVal.string.lastIndexOf('\''));
            retVal.literal = true;
        }else if (!retVal.checkChar(formatter)){
            return null;
        }else if(formatter.indexOf('w')!=-1){
            retVal.unitType= retVal.TYPE_WEEK;
        }else if(formatter.indexOf('d')!=-1){
            retVal.unitType= retVal.TYPE_DAY;
        }else if(formatter.indexOf('h')!=-1){
            retVal.unitType= retVal.TYPE_HOUR;
        }else if(formatter.indexOf('m')!=-1){
            retVal.unitType= retVal.TYPE_MINUTE;
        }else if(formatter.indexOf('s')!=-1){
            retVal.unitType= retVal.TYPE_SECOND;
        }
        //set precision of format
        if (formatter.indexOf('.')>=0 && !retVal.literal){
            retVal.precision=formatter.substring(formatter.indexOf('.')+1).length();
        }
        //set length of format
        if (!retVal.literal){
            retVal.length =formatter.length();
        }
        return  retVal;
    }
    
    protected double convertUnits(double value, int srcUnit, int destUnit) {
        return value;
    }
    
    private String currentFormat;
    private Vector etFormats = new Vector();
    private int roundingMode = BigDecimal.ROUND_HALF_UP;
    private int smallestUnit = ETFormatObject.TYPE_WEEK;
    private int largestUnit = ETFormatObject.TYPE_SECOND;
    private static String globalFormat = "hh:mm:ss";
    
    private class ETFormatObject {
        private static final int TYPE_WEEK = 5;
        private static final int TYPE_DAY = 4;
        private static final int TYPE_HOUR = 3;
        private static final int TYPE_MINUTE = 2;
        private static final int TYPE_SECOND = 1;
        
        private  final BigDecimal FACTOR_WEEK = new BigDecimal("604800");
        private  final BigDecimal FACTOR_DAY = new BigDecimal("86400");
        private  final BigDecimal FACTOR_HOUR  = new BigDecimal("3600");
        private  final BigDecimal FACTOR_MINUTE  = new BigDecimal("60");
        private  final BigDecimal FACTOR_SECOND  = new BigDecimal("1");
        
        private ETFormatObject(){
        }
        
        private BigDecimal parse(String str) {
            BigDecimal retVal = new BigDecimal(str);
            switch (unitType){
                case TYPE_WEEK: return retVal.multiply(FACTOR_WEEK);
                case TYPE_DAY:  return retVal.multiply(FACTOR_DAY);
                case TYPE_HOUR: return retVal.multiply(FACTOR_HOUR);
                case TYPE_MINUTE: return retVal.multiply(FACTOR_MINUTE);
                case TYPE_SECOND: return retVal.multiply(FACTOR_SECOND);
            }
            return null;
        }
        
        private String format(BigDecimal val){
            String retVal= new String();
            BigDecimal factor = new BigDecimal("1");
            BigDecimal limitFactor = null;
            
            if (literal==true){
                return string;
            }
            
            switch (unitType){
                case TYPE_WEEK:{
                    factor = FACTOR_WEEK;
                    break;
                }
                case TYPE_DAY:{
                    factor = FACTOR_DAY;
                    limitFactor = new BigDecimal("7");
                    break;
                }
                case TYPE_HOUR:{
                    factor = FACTOR_HOUR;
                    limitFactor = new BigDecimal("24");
                    break;
                }
                case TYPE_MINUTE:{
                    factor = FACTOR_MINUTE;
                    limitFactor = new BigDecimal("60");
                    break;
                }
                case TYPE_SECOND:{
                    factor = FACTOR_SECOND;
                    limitFactor = new BigDecimal("60");
                    break;
                }
            }
            int roundingFactor = BigDecimal.ROUND_DOWN;
            if (smallestUnit==unitType){
                roundingFactor = roundingMode;
            }
            BigDecimal unitVal = val.divide(factor,precision,roundingFactor);
            if (unitType!=largestUnit && unitVal.compareTo(limitFactor)!=-1 ){
                unitVal=new BigDecimal
                (unitVal.doubleValue()% limitFactor.doubleValue())
                .setScale(precision,roundingFactor);
            }
            retVal = unitVal.toString();
            if (retVal.length()<length){
                retVal = alignRight(retVal,length,'0');
            }
            //pattern like .ww
            if (string.indexOf('.')==0){
                retVal=retVal.substring(retVal.indexOf('.'));
            }
            return retVal;
        }
        
        public String toString(){
            String retValue = "string: "+ string +"\n"+
            "unitType: "+ unitType + "\n\n";
            return retValue;
        }
        
        private boolean checkChar(String formatter){
            char f[] = formatter.toCharArray();
            for (int i=0; i<f.length; i++){
                String s= f[i] + "";
                if (legalChars.indexOf(s)<0){
                    return false;
                }
            }
            return true;
        }
        
        private String alignRight( String value, int width, char fillChar ) {
            
            int len = 0;
            
            if( value != null )
                len = value.trim().length();
            
            if( len > width )
                return value.substring( len - width );
            
            int i;
            String newValue = new String();
            for( i=0; i < (width - len); i++ )
                newValue += fillChar;
            
            if( len == 0 )
                return newValue;
            
            return newValue.concat( value.trim() );
        }
        
        private String legalChars ="wdhms.";
        private int unitType= -1;
        private int length = 0;
        private int precision = 0;
        private String string = null;
        private boolean literal = false;
        
    }
    
}