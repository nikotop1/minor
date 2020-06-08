package com.jiuyv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class OfficeApp {
	
	public static void main(String[] args) {
		SpringApplication.run(OfficeApp.class, args);
	}

}
