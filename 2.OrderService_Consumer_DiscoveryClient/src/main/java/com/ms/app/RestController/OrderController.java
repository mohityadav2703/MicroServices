package com.ms.app.RestController;

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
	public ResponseEntity<String> showOrderData(){
		String cartMsg=service.getCartData();
		return ResponseEntity.ok("FROM ORDER SERVICE :"+cartMsg);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hello From Order Controller ");
	}
}
