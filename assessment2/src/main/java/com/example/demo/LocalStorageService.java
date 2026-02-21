package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;


@Scope("prototype")
@Lazy
@Component("localStorage")
public class LocalStorageService implements StorageService {
	
	public LocalStorageService() {
		System.out.println("LocalStorageService Bean created");
	}
	@Override
	public void storeFile(String fileName) {
		System.out.println("This is a file"+fileName);
	}


}
