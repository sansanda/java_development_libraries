/*
 * DimensionUnits.java
 *
 * Created on March 3, 2003, 11:26 AM
 */

package com.pcauto.util;

/**
 * Used Java typesafe enum pattern to port C++ enum.
 * See http://developer.java.sun.com/developer/Books/shiftintojava/page1.html#replaceenums.
 * @author  genec
 */
public final class DimensionUnits extends Units {
    
    public static final DimensionUnits INCH = new DimensionUnits("in", "Inches");
    public static final DimensionUnits CENTIMETRE = new DimensionUnits("cm", "Centimetres");
    public static final DimensionUnits POINT = new DimensionUnits("pt", "Points");
    public static final DimensionUnits FIXED_FONT = new DimensionUnits("chars", "Characters");
    public static final DimensionUnits[] ALL = {INCH, CENTIMETRE, POINT, FIXED_FONT};
    
    private static int nextId = 0;
    
    public Units[] getAll() {
        return ALL;
    }
    
    public double convertFrom(double value, Units srcUnits) {
        if (!(srcUnits instanceof DimensionUnits)) throw new IllegalArgumentException("units must be of type DimensionUnits");
        double CM_IN = 2.54;
        double PT_IN = 72;
        double PT_CM = PT_IN / CM_IN;

        // conversion array to store multiplier for conversion [srcunit][destunit]
        // ideally should be matrix where symmetric entries are inverse of each
        // other but to minimize data errors, one of each symmetric entry is 0.0.
        // Code should take inverse of symmetric entry if zero detected
        double convertArray[][] =

        // SRC\DEST    IN       CM      PT      FF
        /* IN */   { { 1.0,     CM_IN,  PT_IN,  1.0 },
        /* CM */     { 0.0,     1.0,    PT_CM,  1.0 },
        /* PT */     { 0.0,     0.0,    1.0,    1.0 },
        /* FF */     { 0.0,     0.0,    0.0,    1.0 } };

        double convertFactor = convertArray[srcUnits.getId()][id];
        if (convertFactor == 0.0) {
            convertFactor = 1.0 / convertArray[id][srcUnits.getId()];
        } else if (convertFactor == -1.0) {
            // Can't perform that conversion (ie. to/from Fixed Font)
            return value;
        }
        return (value*convertFactor);
    }
    
    // for serialization
    Object readResolve() throws java.io.ObjectStreamException {
        return ALL[id];
    }

    private DimensionUnits(String str, String desc) {
        super(str, desc);
        id = nextId++;
    }

}
