package com.bitguiders.raspberrypi.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.RaspiPin;

public class LedBlink2 
{
	public void blink(GpioPinDigitalOutput pin,int sleepTime,String pinName) throws InterruptedException{
		pin.blink(1000,15000);	
    	System.out.println(pinName);
    	Thread.sleep(sleepTime);
    	pin.low();
	}
    public static void main( String[] args )
    {
    	LedBlink2 ledBlink2 = new LedBlink2();
    	
        System.out.println( "LedBlink" );
        try {
    	    final GpioController gpio = GpioFactory.getInstance();
    	    
    	    final GpioPinDigitalOutput redPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
    	    final GpioPinDigitalOutput whitePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
    	    final GpioPinDigitalOutput greenPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
    	    
    	    int sleepTime=600;
    	    for(int i=1;i<=10;i++) {
    	    	ledBlink2.blink(redPin, sleepTime, i+"-Red...");
    	    	ledBlink2.blink(whitePin, sleepTime, i+"-White...");
    	    	ledBlink2.blink(greenPin, sleepTime, i+"-Green...");
    	    	Thread.sleep(sleepTime);
    	    }
    	    
    	    redPin.low();
    	    whitePin.low();
    	    greenPin.low();
    	    gpio.shutdown();
    	    

    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
}
