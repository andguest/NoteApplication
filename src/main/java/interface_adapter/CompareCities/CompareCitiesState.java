package interface_adapter.CompareCities;

import entity.Weather;
/**
 * The State for the Compare Cities Use case.
 */

public class CompareCitiesState {
    private String error;
    private String firstCityName;
    private String secondCityName;
    private Weather firstWeather;
    private Weather secondWeather;

    public CompareCitiesState(CompareCitiesState copy) {
        this.error = copy.error;
        this.firstCityName = copy.firstCityName;
        this.secondCityName = copy.secondCityName;
        this.setFirstWeather(copy.getFirstWeather());
        this.setSecondWeather(copy.getSecondWeather());
    }

    public CompareCitiesState() {
    }

    public String getError() {
        return error;
    }

    public String getFirstCityName() {
        return firstCityName;
    }

    public String getSecondCityName() {
        return secondCityName;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setFirstCityName(String firstCityName) {
        this.firstCityName = firstCityName;
    }

    public void setSecondCityName(String secondCityName) {
        this.secondCityName = secondCityName;
    }

    public Weather getFirstWeather() {
        return firstWeather;
    }

    public void setFirstWeather(Weather firstWeather) {
        this.firstWeather = firstWeather;
    }

    public Weather getSecondWeather() {
        return secondWeather;
    }

    public void setSecondWeather(Weather secondWeather) {
        this.secondWeather = secondWeather;
    }
}
