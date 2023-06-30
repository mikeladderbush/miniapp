package com.ladderbush.miniapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ladderbush.miniapp.Services")
public class MiniappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MiniappApplication.class, args);

	}
	/*
	 * @Bean
	 * CommandLineRunner run(UserService userService) {
	 * return args -> {
	 * userService.saveRole(new Role(null, "ROLE_ADMIN"));
	 * 
	 * userService.saveUser(new User(null, "Mike Roni", "Roni", "1234", new
	 * ArrayList<>(),new ArrayList<>()));
	 * 
	 * userService.addRoleToUser("Roni", "ROLE_ADMIN");
	 * };
	 * }
	 */

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