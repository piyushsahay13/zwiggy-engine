package com.zwiggy.zwiggyengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.zwiggy.zwiggyengine.repositories")
@EnableMongoRepositories(basePackages = "com.zwiggy.zwiggyengine.repositories")
public class ZwiggyengineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZwiggyengineApplication.class, args);
	}

}
