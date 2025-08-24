package com.kevin.weather.weather_dashboard.controller;

import com.kevin.weather.weather_dashboard.service.WeatherService;
import com.kevin.weather.weather_dashboard.dto.WeatherResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling weather-related HTTP requests.
 * Provides endpoints for retrieving weather information from external APIs.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherController {

  /**
   * Weather service for retrieving weather data from external APIs.
   */
  @Autowired
  private WeatherService weatherService;

  /**
   * Retrieves weather information for a specified city.
   * 
   * @param city the name of the city to get weather information for
   * @return ResponseEntity containing WeatherResponseDTO on success, or error message on failure
   */
  @GetMapping("/weather")
  public ResponseEntity<?> getWeather(@RequestParam String city) {
    try {
      WeatherResponseDTO weather = weatherService.getWeather(city);
      return ResponseEntity.ok(weather);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City not found or backend error");
    }
  }
}