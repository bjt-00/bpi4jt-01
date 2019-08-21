package com.bitguiders.raspberrypi.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class LedBlink 
{
    public static void main( String[] args )
    {
        System.out.println( "LedBlink" );
        try {
    	    final GpioController gpio = GpioFactory.getInstance();
    	    final GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);

    	    ledPin.blink(1000, 15000);

    	    for(int i=1;i<=10;i++) {
    		Thread.sleep(500);
    		System.out.println(i+"-Blinking...");
    	    }

    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
}
