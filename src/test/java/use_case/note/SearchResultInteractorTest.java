package use_case.note;

import entity.Weather;
import org.junit.Before;
import org.junit.Test;
import use_case.note.search_result.*;

import java.io.IOException;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

public class SearchResultInteractorTest {
    private SearchResultInputBoundary inputBoundary;
    private SearchResultOutputBoundary outputBoundary;
    private WeatherDataAccessInterface weatherDataAccess;
    private HistoricalWeatherDataAccessInterface historicalWeatherDataAccess;
    private SearchResultInputData inputData;

    @Before
    public void setUp() {
        historicalWeatherDataAccess = new HistoricalWeatherDataAccessInterface() {
            @Override
            public void saveWeather(Weather weather, String timestamp) throws IOException {
                // No-op for testing
            }

            @Override
            public Weather getWeather(String city, String timestamp) throws IOException {
                return createMockWeather();
            }
        };

        weatherDataAccess = new WeatherDataAccessInterface() {
            @Override
            public Weather getWeather(String city) throws IOException {
                return createMockWeather();
            }
        };

        outputBoundary = new SearchResultOutputBoundary() {
            @Override
            public void presentSuccessView(SearchResultOutputData outputData) {
                Weather expectedWeather = createMockWeather();
                assertNotEquals(expectedWeather, outputData.getWeather());
                assertTrue(!outputData.isUseCaseFailed());
            }

            @Override
            public void presentFailView(String errorMessage) {
                assertNull(errorMessage);
            }
        };

        inputData = new SearchResultInputData("Toronto", "2023-11-27");
    }

    @Test
    public void testExecuteSuccess() throws IOException {
        SearchResultInteractor interactor = new SearchResultInteractor(outputBoundary, weatherDataAccess, historicalWeatherDataAccess);
        interactor.execute(inputData);
    }

    @Test
    public void testExecuteFailure() throws IOException {
        historicalWeatherDataAccess = new HistoricalWeatherDataAccessInterface() {

            @Override
            public void saveWeather(Weather weather, String timestamp) throws IOException {
                // No-op for testing
                throw new IOException("Failed to retrieve weather data");
            }

            @Override
            public Weather getWeather(String city, String timestamp) throws IOException {
                throw new IOException("Failed to retrieve weather data");
            }
        };

        outputBoundary = new SearchResultOutputBoundary() {
            @Override
            public void presentSuccessView(SearchResultOutputData outputData) {
                fail("Expected failure, but success view was presented");
            }

            @Override
            public void presentFailView(String errorMessage) {
                assertNotNull(errorMessage);
                assertEquals("Failed to retrieve weather data: Failed to retrieve weather data", errorMessage);
            }
        };

        SearchResultInteractor interactor = new SearchResultInteractor(outputBoundary,
                weatherDataAccess, historicalWeatherDataAccess);
        try {
            interactor.execute(inputData);
        } catch (RuntimeException e) {
            assertEquals("Failed to retrieve weather data", e.getMessage());
        }
    }

    private Weather createMockWeather() {
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
}
