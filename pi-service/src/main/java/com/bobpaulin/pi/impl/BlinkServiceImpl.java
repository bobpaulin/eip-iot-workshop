package com.bobpaulin.pi.impl;

import java.util.HashMap;
import java.util.Map;

import com.bobpaulin.pi.BlinkService;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.service.GpioService;

public class BlinkServiceImpl implements BlinkService 
{
	
	private GpioService gpioService;
	
	private Map<String, GpioPinDigitalOutput> ledOutMap;
	
	public BlinkServiceImpl() {
		ledOutMap = new HashMap<String, GpioPinDigitalOutput>();
	}
	
	public void init()
	{
		ledOutMap.put("red", gpioService.provisionDigitalOutputPin(RaspiPin.GPIO_07, "RedLED", PinState.LOW));
		ledOutMap.put("blue", gpioService.provisionDigitalOutputPin(RaspiPin.GPIO_00, "BlueLED", PinState.LOW));
	}

	@Override
	public void blink(String color) 
	{
		GpioPinDigitalOutput colorOutput = ledOutMap.get(color);
		try {
			colorOutput.high();
			Thread.currentThread().sleep(2000);
			colorOutput.low();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setGpioService(GpioService gpioService) {
		this.gpioService = gpioService;
	}

}
