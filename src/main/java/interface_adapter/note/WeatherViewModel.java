package interface_adapter.note;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the NoteView.
 */
public class WeatherViewModel extends ViewModel<WeatherState> {
    public WeatherViewModel() {
        super("weather");
        setState(new WeatherState());
    }
}
