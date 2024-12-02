package use_case.note.alert_pop;

import data_access.TestDataAccessObject;
import entity.Weather;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlertPopInteractorTest {

    private TestDataAccessObject testDataAccess;
    private AlertPopInputData alertPopInputData;

    @BeforeEach
    void init() {
        // Initialize a DAO that does not access info from API but rather gets info through coded inputs.
        testDataAccess = new TestDataAccessObject();
    }

    @Test
    void successNoAlertTest() {
        // Initializes input data and stores info into DAO.
        alertPopInputData = new AlertPopInputData("Toronto");
        Weather weather = new Weather("Toronto", 12f, "Sunny", "broken clouds",
                21f, 69, 24, 79, 44, "no weather alert");
        testDataAccess.saveWeatherinfor(weather);

        // Creates a successPresenter that tests whether the test case is as we expect.
        AlertPopOutputBoundary successPresenter = new AlertPopOutputBoundary() {
            @Override
            public void prepareSuccessView(AlertPopOutputData alertPopOutputData) {
                assertEquals("no weather alert", alertPopOutputData.getAlert());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        AlertPopInteractor interactor = new AlertPopInteractor(testDataAccess, successPresenter);
        interactor.execute(alertPopInputData);
    }

    @Test
    void successAlertTest() {
        //Initializes input data and stores info into DAO.
        alertPopInputData = new AlertPopInputData("Tokyo");
        Weather weather = new Weather("Tokyo", 12f, "Sunny", "broken clouds",
                21f, 69, 24, 79, 44, "North winds 15 to 20 kt");
        testDataAccess.saveWeatherinfor(weather);

        // Creates a successPresenter that tests whether the test case is as we expect.
        AlertPopOutputBoundary successPresenter = new AlertPopOutputBoundary() {
            @Override
            public void prepareSuccessView(AlertPopOutputData alertPopOutputData) {
                assertEquals("North winds 15 to 20 kt", alertPopOutputData.getAlert());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        AlertPopInteractor interactor = new AlertPopInteractor(testDataAccess, successPresenter);
        interactor.execute(alertPopInputData);
    }

    @Test
    void failureInvalidCityTest() {
        //initializes input data and stores info into DAO.
        alertPopInputData = new AlertPopInputData("not a city");
        Weather weather = new Weather("Toronto", 12f, "Sunny", "broken clouds",
                21f, 69, 24, 79, 44, "no weather alert");
        testDataAccess.saveWeatherinfor(weather);

        // Creates a failurePresenter that tests whether the test case is as we expect.
        AlertPopOutputBoundary failurePresenter = new AlertPopOutputBoundary() {
            @Override
            public void prepareSuccessView(AlertPopOutputData alertPopOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Failed to retrieve weather data: This city is not found", errorMessage);
            }
        };

        AlertPopInteractor interactor = new AlertPopInteractor(testDataAccess, failurePresenter);
        interactor.execute(alertPopInputData);
    }
}