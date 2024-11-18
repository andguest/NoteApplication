package use_case.search_return;

import entity.Weather;

public class SearchReturnOutputData {

    private final String location;
    private final Weather weather;
    private final boolean useCaseFailed;

    public SearchReturnOutputData(String location, Weather weather, boolean useCaseFailed) {
        this.location = location;
        this.weather = weather;
        this.useCaseFailed = useCaseFailed;
    }

    public String getLocation() {
        return location;
    }

    public Weather getWeather() {return weather;}

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
