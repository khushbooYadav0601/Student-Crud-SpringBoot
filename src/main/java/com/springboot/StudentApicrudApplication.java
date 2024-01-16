package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApicrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApicrudApplication.class, args);
		System.out.println("Student CRUD Operation");
	}

}
