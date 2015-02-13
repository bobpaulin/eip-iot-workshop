package com.bobpaulin.camel;

import com.bobpaulin.pi.BlinkService;

public class EndpointToPi4J {
	private BlinkService blinkService;
	public void blink(String payload)
	{
		System.out.println("Endpoint: " + payload);
		blinkService.blink(payload);
	}
	
	public void setBlinkService(BlinkService blinkService) {
		this.blinkService = blinkService;
	}
}
