package com.ms.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("CART-SERVICE")
public interface CartConsumerService {
	
	@GetMapping("/cart/message")
	public ResponseEntity<String> cartData();
	
	

}
