package com.eradaw.springProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class SpringProjectApplication{
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

}
