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

    @Test
    public void successTest() {
        // this is the mock input data.
        final CompareCitiesInputData inputData = new CompareCitiesInputData("Toronto", "Tokyo");

        final CompareCitiesDataAccessInterface compareCitiesDataAccessInterface = new InMemoryUserDataAccessObject();

        CompareCitiesOutputBoundary SuccessPresenter = new CompareCitiesOutputBoundary() {
            // make a presenter
            @Override
            public void prepareSuccessView(CompareCitiesOutPutData outputData) {
                Assertions.assertEquals("Toronto", outputData.getFirstCityname());
                Assertions.assertEquals(10.5, outputData.getSecondWeather().getTemperature());
                Assertions.assertEquals("Tokyo", outputData.getSecondCityname());
                Assertions.assertEquals(0, outputData.getSecondWeather().getHumidity());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                Assertions.fail("Use case failure is unexpected.");
            }
        }

        final CompareCitiesInputBoundary interactor = new CompareCitiesInteractor(compareCitiesDataAccessInterface, SuccessPresenter);
        interactor.execute(inputData);
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