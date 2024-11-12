package use_case.note.search_return;

public interface SearchReturnOutputBoundary {

    void presentSuccessView(SearchReturnOutputData searchReturnOutputData);

    void prepareFailView(String errorMessage);
}
