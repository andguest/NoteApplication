package view;

import interface_adapter.note.WeatherViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observer;

/*
 * This class responsible for creating the Weather Subpanel of the main. The Weather subpanel itself contains a bunch
 * of LabelTextPanel that displays varies weather information.
 * This part of view will have to change based on the output, so it depends on the view model.
 */
public class WeatherPanelView extends JPanel implements PropertyChangeListener {
    private final WeatherViewModel weatherViewModel;

    private final LabelTextPanel weatherfincitypanel;
    private final LabelTextPanel temperaturepanel;
    private final LabelTextPanel skyconditionpanel;
    private final LabelTextPanel humiditypanel;
    private final LabelTextPanel windspeedpanel;
    private final LabelTextPanel visibilitypanel;

    private final JLabel emptylabel = new JLabel("");
    private final int weatherpanelwidth = 370;
    private final int weatherpanelheight = 400;

    public WeatherPanelView(WeatherViewModel weatherViewModel) {
        this.weatherViewModel = weatherViewModel;
        this.weatherViewModel.addPropertyChangeListener(this);

        this.setSize(weatherpanelwidth, weatherpanelheight);
        weatherfincitypanel = new LabelTextPanel(new JLabel("Weather in"), emptylabel);
        temperaturepanel = new LabelTextPanel(new JLabel("Temperature"), emptylabel);
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
    }
    /*
    * method listens for changes in the WeatherViewModel and updates each LabelTextPanel based on the new data.
     */
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
