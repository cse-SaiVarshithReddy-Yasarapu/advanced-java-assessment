package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Assessment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assessment2Application.class, args);
		  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Assessment2Application.class);

	        StorageService storageService = context.getBean(StorageService.class);
	        storageService.storeFile("cloudFile.txt");


	        StorageService local1 = context.getBean("localStorage",StorageService.class);
	        local1.storeFile("localFile1.txt");

	        StorageService local2 = context.getBean("localStorage",StorageService.class);
	        local2.storeFile("localFile2.txt");


	        context.close();
		
	}

}
