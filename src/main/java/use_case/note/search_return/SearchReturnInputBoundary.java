package use_case.note.search_return;

/**
 * The input boundary for the search return use case.
 */
public interface SearchReturnInputBoundary {

    /**
     * Execute the search return use case.
     *
     * @param searchReturnInputData The input data for the search return use case.
     */
    void execute(SearchReturnInputData searchReturnInputData);
}
