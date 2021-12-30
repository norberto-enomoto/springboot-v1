package com.example.workshop.springboot;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));   // It will set UTC timezone
        System.out.println("Spring boot application running America/Sao_Paulo timezone : " + new Date());   // It will print UTC timezone
    }
		
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
