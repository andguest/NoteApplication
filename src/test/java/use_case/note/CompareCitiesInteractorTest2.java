package use_case.note;

import data_access.InMemoryUserDataAccessObject; // Replace with the correct package if different
import data_access.WeatherDataAccessObject;
import entity.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import use_case.note.CompareCities.*;

import java.io.IOException;

class CompareCitiesInteractorTest2 {

    @Test
    public void testSuccessComparison() {
        // Arrange
        CompareCitiesDataAccessInterface dao = new InMemoryUserDataAccessObject();

        // Add mock weather data directly into the DAO
        dao.saveWeatherinfor(new Weather("Toronto", 10.5, "Clear", "Sunny", 5.0, 50, 1000, -79.38, 43.65, "No alerts"));
        dao.saveWeatherinfor(new Weather("Tokyo", 15.0, "Cloudy", "Overcast", 3.0, 70, 800, 139.69, 35.69, "No alerts"));

        CompareCitiesOutputBoundary presenter = new CompareCitiesOutputBoundary() {
            @Override
            public void prepareSuccessView(CompareCitiesOutPutData outputData) {
                assertEquals("Toronto", outputData.getFirstCityname());
                assertEquals(10.5, outputData.getFirstWeather().getTemperature(), 0.01);
                assertEquals("Tokyo", outputData.getSecondCityname());
                assertEquals(1.0, outputData.getSecondWeather().getTemperature(), 0.01);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure: " + errorMessage);
            }
        };

        CompareCitiesInteractor interactor = new CompareCitiesInteractor(dao, presenter);
        CompareCitiesInputData inputData = new CompareCitiesInputData("Toronto", "Tokyo");

        // Act
        interactor.execute(inputData);
    }

    @Test
    public void testSameCityComparison() {
        // Arrange
        CompareCitiesDataAccessInterface dao = new InMemoryUserDataAccessObject();

        CompareCitiesOutputBoundary presenter = new CompareCitiesOutputBoundary() {
            @Override
            public void prepareSuccessView(CompareCitiesOutPutData outputData) {
                fail("Comparison of the same city should fail.");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Cannot compare the same city", errorMessage);
            }
        };

        CompareCitiesInteractor interactor = new CompareCitiesInteractor(dao, presenter);
        CompareCitiesInputData inputData = new CompareCitiesInputData("Toronto", "Toronto");

        // Act
        interactor.execute(inputData);
    }

    @Test
    public void testCityNotFound1() {
        // Arrange
        CompareCitiesDataAccessInterface dao = new InMemoryUserDataAccessObject();

        CompareCitiesOutputBoundary presenter = new CompareCitiesOutputBoundary() {
            @Override
            public void prepareSuccessView(CompareCitiesOutPutData outputData) {
                fail("City not found should fail.");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("city not found", errorMessage);
            }
        };


        CompareCitiesInteractor interactor = new CompareCitiesInteractor(dao, presenter);
        CompareCitiesInputData inputData = new CompareCitiesInputData("NonExistentCity", "Tokyo");

        // Act
        try {
            interactor.execute(inputData);
        }
        catch (RuntimeException e) {
            assertFalse(e.getCause() instanceof IOException);
            assertEquals("Failed to fetch weather data", e.getMessage());
        }
    }
    @Test
    public void testCityNotFound2() {
        // Arrange
        CompareCitiesDataAccessInterface dao = new InMemoryUserDataAccessObject();

        CompareCitiesOutputBoundary presenter = new CompareCitiesOutputBoundary() {
            @Override
            public void prepareSuccessView(CompareCitiesOutPutData outputData) {
                fail("City not found should fail.");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("city not found", errorMessage);
            }
        };


        CompareCitiesInteractor interactor = new CompareCitiesInteractor(dao, presenter);
        CompareCitiesInputData inputData = new CompareCitiesInputData("Toronto", "randomcity");

        // Act
        try {
            interactor.execute(inputData);
        }
        catch (RuntimeException e) {
            assertFalse(e.getCause() instanceof IOException);
            assertEquals("Failed to fetch weather data", e.getMessage());
        }

    }

    @Test
    public void testIOExceptionHandlingForBothCities() {
        // Custom DAO that throws IOException for both cities
        CompareCitiesDataAccessInterface dao = new InMemoryUserDataAccessObject() {
            @Override
            public Weather getWeather(String cityName) throws IOException {
                throw new IOException("Network error while fetching weather data for " + cityName);
            }
        };

        CompareCitiesOutputBoundary presenter = new CompareCitiesOutputBoundary() {
            @Override
            public void prepareSuccessView(CompareCitiesOutPutData outputData) {
                fail("IOException should result in failure, not success.");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                // Check if the error message is the same for the first city
                if (errorMessage.contains("Toronto")) {
                    assertTrue(errorMessage.contains("Network error while fetching weather data for Toronto"));
                }
                // Check if the error message is the same for the second city
                else if (errorMessage.contains("Tokyo")) {
                    assertTrue(errorMessage.contains("Network error while fetching weather data for Tokyo"));
                } else {
                    fail("Unexpected error message: " + errorMessage);
                }
            }
        };

        CompareCitiesInteractor interactor = new CompareCitiesInteractor(dao, presenter);
        CompareCitiesInputData inputData = new CompareCitiesInputData("Toronto", "Tokyo");

        // Act
        try {
            interactor.execute(inputData);
        }
        catch (RuntimeException e) {
            assertFalse(e.getCause() instanceof IOException);
        }
    }
}