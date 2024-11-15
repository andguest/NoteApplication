package interface_adapter.weather;

import use_case.note.NoteOutputBoundary;

/**
 * The presenter for our Note viewing and editing program.
 */
public class WeatherPresenter implements NoteOutputBoundary {

    private final WeatherViewModel weatherViewModel;

    public WeatherPresenter(WeatherViewModel weatherViewModel) {
        this.weatherViewModel = weatherViewModel;
    }

    /**
     * Prepares the success view for the Weather related Use Cases.
     *
     * @param weather the output data
     */
    @Override
    public void prepareSuccessView(String weather) {
        weatherViewModel.getState().setWeather(weather);
        weatherViewModel.getState().setError(null);
        weatherViewModel.firePropertyChanged();
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
