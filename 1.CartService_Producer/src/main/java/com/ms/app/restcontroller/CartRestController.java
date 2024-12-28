package com.ms.app.restcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RefreshScope
public class CartRestController {

	@Value("${my.app.title}")
	private String title;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/message")
	public ResponseEntity<String> cartMessage(){
		return ResponseEntity.ok("FROM CART SERVICE :"+port +title);
	}
}
