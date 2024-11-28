package interface_adapter.SearchResult;

import use_case.note.search_result.SearchResultOutputBoundary;
import use_case.note.search_result.SearchResultOutputData;
/**
 * Presenter for the Search Result use case.
 */

public class SearchResultPresenter implements SearchResultOutputBoundary {

    private final SearchResultViewModel viewModel;

    public SearchResultPresenter(SearchResultViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void presentSuccessView(SearchResultOutputData searchResultOutputData) {
        viewModel.getState().setWeather(searchResultOutputData.getWeather());
    }

    @Override
    public void presentFailView(String errorMessage) {
        viewModel.getState().setError(errorMessage);
    }
}
