package com.microservice.orderservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
	//Data member WebClient
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public Mono<String> placeOrder(){
		//Business Logic
		Mono<String> inventoryResponse = webClientBuilder
				.build()
				.get()
				//.uri("http://localhost:8081/inventory/check")
				.uri("https://inventory-service-c3mg.onrender.com/inventory/check")
				.retrieve()
				.bodyToMono(String.class);
		
		Mono<String> paymentResponse = webClientBuilder
				.build()
				.get()
				//.uri("http://localhost:8082/payment/initiate")
				.uri("https://payment-service-oa9c.onrender.com/payment/initiate")
				.retrieve()
				.bodyToMono(String.class);
		
		return Mono.zip(inventoryResponse, paymentResponse)
				.map(tuple -> "Order Placed : Inventory - "+tuple.getT1()+" Payment "+tuple.getT2());
		//Business Logic
	}
}
