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

/* Current issues to take care of:
 * 2. connect image entries with specific miniature entries.
 * 3. display multiple images if they share a miniature id.
 */