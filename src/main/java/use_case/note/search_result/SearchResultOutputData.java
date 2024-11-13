package use_case.note.search_result;

import entity.Weather;

import java.util.Map;

public class SearchResultOutputData {

    private final String location;
    private final Map<String, Weather> weather;
    private final boolean useCaseFailed;

    public SearchResultOutputData(String location, Map<String, Weather> weather, boolean useCaseFailed) {
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
