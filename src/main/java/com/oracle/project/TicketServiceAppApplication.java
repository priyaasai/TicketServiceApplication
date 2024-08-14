package com.oracle.project;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TicketServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketServiceAppApplication.class, args);
		System.out.println("TicketService Application Started");
	}
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}
