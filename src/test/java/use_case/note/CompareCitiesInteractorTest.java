package use_case.note;

import entity.User;
import entity.Weather;
import org.junit.Test;
import use_case.note.CompareCities.CompareCitiesDataAccessInterface;
import use_case.note.CompareCities.CompareCitiesInputData;
import use_case.note.CompareCities.CompareCitiesInteractor;
import use_case.note.CompareCities.CompareCitiesOutputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CompareCitiesInteractorTest {

    @Test
    public void testExecuteRefreshSuccess() {

        CompareCitiesDataAccessInterface compareCitiesDataAccessInterface = new CompareCitiesDataAccessInterface() {


            @Override
            public String saveWeatherinfor(Weather weather) {
                return "";
            }


            @Override
            public String loadWeather(Weather weather) {
                return "test";
            }
        };

        CompareCitiesOutputBoundary compareCitiesOB = new CompareCitiesOutputBoundary() {
            @Override
            public void prepareSuccessView(String message) {
                assertEquals("test", message);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail(errorMessage);
            }
        };

        CompareCitiesInteractor compareCitiesInteractor = new CompareCitiesInteractor(compareCitiesDataAccessInterface, compareCitiesOB);
        CompareCitiesInputData inputData = new CompareCitiesInputData("City1", "City2");

        compareCitiesInteractor.execute(inputData);


    }
}