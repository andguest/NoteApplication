import entity.Weather;
import org.junit.Before;
import org.junit.Test;
//import org.junit.Assert;
//import org.junit.Assert.*;
import use_case.note.search_result.SearchResultInputBoundary;
//import org.mockito.Mockito;
import use_case.note.HistoricalWeatherDataAccessInterface;
import use_case.note.WeatherDataAccessInterface;
import use_case.note.search_result.SearchResultInputData;
import use_case.note.search_result.SearchResultOutputBoundary;
import use_case.note.search_result.SearchResultOutputData;

import java.io.IOException;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

//import static org.mockito.Mockito.*;

public class SearchResultInteractorTest {
    private SearchResultInputBoundary inputBoundary;
    private SearchResultOutputBoundary outputBoundary;
    private WeatherDataAccessInterface weatherDataAccess;
    private HistoricalWeatherDataAccessInterface historicalWeatherDataAccess = new HistoricalWeatherDataAccessInterface() {
        @Override
        public void saveWeather(Weather weather, String timstamp) throws IOException {

        }

        @Override
        public Weather getWeather(String city, String timestamp) throws IOException {
            return null;
        }
    };
    String city = "Toronto";
    String timestamp = "2023-11-27";
    private SearchResultInputData inputData = new SearchResultInputData(city, timestamp);
//    private String city;
//    private String timestamp;

    @Before
//    public void setUp() {
//
//        SearchResultInputData inputData = new SearchResultInputData(city, timestamp);
//        inputBoundary = new SearchResultInputBoundary() {
//            @Override
//            public void execute(SearchResultInputData inputData) {
//
//            };
//        };
//        weatherDataAccess = new WeatherDataAccessInterface() {
//            @Override
//            public Weather getWeather(String city) throws IOException {
//                return null;
//            }
//        };
//        historicalWeatherDataAccess = new HistoricalWeatherDataAccessInterface() {
//            @Override
//            public void saveWeather(Weather weather, String timstamp) throws IOException {
//
//            }
//
//            @Override
//            public Weather getWeather(String city, String timestamp) throws IOException {
//                return null;
//            }
//        };
//        inputBoundary = new SearchResultInputBoundary() {
//            @Override
//            public void execute(SearchResultInputData searchResultInputData) {
//
//            }
//        };
//    }

    @Test
    public void testExecuteSuccess() throws IOException {
        HistoricalWeatherDataAccessInterface hisDataAccess = new HistoricalWeatherDataAccessInterface() {
            @Override
            public void saveWeather(Weather weather, String timstamp) throws IOException {

            }

            @Override
            public Weather getWeather(String city, String timestamp) throws IOException {
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
                return weather;
            }
        };
        WeatherDataAccessInterface weatherDataAccess = new WeatherDataAccessInterface() {
            @Override
            public Weather getWeather(String city) throws IOException {
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
                return weather;
            }
        };
        SearchResultOutputBoundary outputBoundary = new SearchResultOutputBoundary() {
            @Override
            public void presentSuccessView(SearchResultOutputData outputData) {
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
//                return weather;
                assertEquals(weather,outputData);
            }

            @Override
            public void presentFailView(String errorMessage) {
                assertNull(errorMessage);
            }
        };
    }

    @Test
    public void testExecuteFailure() throws IOException {
        // Arrange
//        String city = "Toronto";
//        String timestamp = "2023-11-27";
//        SearchResultInputData inputData = new SearchResultInputData(city, timestamp);
//        when(historicalWeatherDataAccess.getWeather(city.toLowerCase())).thenThrow(new IOException("Error fetching data"));

        // Act
        inputBoundary.execute(inputData);

        // Assert
        outputBoundary.presentFailView("Failed to retrieve weather data: Error fetching data");
//        verify(outputBoundary).presentFailView("Failed to retrieve weather data: Error fetching data");
    }
}

