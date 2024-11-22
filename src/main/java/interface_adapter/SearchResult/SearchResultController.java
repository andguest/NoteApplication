package interface_adapter.SearchResult;

import use_case.note.search_result.SearchResultInputBoundary;
import use_case.note.search_result.SearchResultInputData;

/**
 * The controller for the search result view. It is responsible for executing the search result use case.
 */
public class SearchResultController {

    private final SearchResultInputBoundary searchResultInputBoundary;

    // Constructor that injects the use case's input boundary
    public SearchResultController(SearchResultInputBoundary searchResultInputBoundary) {
        this.searchResultInputBoundary = searchResultInputBoundary;
    }

    /**
     * Executes the search result use case with the given city name and date.
     *
     * @param cityName the name of the city to search for
     * @param date the date to search for
     */
    public void execute(String cityName, String date) {
        // Create a SearchResultInputData object to encapsulate the input data
        final SearchResultInputData inputData = new SearchResultInputData(cityName, date);
        // Call the use case's execute method with the input data
        searchResultInputBoundary.execute(inputData);
    }
}

