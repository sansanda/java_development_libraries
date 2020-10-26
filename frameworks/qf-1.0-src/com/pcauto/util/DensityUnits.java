/*
 * DensityUnits.java
 *
 * Created on March 3, 2003, 11:26 AM
 */

package com.pcauto.util;

/**
 * Used Java typesafe enum pattern to port C++ enum.
 * See http://developer.java.sun.com/developer/Books/shiftintojava/page1.html#replaceenums.
 * @author  genec
 */
public final class DensityUnits extends Units {
    
    public static final DensityUnits NONE = new DensityUnits("", "");
    public static final DensityUnits CHARS_INCH = new DensityUnits("chars/in", "Characters per Inch");
    public static final DensityUnits CHARS_CENTIMETRE = new DensityUnits("chars/cm", "Characters per Centimetre");
    public static final DensityUnits LINES_INCH = new DensityUnits("lines/in", "Lines per Inch");
    public static final DensityUnits LINES_CENTIMETRE = new DensityUnits("lines/cm", "Lines per Centimeter");
    public static final DensityUnits POINTS_CHAR = new DensityUnits("pts/char", "Points per Character");
    public static final DensityUnits POINTS_LINE = new DensityUnits("pts/line", "Points per Line");
    public static final DensityUnits[] ALL = {NONE, CHARS_INCH, CHARS_CENTIMETRE, LINES_INCH, LINES_CENTIMETRE, POINTS_CHAR, POINTS_LINE};
    
    private static int nextId = 0;
    
    public Units[] getAll() {
        return ALL;
    }
    
    public double convertFrom(double value, Units srcUnits) {
        if (!(srcUnits instanceof DensityUnits)) throw new IllegalArgumentException("units must be of type DensityUnits");
        double CM_IN = 2.54;
        double PT_IN = 72;
        double PT_CM = PT_IN / CM_IN;

        // conversion array to store multiplier for conversion [srcunit][destunit]
        // ideally should be matrix where symmetric entries are inverse of each
        // other but to minimize data errors, one of each symmetric entry is 0.0.
        // Code should take inverse of symmetric entry if zero detected
        double convertArray[][] =

        // SRC\DEST    NONE     CH/IN   CH/CM   LN/IN   LN/CM   PT/CH   PT/LN
        /* NONE */  { {  1.0,   -1.0,   -1.0,   -1.0,   -1.0,   -1.0,   -1.0   },
        /* CH/IN */   { -1.0,    1.0,    0.0,   -1.0,   -1.0,    PT_IN, -1.0   },
        /* CH/CM */   { -1.0,    CM_IN,  1.0,   -1.0,   -1.0,    PT_CM, -1.0   },
        /* LN/IN */   { -1.0,   -1.0,   -1.0,    1.0,    0.0,   -1.0,    PT_IN },
        /* LN/CM */   { -1.0,   -1.0,   -1.0,    CM_IN,  1.0,   -1.0,    PT_CM },
        /* PT/CH */   { -1.0,    PT_IN,  PT_CM, -1.0,   -1.0,    1.0,   -1.0   },
        /* PT/LN */   { -1.0,   -1.0,   -1.0,    PT_IN,  PT_CM, -1.0,    1.0   } };

        // When we convert from things line ch/in to pt/ch we will need to invert
        // the original value, but we don't do this for conversions such as ch/in
        // to ch/cm
        boolean invertValueArray[][] =

        // SRC\DEST    NONE     CH/IN   CH/CM   LN/IN   LN/CM   PT/CH   PT/LN
        /* NONE */  { {false,   false,  false,  false,  false,  false,  false },
        /* CH/IN */   {false,   false,  false,  false,  false,  true,   false },
        /* CH/CM */   {false,   false,  false,  false,  false,  true,   false },
        /* LN/IN */   {false,   false,  false,  false,  false,  false,  true  },
        /* LN/CM */   {false,   false,  false,  false,  false,  false,  true  },
        /* PT/CH */   {false,   true,   true,   false,  false,  false,  false },
        /* PT/LN */   {false,   false,  false,  true,   true,   false,  false } };

        double convertFactor = convertArray[srcUnits.getId()][getId()];
        if (convertFactor == 0.0) convertFactor = 1.0/convertArray[getId()][srcUnits.getId()];
        else if (convertFactor == -1.0) {
            // Can't perform that conversion (ie. to/from NONE, or any line to chars)
            return value;
        }
        if (invertValueArray[srcUnits.getId()][getId()]) value = 1.0 / value;
        return (value*convertFactor);
    }
    
    // for serialization
    Object readResolve() throws java.io.ObjectStreamException {
        return ALL[id];
    }

    private DensityUnits(String str, String desc) {
        super(str, desc);
        id = nextId++;
    }

}
