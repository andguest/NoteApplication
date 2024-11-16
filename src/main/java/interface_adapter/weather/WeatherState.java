package interface_adapter.weather;

import entity.Weather;

/**
 * The state information for the weather view model.
 */
public class WeatherState {
    private Weather weather = new Weather("", 0, 0, 0, "", "", 0, 0);
    private String error;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void setError(String errorMessage) {
        this.error = errorMessage;
    }

    public String getError() {
        return error;
    }
}
