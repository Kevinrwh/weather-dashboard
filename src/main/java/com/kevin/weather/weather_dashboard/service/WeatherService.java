package com.kevin.weather.weather_dashboard.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// Annotation marking the class as a service component in the Spring context.
// making it eligible for component scanning and dependency injection.

@Service
public class WeatherService {

  // API key for OpenWeatherMap, injected from application.properties.
  // Value annotation injects the value of weather.api.key from application.properties
  // into the apiKey field.
  @Value("${weather.api.key}")
  private String apiKey;

  // Method to fetch weather data for a given city.
  // Constructs URL for the API call, uses RestTemplate to make HTTP GET
  // request to the OpenWeatherMap API, and returns the response as a String.
  public String getWeather(String city) {
    // Construct the URL for the OpenWeatherMap API
    String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

    // Create an instance of RestTemplate to make HTTP requests.
    // TODO: Implement api 3.0, which uses lat and lon information.
    RestTemplate restTemplate = new RestTemplate();
    // Make a GET request to the API and return the response as a String
    return restTemplate.getForObject(url, String.class);
  }
}