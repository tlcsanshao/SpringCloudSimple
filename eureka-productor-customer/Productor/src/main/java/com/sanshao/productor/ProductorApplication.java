package com.sanshao.productor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductorApplication.class, args);
	}

}
