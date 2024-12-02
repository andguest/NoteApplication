package view;

import interface_adapter.nearby_cities.NearbyCitiesController;
import interface_adapter.nearby_cities.NearbyCitiesState;
import interface_adapter.nearby_cities.NearbyCitiesViewModel;
import interface_adapter.weather.WeatherController;
import interface_adapter.weather.WeatherState;
import interface_adapter.weather.WeatherViewModel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NearbyCitiesView extends JPanel implements PropertyChangeListener {
    private final JLabel listInputPanel;
    private final JList<String> cities;
    private final NearbyCitiesViewModel nearbyCitiesViewModel;
    private final WeatherViewModel weatherViewModel;

    private NearbyCitiesController nearbyCitiesController;
    private WeatherController weatherController;

    public NearbyCitiesView(NearbyCitiesViewModel nearbyCitiesViewModel, WeatherViewModel weatherViewModel) {
        this.nearbyCitiesViewModel = nearbyCitiesViewModel;
        this.weatherViewModel = weatherViewModel;
        this.nearbyCitiesViewModel.addPropertyChangeListener(this);
        this.weatherViewModel.addPropertyChangeListener(this);

        this.listInputPanel = new JLabel("Nearby cities (double click to select):");

        this.add(this.listInputPanel);

        cities = new JList<>();

        cities.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    weatherController.execute(cities.getSelectedValue());
                }
            }
        });

        this.add(cities);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("Weather")) {
            final WeatherState weatherState = (WeatherState) evt.getNewValue();
            nearbyCitiesController.execute(weatherState.getWeather().getLon(), weatherState.getWeather().getLat());
        }
        else if (evt.getPropertyName().equals("NearbyList")) {
            final NearbyCitiesState nearbyCitiesState = (NearbyCitiesState) evt.getNewValue();
            cities.setListData(nearbyCitiesState.getCities());
        }
    }

    public void setNearbyListController(NearbyCitiesController nearbyCitiesController) {
        this.nearbyCitiesController = nearbyCitiesController;
    }

    public void setWeatherController(WeatherController weatherController) {
        this.weatherController = weatherController;
    }

}
