package com.kevin.weather.weather_dashboard.service;


import com.kevin.weather.weather_dashboard.dto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

/**
 * Service for retrieving weather data from the OpenWeatherMap API.
 * This service handles external API calls and data transformation for weather information.
 */
@Service
public class WeatherService {

  /**
   * API key for OpenWeatherMap API, injected from application properties.
   */
  @Value("${weather.api.key}")
  private String apiKey;

  /**
   * Retrieves current weather information for a specified city.
   * 
   * @param city the name of the city to get weather information for
   * @return WeatherResponseDTO containing the city name, temperature, and weather description
   * @throws org.springframework.web.client.RestClientException if the API call fails
   */
  public WeatherResponseDTO getWeather(String city) {
    String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.getForObject(url, String.class);

    JSONObject json = new JSONObject(response);
    String cityName = json.getString("name");
    double temp = json.getJSONObject("main").getDouble("temp");
    String description = json.getJSONArray("weather").getJSONObject(0).getString("description");

    return new WeatherResponseDTO(cityName, temp, description);
  }
}