package view;

import entity.Weather;
import interface_adapter.converter.ConverterController;
import interface_adapter.SearchResult.SearchResultViewModel;
import interface_adapter.weather.WeatherViewModel;
import interface_adapter.weather.WeatherController;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * This class responsible for creating the Weather Subpanel of the main. The Weather subpanel itself contains a bunch
 * of LabelTextPanel that displays varies weather information.
 * This part of view will have to change based on the output, so it depends on the view model
 **/
public class WeatherPanelView extends JPanel implements PropertyChangeListener, ActionListener {
    private final WeatherViewModel weatherViewModel;
    private SearchResultViewModel searchResultViewModel;

    private final LabelTextPanel weatherfincitypanel;
    private final LabelTextPanel temperaturepanel;
    private LabelTextPanel skyconditionpanel;
    private LabelTextPanel humiditypanel;
    private LabelTextPanel windspeedpanel;
    private LabelTextPanel visibilitypanel;
    private LabelTextPanel searchresultpanel;

    private final JLabel emptylabel = new JLabel("");
    private final JButton temperatureconverter;
    private WeatherController weatherController;
    private static final int WEATHER_PANEL_WIDTH = 370;
    public static final int WEATHERPANELHEIGHT = 400;

    public WeatherPanelView(WeatherViewModel weatherViewModel, SearchResultViewModel searchResultViewModel,
                            PropertyChangeEvent evt) {
        this.weatherViewModel = weatherViewModel;
        this.weatherViewModel.addPropertyChangeListener(this);
        // Users can search for weather at a given time
        this.searchResultViewModel = searchResultViewModel;
        this.searchResultViewModel.addPropertyChangeListener(this);

        this.setSize(WEATHER_PANEL_WIDTH, WEATHERPANELHEIGHT);
        weatherfincitypanel = new LabelTextPanel(new JLabel("Weather in"), emptylabel);
        temperaturepanel = new LabelTextPanel(new JLabel("Temperature"), emptylabel);
        // Note we  want to add a convertor here.The button needs an action listener.
        this.temperatureconverter = new JButton("Temperature Converter");
        temperatureconverter.addActionListener(event -> {
            // if the event is coming from cityinput field, execute controller
            if (event.getSource() == temperatureconverter) {
                ConverterController.execute((Weather) evt.getSource());
            }

            skyconditionpanel = new LabelTextPanel(new JLabel("Sky"), emptylabel);
            humiditypanel = new LabelTextPanel(new JLabel("Humidity"), emptylabel);
            windspeedpanel = new LabelTextPanel(new JLabel("Wind"), emptylabel);
            visibilitypanel = new LabelTextPanel(new JLabel("Visibility"), emptylabel);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.add(weatherfincitypanel);
            this.add(temperaturepanel);
            this.add(temperatureconverter);
            this.add(skyconditionpanel);
            this.add(humiditypanel);
            this.add(windspeedpanel);
            this.add(visibilitypanel);
        });
        /*
         * method listens for changes in the WeatherViewModel and updates each LabelTextPanel based on the new data.
         */

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
        });
    }
}
