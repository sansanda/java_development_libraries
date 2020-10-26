/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.unit;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class ScaleUnit {
	/* The following dimension unit powers and descriptions are taken from 
	 * http://www.muenster.org/uiw/fach/physik/lexikon/allg/phygr.htm#Einheiten
	 */
	public static final int YOCTO = -24;
	public static final int ZOPTO = -21;
	public static final int ATTO = -18;
	public static final int FEMTO = -15;
	public static final int PICO = -12;
	public static final int NANO = -9;
	public static final int MICRO = -6;
	public static final int MILLI = -3;
	public static final int CENTI = -2;
	public static final int DECI = -1;
	public static final int NOSCALEUNIT = 0;
	public static final int DECA = 1;
	public static final int HECTO = 2;
	public static final int KILO = 3;
	public static final int MEGA = 6;
	public static final int GIGA = 9;
	public static final int TERA = 12;
	public static final int PETA = 15;
	public static final int EXA = 18;
	public static final int ZETTA = 21;
	public static final int YOTTA = 24;

	public static final String YOCTO_PREFIX_STRING = "y";
	public static final String ZOPTO_PREFIX_STRING = "z";
	public static final String ATTO_PREFIX_STRING = "a";
	public static final String FEMTO_PREFIX_STRING = "f";
	public static final String PICO_PREFIX_STRING = "p";
	public static final String NANO_PREFIX_STRING = "n";
	public static final String MICRO_PREFIX_STRING = "\u03BC";
	public static final String MILLI_PREFIX_STRING = "m";
	public static final String CENTI_PREFIX_STRING = "c";
	public static final String DECI_PREFIX_STRING = "d";
	public static final String DECA_PREFIX_STRING = "D";
	public static final String HECTO_PREFIX_STRING = "h";
	public static final String KILO_PREFIX_STRING = "k";
	public static final String MEGA_PREFIX_STRING = "M";
	public static final String GIGA_PREFIX_STRING = "G";
	public static final String TERA_PREFIX_STRING = "T";
	public static final String PETA_PREFIX_STRING = "P";
	public static final String EXA_PREFIX_STRING = "E";
	public static final String ZETTA_PREFIX_STRING = "Z";
	public static final String YOTTA_PREFIX_STRING = "Y";
    

	public static final String YOCTO_PREFIX_FULL_STRING = "yocto";
	public static final String ZOPTO_PREFIX_FULL_STRING = "zopto";
	public static final String ATTO_PREFIX_FULL_STRING = "atto";
	public static final String FEMTO_PREFIX_FULL_STRING = "femto";
	public static final String PICO_PREFIX_FULL_STRING = "pico";
	public static final String NANO_PREFIX_FULL_STRING = "nano";
	public static final String MICRO_PREFIX_FULL_STRING = "micro";
	public static final String MILLI_PREFIX_FULL_STRING = "milli";
	public static final String CENTI_PREFIX_FULL_STRING = "centi";
	public static final String DECI_PREFIX_FULL_STRING = "deci";
	public static final String DECA_PREFIX_FULL_STRING = "deca";
	public static final String HECTO_PREFIX_FULL_STRING = "hecto";
	public static final String KILO_PREFIX_FULL_STRING = "kilo";
	public static final String MEGA_PREFIX_FULL_STRING = "Mega";
	public static final String GIGA_PREFIX_FULL_STRING = "Giga";
	public static final String TERA_PREFIX_FULL_STRING = "Tera";
	public static final String PETA_PREFIX_FULL_STRING = "Peta";
	public static final String EXA_PREFIX_FULL_STRING = "Exa";
	public static final String ZETTA_PREFIX_FULL_STRING = "Zetta";
	public static final String YOTTA_PREFIX_FULL_STRING = "Yotta";

	
	
	public static String getScaleUnitString(int scaleExponent) {
		String result = "";
		switch (scaleExponent) {
			case ScaleUnit.ATTO: 
				result = ScaleUnit.ATTO_PREFIX_STRING;
				break;
			case ScaleUnit.FEMTO:
				result = ScaleUnit.FEMTO_PREFIX_STRING;
				break;
			case ScaleUnit.PICO:
				result = ScaleUnit.PICO_PREFIX_STRING;
				break;
			case ScaleUnit.NANO:
				result = ScaleUnit.NANO_PREFIX_STRING;
				break;
			case ScaleUnit.MICRO:
				result = ScaleUnit.MICRO_PREFIX_STRING;
				break;
			case ScaleUnit.MILLI:
				result = ScaleUnit.MILLI_PREFIX_STRING;
				break;
			case ScaleUnit.CENTI:
				result = ScaleUnit.CENTI_PREFIX_STRING;
				break;
			case ScaleUnit.DECI:
				result = ScaleUnit.DECI_PREFIX_STRING;
				break;
			case ScaleUnit.NOSCALEUNIT:
				result = "";
				break;
			case ScaleUnit.DECA:
				result = ScaleUnit.DECA_PREFIX_STRING;
				break;
			case ScaleUnit.HECTO:
				result = ScaleUnit.HECTO_PREFIX_STRING;
				break;
			case ScaleUnit.KILO:
				result = ScaleUnit.KILO_PREFIX_STRING;
				break;
			case ScaleUnit.MEGA:
				result = ScaleUnit.MEGA_PREFIX_STRING;
				break;
			case ScaleUnit.GIGA:
				result = ScaleUnit.GIGA_PREFIX_STRING;
				break;
			case ScaleUnit.TERA:
				result = ScaleUnit.TERA_PREFIX_STRING;
				break;
			default:
				//this should never happen;
//				throw new AssertionError("invalid input in ScaleUnit.getScaleUnitString " + scaleExponent);
				result = "10^" + scaleExponent;
		}
		return result;
	}	
}
