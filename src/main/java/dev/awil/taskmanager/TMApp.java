package dev.awil.taskmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TMApp {

	private static final Logger log = LoggerFactory.getLogger(TMApp.class);

	public static void main(String[] args) {
		SpringApplication.run(TMApp.class, args);
		log.info("Application started successfully!!");
	}

}
