package com.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringFileConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFileConfigServerApplication.class, args);
	}
}
