package com.ms.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ms.app.entity.Stock;
import com.ms.app.store.MessageStore;
import com.ms.app.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerService {

	@Autowired
	private JsonUtil util;
	
	@Autowired
	private MessageStore store;
	
	@KafkaListener(topics = "${kafka-topic-name}", groupId = "group-id")
	public void readMessage(String message) {
		log.info("MESSAGE RECEIVED AT CONSUMER :: {}", message);
		Stock stock = util.convertJsonToObject(message);
		store.save(stock);
	}

}
