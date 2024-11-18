package use_case.alert_pop;

import use_case.WeatherDataAccessInterface;
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
            String alert = weather.getAlertDescription();
            String noAlert = "no alerts";

            if (noAlert.equals(alert)) {
                AlertPopOutputData outputData = new AlertPopOutputData(noAlert);
                outputBoundary.prepareSuccessView(outputData);
            } else {
                AlertPopOutputData outputData = new AlertPopOutputData(alert);
                outputBoundary.prepareSuccessView(outputData);
            }
        } catch (Exception e) {
            outputBoundary.prepareFailView("Failed to retrieve weather data: " + e.getMessage());
        }
    }
}

