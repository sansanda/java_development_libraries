/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity;

import com.schneide.quantity.unit.*;



/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class FrequentlyUsedUnits {


	public static CompoundUnit getDimensionlessUnit() {
		CompoundUnit compoundUnit = new CompoundUnit();
		return compoundUnit;		
	}

	/* START MECHANICAL UNITS */

	/* START SPACE UNITS */
	
	public static CompoundUnit getMeter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter());
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}
	
	public static CompoundUnit getKilometer() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 1, ScaleUnit.KILO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}
	
	public static CompoundUnit getMillimeter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 1, ScaleUnit.MILLI);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}
	
	public static CompoundUnit getMicrometer() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 1, ScaleUnit.MICRO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}
	
	public static CompoundUnit getNanometer() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 1, ScaleUnit.NANO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}	
	
	/* END SPACE UNITS */
	

	/* BEGIN AREA UNITS */
	
	
	public static CompoundUnit getSquareKilometer() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 2, ScaleUnit.KILO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}

	public static CompoundUnit getSquareMeter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}	
	
	public static CompoundUnit getSquareMillimeter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 2, ScaleUnit.MILLI);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}	
	
	public static CompoundUnit getSquareMicrometer() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 2, ScaleUnit.MICRO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}	

	public static CompoundUnit getSquareNanometer() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 2, ScaleUnit.NANO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}
	/* END AREA UNITS */


	/* BEGIN VOLUME UNITS */

	public static CompoundUnit getCubicKilometer() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 3, ScaleUnit.KILO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}

	public static CompoundUnit getCubicMeter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 3, ScaleUnit.NOSCALEUNIT);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}	
	
	public static CompoundUnit getCubicMillimeter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 3, ScaleUnit.MILLI);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}	
	
	public static CompoundUnit getCubicMicrometer() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 3, ScaleUnit.MICRO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}	

	public static CompoundUnit getCubicNanometer() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 3, ScaleUnit.NANO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}
	
	public static CompoundUnit getLiter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMeter(), 3, ScaleUnit.DECI);
		compoundUnit.extendSignature(unit);
		compoundUnit.setUnitName("l");
		return compoundUnit;
	}

    public static CompoundUnit getMicroliter() {
        CompoundUnit compoundUnit = getLiter();
        Unit dimensionless = new DimensionlessUnit(ScaleUnit.MICRO);
        compoundUnit.extendSignature(dimensionless);
        compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "l");
        return compoundUnit;
    }

	public static CompoundUnit getMilliliter() {
		CompoundUnit compoundUnit = getLiter();
		Unit dimensionless = new DimensionlessUnit(ScaleUnit.MILLI);
		compoundUnit.extendSignature(dimensionless);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "l");
		return compoundUnit;
	}

	/* END VOLUME UNITS */


	/* BEGIN TIME UNITS */
	
	public static CompoundUnit getHour() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarHour());
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}

    public static CompoundUnit getMinute() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarMinute());
		compoundUnit.extendSignature(unit);
		return compoundUnit;
    }

	public static CompoundUnit getSecond() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarSecond());
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}	
	
	public static CompoundUnit getMillisecond() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarSecond(), 1, ScaleUnit.MILLI);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}

	public static CompoundUnit getMicrosecond() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarSecond(), 1, ScaleUnit.MICRO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}

	/* END TIME UNITS */
	
	
	/* BEGIN WEIGHT UNITS */
	
	public static CompoundUnit getKilogram() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}	

	public static CompoundUnit getGram() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarGram());
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}	
	
	public static CompoundUnit getMilligram() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarGram(), 1, ScaleUnit.MILLI);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}		

	public static CompoundUnit getMicrogram() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarGram(), 1, ScaleUnit.MICRO);
		compoundUnit.extendSignature(unit);
		return compoundUnit;
	}		
	
	/* END WEIGHT UNITS */
	
	
	/* BEGIN FREQUENCY UNITS */
	
	public static CompoundUnit getHertz() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarSecond());
		unit.invert();
		compoundUnit.extendSignature(unit);
		compoundUnit.setUnitName("Hz");
		return compoundUnit;
	}		

	public static CompoundUnit getKilohertz() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarSecond(), 1, ScaleUnit.KILO);
		unit.invert();
		compoundUnit.extendSignature(unit);
		compoundUnit.setUnitName(ScaleUnit.KILO_PREFIX_STRING + "Hz");
		return compoundUnit;
	}		

	public static CompoundUnit getMegahertz() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarSecond(), 1, ScaleUnit.MEGA);
		unit.invert();
		compoundUnit.extendSignature(unit);
		compoundUnit.setUnitName(ScaleUnit.MEGA_PREFIX_STRING + "Hz");
		return compoundUnit;
	}		

	public static CompoundUnit getGigahertz() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarSecond(), 1, ScaleUnit.GIGA);
		unit.invert();
		compoundUnit.extendSignature(unit);
		compoundUnit.setUnitName(ScaleUnit.GIGA_PREFIX_STRING + "Hz");
		return compoundUnit;
	}		

	public static CompoundUnit getTerahertz() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit unit = new Unit(new AtomarSecond(), 1, ScaleUnit.TERA);
		unit.invert();
		compoundUnit.extendSignature(unit);
		compoundUnit.setUnitName(ScaleUnit.TERA_PREFIX_STRING + "Hz");
		return compoundUnit;
	}		

	/* END FREQUENCY UNITS */


	/* BEGING SPEED UNITS */

	public static CompoundUnit getMeterPerSecond() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit second = new Unit(new AtomarSecond());
		second.invert();
		Unit meter = new Unit(new AtomarMeter());
		compoundUnit.extendSignature(meter);
		compoundUnit.extendSignature(second);
		return compoundUnit;
	}		

	public static CompoundUnit getKilometerPerHour() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit hour = new Unit(new AtomarHour());
		hour.invert();
		Unit kilometer = new Unit(new AtomarMeter(), 1, ScaleUnit.KILO);
		compoundUnit.extendSignature(kilometer);
		compoundUnit.extendSignature(hour);
		return compoundUnit;
	}		


	/* END SPEED UNITS */


	/* BEGIN ACCELERATION UNITS */

	public static CompoundUnit getMeterPerSecondToPowerTwo() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meter = new Unit(new AtomarMeter());
		compoundUnit.extendSignature(meter);
		compoundUnit.extendSignature(seconds);
		return compoundUnit;
	}		
	
	/* END ACCELERATION UNITS */

	/* BEGIN FORCE UNITS */

	public static CompoundUnit getNewton() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meter = new Unit(new AtomarMeter());
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		compoundUnit.extendSignature(meter);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.setUnitName("N");
		return compoundUnit;
	}		
	
	/* END FORCE UNITS */


	/* BEGIN PRESSURE UNITS */

	public static CompoundUnit getKilopascal() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meter = new Unit(new AtomarMeter());
		meter.invert();
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.KILO);
		compoundUnit.extendSignature(meter);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.KILO_PREFIX_STRING + "Pa");
		return compoundUnit;
	}		
	
	public static CompoundUnit getPascal() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meter = new Unit(new AtomarMeter());
		meter.invert();
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		compoundUnit.extendSignature(meter);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.setUnitName("Pa");
		return compoundUnit;
	}		

	public static CompoundUnit getMillipascal() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meter = new Unit(new AtomarMeter());
		meter.invert();
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1, ScaleUnit.MILLI);
		compoundUnit.extendSignature(meter);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "Pa");
		return compoundUnit;
	}		

	public static CompoundUnit getMicropascal() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meter = new Unit(new AtomarMeter());
		meter.invert();
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.MICRO);
		compoundUnit.extendSignature(meter);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "Pa");
		return compoundUnit;
	}		

	/* END PRESSURE UNITS */


	/* BEGIN ENERGY UNITS */

	public static CompoundUnit getMegajoule() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.MEGA);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MEGA_PREFIX_STRING + "J");
		return compoundUnit;
	}		

	public static CompoundUnit getKilojoule() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.KILO);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.KILO_PREFIX_STRING + "J");
		return compoundUnit;
	}		

	public static CompoundUnit getJoule() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.setUnitName("J");
		return compoundUnit;
	}		

	public static CompoundUnit getNewtonmeter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.setUnitName("Nm");
		return compoundUnit;
	}		

	public static CompoundUnit getMillijoule() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.MILLI);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "J");
		return compoundUnit;
	}		

	public static CompoundUnit getMicrojoule() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.MICRO);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "J");
		return compoundUnit;
	}		

	/* END ENERGY UNITS */


    /* BEGIN POWER UNITS */
    
    public static CompoundUnit getTerawatt() {
		CompoundUnit compoundUnit = makeWatt();
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.TERA);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.TERA_PREFIX_STRING + "W");
		return compoundUnit;
    }   
    
    public static CompoundUnit getGigawatt() {
		CompoundUnit compoundUnit = makeWatt();
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.GIGA);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.GIGA_PREFIX_STRING + "W");
		return compoundUnit;
    }   
    
    public static CompoundUnit getMegawatt() {
		CompoundUnit compoundUnit = makeWatt();
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.MEGA);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MEGA_PREFIX_STRING + "W");
		return compoundUnit;
    }   
    
    public static CompoundUnit getKilowatt() {
		CompoundUnit compoundUnit = makeWatt();
		Unit dimension = new DimensionlessUnit(ScaleUnit.KILO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.KILO_PREFIX_STRING + "W");
		return compoundUnit;
    }   

    public static CompoundUnit getWatt() {
		CompoundUnit compoundUnit = makeWatt();
		compoundUnit.setUnitName("W");
		return compoundUnit;
    }   
    
    public static CompoundUnit getMilliwatt() {
		CompoundUnit compoundUnit = makeWatt();
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.MILLI);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "W");
		return compoundUnit;
    }       

    public static CompoundUnit getMicrowatt() {
		CompoundUnit compoundUnit = makeWatt();
		Unit dimension = new Unit(new AtomarDimensionlessUnit(), 1,ScaleUnit.MICRO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "W");
		return compoundUnit;
    }   
    
    private static CompoundUnit makeWatt() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 3, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(kilogram);
		return compoundUnit;
    }
    
    /* END POWER UNITS */
    
    
    /* BEGIN DENSITY UNITS */
    
    public static CompoundUnit getKilogramPerCubicmeter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit meters = new Unit(new AtomarMeter(), 3, ScaleUnit.NOSCALEUNIT);
		meters.invert();
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(kilogram);
		return compoundUnit;
    }   
    
    /* END DENSITY UNITS */
    
    
    /* BEGIN TEMPERATURE UNITS */
    
    public static CompoundUnit getKelvin() {
        CompoundUnit compoundUnit = new CompoundUnit();
        Unit kelvin = new Unit(new AtomarKelvin());
        compoundUnit.extendSignature(kelvin);
        return compoundUnit;
    }   
    
    public static CompoundUnit getGradCelsius() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit celsius = new Unit(new AtomarDegreeCelsius());
		compoundUnit.extendSignature(celsius);
		return compoundUnit;
    }   
    
    public static CompoundUnit getGradFahrenheit() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit fahrenheit = new Unit(new AtomarDegreeFahrenheit());
		compoundUnit.extendSignature(fahrenheit);
		return compoundUnit;
    }   
    
    /* END TEMPERATURE UNITS */
    
    
    /* BEGIN CURRENT UNITS */
    
    public static CompoundUnit getAmpere() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit ampere = new Unit(new AtomarAmpere());
		compoundUnit.extendSignature(ampere);
		return compoundUnit;
    }   
    
    public static CompoundUnit getMilliampere() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit ampere = new Unit(new AtomarAmpere(), 1, ScaleUnit.MILLI);
		compoundUnit.extendSignature(ampere);
		return compoundUnit;
    }   
    
    public static CompoundUnit getMicroampere() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit ampere = new Unit(new AtomarAmpere(), 1, ScaleUnit.MICRO);
		compoundUnit.extendSignature(ampere);
		return compoundUnit;
    }   
    
    public static CompoundUnit getNanoampere() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit ampere = new Unit(new AtomarAmpere(), 1, ScaleUnit.NANO);
		compoundUnit.extendSignature(ampere);
		return compoundUnit;
    }   
    
    /* END CURRENT UNITS */


    /* BEGIN CHARGE UNITS */
    
    private static CompoundUnit makeCoulomb() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit ampere = new Unit(new AtomarAmpere());
		Unit second = new Unit(new AtomarSecond());
		compoundUnit.extendSignature(ampere);
		compoundUnit.extendSignature(second);
		return compoundUnit;
    }
    
    public static CompoundUnit getCoulomb() {
        CompoundUnit compoundUnit = makeCoulomb();
		compoundUnit.setUnitName("C");
        return compoundUnit;
    }

    public static CompoundUnit getMillicoulomb() {
        CompoundUnit compoundUnit = makeCoulomb();
        Unit dimension = new DimensionlessUnit(ScaleUnit.MILLI);
        compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "C");
        return compoundUnit;
    }

    public static CompoundUnit getMicrocoulomb() {
		CompoundUnit compoundUnit = makeCoulomb();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MICRO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "C");
		return compoundUnit;
    }

    /* END CHARGE UNITS */



    /* BEGIN CURRENTDENSITY UNITS */
    
    public static CompoundUnit getAmperePerSquareMeter() {
        CompoundUnit compoundUnit = new CompoundUnit();
		Unit ampere = new Unit(new AtomarAmpere());
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		meters.invert();
		compoundUnit.extendSignature(ampere);
		compoundUnit.extendSignature(meters);
		return compoundUnit;
    }

    /* END CURRENTDENSITY UNITS */



    /* BEGIN VOLTAGE UNITS */
    
    private static CompoundUnit makeVolt() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit seconds = new Unit(new AtomarSecond(), 3, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit ampere = new Unit(new AtomarAmpere());
		ampere.invert();
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(ampere);
		return compoundUnit;
    }
    
    public static CompoundUnit getMegavolt() {
        CompoundUnit compoundUnit = makeVolt();
        Unit dimension = new DimensionlessUnit(ScaleUnit.MEGA);
        compoundUnit.extendSignature(dimension);
        compoundUnit.setUnitName(ScaleUnit.MEGA_PREFIX_STRING + "V");
        return compoundUnit;
    }

    public static CompoundUnit getKilovolt() {
		CompoundUnit compoundUnit = makeVolt();
		Unit dimension = new DimensionlessUnit(ScaleUnit.KILO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.KILO_PREFIX_STRING + "V");
		return compoundUnit;
    }

    public static CompoundUnit getVolt() {
		CompoundUnit compoundUnit = makeVolt();
		compoundUnit.setUnitName("V");
		return compoundUnit;
    }

    public static CompoundUnit getMillivolt() {
		CompoundUnit compoundUnit = makeVolt();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MILLI);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "V");
		return compoundUnit;
    }

    public static CompoundUnit getMicrovolt() {
		CompoundUnit compoundUnit = makeVolt();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MICRO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "V");
		return compoundUnit;
    }

    /* END VOLTAGE UNITS */
    

    /* BEGIN RESISTANCE UNITS */
    
    private static CompoundUnit makeOhm() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit seconds = new Unit(new AtomarSecond(), 3, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit amperes = new Unit(new AtomarAmpere(), 2, ScaleUnit.NOSCALEUNIT);
		amperes.invert();
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(amperes);
		return compoundUnit;
    }
    
    public static CompoundUnit getGigaohm() {
		CompoundUnit compoundUnit = makeOhm();
		Unit dimension = new DimensionlessUnit(ScaleUnit.GIGA);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.GIGA_PREFIX_STRING + "\u03A9");
		return compoundUnit;
    }

    public static CompoundUnit getMegaohm() {
		CompoundUnit compoundUnit = makeOhm();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MEGA);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MEGA_PREFIX_STRING + "\u03A9");
		return compoundUnit;
    }

    public static CompoundUnit getKiloohm() {
		CompoundUnit compoundUnit = makeOhm();
		Unit dimension = new DimensionlessUnit(ScaleUnit.KILO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.KILO_PREFIX_STRING + "\u03A9");
		return compoundUnit;
    }

    public static CompoundUnit getOhm() {
		CompoundUnit compoundUnit = makeOhm();
		compoundUnit.setUnitName("\u03A9");
		return compoundUnit;
    }

    public static CompoundUnit getMilliohm() {
		CompoundUnit compoundUnit = makeOhm();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MILLI);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "\u03A9");
		return compoundUnit;
    }

    public static CompoundUnit getMicroohm() {
		CompoundUnit compoundUnit = makeOhm();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MICRO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "\u03A9");
		return compoundUnit;
    }

    /* END RESISTANCE UNITS */


    /* BEGIN CAPACITY UNITS */
    
    private static CompoundUnit makeFarad() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond(), 4, ScaleUnit.NOSCALEUNIT);
		Unit amperes = new Unit(new AtomarAmpere(), 2, ScaleUnit.NOSCALEUNIT);
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		kilogram.invert();
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		meters.invert();
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(amperes);
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(meters);
		return compoundUnit;
    }

    public static CompoundUnit getMegafarad() {
		CompoundUnit compoundUnit = makeFarad();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MEGA);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MEGA_PREFIX_STRING + "F");
		return compoundUnit;
    }

    public static CompoundUnit getKilofarad() {
		CompoundUnit compoundUnit = makeFarad();
		Unit dimension = new DimensionlessUnit(ScaleUnit.KILO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.KILO_PREFIX_STRING + "F");
		return compoundUnit;
    }

    public static CompoundUnit getFarad() {
		CompoundUnit compoundUnit = makeFarad();
		compoundUnit.setUnitName("F");
		return compoundUnit;
    }

    public static CompoundUnit getMillifarad() {
		CompoundUnit compoundUnit = makeFarad();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MILLI);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "F");
		return compoundUnit;
    }

    public static CompoundUnit getMicrofarad() {
		CompoundUnit compoundUnit = makeFarad();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MICRO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "F");
		return compoundUnit;
    }

    /* END CAPACITY UNITS */


    /* BEGIN ELECTRIC FIELD STRENGTH UNITS */

    public static CompoundUnit getVoltPerMeter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit meters = new Unit(new AtomarMeter(), 1, ScaleUnit.NOSCALEUNIT);
		Unit seconds = new Unit(new AtomarSecond(), 3, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		Unit ampere = new Unit(new AtomarAmpere());
		ampere.invert();
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		compoundUnit.extendSignature(ampere);
		compoundUnit.setUnitName("V/m");
		return compoundUnit;
    }

    /* END ELECTRIC FIELD STRENGTH UNITS */


    /* BEGIN MAGNETIC FIELD STRENGTH UNITS */

    public static CompoundUnit getAmperePerMeter() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit ampere = new Unit(new AtomarAmpere());
		Unit meters = new Unit(new AtomarMeter());
		meters.invert();
		compoundUnit.extendSignature(ampere);
		compoundUnit.extendSignature(meters);
		return compoundUnit;
    }

    /* END MAGNETIC FIELD STRENGTH UNITS */


    /* BEGIN ELECTROMAGNETIC INDUCTION UNITS */

	private static CompoundUnit makeTesla() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit ampere = new Unit(new AtomarAmpere());
		ampere.invert();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(ampere);
		compoundUnit.extendSignature(seconds);
		return compoundUnit;
	}

    public static CompoundUnit getTesla() {
        CompoundUnit compoundUnit = makeTesla();
		compoundUnit.setUnitName("T");
		return compoundUnit;
    }

    public static CompoundUnit getMillitesla() {
		CompoundUnit compoundUnit = makeTesla();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MILLI);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "T");
		return compoundUnit;
    }

    public static CompoundUnit getMicrotesla() {
		CompoundUnit compoundUnit = makeTesla();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MICRO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "T");
		return compoundUnit;
    }

    public static CompoundUnit getNanotesla() {
		CompoundUnit compoundUnit = makeTesla();
		Unit dimension = new DimensionlessUnit(ScaleUnit.NANO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.NANO_PREFIX_STRING + "T");
		return compoundUnit;
    }

    public static CompoundUnit getPicotesla() {
		CompoundUnit compoundUnit = makeTesla();
		Unit dimension = new DimensionlessUnit(ScaleUnit.PICO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.PICO_PREFIX_STRING + "T");
		return compoundUnit;
    }

    /* END ELECTROMAGNETIC INDUCTION UNITS */
 
 
    /* BEGIN INDUCTANCE UNITS */

	private static CompoundUnit makeHenry() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit kilogram = new Unit(new AtomarGram(), 1, ScaleUnit.KILO);
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit amperes = new Unit(new AtomarAmpere(), 2, ScaleUnit.NOSCALEUNIT);
		amperes.invert();
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		compoundUnit.extendSignature(kilogram);
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(amperes);
		compoundUnit.extendSignature(seconds);
		return compoundUnit;
	}
	
    public static CompoundUnit getHenry() {
		CompoundUnit compoundUnit = makeHenry();
		compoundUnit.setUnitName("H");
		return compoundUnit;
    }

    public static CompoundUnit getMillihenry() {
		CompoundUnit compoundUnit = makeTesla();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MILLI);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "H");
		return compoundUnit;
    }

    public static CompoundUnit getMicrohenry() {
		CompoundUnit compoundUnit = makeTesla();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MICRO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "H");
		return compoundUnit;
    }

    /* END INDUCTANCE UNITS */


    /* BEGIN LUMINOUS INTENSITY UNITS */

    public static CompoundUnit getCandela() {
        CompoundUnit compoundUnit = new CompoundUnit();
        Unit candela = new Unit(new AtomarCandela());
        compoundUnit.extendSignature(candela);
        return compoundUnit;
    }

    /* END LUMINOUS INTENSITY UNITS */


    /* BEGIN ENERGY DOSE UNITS */
    
    private static CompoundUnit makeGray() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit meters = new Unit(new AtomarMeter(), 2, ScaleUnit.NOSCALEUNIT);
		Unit seconds = new Unit(new AtomarSecond(), 2, ScaleUnit.NOSCALEUNIT);
		seconds.invert();
		compoundUnit.extendSignature(meters);
		compoundUnit.extendSignature(seconds);
		return compoundUnit;
    }

    public static CompoundUnit getGray() {
		CompoundUnit compoundUnit = makeTesla();
		compoundUnit.setUnitName("Gy");
		return compoundUnit;
    }

    public static CompoundUnit getMilligray() {
		CompoundUnit compoundUnit = makeTesla();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MILLI);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "Gy");
		return compoundUnit;
    }

    public static CompoundUnit getMicrogray() {
		CompoundUnit compoundUnit = makeTesla();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MICRO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MICRO_PREFIX_STRING + "Gy");
		return compoundUnit;
    }

	public static CompoundUnit getSievert() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit sievert = new Unit(new AtomarSievert());
		compoundUnit.extendSignature(sievert);
		return compoundUnit;
	}
	
    /* END ENERGY DOSE UNITS */

    /* BEGIN ACTIVITY UNITS */
    
	private static CompoundUnit makeBequerel() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit seconds = new Unit(new AtomarSecond());
		seconds.invert();
		compoundUnit.extendSignature(seconds);
		return compoundUnit;
	}

    public static CompoundUnit getMillibequerel() {
		CompoundUnit compoundUnit = makeBequerel();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MILLI);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MILLI_PREFIX_STRING + "Bq");
		return compoundUnit;
    }       
    
    public static CompoundUnit getBequerel() {
		CompoundUnit compoundUnit = makeBequerel();
		compoundUnit.setUnitName("Bq");
		return compoundUnit;
    }       

    public static CompoundUnit getKilobequerel() {
		CompoundUnit compoundUnit = makeBequerel();
		Unit dimension = new DimensionlessUnit(ScaleUnit.KILO);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.KILO_PREFIX_STRING + "Bq");
		return compoundUnit;
    }       

    public static CompoundUnit getMegabequerel() {
		CompoundUnit compoundUnit = makeBequerel();
		Unit dimension = new DimensionlessUnit(ScaleUnit.MEGA);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.MEGA_PREFIX_STRING + "Bq");
		return compoundUnit;
    }       

    public static CompoundUnit getGigabequerel() {
		CompoundUnit compoundUnit = makeBequerel();
		Unit dimension = new DimensionlessUnit(ScaleUnit.GIGA);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.GIGA_PREFIX_STRING + "Bq");
		return compoundUnit;
    }       

    public static CompoundUnit getTerabequerel() {
		CompoundUnit compoundUnit = makeBequerel();
		Unit dimension = new DimensionlessUnit(ScaleUnit.TERA);
		compoundUnit.extendSignature(dimension);
		compoundUnit.setUnitName(ScaleUnit.TERA_PREFIX_STRING + "Bq");
		return compoundUnit;
    }       

    /* END ACTIVITY UNITS */
    

    /* BEGIN AMOUNT OF SUBSTANCE UNITS */
    
    public static CompoundUnit getMole() {
		CompoundUnit compoundUnit = new CompoundUnit();
		Unit mole = new Unit(new AtomarMole());
		compoundUnit.extendSignature(mole);
		return compoundUnit;
   }       

     public static CompoundUnit getPartsPerBillion() {
		CompoundUnit compoundUnit = new CompoundUnit();
		compoundUnit.setUnitName("ppb");
        return compoundUnit;
    }




    /* END AMOUNT OF SUBSTANCE UNITS */
   
	public static CompoundUnit invert(CompoundUnit compoundUnit) {
		compoundUnit.invert();
		compoundUnit.setUnitName(null);
		return compoundUnit;
	}
 
}
