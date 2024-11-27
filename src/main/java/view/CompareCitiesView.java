package view;

import interface_adapter.CompareCities.CompareCitiesState;
import interface_adapter.CompareCities.CompareCitiesViewModel;
import interface_adapter.weather.WeatherState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CompareCitiesView extends JFrame implements PropertyChangeListener {
    private final LabelTextPanel weatherincitypanelA;
    private final LabelTextPanel temperaturepanelA;
    private LabelTextPanel skyconditionpanelA;
    private LabelTextPanel humiditypanelA;
    private LabelTextPanel windspeedpanelA;
    private LabelTextPanel visibilitypanelA;

    private final JLabel cityA = new JLabel("");
    private final JLabel tempA = new JLabel("");
    private final JLabel skyconditionA = new JLabel("");
    private final JLabel humidityA = new JLabel("");
    private final JLabel windspeedA = new JLabel("");
    private final JLabel visibilityA = new JLabel("");

    private final LabelTextPanel weatherincitypanelB;
    private final LabelTextPanel temperaturepanelB;
    private LabelTextPanel skyconditionpanelB;
    private LabelTextPanel humiditypanelB;
    private LabelTextPanel windspeedpanelB;
    private LabelTextPanel visibilitypanelB;

    private final JLabel cityB = new JLabel("");
    private final JLabel tempB = new JLabel("");
    private final JLabel skyconditionB = new JLabel("");
    private final JLabel humidityB = new JLabel("");
    private final JLabel windspeedB = new JLabel("");
    private final JLabel visibilityB = new JLabel("");

    private CompareCitiesViewModel compareCitiesViewModel;

    public CompareCitiesView(CompareCitiesViewModel compareCitiesViewModel) {
        this.compareCitiesViewModel = compareCitiesViewModel;

        weatherincitypanelA = new LabelTextPanel(new JLabel("Current Weather in"), cityA);
        temperaturepanelA = new LabelTextPanel(new JLabel("Temperature"), tempA);
        skyconditionpanelA = new LabelTextPanel(new JLabel("Sky"), skyconditionA);
        humiditypanelA = new LabelTextPanel(new JLabel("Humidity"), humidityA);
        windspeedpanelA = new LabelTextPanel(new JLabel("Wind"), windspeedA);
        visibilitypanelA = new LabelTextPanel(new JLabel("Visibility"), visibilityA);

        weatherincitypanelB = new LabelTextPanel(new JLabel("Current Weather in"), cityB);
        temperaturepanelB = new LabelTextPanel(new JLabel("Temperature"), tempB);
        skyconditionpanelB = new LabelTextPanel(new JLabel("Sky"), skyconditionB);
        humiditypanelB = new LabelTextPanel(new JLabel("Humidity"), humidityB);
        windspeedpanelB = new LabelTextPanel(new JLabel("Wind"), windspeedB);
        visibilitypanelB = new LabelTextPanel(new JLabel("Visibility"), visibilityB);

        this.setLayout(new GridLayout(2, 6));
        this.add(weatherincitypanelA, BorderLayout.WEST);
        this.add(temperaturepanelA, BorderLayout.WEST);
        this.add(skyconditionpanelA, BorderLayout.WEST);
        this.add(humiditypanelA, BorderLayout.WEST);
        this.add(windspeedpanelA, BorderLayout.WEST);
        this.add(visibilitypanelA, BorderLayout.WEST);
        this.add(weatherincitypanelB, BorderLayout.EAST);
        this.add(temperaturepanelB, BorderLayout.EAST);
        this.add(skyconditionpanelB, BorderLayout.EAST);
        this.add(humiditypanelB, BorderLayout.EAST);
        this.add(windspeedpanelB, BorderLayout.EAST);
        this.add(visibilitypanelB, BorderLayout.EAST);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        final CompareCitiesState compareCitiesState = (CompareCitiesState) evt.getNewValue();
        setfield(compareCitiesState);
    }

    public void setfield(CompareCitiesState compareCitiesState) {
        cityA.setText(compareCitiesState.getFirstWeather().getCityName());
        tempA.setText(String.valueOf(compareCitiesState.getFirstWeather().getTemperature()));
        skyconditionA.setText(compareCitiesState.getFirstWeather().getWeather());
        humidityA.setText(String.valueOf(compareCitiesState.getFirstWeather().getHumidity()));
        windspeedA.setText(String.valueOf(compareCitiesState.getFirstWeather().getWindSpeed()));
        visibilityA.setText(String.valueOf(compareCitiesState.getFirstWeather().getVisibility()));
        cityB.setText(compareCitiesState.getSecondWeather().getCityName());
        tempB.setText(String.valueOf(compareCitiesState.getSecondWeather().getTemperature()));
        skyconditionB.setText(compareCitiesState.getSecondWeather().getWeather());
        humidityB.setText(String.valueOf(compareCitiesState.getSecondWeather().getHumidity()));
        windspeedB.setText(String.valueOf(compareCitiesState.getSecondWeather().getWindSpeed()));
        visibilityB.setText(String.valueOf(compareCitiesState.getSecondWeather().getVisibility()));
    }
}
