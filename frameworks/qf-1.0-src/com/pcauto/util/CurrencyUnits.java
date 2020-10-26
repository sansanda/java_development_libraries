/*
 * CurrencyUnits.java
 *
 * Created on March 3, 2003, 11:26 AM
 */

package com.pcauto.util;

/**
 * Used Java typesafe enum pattern to port C++ enum.
 * See http://developer.java.sun.com/developer/Books/shiftintojava/page1.html#replaceenums.
 * @author  genec
 */
public final class CurrencyUnits extends Units {
    
    public static final CurrencyUnits CAN_DOLLARS = new CurrencyUnits("$", "Canadian Dollars");
    public static final CurrencyUnits US_DOLLARS = new CurrencyUnits("$", "US Dollars");
    public static final CurrencyUnits AUS_DOLLARS = new CurrencyUnits("$", "Australian Dollars");
    public static final CurrencyUnits EURO = new CurrencyUnits("�", "Euro");
    public static final CurrencyUnits[] ALL = {CAN_DOLLARS, US_DOLLARS, AUS_DOLLARS, EURO};
    
    private static int nextId = 0;
    
    public double convertFrom(double value, Units srcUnits) {
        if (!(srcUnits instanceof CurrencyUnits)) throw new IllegalArgumentException("units must be of type CurrencyUnits");
        if (value == Currency.ZERO.getQuantity()) return value;
        double convertFactor = convertArray[srcUnits.getId()][getId()];
        if (convertFactor == 0.0) convertFactor = (1.0/convertArray[getId()][srcUnits.getId()]);
        return (value*convertFactor);
    }
    
    public Units[] getAll() {
        return ALL;
    }
    
    // conversion array to store multiplier for conversion [srcunit][destunit]
    // ideally should be matrix where symmetric entries are inverse of each
    // other but to minimize data errors, one of each symmetric entry is 0.0.
    // Code should take inverse of symmetric entry if zero detected
    // Conversion rates have been hardcoded to Sept. 06, 2002
    static double convertArray[][] =
    // SRC\DEST         CAN       US        AUS         EURO
    /* CAN */    { {    1.0,      0.64,     1.1456,     0.63008   },
    /* US */       {    0.0,      1.0,      1.80,       1.0       },
    /* AUS */      {    0.0,      0.0,      1.0,        0.55      },
    /* EURO */     {    0.0,      0.0,      0.0,        1.0       } };
    
    // for serialization
    Object readResolve() throws java.io.ObjectStreamException {
        return ALL[id];
    }
    
    private CurrencyUnits(String str, String desc) {
        super(str, desc);
        id = nextId++;
    }

}
