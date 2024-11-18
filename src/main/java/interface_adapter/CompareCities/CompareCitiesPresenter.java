package interface_adapter.CompareCities;

import interface_adapter.weather.WeatherViewModel;
import use_case.note.CompareCities.CompareCitiesOutPutData;
import use_case.note.CompareCities.CompareCitiesOutputBoundary;

public class CompareCitiesPresenter implements CompareCitiesOutputBoundary {
    private final WeatherViewModel viewModel;
    public CompareCitiesPresenter(WeatherViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareFailView(String errorMessage) {
        viewModel.getState().setError(errorMessage);
        viewModel.firePropertyChanged();
    }
    @Override
    public void prepareSuccessView(CompareCitiesOutPutData outputData) {
        viewModel.getState().setError(null);
        viewModel.firePropertyChanged();
    }
}
