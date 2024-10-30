package com.Cabrera.PNL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PnlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PnlApplication.class, args);
	}

}
