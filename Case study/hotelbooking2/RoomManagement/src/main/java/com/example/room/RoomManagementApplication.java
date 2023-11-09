package com.example.room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

//@EnableDiscoveryClient
@ComponentScan(basePackages= {"com.*"})
public class RoomManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomManagementApplication.class, args);
	}

}
