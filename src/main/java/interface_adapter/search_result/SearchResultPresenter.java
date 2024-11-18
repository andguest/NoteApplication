package interface_adapter.search_result;

import interface_adapter.weather.WeatherViewModel;
import use_case.search_result.SearchResultOutputBoundary;
import use_case.search_result.SearchResultOutputData;


public class SearchResultPresenter implements SearchResultOutputBoundary {

    private final WeatherViewModel viewModel;

    public SearchResultPresenter(WeatherViewModel viewModel) {
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
