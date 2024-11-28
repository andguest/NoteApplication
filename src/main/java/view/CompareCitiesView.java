package view;

import interface_adapter.CompareCities.CompareCitiesState;
import interface_adapter.CompareCities.CompareCitiesViewModel;

import javax.swing.*;
import java.awt.*;

public class CompareCitiesView extends JFrame {
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

    private LabelTextPanel travelcityA;
    private LabelTextPanel travelcityB;

    private final JLabel cityB = new JLabel("");
    private final JLabel tempB = new JLabel("");
    private final JLabel skyconditionB = new JLabel("");
    private final JLabel humidityB = new JLabel("");
    private final JLabel windspeedB = new JLabel("");
    private final JLabel visibilityB = new JLabel("");

    private final int frameheight = 600;
    private final int framewidth = 1000;
    private JLabel reasonA;
    private JLabel reasonB;

    private CompareCitiesViewModel viewModel;

    public CompareCitiesView(CompareCitiesViewModel viewModel) {
        this.viewModel = viewModel;
//        viewModel.addPropertyChangeListener(this);
        final CompareCitiesState compareCitiesState = this.viewModel.getState();
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

        if (Math.max(Double.parseDouble(tempA.getText()),
                Double.parseDouble(tempB.getText())) == Double.parseDouble(tempA.getText())) {
            reasonA = new JLabel("Warmer Temperature \uD83D\uDD25");
        }
        else {
            reasonA = new JLabel("Cooler Temperature ⛄");
        }
        travelcityA = new LabelTextPanel(new JLabel("Travel to this city if you like: "), reasonA);

        if ("Clouds".equals(skyconditionB.getText())) {
            reasonB = new JLabel("Clouds ☁");
        }
        else if ("Clear".equals(skyconditionB.getText())){
            reasonB = new JLabel("Sunshine ☀");
        }
        else {
            reasonB = new JLabel("Rainy \uD83C\uDF27\uFE0F");
        }

        travelcityB = new LabelTextPanel(new JLabel("Travel to this city if you like: "), reasonB);

        this.setLayout(new GridLayout(7, 2));
        this.add(weatherincitypanelA);
        this.add(weatherincitypanelB);
        this.add(temperaturepanelA);
        this.add(temperaturepanelB);
        this.add(skyconditionpanelA);
        this.add(skyconditionpanelB);
        this.add(humiditypanelA);
        this.add(humiditypanelB);
        this.add(windspeedpanelA);
        this.add(windspeedpanelB);
        this.add(visibilitypanelA);
        this.add(visibilitypanelB);
        this.add(travelcityA);
        this.add(travelcityB);
        this.setSize(framewidth, frameheight);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

//    public void propertyChange(PropertyChangeEvent evt) {
//        final CompareCitiesState compareCitiesState = (CompareCitiesState) evt.getNewValue();
//        setfield(compareCitiesState);
//    }
//
//    public void setfield(CompareCitiesState compareCitiesState) {
//        final CompareCitiesState compareCitiesState = this.viewModel.getState();
//        cityA.setText(compareCitiesState.getFirstWeather().getCityName());
//        tempA.setText(String.valueOf(compareCitiesState.getFirstWeather().getTemperature()));
//        skyconditionA.setText(compareCitiesState.getFirstWeather().getWeather());
//        humidityA.setText(String.valueOf(compareCitiesState.getFirstWeather().getHumidity()));
//        windspeedA.setText(String.valueOf(compareCitiesState.getFirstWeather().getWindSpeed()));
//        visibilityA.setText(String.valueOf(compareCitiesState.getFirstWeather().getVisibility()));
//        cityB.setText(compareCitiesState.getSecondWeather().getCityName());
//        tempB.setText(String.valueOf(compareCitiesState.getSecondWeather().getTemperature()));
//        skyconditionB.setText(compareCitiesState.getSecondWeather().getWeather());
//        humidityB.setText(String.valueOf(compareCitiesState.getSecondWeather().getHumidity()));
//        windspeedB.setText(String.valueOf(compareCitiesState.getSecondWeather().getWindSpeed()));
//        visibilityB.setText(String.valueOf(compareCitiesState.getSecondWeather().getVisibility()));
//    }
}
