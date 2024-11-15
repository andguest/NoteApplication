package interface_adapter.weather;

import use_case.note.search_result.SearchResultInputBoundary;
import use_case.note.search_result.SearchResultInputData;

/**
 * Controller for our Note related Use Cases.
 */
public class WeatherController {

    private final SearchResultInputBoundary searchInteractor;

    public WeatherController(SearchResultInputBoundary searchInteractor) {
        this.searchInteractor = searchInteractor;
    }

    /**
     * Execute the weather use case.
     * @param cityName the city to find the weather for
     */
    public void execute(String cityName) {
        final SearchResultInputData searchInputData = new SearchResultInputData(cityName);
        searchInteractor.execute(searchInputData);
    }
}
