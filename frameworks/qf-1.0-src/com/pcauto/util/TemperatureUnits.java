/*
 * TemperatureUnits.java
 *
 * Created on March 3, 2003, 11:26 AM
 */

package com.pcauto.util;

/**
 * Used Java typesafe enum pattern to port C++ enum.
 * See http://developer.java.sun.com/developer/Books/shiftintojava/page1.html#replaceenums.
 * @author  genec
 */
public final class TemperatureUnits extends Units {
    
    public static final TemperatureUnits KELVIN = new TemperatureUnits("k", "Kelvin");
    public static final TemperatureUnits FAHRENHEIT = new TemperatureUnits("f", "Fahrenheit");
    public static final TemperatureUnits CELCIUS = new TemperatureUnits("c", "Celcius");
    public static final TemperatureUnits[] ALL = {KELVIN, FAHRENHEIT, CELCIUS};
    
    private static int nextId = 0;
    
    public Units[] getAll() {
        return ALL;
    }
    
    public double convertFrom(double value, Units srcUnits) {
        if (!(srcUnits instanceof TemperatureUnits)) throw new IllegalArgumentException("units must be of type TemperatureUnits");
        double CEL_TO_FAR_FACTOR = 1.8;  // (9/5)
        double FAR_TO_CEL_FACTOR = (32/CEL_TO_FAR_FACTOR);
        
        // conversion arrays to store offsets and multiplication factor
        // for conversion [srcunit][destunit]
        double offsetArray[][] =
        // SRC\DEST        Kelvin             FAHRENHEIT                     Celcius
        /* Kelvin */    { { 0.0,              (-273.16 + FAR_TO_CEL_FACTOR), -273.16 },
        /* Farhenheit */  { (-32 + 491.688),  0.0,                           -32     },
        /* Celcius */     { 273.16,           FAR_TO_CEL_FACTOR,             0.0     } };
        
        double convertArray[][] =
        // SRC\DEST        Kelvin               FAHRENHEIT            Celcius
        /* Kelvin */    { { 1.0,                CEL_TO_FAR_FACTOR,    1.0     },
        /* Fahrenheit */  { 0.0,                1.0,                  0.0     },
        /* Celcius */     { 1.0,                CEL_TO_FAR_FACTOR,    1.0     }  };
        
        double offsetFactor = offsetArray[srcUnits.getId()][getId()];
        double convertFactor = convertArray[srcUnits.getId()][getId()];
        if( convertFactor == 0.0 ) {
            convertFactor = (1.0/convertArray[getId()][srcUnits.getId()]);
        }
        return ((value+offsetFactor)*convertFactor);
    }
    
    // for serialization
    Object readResolve() throws java.io.ObjectStreamException {
        return ALL[id];
    }
    
    private TemperatureUnits(String str, String desc) {
        super(str, desc);
        id = nextId++;
    }
    
}
