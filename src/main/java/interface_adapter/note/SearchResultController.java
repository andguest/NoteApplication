package interface_adapter.note;

import use_case.note.search_result.SearchResultInputBoundary;
import use_case.note.search_result.SearchResultInputData;

/**
 * Controller class that handles the search result use case.
 */
public class SearchResultController {

    private final SearchResultInputBoundary searchResultInteractor;

    // Constructor that injects the use case's input boundary
    public SearchResultController(SearchResultInputBoundary searchResultInteractor) {
        this.searchResultInteractor = searchResultInteractor;
    }

    /**
     * Executes the search result use case.
     * @param cityName the name of the city to search for
     * @param date the date to search for
     */
    public void execute(String cityName, String date) {
        // Create a SearchResultInputData object to encapsulate the input data
        final SearchResultInputData inputData = new SearchResultInputData(cityName, date);
        // Call the use case's execute method with the input data
        searchResultInteractor.execute(inputData);
    }
}

