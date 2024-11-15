package interface_adapter.weather;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the WeatherView.
 */
public class WeatherViewModel extends ViewModel<WeatherState> {
    public WeatherViewModel() {
        super("weather");
        setState(new WeatherState());
    }
}
