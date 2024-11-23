package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import entity.Weather;
import interface_adapter.SearchResult.SearchResultState;
import interface_adapter.SearchResult.SearchResultViewModel;

/**
 * The View for when the user is viewing a note in the program.
 */
public class HistoricalSearchedWeatherView extends JPanel implements PropertyChangeListener {

    private final SearchResultViewModel searchResultViewModel;
    private LabelTextPanel weatherfincitypanel;
    private LabelTextPanel temperaturepanel;
    private LabelTextPanel skyconditionpanel;
    private LabelTextPanel humiditypanel;
    private LabelTextPanel windspeedpanel;
    private LabelTextPanel visibilitypanel;
    private LabelTextPanel citypanel;
//    private LabelTextPanel metrixPanel;

    private final JLabel emptylabel = new JLabel("");

    private final JLabel noteName = new JLabel("search result");
    private final JTextArea cityInputField = new JTextArea();
    private final JTextArea dateInputField = new JTextArea();
    private static final int HISTORICALPANELWIDTH = 370;
    public static final int HISTORICALPANELHEIGHT = 400;

    //    private final JButton cityButton = new JButton("Searched City");
//    private final JButton dateButton = new JButton("Date");
//    private final JLabel cityLabel = new JLabel("City:");
//    private final JLabel dateLabel = new JLabel("Date:");
//    private final JButton searchButton = new JButton("Search");
    public HistoricalSearchedWeatherView(SearchResultViewModel searchResultViewModel,
                        PropertyChangeEvent evt) {
        this.searchResultViewModel = searchResultViewModel;
        // Users can search for weather at a given time
        this.searchResultViewModel.addPropertyChangeListener(this);

        this.setSize(HISTORICALPANELWIDTH, HISTORICALPANELHEIGHT);
        weatherfincitypanel = new LabelTextPanel(new JLabel("Weather in"), emptylabel);
        temperaturepanel = new LabelTextPanel(new JLabel("Temperature"), emptylabel);
        // Note we  want to add a convertor here.The button needs an action listener.
        citypanel = new LabelTextPanel(new JLabel("City"), emptylabel);
//        metrixPanel = new LabelTextPanel(new JLabel("Metrix"), emptylabel);
        skyconditionpanel = new LabelTextPanel(new JLabel("Sky"), emptylabel);
        humiditypanel = new LabelTextPanel(new JLabel("Humidity"), emptylabel);
        windspeedpanel = new LabelTextPanel(new JLabel("Wind"), emptylabel);
        visibilitypanel = new LabelTextPanel(new JLabel("Visibility"), emptylabel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(weatherfincitypanel);
        this.add(temperaturepanel);
        this.add(skyconditionpanel);
        this.add(humiditypanel);
        this.add(windspeedpanel);
        this.add(visibilitypanel);
        this.add(citypanel);
//        this.add(metrixPanel);
        }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final String propertyName = evt.getPropertyName();
        final SearchResultState state = (SearchResultState) evt.getNewValue();
        final Weather searchedWeather = state.getWeather();


        SwingUtilities.invokeLater(() -> {
            switch (propertyName) {
                case "city":
                    weatherfincitypanel.setoutput(searchedWeather.getCityName());
                    break;
                case "temperature":
                    float temperature = searchedWeather.getTemperature();
                    String temperatureString = String.valueOf(temperature);
                    temperaturepanel.setoutput(temperatureString);
                    break;
                case "skyCondition":
                    skyconditionpanel.setoutput(searchedWeather.getDescription());
                    break;
                case "humidity":
                    int humidity = searchedWeather.getHumidity();
                    String humidityString = String.valueOf(humidity);
                    humiditypanel.setoutput(humidityString););
                    break;
                case "windSpeed":
                    float windSpeed = searchedWeather.getWindSpeed();
                    String windSpeedString = String.valueOf(windSpeed);
                    windspeedpanel.setoutput(windSpeedString);
                    break;
                case "visibility":
                    int visibility = searchedWeather.getVisibility();
                    String visibilityString = String.valueOf(visibility);
                    visibilitypanel.setoutput(visibilityString);
                    break;
            }
    });

//    private void setFields(SearchResultState state) {
//    temperaturepanel.setText(state.getWeather().getTemperature());
//    }

}
