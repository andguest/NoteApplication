package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import interface_adapter.SearchResult.SearchResultState;
import interface_adapter.SearchResult.SearchResultViewModel;

/**
 * The View for when the user is viewing a note in the program.
 */
public class HistoricalSearchedWeatherView extends JPanel implements PropertyChangeListener {

    private static final int HISTORICALPANELWIDTH = 370;
    private static final int HISTORICALPANELHEIGHT = 400;
    private final SearchResultViewModel searchResultViewModel;
    private LabelTextPanel weatherfincitypanel;
    private LabelTextPanel temperaturepanel;
    private LabelTextPanel skyconditionpanel;
    private LabelTextPanel humiditypanel;
    private LabelTextPanel windspeedpanel;
    private LabelTextPanel visibilitypanel;
    private LabelTextPanel citypanel;

    private final JLabel emptylabel = new JLabel("");

    private final JLabel noteName = new JLabel("search result");
    private final JTextArea cityInputField = new JTextArea();
    private final JTextArea dateInputField = new JTextArea();
    private final JLabel city = new JLabel("");
    private final JLabel temp = new JLabel("");
    private final JLabel skycondition = new JLabel("");
    private final JLabel humidity = new JLabel("");
    private final JLabel windspeed = new JLabel("");
    private final JLabel visibility = new JLabel("");

    public HistoricalSearchedWeatherView(SearchResultViewModel searchResultViewModel, PropertyChangeEvent evt) {
        this.searchResultViewModel = searchResultViewModel;
        // Users can search for weather at a given time
        this.searchResultViewModel.addPropertyChangeListener(this);

        this.setSize(HISTORICALPANELWIDTH, HISTORICALPANELHEIGHT);
        weatherfincitypanel = new LabelTextPanel(new JLabel("Historic Weather in: "), city);
        temperaturepanel = new LabelTextPanel(new JLabel("Temperature: "), temp);
        // Note we  want to add a convertor here.The button needs an action listener.
        skyconditionpanel = new LabelTextPanel(new JLabel("Sky: "), skycondition);
        humiditypanel = new LabelTextPanel(new JLabel("Humidity: "), humidity);
        windspeedpanel = new LabelTextPanel(new JLabel("Wind: "), windspeed);
        visibilitypanel = new LabelTextPanel(new JLabel("Visibility: "), visibility);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(weatherfincitypanel);
        this.add(temperaturepanel);
        this.add(skyconditionpanel);
        this.add(humiditypanel);
        this.add(windspeedpanel);
        this.add(visibilitypanel);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final String propertyName = evt.getPropertyName();
        final String search = "searchResult";
        if (propertyName.equals(search)) {
            final SearchResultState state = (SearchResultState) evt.getNewValue();

            city.setText(state.getWeather().getCityName());
            temp.setText(state.getWeather().getTemperature() + "°C");
            skycondition.setText(state.getWeather().getWeather());
            humidity.setText(Math.abs(state.getWeather().getHumidity()) + "%");
            windspeed.setText(state.getWeather().getWindSpeed() + "m/s");
            visibility.setText(state.getWeather().getVisibility() + "m");

        }

    }
}
