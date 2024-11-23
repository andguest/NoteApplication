package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

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
        final String propertyName = evt.getPropertyName();
        final String newValue = (String) evt.getNewValue();

        SwingUtilities.invokeLater(() -> {
            switch (propertyName) {
                case "city":
                    weatherfincitypanel.setoutput(newValue);
                    break;
                case "temperature":
                    temperaturepanel.setoutput(newValue);
                    break;
                case "skyCondition":
                    skyconditionpanel.setoutput(newValue);
                    break;
                case "humidity":
                    humiditypanel.setoutput(newValue);
                    break;
                case "windSpeed":
                    windspeedpanel.setoutput(newValue);
                    break;
                case "visibility":
                    visibilitypanel.setoutput(newValue);
                    break;
            }
    }

//    private void setFields(SearchResultState state) {
//    temperaturepanel.setText(state.getWeather().getTemperature());
//    }

}
