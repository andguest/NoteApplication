package use_case.note;

import data_access.InMemoryUserDataAccessObject;
import data_access.WeatherDataAccessObject;
import entity.Weather;
import interface_adapter.CompareCities.CompareCitiesPresenter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import use_case.note.CompareCities.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CompareCitiesInteractorTest {
    private CompareCitiesOutputBoundary presenter;
    private CompareCitiesDataAccessInterface compareCitiesDataAccessInterface;

    @Test
    public void successTest() {
        // this is the mock input data.
        final CompareCitiesInputData inputData = new CompareCitiesInputData("Toronto", "Tokyo");

        compareCitiesDataAccessInterface = new InMemoryUserDataAccessObject();

        presenter = new CompareCitiesOutputBoundary() {
            // make a presenter
            @Override
            public void prepareSuccessView(CompareCitiesOutPutData outputData) {
                Assertions.assertEquals("Toronto", outputData.getFirstCityname());
                Assertions.assertEquals(1.0, outputData.getSecondWeather().getTemperature());
                Assertions.assertEquals("Tokyo", outputData.getSecondCityname());
                Assertions.assertEquals(2, outputData.getSecondWeather().getHumidity());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                Assertions.fail("city not found");
            }
        };

        CompareCitiesInputBoundary interactor = new CompareCitiesInteractor(compareCitiesDataAccessInterface, presenter);
        interactor.execute(inputData);
    }
    @Test
    public void successexecuteTest () {
        CompareCitiesInputData inputdata = new CompareCitiesInputData("Toronto", "Tokyo");
        compareCitiesDataAccessInterface = new InMemoryUserDataAccessObject();
        String firstcityName = "Toronto";
        Double firsttemperature = 10.5;
        String firstsky = "rain";
        String firstdescription = "first description";
        Double firstwindSpeed = 0.0;
        int firsthumidity = 1;
        int firstvisibility = 2;
        Double firstlon = 3.0;
        Double firstlat = 4.0;
        String firstalertDescription = "No alerts";

        Weather firstweather = new Weather(firstcityName, firsttemperature, firstsky,firstdescription, firstwindSpeed, firsthumidity, firstvisibility, firstlon, firstlat, firstalertDescription);
        compareCitiesDataAccessInterface.saveWeatherinfor(firstweather);
        String secondcityName = "Tokyo";
        Double secondtemperature = 1.0;
        String secondsky = "cloud";
        String seconddescription = "second description";
        Double secondwindSpeed = 2.0;
        int secondhumidity = 2;
        int secondvisibility = 1000;
        Double secondlon = 20.0;
        Double secondlat = 25.0;
        String secondalertDescription = "Alerts";
        Weather secondweather = new Weather(secondcityName, secondtemperature, secondsky, seconddescription, secondwindSpeed, secondhumidity, secondvisibility, secondlon, secondlat, secondalertDescription);
        compareCitiesDataAccessInterface.saveWeatherinfor(secondweather);
    }

    @Test
    public void testExecute_SameCityComparison() {
        // Arrange
        CompareCitiesInputData inputData = new CompareCitiesInputData("Toronto", "Toronto");

        // Act
        CompareCitiesInputBoundary interactor = new CompareCitiesInteractor(compareCitiesDataAccessInterface, presenter);
        interactor.execute(inputData);

        // Assert
        presenter.prepareFailView("Cannot compare the same city");
    }
}

//
////        Weather weather1 = compareCitiesDataAccessInterface.getWeather(inputData.getFirstcityname());
////        compareCitiesDataAccessInterface.saveWeatherinfor(weather1);
////        Weather weather2 = compareCitiesDataAccessInterface.getWeather(inputData.getSecondcityname());
////        compareCitiesDataAccessInterface.saveWeatherinfor(weather2);
//    }
//
//            @Override
//            public boolean isCityexist(String cityname) {
//                return true;
//            }
//
//            @Override
//            public boolean isCityExist(String cityname) {
//                return false;
//            }
//        } {
//
//
//            @Override
//            public String saveWeatherinfor(Weather weather) {
//                return "";
//            }
//
//
//            @Override
//            public String loadWeather(Weather weather) {
//                return "test";
//            }
//        };
//
//        CompareCitiesOutputBoundary compareCitiesOB = new CompareCitiesOutputBoundary() {
//            @Override
//            public void prepareSuccessView(String message) {
//                assertEquals("test", message);
//            }
//
//            @Override
//            public void prepareFailView(String errorMessage) {
//                fail(errorMessage);
//            }
//        };
//
//        CompareCitiesInteractor compareCitiesInteractor = new CompareCitiesInteractor(compareCitiesDataAccessInterface, compareCitiesOB);
//        CompareCitiesInputData inputData = new CompareCitiesInputData("City1", "City2");
//
//        compareCitiesInteractor.execute(inputData);
//
//
//    }
//}