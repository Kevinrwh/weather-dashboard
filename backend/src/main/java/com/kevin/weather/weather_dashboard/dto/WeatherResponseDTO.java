package com.kevin.weather.weather_dashboard.dto;

/**
 * Data Transfer Object for weather response information.
 * Contains weather data returned from the weather service API.
 */
public class WeatherResponseDTO {
    /**
     * The name of the city for which weather data is provided.
     */
    private String city;
    
    /**
     * The current temperature in Celsius.
     */
    private double temperature;
    
    /**
     * A brief description of the current weather conditions.
     */
    private String description;

    /**
     * Default constructor for WeatherResponseDTO.
     */
    public WeatherResponseDTO() {}

    /**
     * Constructor for creating a WeatherResponseDTO with all fields.
     * 
     * @param city the name of the city
     * @param temperature the temperature in Celsius
     * @param description the weather description
     */
    public WeatherResponseDTO(String city, double temperature, String description) {
        this.city = city;
        this.temperature = temperature;
        this.description = description;
    }

    /**
     * Gets the city name.
     * 
     * @return the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city name.
     * 
     * @param city the city name to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the temperature.
     * 
     * @return the temperature in Celsius
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature.
     * 
     * @param temperature the temperature in Celsius to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Gets the weather description.
     * 
     * @return the weather description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the weather description.
     * 
     * @param description the weather description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
