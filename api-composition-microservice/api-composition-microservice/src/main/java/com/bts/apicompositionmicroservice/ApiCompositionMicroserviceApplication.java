package com.bts.apicompositionmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ApiCompositionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCompositionMicroserviceApplication.class, args);
	}

}
