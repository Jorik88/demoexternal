package com.example.demoexternal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemoexternalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoexternalApplication.class, args);
	}

}
