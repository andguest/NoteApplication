package interface_adapter.weather;

import entity.Weather;

/**
 * The state information for the weather view model.
 */
public class WeatherState {
    private Weather weather;
    private String error;
    private String alert;

    public Weather getWeather() {
        return weather;
    }

    public String getAlert() {
        return alert;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void setError(String errorMessage) {
        this.error = errorMessage;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getError() {
        return error;
    }
}
