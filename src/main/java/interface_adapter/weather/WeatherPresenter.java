package interface_adapter.weather;

import use_case.note.search_result.SearchResultOutputBoundary;
import use_case.note.search_result.SearchResultOutputData;

/**
 * The presenter for the
 */
public class WeatherPresenter implements SearchResultOutputBoundary {

    private final WeatherViewModel weatherViewModel;

    public WeatherPresenter(WeatherViewModel weatherViewModel) {
        this.weatherViewModel = weatherViewModel;
    }

    /**
     * Prepares the success view for the Weather related Use Cases.
     *
     * @param response the output data
     */
    @Override
    public void presentSuccessView(SearchResultOutputData response) {
        weatherViewModel.getState().setWeather(response.getWeather());
        weatherViewModel.getState().setError(null);
        weatherViewModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view for the Weather related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void presentFailView(String errorMessage) {
        weatherViewModel.getState().setError(errorMessage);
        weatherViewModel.firePropertyChanged();
    }
}
