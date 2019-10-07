package com.fundoo.rabbitMQ;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer 
{
	@Autowired
    private RabbitTemplate rabbitTemplate;
 
	public void sendMessage(String emailId, String subject, String body) 
	{
		List<String> list = new ArrayList<String>();
		
		list.add(emailId);
		list.add(subject);
		list.add(body);
		
		rabbitTemplate.convertAndSend(RabbitMQProducerConfig.ROUTING_KEY, list);
     	System.out.println("Is listener returned ::: "+rabbitTemplate.isReturnListener());
	}
	
}
