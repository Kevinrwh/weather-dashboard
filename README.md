# Weather Dashboard

This is a Spring Boot application that fetches and displays weather data using the OpenWeatherMap API.

## Prerequisites

- Java 22
- Maven
- An OpenWeatherMap API key

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/weather-dashboard.git
   cd weather-dashboard

2. Get a OpenWeatherMap API key:

    Navigate to https://openweathermap.org/ and sign up to get an API key.

3. Set up your API key environment variable:
    On MacOS/Linux
    ```bash
   # On MacOS/Linux
    export WEATHER_API_KEY=your_actual_api_key
   
   # On Windows
    export WEATHER_API_KEY=your_actual_api_key

## Usage
1. Run the application.
    Type http://localhost:8080/weather?city=CityName into your browser. Replace CityName with the city you'd like to get weather information for.

## Contributing
If you would like to contribute to this project, fork the project, and submit a pull request.

## Licensing
This project is licensed under the MIT license.