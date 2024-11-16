package interface_adapter.note;

import entity.Weather;

/**
 * The State for a search result.
 * <p>For this example, a note is simplay a string.</p>
 */
public class SearchResultState {
    private Weather weather;
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
