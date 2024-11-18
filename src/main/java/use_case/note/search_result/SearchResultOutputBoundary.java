package use_case.note.search_result;

public interface SearchResultOutputBoundary {

    void presentSuccessView(SearchResultOutputData searchResultOutputData);

    void presentFailView(String errorMessage);
}
