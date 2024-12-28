package com.ms.app.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ms.app.producer.ProducerService;

@Component
public class MessageRunner {
	
	@Autowired
	private ProducerService ps;
	
	@Scheduled(cron = "*/10 * * * * *")
	public void testRun() throws Exception{
		ps.sendMessge("Hello : "+new Date(System.currentTimeMillis()));
		System.out.println("PRODUCER SENT MESSAGE");
	}
}
	