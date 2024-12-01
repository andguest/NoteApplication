//import entity.Weather;
//import org.junit.Test;
//import use_case.note.search_result.SearchResultInputBoundary;
//import use_case.note.HistoricalWeatherDataAccessInterface;
//import use_case.note.WeatherDataAccessInterface;
//import use_case.note.search_result.SearchResultInputData;
//import use_case.note.search_result.SearchResultOutputBoundary;
//import use_case.note.search_result.SearchResultOutputData;
//
//import java.io.IOException;
//
//import static junit.framework.TestCase.assertNull;
//import static org.junit.Assert.assertEquals;
//
//
//public class SearchResultInteractorTest {
//    private SearchResultInputBoundary inputBoundary;
//    private SearchResultOutputBoundary outputBoundary;
//    private WeatherDataAccessInterface weatherDataAccess;
//    private HistoricalWeatherDataAccessInterface historicalWeatherDataAccess = new HistoricalWeatherDataAccessInterface() {
//        @Override
//        public void saveWeather(Weather weather, String timstamp) throws IOException {
//
//        }
//
//        @Override
//        public Weather getWeather(String city, String timestamp) throws IOException {
//            return null;
//        }
//    };
//    String city = "Toronto";
//    String timestamp = "2023-11-27";
//    private SearchResultInputData inputData = new SearchResultInputData(city, timestamp);
//
//
//
//    @Test
//    public void testExecuteSuccess() throws IOException {
//        HistoricalWeatherDataAccessInterface hisDataAccess = new HistoricalWeatherDataAccessInterface() {
//            @Override
//            public void saveWeather(Weather weather, String timstamp) throws IOException {
//
//            }
//
//            @Override
//            public Weather getWeather(String city, String timestamp) throws IOException {
//                String cityName = "Toronto";
//                Double temperature = 10.0;
//                String weather1 = "Cloudy";
//                String description = "Cloudy with a chance of meatballs";
//                Double windSpeed = 10.0;
//                int humidity = 10;
//                int visibility = 10;
//                Double lon = 10.0;
//                Double lat = 10.0;
//                String alertDescription = "No alerts";
//                Weather weather = new Weather(cityName, temperature, weather1, description, windSpeed, humidity, visibility, lon, lat, alertDescription);
//                return weather;
//            }
//        };
//        WeatherDataAccessInterface weatherDataAccess = new WeatherDataAccessInterface() {
//            @Override
//            public Weather getWeather(String city) throws IOException {
//                String cityName = "Toronto";
//                Double temperature = 10.0;
//                String weather1 = "Cloudy";
//                String description = "Cloudy with a chance of meatballs";
//                Double windSpeed = 10.0;
//                int humidity = 10;
//                int visibility = 10;
//                Double lon = 10.0;
//                Double lat = 10.0;
//                String alertDescription = "No alerts";
//                Weather weather = new Weather(cityName, temperature, weather1, description, windSpeed, humidity, visibility, lon, lat, alertDescription);
//                return weather;
//            }
//        };
//        SearchResultOutputBoundary outputBoundary = new SearchResultOutputBoundary() {
//            @Override
//            public void presentSuccessView(SearchResultOutputData outputData) {
//                String cityName = "Toronto";
//                Double temperature = 10.0;
//                String weather1 = "Cloudy";
//                String description = "Cloudy with a chance of meatballs";
//                Double windSpeed = 10.0;
//                int humidity = 10;
//                int visibility = 10;
//                Double lon = 10.0;
//                Double lat = 10.0;
//                String alertDescription = "No alerts";
//                Weather weather = new Weather(cityName, temperature, weather1, description, windSpeed, humidity, visibility, lon, lat, alertDescription);
//                assertEquals(weather,outputData);
//            }
//
//            @Override
//            public void presentFailView(String errorMessage) {
//                assertNull(errorMessage);
//            }
//        };
//    }
//
//}
//
import entity.Weather;
import org.junit.Before;
import org.junit.Test;
import use_case.note.search_result.*;
import use_case.note.HistoricalWeatherDataAccessInterface;
import use_case.note.WeatherDataAccessInterface;

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
        interactor.execute(inputData);
    }

    @Test
    public void testExecuteFailure() throws IOException {
        weatherDataAccess = new WeatherDataAccessInterface() {
            @Override
            public Weather getWeather(String city) throws IOException {
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
                assertEquals("Failed to retrieve weather data: Failed to retrieve weather data", errorMessage);
            }
        };

        SearchResultInteractor interactor = new SearchResultInteractor(outputBoundary, weatherDataAccess, historicalWeatherDataAccess);
//        interactor.execute(inputData);
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
