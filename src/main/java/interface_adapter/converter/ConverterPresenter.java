package interface_adapter.converter;

import interface_adapter.weather.WeatherViewModel;
import use_case.note.convert_farenheit.ConvertFarenheitOutputBoundary;
import use_case.note.convert_farenheit.ConvertFarenheitOutputData;

public class ConverterPresenter implements ConvertFarenheitOutputBoundary {
    private final WeatherViewModel viewModel;

    public ConverterPresenter(WeatherViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareFailView(String errorMessage) {
        viewModel.getState().setError(errorMessage);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(ConvertFarenheitOutputData outputData) {
        final String weather = viewModel.getState().getWeather();
        viewModel.getState().setWeather(weather);
        viewModel.getState().setError(null);
        viewModel.firePropertyChanged();
    }
}
