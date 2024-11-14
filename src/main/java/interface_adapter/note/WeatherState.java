package interface_adapter.note;

/**
 * The State for a weather.
 * <p>For this example, a note is simplay a string.</p>
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
