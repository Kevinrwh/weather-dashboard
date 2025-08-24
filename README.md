# Weather Dashboard

This is a full-stack weather dashboard application with a Java Spring Boot backend and a React frontend.

## Features
- View current weather for London by default
- Search for weather in any city
- Responsive, user-friendly dashboard

## Project Structure

- `backend/` — Java Spring Boot REST API
- `frontend/` — React app UI

## Setup Instructions

### Prerequisites
- Java 22 (for backend)
- Node.js 18.20.0+ and npm (for frontend)
- OpenWeatherMap API key (https://openweathermap.org/)

### Backend Setup
1. `cd backend`
2. Set your API key as an environment variable:
    ```bash
    export WEATHER_API_KEY=your_actual_api_key
    ```
3. Start the backend:
    ```bash
    ./mvnw spring-boot:run
    ```
    The backend will run on http://localhost:8080

### Frontend Setup
1. `cd frontend`
2. Install dependencies:
    ```bash
    npm install
    ```
3. Start the frontend:
    ```bash
    npm start
    ```
    The frontend will run on http://localhost:3000

## Usage
1. Open http://localhost:3000 in your browser.
2. The dashboard will show London weather by default.
3. Enter a city name and click "Get Weather" to view weather for any city.

## Contributing
If you would like to contribute to this project, fork the project, and submit a pull request.

## License
This project is licensed under the MIT license.