/*
 * VolumeUnits.java
 *
 * Created on March 3, 2003, 11:26 AM
 */

package com.pcauto.util;

/**
 * Used Java typesafe enum pattern to port C++ enum.
 * See http://developer.java.sun.com/developer/Books/shiftintojava/page1.html#replaceenums.
 * @author  genec
 */
public final class VolumeUnits extends Units {
    
    public static final VolumeUnits CUBIC_METRE = new VolumeUnits("m�", "Cubic Metres");
    public static final VolumeUnits CUBIC_YARD = new VolumeUnits("yd�", "Cubic Yards");
    public static final VolumeUnits[] ALL = {CUBIC_METRE, CUBIC_YARD};
    
    private static int nextId = 0;
    
    public Units[] getAll() {
        return ALL;
    }
    
    public double convertFrom(double value, Units srcUnits) {
        if (!(srcUnits instanceof VolumeUnits)) throw new IllegalArgumentException("units must be of type VolumeUnits");
        if (value == Volume.ZERO.getQuantity()) return value;
        double convertFactor = convertArray[srcUnits.getId()][id];
        if( convertFactor == 0.0 ) convertFactor = 1.0/convertArray[id][srcUnits.getId()];
        return (value*convertFactor);
    }
    
    // conversion array to store multiplier for conversion [srcunit][destunit]
    // ideally should be matrix where symmetric entries are inverse of each
    // other but to minimize data errors, one of each symmetric entry is 0.0.
    // Code should take inverse of symmetric entry if zero detected
    protected static double convertArray[][] =
    
    // SRC\DEST    m�        yd�
    /* m� */   {  { 1.0,      1.3079 },
    /* yd� */    { 0.0,      1.0} };
    
    // for serialization
    Object readResolve() throws java.io.ObjectStreamException {
        return ALL[id];
    }
    
    private VolumeUnits(String str, String desc) {
        super(str, desc);
        id = nextId++;
    }
    
}
