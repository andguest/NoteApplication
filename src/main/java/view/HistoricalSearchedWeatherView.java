package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import entity.Weather;
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

    public HistoricalSearchedWeatherView(SearchResultViewModel searchResultViewModel,
                                         PropertyChangeEvent evt) {
        this.searchResultViewModel = searchResultViewModel;
        // Users can search for weather at a given time
        this.searchResultViewModel.addPropertyChangeListener(this);

        this.setSize(HISTORICALPANELWIDTH, HISTORICALPANELHEIGHT);
        weatherfincitypanel = new LabelTextPanel(new JLabel("Searched Weather"), emptylabel);
        temperaturepanel = new LabelTextPanel(new JLabel("Temperature"), emptylabel);
        // Note we  want to add a convertor here.The button needs an action listener.
        citypanel = new LabelTextPanel(new JLabel("City"), emptylabel);
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
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        final String propertyName = evt.getPropertyName();
//        final SearchResultState state = (SearchResultState) evt.getNewValue();
//        final Weather searchedWeather = state.getWeather();
//        if (evt.getPropertyName().equals("searchedWeather")) {
            final SearchResultState state = (SearchResultState) evt.getNewValue();
            final Weather searchedWeather = state.getWeather();
//            SwingUtilities.invokeLater(() -> {
                weatherfincitypanel.setoutput(searchedWeather.getCityName());
                temperaturepanel.setoutput(String.valueOf(searchedWeather.getTemperature()));
                skyconditionpanel.setoutput(searchedWeather.getDescription());
                humiditypanel.setoutput(String.valueOf(searchedWeather.getHumidity()));
                windspeedpanel.setoutput(String.valueOf(searchedWeather.getWindSpeed()));
                visibilitypanel.setoutput(String.valueOf(searchedWeather.getVisibility()));
                citypanel.setoutput(searchedWeather.getCityName());
//            });
//        }

//        SwingUtilities.invokeLater(() -> {
//        changeProperty(propertyName, searchedWeather);
//        });

    }

//    private void changeProperty(String propertyName, Weather searchedWeather) {
//        if (propertyName.equals("searchedWeather")) {
//            weatherfincitypanel.setoutput(searchedWeather.getCityName());
//            temperaturepanel.setoutput(String.valueOf(searchedWeather.getTemperature()));
//            skyconditionpanel.setoutput(searchedWeather.getDescription());
//            humiditypanel.setoutput(String.valueOf(searchedWeather.getHumidity()));
//            windspeedpanel.setoutput(String.valueOf(searchedWeather.getWindSpeed()));
//            visibilitypanel.setoutput(String.valueOf(searchedWeather.getVisibility()));
//            citypanel.setoutput(searchedWeather.getCityName());
//        }
//    }
//        switch (propertyName) {
//            case "city":
//                weatherfincitypanel.setoutput(searchedWeather.getCityName());
//                break;
//            case "temperature":
//                final double temperature = searchedWeather.getTemperature();
//                final String temperatureString = String.valueOf(temperature);
//                temperaturepanel.setoutput(temperatureString);
//                break;
//            case "skyCondition":
//                skyconditionpanel.setoutput(searchedWeather.getDescription());
//                break;
//            case "humidity":
//                final int humidity = searchedWeather.getHumidity();
//                final String humidityString = String.valueOf(humidity);
//                humiditypanel.setoutput(humidityString);
//                break;
//            case "windSpeed":
//                final double windSpeed = searchedWeather.getWindSpeed();
//                final String windSpeedString = String.valueOf(windSpeed);
//                windspeedpanel.setoutput(windSpeedString);
//                break;
//            case "visibility":
//                final int visibility = searchedWeather.getVisibility();
//                final String visibilityString = String.valueOf(visibility);
//                visibilitypanel.setoutput(visibilityString);
//                break;
//            default:
//                System.out.println("Unknown property: " + propertyName);
//                break;
//        }
//    }
}
