package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data_access.WeatherDataAccessObject;
import entity.Weather;
import interface_adapter.SearchResult.SearchResultViewModel;
import interface_adapter.converter.ConverterController;
//import interface_adapter.weather.WeatherController;
import interface_adapter.weather.WeatherState;
import interface_adapter.weather.WeatherViewModel;

/**
 * This class responsible for creating the Weather Subpanel of the main. The Weather subpanel itself contains a bunch
 * of LabelTextPanel that displays varies weather information.
 * This part of view will have to change based on the output, so it depends on the view model
 **/
public class WeatherPanelView extends JPanel implements PropertyChangeListener, ActionListener {
    private final WeatherViewModel weatherViewModel;
    private SearchResultViewModel searchResultViewModel;

    private final LabelTextPanel weatherincitypanel;
    private final LabelTextPanel temperaturepanel;
    private LabelTextPanel skyconditionpanel;
    private LabelTextPanel humiditypanel;
    private LabelTextPanel windspeedpanel;
    private LabelTextPanel visibilitypanel;
    private LabelTextPanel timepanel;
    private LabelTextPanel unitpanel;
    private Weather currentWeather;

    private final JLabel metric = new JLabel("Metric");
    private final JLabel city = new JLabel("");
    private final JLabel temp = new JLabel("");
    private final JLabel skycondition = new JLabel("");
    private final JLabel humidity = new JLabel("");
    private final JLabel windspeed = new JLabel("");
    private final JLabel visibility = new JLabel("");
    private final JLabel time = new JLabel("");
    private final JButton unitconverter;

    private ConverterController convertorController;
    private static final int WEATHER_PANEL_WIDTH = 370;
    private static final int WEATHERPANELHEIGHT = 400;

    public WeatherPanelView(WeatherViewModel weatherViewModel, PropertyChangeEvent evt) {
        this.weatherViewModel = weatherViewModel;
        this.weatherViewModel.addPropertyChangeListener(this);

        this.setSize(WEATHER_PANEL_WIDTH, WEATHERPANELHEIGHT);
        weatherincitypanel = new LabelTextPanel(new JLabel("Current Weather in"), city);
        temperaturepanel = new LabelTextPanel(new JLabel("Temperature"), temp);
        timepanel = new LabelTextPanel(new JLabel("Time"), time);
        // Note we  want to add a convertor that convert the weather information from degree celsius to fahrenheit,
        // or the opposite.The button needs an action listener that pass the change to a ConverterController.
        this.unitconverter = new JButton("Unit Converter");
        unitconverter.addActionListener(event -> {
            // if the event is coming from temperature converter button, execute convertor controller
            if (event.getSource() == unitconverter) {

                if (city != null) {
                    final Weather tempWeather = currentWeather;
                    convertorController.execute(tempWeather);
                    System.out.println("worked");
                    System.out.println(tempWeather.getCityName());
                }

            }
        });

        unitpanel = new LabelTextPanel(new JLabel("Unit"), metric);
        skyconditionpanel = new LabelTextPanel(new JLabel("Sky: "), skycondition);
        humiditypanel = new LabelTextPanel(new JLabel("Humidity: "), humidity);
        windspeedpanel = new LabelTextPanel(new JLabel("Wind: "), windspeed);
        visibilitypanel = new LabelTextPanel(new JLabel("Visibility: "), visibility);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(weatherincitypanel);
        this.add(temperaturepanel);
        this.add(skyconditionpanel);
        this.add(humiditypanel);
        this.add(windspeedpanel);
        this.add(visibilitypanel);
        this.add(unitconverter);
        this.add(unitpanel);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final WeatherState weatherState = (WeatherState) evt.getNewValue();
        setfield(weatherState);
        this.currentWeather = weatherState.getWeather();
        System.out.println(weatherState.getWeather());
    }

    public void setfield(WeatherState weatherState) {
        final boolean metric1 = weatherState.getWeather().isMetric();
        if (metric1) {
            metric.setText("Metric");
        }
        else {
            metric.setText("Imperial");
        }

        city.setText(weatherState.getWeather().getCityName());
        temp.setText(String.valueOf(weatherState.getWeather().getTemperature()));
        skycondition.setText(weatherState.getWeather().getWeather());
        humidity.setText(String.valueOf(weatherState.getWeather().getHumidity()));
        windspeed.setText(String.valueOf(weatherState.getWeather().getWindSpeed()));
        visibility.setText(String.valueOf(weatherState.getWeather().getVisibility()));
        final DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH").withZone(ZoneOffset.UTC);
        final String timestamp = formatter.format(Instant.now());
        time.setText(timestamp);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println("Enter" + event.getActionCommand());

    }

    public void setConverterController(ConverterController converterController) {
        this.convertorController = converterController;
    }
}
