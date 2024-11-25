package interface_adapter.weather;

import use_case.note.search_return.SearchReturnOutputBoundary;
import use_case.note.search_return.SearchReturnOutputData;

/**
 * The presenter for the weather use case.
 */
public class WeatherPresenter implements SearchReturnOutputBoundary {

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
    public void presentSuccessView(SearchReturnOutputData response) {
        weatherViewModel.getState().setWeather(response.getWeather());
        weatherViewModel.getState().setError(null);
        weatherViewModel.firePropertyChanged("Weather");
    }

    /**
     * Prepares the failure view for the Weather related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        weatherViewModel.getState().setError(errorMessage);
        weatherViewModel.firePropertyChanged();
    }
}
