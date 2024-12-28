package com.ms.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConsumerService {

	@Autowired
	private LoadBalancerClient client;
	
	
	public String getCartData() {
		//make call to Eureka to get MS service id
		ServiceInstance si=client.choose("CART-SERVICE");
		
		//create url
		String url=si.getUri()+"/cart/message";
		
		//Create RestTemplate To Http Call
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> re=rt.getForEntity(url, String.class);
		return re.getBody();
	}
}
