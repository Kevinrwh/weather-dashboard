
import React, { useState, useEffect } from 'react';


function WeatherDashboard() {
  const [city, setCity] = useState('London');
  const [input, setInput] = useState('');
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);

  // Fetch weather for the current city
  const fetchWeather = async (cityName) => {
    try {
      setError(null);
      setLoading(true);
      const apiUrl = process.env.REACT_APP_API_URL || 'http://localhost:8080';
      const response = await fetch(`${apiUrl}/weather?city=${encodeURIComponent(cityName)}`);
      if (!response.ok) throw new Error('City not found or backend error');
      const data = await response.json();
      setWeather(data);
    } catch (err) {
      setWeather(null);
      setError(err.message);
    } finally {
      setLoading(false);
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
        <button type="submit" style={{ padding: '0.5rem', marginLeft: '0.5rem' }} disabled={!input.trim() || loading}>
          {loading ? 'Loading...' : 'Get Weather'}
        </button>
      </form>
      {loading && <div>Loading weather data...</div>}
      {error && <div style={{ color: 'red' }}>{error}</div>}
      {weather && weather.city ? (
        <div>
          <h2>{weather.city}</h2>
          <p>Temperature: {weather.temperature}°C</p>
          <p>Weather: {weather.description}</p>
        </div>
      ) : (
        !loading && !error && <div>No weather data available.</div>
      )}
    </div>
  );
}

export default WeatherDashboard;
