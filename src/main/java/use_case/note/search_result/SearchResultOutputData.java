package use_case.note.search_result;

import entity.Weather;

public class SearchResultOutputData {

    private final Weather weather;
    private final boolean useCaseFailed;

    public SearchResultOutputData(Weather weather, boolean useCaseFailed) {
        this.weather = weather;
        this.useCaseFailed = useCaseFailed;
    }

    public Weather getWeather() {
        return weather;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
