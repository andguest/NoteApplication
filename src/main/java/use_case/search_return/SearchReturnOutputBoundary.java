package use_case.search_return;

public interface SearchReturnOutputBoundary {

    void presentSuccessView(SearchReturnOutputData searchReturnOutputData);

    void prepareFailView(String errorMessage);
}
