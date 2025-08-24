package com.kevin.weather.weather_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Weather Dashboard Spring Boot application.
 * This class serves as the entry point for the application and configures 
 * Spring Boot's auto-configuration, component scanning, and configuration properties.
 */
@SpringBootApplication
public class WeatherDashboardApplication {

	/**
	 * Main method that starts the Spring Boot application.
	 * 
	 * @param args command line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(WeatherDashboardApplication.class, args);
	}

}