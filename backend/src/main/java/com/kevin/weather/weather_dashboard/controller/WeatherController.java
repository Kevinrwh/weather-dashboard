package com.kevin.weather.weather_dashboard.controller;

import com.kevin.weather.weather_dashboard.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// RestController annotation marks the class as a RESTful web service controller.
// It combines @Controller and @ResponseBody to simplify.
// CrossOrigin annotation enables Cross-Origin Resource Sharing (CORS) for the
// specified origin. Allowing React frontend running on localhost:3000
// to make requests to this controller.
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherController {

  // Autowired annotation allows Spring to resolve and inject collaborating beans
  // into the controller.
  // Inject WeatherService into the controller
  @Autowired
  private WeatherService weatherService;

  // GetMapping annotation maps HTTP GET requests to /weather endpoint. The
  // method is invoked when a GET request is received at this endpoint.
  // getWeather method handles the incoming request, calls the WeatherService to
  // get the weather data for the specified city, and returns the data as a response.
  // Define an endpoint to get weather data for a given city.
  @GetMapping("/weather")
  public String getWeather(@RequestParam String city) {
    // Call the WeatherService to get the Weather data.
    return weatherService.getWeather(city);
  }
}