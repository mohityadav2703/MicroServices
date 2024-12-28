package com.ms.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

@Component
public class ProducerService {

	@Autowired
	private JmsTemplate template;
	
	@Value("${my.app.desti-name}")
	private String destination;

	public void sendMessge(String message) {
		template.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage tm= session.createTextMessage(message);
				return tm;
			}
		});
	}
	
//	public void sendMessge(String message) {
//		template.send(destination,//destination name
//				(session)-> session.createTextMessage(message) //message creator 
//				);
//	}
	
}
