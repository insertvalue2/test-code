package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringIocApplication.class, args);
		
		ApplicationContext context = ApplicationContextProvider.getContext();
		//Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
		// Encoder encoder = new Encoder(base64Encoder);
		 
		Encoder encoder = context.getBean("myBase64Encode", Encoder.class);
		String url = "www.naver.com/news/it?page=10&size=10&name=bootcamp";
		String result = encoder.encode(url);
		System.out.println(result);
		
	}
}
