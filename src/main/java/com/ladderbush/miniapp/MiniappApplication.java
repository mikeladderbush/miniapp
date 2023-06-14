package com.ladderbush.miniapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MiniappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MiniappApplication.class, args);

	}

}

//display the image on the page.