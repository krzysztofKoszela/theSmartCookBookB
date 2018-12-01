package com.krzysztof.koszela.innowacyjnaksiazkakucharska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InnowacyjnaKsiazkaKucharskaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnowacyjnaKsiazkaKucharskaApplication.class, args);
	}

}
