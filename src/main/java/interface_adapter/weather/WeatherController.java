package interface_adapter.weather;

import use_case.note.search_return.SearchReturnInputBoundary;
import use_case.note.search_return.SearchReturnInputData;

/**
 * Controller for our weather related Use Cases.
 */
public class WeatherController {

    private final SearchReturnInputBoundary searchInteractor;

    public WeatherController(SearchReturnInputBoundary searchInteractor) {
        this.searchInteractor = searchInteractor;
    }

    /**
     * Execute the weather use case.
     * @param cityName the city to find the weather for
     */
    public void execute(String cityName) {
        final SearchReturnInputData searchInputData = new SearchReturnInputData(cityName);
        searchInteractor.execute(searchInputData);
    }
}
