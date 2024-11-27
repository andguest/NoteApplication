package interface_adapter.CompareCities;

import use_case.note.CompareCities.CompareCitiesOutPutData;
import use_case.note.CompareCities.CompareCitiesOutputBoundary;

/**
 * The Presenter for the Compare Cities Use case.
 */
public class CompareCitiesPresenter implements CompareCitiesOutputBoundary {
    private final CompareCitiesViewModel viewModel;

    public CompareCitiesPresenter(CompareCitiesViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // viewModel.getState will provide a CompareCitiesState
        viewModel.getState().setError(errorMessage);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(CompareCitiesOutPutData outputData) {
        viewModel.getState().setError(null);
        viewModel.getState().setFirstCityName(outputData.getFirstCityname());
        viewModel.getState().setSecondCityName(outputData.getSecondCityname());
        viewModel.getState().setFirstWeather(outputData.getFirstWeather());
        viewModel.getState().setSecondWeather(outputData.getSecondWeather());

        viewModel.firePropertyChanged("CompareCity");
    }
}

