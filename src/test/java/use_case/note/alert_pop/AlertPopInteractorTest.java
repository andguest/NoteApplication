package use_case.note.alert_pop;

import data_access.TestDataAccessObject;
import data_access.WeatherDataAccessObject;
import entity.Weather;
import interface_adapter.alert_pop.AlertPopPresenter;
import interface_adapter.weather.WeatherViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.note.WeatherDataAccessInterface;

import static org.junit.jupiter.api.Assertions.*;

class AlertPopInteractorTest {

    private TestDataAccessObject testDataAccess;
    private WeatherViewModel weatherViewModel;
    private AlertPopOutputBoundary alertPopOutputBoundary;
    private AlertPopInputData alertPopInputData;

    @BeforeEach
    void init() {
        testDataAccess = new TestDataAccessObject();
        weatherViewModel = new WeatherViewModel();
        alertPopOutputBoundary = new AlertPopPresenter(weatherViewModel);
    }

    @Test
    void successTest() {
        alertPopInputData = new AlertPopInputData("Toronto");
        AlertPopInteractor interactor = new AlertPopInteractor(testDataAccess, alertPopOutputBoundary);
        Weather weather = new Weather("Toronto", 12f, "Sunny", "broken clouds",
                21f, 69, 24, 79, 44, "no weather alert");
        testDataAccess.saveWeatherinfor(weather);
    }
}