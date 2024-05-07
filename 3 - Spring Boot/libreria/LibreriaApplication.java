package it.learnspring.libreria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Serve a Spring per capire che classe è (component di Spring).
public class LibreriaApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(LibreriaApplication.class, args);
	}

}