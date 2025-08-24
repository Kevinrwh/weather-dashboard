import React, { useState, useEffect } from 'react';

function WeatherDashboard() {
  const [city, setCity] = useState('London');
  const [input, setInput] = useState('');
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState(null);

  // Fetch weather for the current city
  const fetchWeather = async (cityName) => {
    try {
      setError(null);
      const response = await fetch(`http://localhost:8080/weather?city=${encodeURIComponent(cityName)}`);
      if (!response.ok) throw new Error('City not found or backend error');
      const data = await response.json();
      setWeather(data);
    } catch (err) {
      setWeather(null);
      setError(err.message);
    }
  };

  // On component mount, fetch London weather
  useEffect(() => {
    fetchWeather('London');
  }, []);

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    if (input.trim()) {
      setCity(input.trim());
      fetchWeather(input.trim());
      setInput('');
    }
  };

  return (
    <div style={{ maxWidth: 400, margin: '2rem auto', padding: '2rem', border: '1px solid #ccc', borderRadius: 8 }}>
      <h1>Weather Dashboard</h1>
      <form onSubmit={handleSubmit} style={{ marginBottom: '1rem' }}>
        <input
          value={input}
          onChange={e => setInput(e.target.value)}
          placeholder="Enter city"
          style={{ padding: '0.5rem', width: '70%' }}
        />
        <button type="submit" style={{ padding: '0.5rem', marginLeft: '0.5rem' }}>Get Weather</button>
      </form>
      {error && <div style={{ color: 'red' }}>{error}</div>}
      {weather && weather.name && (
        <div>
          <h2>{weather.name}</h2>
          <p>Temperature: {weather.main.temp}K</p>
          <p>Weather: {weather.weather[0].description}</p>
        </div>
      )}
    </div>
  );
}

export default WeatherDashboard;
