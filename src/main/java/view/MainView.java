package view;

import interface_adapter.SearchResult.SearchResultViewModel;
import interface_adapter.nearby_cities.NearbyCitiesViewModel;
import interface_adapter.weather.WeatherViewModel;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;

public class MainView extends JFrame {
    public NearbyCitiesView nearbyCitiesView;
    public MapPanelView mapPanelView;
    public WeatherPanelView weatherPanelView;
    private HistoricalSearchedWeatherView historicalSearchedWeatherView;

    private final int frameWidth = 1500;
    private final int frameHeight = 1000;

    public MainView(NearbyCitiesViewModel nearbyCitiesViewModel, WeatherViewModel weatherViewModel, SearchResultViewModel searchResultViewModel, PropertyChangeEvent evt) {
        nearbyCitiesView = new NearbyCitiesView(nearbyCitiesViewModel, weatherViewModel);
        mapPanelView = new MapPanelView(weatherViewModel);
        weatherPanelView = new WeatherPanelView(weatherViewModel, evt);
        historicalSearchedWeatherView = new HistoricalSearchedWeatherView(searchResultViewModel, evt);
        this.setTitle("Weather Wizard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        // I choose to use 1X2 gridlayout so we can have both panel side by side
        this.setLayout(new GridLayout(1, 4));
        this.add(nearbyCitiesView);
        this.add(mapPanelView);
        this.add(weatherPanelView);
        this.add(historicalSearchedWeatherView);
        // pack() optimize window size
        this.pack();
        this.setVisible(true);

    }

//    public static void man(String[] args) {
//        new MainView();
//    }

}
