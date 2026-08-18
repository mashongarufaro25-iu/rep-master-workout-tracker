package com.repmaster.repmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class of the app.
 * It starts the Spring Boot program.
 */
@SpringBootApplication
public class RepmasterApplication {

    /**
     * Runs the app.
     * Spring starts and sets everything up.
     *
     * @param args command line arguments
     */

	public static void main(String[] args) {
		SpringApplication.run(RepmasterApplication.class, args);
	}

}
