package com.ms_email.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailApplication {

	public static Logger log = LoggerFactory.getLogger(EmailApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
		log.info("[ms_email] aplicação iniciada");
	}

}
