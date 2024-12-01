package use_case.note.search_return;

import entity.Weather;

/**
 * Output data for the search return use case.
 */
public class SearchReturnOutputData {

    private final String location;
    private final Weather weather;
    private final boolean useCaseFailed;

    public SearchReturnOutputData(Weather weather, boolean useCaseFailed) {
        this.location = weather.getCityName();
        this.weather = weather;
        this.useCaseFailed = useCaseFailed;
    }

    public Weather getWeather() {
        return weather;
    }
}
