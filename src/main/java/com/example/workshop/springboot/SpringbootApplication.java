package com.example.workshop.springboot;

import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootApplication {

    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));   // It will set UTC timezone
        log.info("Spring boot application running America/Sao_Paulo timezone : " + new Date());   // It will print UTC timezone
        log.info("tag: main");  
    }
		
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
