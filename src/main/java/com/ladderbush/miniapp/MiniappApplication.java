package com.ladderbush.miniapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MiniappApplication.class, args);

	}

}

//1. Create method to permanently save the data to a file and confirm it is consistently saved permanently.
//2. add ability to add pictures to the miniature database.
//3. add links to miniatures.
//4. add ability for app to understand the picture and title it is looking at and generate a link to that miniature.
//5. Generate color schemes based on type of miniature (far off goal).