package com.example.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@EnableDiscoveryClient
@ComponentScan(basePackages= {"com.*"})
public class PaymentdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentdetailsApplication.class, args);
	}
	
}
