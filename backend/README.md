# Weather Dashboard — Backend

This folder contains the Java Spring Boot backend for the Weather Dashboard project.

## Prerequisites
- Java 22
- Maven (or use the included Maven wrapper)
- OpenWeatherMap API key

## Setup
1. Set your API key as an environment variable:
	```bash
	export WEATHER_API_KEY=your_actual_api_key
	```
2. Start the backend:
	```bash
	./mvnw spring-boot:run
	```
	The backend will run on http://localhost:8080

## API Usage
- `GET /weather?city=CityName` — Returns weather data for the specified city as JSON.

## Notes
- CORS is enabled for `http://localhost:3000` to allow the React frontend to connect during development.

## License
This project is licensed under the MIT license.
