package com.ladderbush.miniapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MiniappApplication.class, args);

	}

}

//Make it so each entry into the database gets its own link that can then be open and have pictures added to it.
//1. generate a new page variable for each time a new miniature is added.
//4. make the URL open a new react page with the correct information.
//5. add component to this page that allows image uploading.
//6. display the image on the page.