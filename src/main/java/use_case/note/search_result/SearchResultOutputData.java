package use_case.note.search_result;

import entity.Weather;

public class SearchResultOutputData {

    private final String location;
    private final Weather weather;
    private final boolean useCaseFailed;

    public SearchResultOutputData(String location, Weather weather, boolean useCaseFailed) {
        this.location = location;
        this.weather = weather;
        this.useCaseFailed = useCaseFailed;
    }

    public String getLocation() {
        return location;
    }

    public Weather getWeather() {
        return weather;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
