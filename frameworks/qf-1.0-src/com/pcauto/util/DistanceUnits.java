/*
 * DistanceUnits.java
 *
 * Created on March 3, 2003, 11:26 AM
 */

package com.pcauto.util;

/**
 * Used Java typesafe enum pattern to port C++ enum.
 * See http://developer.java.sun.com/developer/Books/shiftintojava/page1.html#replaceenums.
 * @author  genec
 */
public final class DistanceUnits extends Units {
    
    public static final DistanceUnits METRE = new DistanceUnits("m", "Metres");
    public static final DistanceUnits MILE = new DistanceUnits("mi", "Miles");
    public static final DistanceUnits KILOMETRE = new DistanceUnits("km", "Kilometres");
    public static final DistanceUnits INCH = new DistanceUnits("in", "Inches");
    public static final DistanceUnits CENTIMETRE = new DistanceUnits("cm", "Centimetres");
    public static final DistanceUnits YARD = new DistanceUnits("yd", "Yards");
    public static final DistanceUnits MICROMETRE = new DistanceUnits("�m", "Micrometres");
    public static final DistanceUnits[] ALL = {METRE, MILE, KILOMETRE, INCH, CENTIMETRE, YARD, MICROMETRE};
    
    private static int nextId = 0;
    
    public Units[] getAll() {
        return ALL;
    }
    
    public double convertFrom(double value, Units srcUnits) {
        if (!(srcUnits instanceof DistanceUnits)) throw new IllegalArgumentException("units must be of type DistanceUnits");
        if (value == Distance.ZERO.getQuantity()) return value;
        double mi_m = 1609.344;
        double yd_in = 36;
        double in_cm = 2.54;
        double mi_in = 63360;
        double mi_yd = 1760;
        double yd_m = 0.9144;
        
        double convertArray[][] =
        // SRC\DEST   m         mi      km             in       cm        yd         um
        /* m */   {{ 1.0,       0.0,    0.001,         0.0,     100,      0.0,    1000000},
        /* mi */   { mi_m,      1.0,    mi_m/1000,     mi_in,   mi_m*100, mi_yd,  mi_m*1000000},
        /* km */   { 0.0,       0.0,    1.0,           0.0,     100000,   0.0,    1000000000},
        /* in */   { in_cm/100, 0.0,    in_cm/1000000, 1.0,     in_cm,    0.0,    in_cm*1000},
        /* cm */   { 0.0,       0.0,    0.0,           0.0,     1.0,      0.0,    10000},
        /* yd */   { yd_m,      0.0,    yd_m/1000000,  yd_in,   yd_m*100, 1.0,    yd_m*1000000},
        /* um */   { 0.0,       0.0,    0.0,           0.0,     0.0,      0.0,    1.0 } };
        
        double convertFactor = convertArray[srcUnits.getId()][id];
        if (convertFactor == 0.0) convertFactor = 1.0/convertArray[id][srcUnits.getId()];
        return (value*convertFactor);
    }
    
    // for serialization
    Object readResolve() throws java.io.ObjectStreamException {
        return ALL[id];
    }

    private DistanceUnits(String str, String desc) {
        super(str, desc);
        id = nextId++;
    }

}
