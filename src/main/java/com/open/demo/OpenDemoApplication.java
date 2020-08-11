package com.open.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenDemoApplication.class, args);
		
		//http://localhost:8080/item/save/1/item1/11/item001
		//http://localhost:8080/item/findAll
		//http://localhost:8080/item/findByNo/1
		//http://localhost:8080/item/withdraw/1/3
		//http://localhost:8080/item/deposit/1/10
		//http://localhost:8080/item/delete/1
		//http://localhost:8080/swagger-ui.html#/
	}
	


}
