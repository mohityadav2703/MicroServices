package com.ms.app.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.app.service.CartConsumerService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartConsumerService service;

	@GetMapping("/data")
	public ResponseEntity<String> getCartData() {
		ResponseEntity<String> response = service.cartData();
		return ResponseEntity.ok("FROM ORDER SERVICE :" + response.getBody());
	}
}
