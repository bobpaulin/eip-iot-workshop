package com.bobpaulin.pi.impl;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;




import com.bobpaulin.pi.BlinkService;

public class MockBlinkServiceImpl implements BlinkService 
{
	private final JFrame rootFrame;
	private final JPanel colorPanel;
	public MockBlinkServiceImpl() 
	{
		rootFrame = new JFrame("Pi Mock");
		rootFrame.setSize(new Dimension(500, 500));
		
		
		colorPanel = new JPanel();
		colorPanel.setBackground(Color.BLACK);
		
		rootFrame.add(colorPanel);
		rootFrame.setVisible(true);
	}
	
	@Override
	public void blink(String color) 
	{
		if(color.equalsIgnoreCase("blue"))
		{
			colorPanel.setBackground(Color.BLUE);
		}
		else if(color.equalsIgnoreCase("red"))
		{
			colorPanel.setBackground(Color.RED);
		}
		
	}
}
