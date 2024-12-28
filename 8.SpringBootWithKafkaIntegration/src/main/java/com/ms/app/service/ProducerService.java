package com.ms.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.ms.app.entity.Stock;
import com.ms.app.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProducerService {
	@Autowired
	private KafkaTemplate<String, String> template;
	
	@Autowired
	private JsonUtil util;
	
	@Value("${kafka-topic-name}")
	private String topic;
	
	public void send(Stock stock) {
		String message = util.convertObjToJson(stock);
		log.info("PRODUCER SERVICE SENDING MESSAGE TO KAFKA:: {}", message);
		template.send(topic, message);
	}

}
