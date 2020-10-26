/*
 * WeightUnits.java
 *
 * Created on March 3, 2003, 11:26 AM
 */

package com.pcauto.util;

/**
 * Used Java typesafe enum pattern to port C++ enum.
 * See http://developer.java.sun.com/developer/Books/shiftintojava/page1.html#replaceenums.
 * @author  genec
 */
public final class WeightUnits extends Units {
    
    public static final WeightUnits KILOGRAM = new WeightUnits("kg", "Kilograms");
    public static final WeightUnits GRAM = new WeightUnits("g", "Grams");
    public static final WeightUnits TONNE = new WeightUnits("tn", "Metric Tonnes");
    public static final WeightUnits TON = new WeightUnits("ton", "Imperial Tons");
    public static final WeightUnits POUND = new WeightUnits("lb", "Pounds");
    public static final WeightUnits OUNCE = new WeightUnits("oz", "Ounces");
    public static final WeightUnits[] ALL = {KILOGRAM, GRAM, TONNE, TON, POUND, OUNCE};
    
    private static int nextId = 0;
    
    public Units[] getAll() {
        return ALL;
    }
    
    public double convertFrom(double value, Units srcUnits) {
        if (!(srcUnits instanceof WeightUnits)) throw new IllegalArgumentException("units must be of type WeightUnits");
        if (value == Weight.ZERO.getQuantity()) return value;
        double TON_KG = 907.185;
        double LB_KG = 0.45359;
        double OUNCE_KG = 0.02835;
        
        // conversion array to store multiplier for conversion [srcunit][destunit]
        // ideally should be matrix where symmetric entries are inverse of each
        // other but to minimize data errors, one of each symmetric entry is 0.0.
        // Code should take inverse of symmetric entry if zero detected
        double convertArray[][] =
        
        // SRC\DEST    KG        GRAM           TONNE          TON       POUND     OUNCE
        /* KG */   { { 1.0,      1000.0,         0.001,         0.0,     0.0,      0.0 },
        /* GRAM */   { 0.0,      1.0,            0.000001,      0.0,     0.0,      0.0 },
        /* TONNE */  { 0.0,      0.0,            1.0,           0.0,     0.0,      0.0 },
        /* TON */    { TON_KG,   1000.0*TON_KG,  0.001*TON_KG,  1.0,     2000.0,   32000.0 },
        /* LB */     { LB_KG,    1000.0*LB_KG,   0.001*LB_KG,   0.0,     1.0,      16.0 },
        /* OZ   */   { OUNCE_KG, 1000.0*OUNCE_KG,0.001*OUNCE_KG,0.0,     0.0,      1.0 } };
        
        double convertFactor = convertArray[srcUnits.getId()][getId()];
        if(convertFactor == 0.0) convertFactor = 1.0/convertArray[getId()][srcUnits.getId()];
        return (value*convertFactor);
    }
    
    // for serialization
    Object readResolve() throws java.io.ObjectStreamException {
        return ALL[id];
    }

    private WeightUnits(String str, String desc) {
        super(str, desc);
        id = nextId++;
    }

}
