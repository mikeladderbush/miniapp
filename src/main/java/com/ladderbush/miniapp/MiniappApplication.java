package com.ladderbush.miniapp;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ladderbush.miniapp.Security.Role;
import com.ladderbush.miniapp.Security.User;
import com.ladderbush.miniapp.Services.UserService;

@SpringBootApplication
@ComponentScan(basePackages = "com.ladderbush.miniapp.Services")
public class MiniappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MiniappApplication.class, args);

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Roni", "Mike Roni", "1234", new ArrayList<>(), new ArrayList<>()));

			userService.addRoleToUser("Roni", "ROLE_ADMIN");
		};
	}

}

/*
 * Current issues to take care of:
 * add login page
 * add tags like race/faction/colors/weapon/sfw/% of each color
 * make tags searchable
 * add miniature preview
 * add NN to log colors
 * ...
 */