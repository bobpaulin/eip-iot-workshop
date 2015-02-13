package com.bobpaulin.jms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class BlinkProducer implements Runnable {
	
	private final String color;
	
	public BlinkProducer(String color) 
	{
		this.color = color;
	}
	
	public void run() {
		try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = 
            		new ActiveMQConnectionFactory("tcp://localhost:61616");
            
            connectionFactory.setUserName("karaf");
            connectionFactory.setPassword("karaf");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("blink");

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a messages
            TextMessage message = session.createTextMessage(color);

            // Tell the producer to send the message
            producer.send(message);

            // Clean up
            session.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
		
	}
	
	public static void main(String[] args) {
		ExecutorService messageExecutor = Executors.newFixedThreadPool(2);
		
		messageExecutor.execute(new BlinkProducer("red"));
		messageExecutor.execute(new BlinkProducer("blue"));
		messageExecutor.shutdown();
		
	}

}
