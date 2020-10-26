/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.tests;

import junit.framework.TestCase;

import com.schneide.quantity.*;
import com.schneide.quantity.electricalQuantities.Farad;
import com.schneide.quantity.electricalQuantities.Microfarad;
import com.schneide.quantity.electricalQuantities.Millifarad;
import com.schneide.quantity.electricalQuantities.handlers.CapacityHandler;
import com.schneide.quantity.mechanicalQuantities.*;
import com.schneide.quantity.mechanicalQuantities.handlers.SpeedHandler;
import com.schneide.quantity.mechanicalQuantities.handlers.VolumeHandler;
import com.schneide.quantity.miscQuantities.GradCelsius;
import com.schneide.quantity.miscQuantities.GradFahrenheit;
import com.schneide.quantity.miscQuantities.Kelvin;
import com.schneide.quantity.miscQuantities.handlers.TemperatureHandler;

/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class QuantityTest extends TestCase {

	/**
	 * Constructor for QuantityTest.
	 * @param arg0
	 */
	public QuantityTest(String arg0) {
		super(arg0);
	}


	public void testMeter() {
		Meter meter = new Meter(2);
		Kilometer kilometer = new Kilometer(0.002);
		Kilometer result = Kilometer.add(kilometer, meter);
//		System.out.println("meter ist " + meter + " und kilometer ist " + kilometer + " und resutl ist " + result);
		assertTrue(result.equals(new Meter(4)));
		assertTrue(result.equals(new Kilometer(0.004)));
	}

	public void testTime() {
		Hour hour = new Hour(3);
		Minute minute = new Minute(60);
		Hour result1 = Hour.add(minute, hour);
		Minute result2 = Minute.add(hour, minute);
        Second result4 = Second.add(hour, minute);
		Hour result3 = Hour.add(hour, minute);
		assertTrue(result1.equals(new Hour(4)));
		assertTrue(result2.equals(new Minute(240)));
		assertTrue(result4.equals(new Second(14400)));
		assertTrue(result3.equals(new Hour(4)));		
	}

	public void testTemperatures() {
		Kelvin einKelvin = new Kelvin(1);
        GradFahrenheit einFahrenheit = new GradFahrenheit(1);
		GradCelsius einCelsius = new GradCelsius(1);
//		System.out.println(einKelvin + " = " + TemperatureHandler.changeToGradCelsius(einKelvin) + " = " + TemperatureHandler.changeToGradFahrenheit(einKelvin));
//        System.out.println(einKelvin.getValueString(new DecimalFormat("#,##0.0#")));
//		System.out.println(einFahrenheit + " = " + TemperatureHandler.changeToKelvin(einFahrenheit));
//		System.out.println(einCelsius + " = " + TemperatureHandler.changeToKelvin(einCelsius) );
		Kelvin einFahrenheitInKelvin = TemperatureHandler.changeToKelvin(einFahrenheit);
		GradCelsius convertedFahrenheit = TemperatureHandler.changeToGradCelsius(einFahrenheitInKelvin);
		Kelvin backConvertedFahrenheit = TemperatureHandler.changeToKelvin(convertedFahrenheit);
		GradFahrenheit backbackConvertedFahrenheit = TemperatureHandler.changeToGradFahrenheit(backConvertedFahrenheit);
		assertTrue(einFahrenheit.equalsWithEpsilon(backbackConvertedFahrenheit, 0.0002));
		
	}

	public void testMultiplicationWithDowncast() {
		Meter zweiMeter = new Meter(2);
		Second eineSekunde = new Second(1);
		Quantity helpResult = Quantity.divide(zweiMeter, eineSekunde);
		MeterPerSecond result = SpeedHandler.changeToMeterPerSecond(helpResult);
		KilometerPerHour secondResult = SpeedHandler.changeToKilometerPerHour(helpResult);
//		System.out.println("zweimeter ist " + zweiMeter 
//			+ " und eineSekunde ist " + eineSekunde
//			+ " und result ist " + result 
//			+ " und secondresult ist " + secondResult);
		assertTrue(helpResult.equals(new MeterPerSecond(2)));
		assertTrue(secondResult.equalsWithEpsilon(new KilometerPerHour(7.2d), 0.0001d));
	}

	public void testChangeToQuantity() {
		MeterPerSecond mySpeed = new MeterPerSecond(2);
		Quantity changedQunatity  = QuantityHandler.changeToQuantity(mySpeed);
		assertTrue(changedQunatity.equals(mySpeed));		
	}
	
	public void testChangeToSpecialQuantity() {
		Quantity megaFaradQuantity = new Quantity(2, 3, FrequentlyUsedUnits.getMegafarad());
		Meter einmeter = new Meter(1);
		megaFaradQuantity.multiply(einmeter);
		megaFaradQuantity.divide(einmeter);
		megaFaradQuantity.add(new Farad(3,3));
		Millifarad result = CapacityHandler.changeToMillifarad(megaFaradQuantity);
//		System.out.println(megaFaradQuantity.toString() + " = " + result.toString());
		assertTrue(result.equals(megaFaradQuantity));
	}

	public void testRecreationableString1() {
		Quantity einMeterQuantity = new Quantity(2, 3, FrequentlyUsedUnits.getMeter());
		String einMeterQuantityString = einMeterQuantity.toRecreationableString();
		
		Quantity recoveredEinMeter = new Quantity(einMeterQuantityString);
		assertTrue(einMeterQuantity.equals(recoveredEinMeter));

		Meter recoveredSpecialized = new Meter(einMeterQuantityString);
		assertTrue(einMeterQuantity.equals(recoveredSpecialized));
	}
	
	public void testRecreationableString2() {
		Microfarad zweiMicrofarad = new Microfarad(2);
		String zMfString = zweiMicrofarad.toRecreationableString();
//		System.out.println("zwein MicroFarad in String: " + zMfString);

		Quantity reczweiMfQ = new Quantity(zMfString);
		assertTrue(zweiMicrofarad.equals(reczweiMfQ));

		Microfarad reczweiMfMf = new Microfarad(zMfString);
		assertTrue(zweiMicrofarad.equals(reczweiMfMf));
		System.out.println(reczweiMfMf.getUnitString());
	}
		
	public void testLiter() {
		Millipascal millipascal = new Millipascal(5.0d);
		Meter meter = new Meter(1);
		Liter liter = new Liter(3.0d);
		Quantity result = Quantity.multiply(meter, liter);
		Quantity result2 = Quantity.multiply(liter, meter);
		
//		System.out.println(meter + " * " + liter + " = " + result + " = " + result2);
		assertTrue(result.equalsWithEpsilon(result2, 0.0002));
	}
				
	public void testSubstract() {
		Liter tliter = new Liter(1000);
		CubicMeter cmeter = new CubicMeter(1);
		cmeter.substract(tliter);
		CubicMeter transformedliter = VolumeHandler.changeToCubicMeter(tliter);
		tliter.substract(transformedliter);
//		System.out.println("tliter = " + tliter + " cmeter = " + cmeter);
		assertTrue(Math.abs(tliter.getValue()) < 0.00001);
		assertTrue(Math.abs(cmeter.getValue()) < 0.00001);
	}
    
    public void testCompareableAbstractTimeEqual1() {
        Second oneHourInSeconds = new Second(3600);
        Hour oneHour = new Hour(1);
        int compareValue = oneHour.compareTo(oneHourInSeconds);
        assertTrue(compareValue == 0);
    }

    public void testCompareableAbstractTimeEqual2() {
        Second oneHourInSeconds = new Second(3600);
        Hour oneHour = new Hour(1);
        int compareValue = oneHourInSeconds.compareTo(oneHour);
        assertTrue(compareValue == 0);
    }

    public void testCompareableAbstractTimeGreater1() {
        Second oneHourInSeconds = new Second(3599);
        Hour oneHour = new Hour(1);
        int compareValue = oneHour.compareTo(oneHourInSeconds);
        assertTrue(compareValue > 0);
    }
    
    public void testCompareableAbstractTimeGreater2() {
        Second oneHourInSeconds = new Second(3601);
        Hour oneHour = new Hour(1);
        int compareValue = oneHourInSeconds.compareTo(oneHour);
        assertTrue(compareValue > 0);
    }

    public void testCompareableAbstractTimeLesser1() {
        Second oneHourInSeconds = new Second(3601);
        Hour oneHour = new Hour(1);
        int compareValue = oneHour.compareTo(oneHourInSeconds);
//        System.out.println("Lesser1 result: " + compareValue + " beim vergleich " + oneHour + " < " + oneHourInSeconds);
        assertTrue(compareValue < 0);
    }

    public void testCompareableAbstractTimeLesser2() {
        Second oneHourInSeconds = new Second(3599);
        Hour oneHour = new Hour(1);
        int compareValue = oneHourInSeconds.compareTo(oneHour);
//        System.out.println("Lesser2 result: " + compareValue + " beim vergleich " + oneHourInSeconds + " < " + oneHour );
        assertTrue(compareValue < 0);
    }
    
    public void testCompareableNotComparable1() {
        Second thirtySeconds = new Second(30);
        Meter uncomparableThing = new Meter(4.3);
        boolean exceptionCaught = false;
        String message = null;
        try {
            int compareValue = thirtySeconds.compareTo(uncomparableThing);
        } catch (WrongUnitException e) {
            message = e.getMessage();
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        assertEquals(message, "Quantities 30.0 s and 4.3 m are not comparable.");
    }

    public void testCompareableNotComparable2() {
        Second thirtySeconds = new Second(30);
        String uncomparableThing = "Hallo!";
        boolean exceptionCaught = false;
        String message = null;
        try {
            int compareValue = thirtySeconds.compareTo(uncomparableThing);
        } catch (ClassCastException e) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
    }

	public void testCompareableQuantityEqual1() {
		Second oneHourInSeconds = new Second(3600);
		Quantity oneHour = new Quantity(1, FrequentlyUsedUnits.getHour());
		int compareValue = oneHour.compareTo(oneHourInSeconds);
		assertTrue(compareValue == 0);
	}

	public void testCompareableQuantityEqual2() {
		Second oneHourInSeconds = new Second(3600);
		Quantity oneHour = new Quantity(1, FrequentlyUsedUnits.getHour());
		int compareValue = oneHourInSeconds.compareTo(oneHour);
		assertTrue(compareValue == 0);
	}

	public void testCompareableQuantityGreater1() {
		Second oneHourInSeconds = new Second(3599);
		Quantity oneHour = new Quantity(1, FrequentlyUsedUnits.getHour());
		int compareValue = oneHour.compareTo(oneHourInSeconds);
		assertTrue(compareValue > 0);
	}
    
	public void testCompareableQuantityGreater2() {
		Second oneHourInSeconds = new Second(3601);
		Quantity oneHour = new Quantity(1, FrequentlyUsedUnits.getHour());
		int compareValue = oneHourInSeconds.compareTo(oneHour);
		assertTrue(compareValue > 0);
	}

	public void testCompareableQuantityLesser1() {
		Second oneHourInSeconds = new Second(3601);
		Quantity oneHour = new Quantity(1, FrequentlyUsedUnits.getHour());
		int compareValue = oneHour.compareTo(oneHourInSeconds);
//		  System.out.println("Lesser1 result: " + compareValue + " beim vergleich " + oneHour + " < " + oneHourInSeconds);
		assertTrue(compareValue < 0);
	}

	public void testCompareableQuantityLesser2() {
		Second oneHourInSeconds = new Second(3599);
		Quantity oneHour = new Quantity(1, FrequentlyUsedUnits.getHour());
		int compareValue = oneHourInSeconds.compareTo(oneHour);
//		  System.out.println("Lesser2 result: " + compareValue + " beim vergleich " + oneHourInSeconds + " < " + oneHour );
		assertTrue(compareValue < 0);
	}
    
	public void testCompareableNotComparable3() {
		Quantity thirtySeconds = new Quantity(30, FrequentlyUsedUnits.getSecond());
		Meter uncomparableThing = new Meter(4.3);
		boolean exceptionCaught = false;
		String message = null;
		try {
			int compareValue = thirtySeconds.compareTo(uncomparableThing);
		} catch (WrongUnitException e) {
			message = e.getMessage();
			exceptionCaught = true;
		}
		assertTrue(exceptionCaught);
		assertEquals(message, "Quantities 30.0 s and 4.3 m are not comparable.");
	}

     public void testLesser() {
        Second thirtySeconds = new Second(30);
        Millisecond thirtyPointOneSeconds = new Millisecond(30100);
        assertTrue(thirtySeconds.isLesserThan(thirtyPointOneSeconds));
    }

    public void testLesserEquals1() {
        Second thirtySeconds = new Second(30);
        Millisecond thirtyPointOneSeconds = new Millisecond(30100);
        assertTrue(thirtySeconds.isLesserOrEqualWith(thirtyPointOneSeconds));
    }

    public void testLesserEquals2() {
        Second thirtySeconds = new Second(30);
        Millisecond thirtyPointOneSeconds = new Millisecond(30000);
        assertTrue(thirtySeconds.isLesserOrEqualWith(thirtyPointOneSeconds));
    }

    public void testGreater() {
        Second thirtySeconds = new Second(30);
        Millisecond nearlyThirtySeconds = new Millisecond(20900);
        assertTrue(thirtySeconds.isGreaterThan(nearlyThirtySeconds));
    }

    public void testGreaterEquals1() {
        Second thirtySeconds = new Second(30);
        Millisecond nearlyThirtySeconds = new Millisecond(20900);
        assertTrue(thirtySeconds.isGreaterOrEqualWith(nearlyThirtySeconds));
    }

    public void testGreaterEquals2() {
        Second thirtySeconds = new Second(30);
        Millisecond nearlyThirtySeconds = new Millisecond(20900);
        assertTrue(thirtySeconds.isGreaterOrEqualWith(nearlyThirtySeconds));
    }

}
