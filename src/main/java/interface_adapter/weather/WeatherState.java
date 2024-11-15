package interface_adapter.weather;

/**
 * The state information for the weather view model.
 */
public class WeatherState {
    private String weather = "";
    private String error;

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setError(String errorMessage) {
        this.error = errorMessage;
    }

    public String getError() {
        return error;
    }
}
