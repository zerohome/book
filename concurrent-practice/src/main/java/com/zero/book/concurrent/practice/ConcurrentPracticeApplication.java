package com.zero.book.concurrent.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcurrentPracticeApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ConcurrentPracticeApplication.class);
		app.run(args);
//		SpringApplication.run(ConcurrentPracticeApplication.class, args);
	}

}
