package view;

import interface_adapter.nearby_list.NearbyListController;
import interface_adapter.nearby_list.NearbyListState;
import interface_adapter.nearby_list.NearbyListViewModel;
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
    private final NearbyListViewModel nearbyListViewModel;
    private final WeatherViewModel weatherViewModel;

    private NearbyListController nearbyListController;
    private WeatherController weatherController;

    public NearbyCitiesView(NearbyListViewModel nearbyListViewModel, WeatherViewModel weatherViewModel) {
        this.nearbyListViewModel = nearbyListViewModel;
        this.weatherViewModel = weatherViewModel;
        this.nearbyListViewModel.addPropertyChangeListener(this);
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
            nearbyListController.execute(weatherState.getWeather().getLon(), weatherState.getWeather().getLat());
        }
        else if (evt.getPropertyName().equals("NearbyList")) {
            final NearbyListState nearbyListState = (NearbyListState) evt.getNewValue();
            cities.setListData(nearbyListState.getCities());
        }
    }

    public void setNearbyListController(NearbyListController nearbyListController) {
        this.nearbyListController = nearbyListController;
    }

    public void setWeatherController(WeatherController weatherController) {
        this.weatherController = weatherController;
    }

}
