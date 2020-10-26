/*
 * This code is released under the terms and conditions of the Common Public License Version 1.0. 
 * You should have received a copy of the license with the code, if you didn't
 * you can get it at the quantity project homepage or at 
 * <a href="http://www.opensource.org/licenses/cpl.php">http://www.opensource.org/licenses/cpl.php</a>
 */

package com.schneide.quantity.miscQuantities.handlers;

import com.schneide.quantity.*;
import com.schneide.quantity.miscQuantities.*;



/**
 *
 * @author <a href="mailto:matthias.kempka@softwareschneiderei.de">Matthias Kempka</a>, <a href="mailto:anja.hauth@softwareschneiderei.de">Anja Hauth</a>
 */
public class TemperatureHandler {

	private static final double GRAD_CELSIUS_IN_KELVIN = 273.15d;
	/**
	 * Constructor for TemperatureHandler.
	 */
	public TemperatureHandler() {
		super();
	}
	
	public static Kelvin changeToKelvin(AbstractTemperature abstractTemperature) {
		Kelvin result = new Kelvin(0);
		result.add(abstractTemperature);
		return result;
	}	

	public static Kelvin changeToKelvin(GradCelsius gradCelsius) {
		Kelvin result = new Kelvin(gradCelsius.getValue() + GRAD_CELSIUS_IN_KELVIN);
		return result;
	}

	public static Kelvin changeToKelvin(GradFahrenheit gradFahrenheit) {
		double kValue = ((gradFahrenheit.getValue() - 32.0d) * 5.0d/9.0d) + GRAD_CELSIUS_IN_KELVIN;
		Kelvin result = new Kelvin(kValue);
		return result;
	}
	
	public static GradCelsius changeToGradCelsius(AbstractTemperature abstractTemperature) {
		Kelvin helpResult = TemperatureHandler.changeToKelvin(abstractTemperature);
		GradCelsius result = new GradCelsius(helpResult.getValue() - GRAD_CELSIUS_IN_KELVIN);
		return result;
	}
	
	
	/**
	 * Der Deutsche Wissenschaftler Gabriel Daniel Fahrenheit definierte 1714 diese Temperatureinheit.
	 * Als Nullpunkt legte er die tiefste Temperatur fest, die er erzeugen konnte. Mit einer Kältemischung aus Eis, Wasser und Salmiak erreichte er -17,78 °C. Als zweiter Referenzpunkt diente der Dampfpunkt von Wasser. Den Bereich dazwischen unterteilte er in 180 Teile zu je 1 °F.
	 */
	public static GradFahrenheit changeToGradFahrenheit(AbstractTemperature abstractTemperature) {
		Kelvin helpResult = TemperatureHandler.changeToKelvin(abstractTemperature);
		double fValue = (helpResult.getValue() - GRAD_CELSIUS_IN_KELVIN)*(9.0d/5.0d) + 32.0d;
		GradFahrenheit result = new GradFahrenheit(fValue);
		return result;
	}


    public static Kelvin changeToKelvin(Quantity quantity) throws WrongUnitException{
    	Quantity clonedQuantity = (Quantity) quantity.clone();
    	clonedQuantity.changeToUnit(FrequentlyUsedUnits.getKelvin());
    	ValueTransfer resultValue = clonedQuantity.getValueWithPower();
        Kelvin result = new Kelvin(resultValue.getValue(), resultValue.getPower());
        return result;
    }       
	
}
