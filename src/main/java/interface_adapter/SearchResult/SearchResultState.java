package interface_adapter.SearchResult;

import entity.Weather;

/**
 * The State for a search result.
 * <p>For this example, a note is simplay a string.</p>
 */
public class SearchResultState {
    private Weather weather;
    private String error;
    private String date;
    private String cityName;

    public Weather getWeather() {
        return weather;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
