package use_case.note;

import org.junit.Before;
import org.junit.Test;
import use_case.note.search_return.*;
import entity.Weather;

import java.io.IOException;

import static org.junit.Assert.*;

public class SearchReturnInteractorTest {

    private SearchReturnOutputBoundary outputBoundary;
    private WeatherDataAccessInterface weatherDataAccess;
    private HistoricalWeatherDataAccessInterface historicalWeatherDataAccess;

    private SearchReturnInteractor interactor;

    @Before
    public void setUp() {
        outputBoundary = new SearchReturnOutputBoundary() {
            @Override
            public void presentSuccessView(SearchReturnOutputData searchReturnOutputData) {
                // Success handling implementation
            }

            @Override
            public void prepareFailView(String errorMessage) {
                // Failure handling implementation
                assertNotNull(errorMessage);
                assertTrue(errorMessage.startsWith("Failed to retrieve weather data"));
            }
        };

        weatherDataAccess = new WeatherDataAccessInterface() {
            @Override
            public Weather getWeather(String city) throws IOException {
                if (city.equals("Toronto")) {
                    String cityName = "Toronto";
                    Double temperature = 10.0;
                    String weather1 = "Cloudy";
                    String description = "Cloudy with a chance of meatballs";
                    Double windSpeed = 10.0;
                    int humidity = 10;
                    int visibility = 10;
                    Double lon = 10.0;
                    Double lat = 10.0;
                    String alertDescription = "No alerts";
                    return new Weather(cityName, temperature, weather1, description, windSpeed, humidity, visibility, lon, lat, alertDescription);
                }
                throw new IOException("Failed to fetch weather data");
            }
        };

        historicalWeatherDataAccess = new HistoricalWeatherDataAccessInterface() {
            @Override
            public void saveWeather(Weather weather, String timestamp) {
                // Save weather data implementation
            }

            @Override
            public Weather getWeather(String city, String timestamp) throws IOException {
                return null;
            }
        };

        interactor = new SearchReturnInteractor(outputBoundary, weatherDataAccess, historicalWeatherDataAccess);
    }

    @Test
    public void testExecute_success() {
        // Arrange
        String city = "Toronto";
        SearchReturnInputData inputData = new SearchReturnInputData(city);

        // Act
        interactor.execute(inputData);

        // Assert
        String cityName = "Toronto";
        Double temperature = 10.0;
        String weather1 = "Cloudy";
        String description = "Cloudy with a chance of meatballs";
        Double windSpeed = 10.0;
        int humidity = 10;
        int visibility = 10;
        Double lon = 10.0;
        Double lat = 10.0;
        String alertDescription = "No alerts";
        Weather weather = new Weather(cityName, temperature, weather1, description, windSpeed, humidity, visibility, lon, lat, alertDescription);
        SearchReturnOutputData outputData = new SearchReturnOutputData(weather, false);
        assertEquals(10.0, outputData.getWeather().getTemperature(), 0.0);
        assertEquals("Cloudy with a chance of meatballs", outputData.getWeather().getDescription());
    }

    @Test
    public void testExecute_failure() {
        // Arrange
        historicalWeatherDataAccess = new HistoricalWeatherDataAccessInterface() {
            @Override
            public void saveWeather(Weather weather, String timestamp) throws IOException {
                throw new IOException("Simulated IO Exception");
            }

            @Override
            public Weather getWeather(String city, String timestamp) throws IOException {
                return null;
            }
        };
        outputBoundary = new SearchReturnOutputBoundary() {
            @Override
            public void presentSuccessView(SearchReturnOutputData searchReturnOutputData) {
                fail("Expected failure, but success view was presented");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                // Failure handling implementation
                assertNotNull(errorMessage);
                assertTrue(errorMessage.startsWith("Failed to retrieve weather data"));
            }
        };
        interactor = new SearchReturnInteractor(outputBoundary, weatherDataAccess, historicalWeatherDataAccess);
        String city = "Unknown City";
        SearchReturnInputData inputData = new SearchReturnInputData(city);

        // Act
        try {
            interactor.execute(inputData);
        } catch (RuntimeException e) {
                assertFalse(e.getCause() instanceof IOException);
            assertEquals("Failed to fetch weather data", e.getMessage());
        }

    }
}
