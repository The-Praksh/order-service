package com.microservice.orderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class AppConfig {
	
	//webClientBuilder() method
	@Bean
	public WebClient.Builder webClientBuilder(){
		return WebClient.builder();
	}
}
