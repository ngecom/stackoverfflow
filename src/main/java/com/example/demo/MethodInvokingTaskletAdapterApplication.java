package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableBatchProcessing
@SpringBootApplication
public class MethodInvokingTaskletAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MethodInvokingTaskletAdapterApplication.class, args);
	}

}
