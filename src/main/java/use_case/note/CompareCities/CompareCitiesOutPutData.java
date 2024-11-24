package use_case.note.CompareCities;

import entity.Weather;

public class CompareCitiesOutPutData {
    private final String firstCityname;
    private final String secondCityname;
    private Weather firstWeather;
    private Weather secondWeather;
    private final boolean useCaseFailed;

    public CompareCitiesOutPutData(String firstCityname, Weather firstWeather,
                                   String secondCityname, Weather secondWeather, boolean useCaseFailed) {
        this.firstCityname = firstCityname;
        this.secondCityname = secondCityname;
        this.setFirstWeather(firstWeather);
        this.setSecondWeather(secondWeather);
        this.useCaseFailed = useCaseFailed;
    }

    public String getFirstCityname() {
        return firstCityname;
    }

    public String getSecondCityname() {
        return secondCityname;
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
