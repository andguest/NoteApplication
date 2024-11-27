package view;

import interface_adapter.SearchResult.SearchResultController;
import interface_adapter.SearchResult.SearchResultViewModel;
import interface_adapter.weather.WeatherViewModel;

import javax.swing.*;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;

public class MainView extends JPanel {
    private MapPanelView mapPanelView;
    private WeatherPanelView weatherPanelView;
    private HistoricalSearchedWeatherView historicalSearchedWeatherView;
    private final int frameWidth = 1200;
    private final int frameHeight = 1000;

    public MainView(WeatherViewModel weatherViewModel, SearchResultViewModel searchResultViewModel,
                    PropertyChangeEvent evt) {
        mapPanelView = new MapPanelView();
        weatherPanelView = new WeatherPanelView(weatherViewModel, searchResultViewModel, evt);
        this.setSize(frameWidth, frameHeight);
        // I choose to use 1X2 gridlayout so we can have both panel side by side
        this.setLayout(new GridLayout(1, 2));
        this.add(mapPanelView);
        this.add(weatherPanelView);
        this.add(historicalSearchedWeatherView);
        // pack() optimize window size
        this.setVisible(true);

    }

}
