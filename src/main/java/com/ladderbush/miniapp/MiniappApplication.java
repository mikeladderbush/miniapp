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

//Make it so each entry into the database gets its own link that can then be open and have pictures added to it.
//add component to this page that allows image uploading.
//display the image on the page.