package view;

import interface_adapter.SearchResult.SearchResultViewModel;
import interface_adapter.weather.WeatherViewModel;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;

public class MainView extends JFrame {
    private MapPanelView mapPanelView;
    private WeatherPanelView weatherPanelView;
    private SearchResultPanelView searchResultPanelView;

    private final int frameWidth = 1500;
    private final int frameHeight = 1000;

    public MainView(WeatherViewModel weatherViewModel, SearchResultViewModel searchResultViewModel, PropertyChangeEvent evt) {
        mapPanelView = new MapPanelView();
        weatherPanelView = new WeatherPanelView(weatherViewModel, searchResultViewModel, evt);
        this.setTitle("Weather Wizard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        // I choose to use 1X2 gridlayout so we can have both panel side by side
        this.setLayout(new GridLayout(1, 3));
        this.add(mapPanelView);
        this.add(weatherPanelView);
        this.add(searchResultPanelView);
        // pack() optimize window size
        this.pack();
        this.setVisible(true);

    }

//    public static void man(String[] args) {
//        new MainView();
//    }

}
