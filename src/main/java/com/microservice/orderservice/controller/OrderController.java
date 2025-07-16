package com.microservice.orderservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.microservice.orderservice.service.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class OrderController {
	//Service data member
	@Autowired
	private OrderService orderService;
	
	//get method
	@GetMapping("/order/place")
	public Mono<String> placeOrder(){
		return orderService.placeOrder();
	}
	

}
