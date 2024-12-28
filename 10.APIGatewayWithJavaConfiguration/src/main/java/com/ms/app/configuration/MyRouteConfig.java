package com.ms.app.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRouteConfig {

	@Bean
	public RouteLocator configureRoute(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route("cartServiceApp", r-> r.path("/cart/**")
				.uri("lb://CART-SERVICE")
				)
				
				.route("orderServiceApp", r-> r.path("/order/**")
						.filters(f-> f.addRequestHeader("Authorization", "JWT TOKEN IS RECEIVED")
								.addResponseHeader("paymentService", "APPROVED BY VENDOR WITH CODE 12345"))
						.uri("lb://ORDER-SERVICE"))
						.build();
	}
}
