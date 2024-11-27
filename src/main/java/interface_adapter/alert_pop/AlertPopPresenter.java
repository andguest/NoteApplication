package interface_adapter.alert_pop;

import interface_adapter.weather.WeatherViewModel;
import use_case.note.alert_pop.AlertPopOutputBoundary;
import use_case.note.alert_pop.AlertPopOutputData;

/**
 * This is the Presenter for the ALERT POP use case.
 */
public class AlertPopPresenter implements AlertPopOutputBoundary {
    private final WeatherViewModel viewModel;

    public AlertPopPresenter(WeatherViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(AlertPopOutputData alertPopOutputData) {

        viewModel.getState().setAlert(alertPopOutputData.getAlert());
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String message) {
        viewModel.getState().setAlert(message);
        viewModel.firePropertyChanged();
    }

}
