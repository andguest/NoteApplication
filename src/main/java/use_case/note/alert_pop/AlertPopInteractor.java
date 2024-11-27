package use_case.note.alert_pop;

import use_case.note.WeatherDataAccessInterface;
import entity.Weather;

public class AlertPopInteractor implements AlertPopInputBoundary {
    private final WeatherDataAccessInterface weatherAccess;
    private final AlertPopOutputBoundary outputBoundary;

    public AlertPopInteractor(WeatherDataAccessInterface weatherAccess, AlertPopOutputBoundary outputBoundary) {
        this.weatherAccess = weatherAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(AlertPopInputData alertPopInputData) {
        try {
            String cityName = alertPopInputData.getCityName();
            Weather weather = weatherAccess.getWeather(cityName);
            String alert = weather.getDescription();
            String noAlert = "no weather alert";

            if (noAlert.equals(alert)) {
                AlertPopOutputData outputData = new AlertPopOutputData(noAlert, false);
                outputBoundary.prepareSuccessView(outputData);
            } else {
                AlertPopOutputData outputData = new AlertPopOutputData(alert, false);
                outputBoundary.prepareSuccessView(outputData);
            }
        } catch (Exception e) {
            outputBoundary.prepareFailView("Failed to retrieve weather data: " + e.getMessage());
        }
    }
}

