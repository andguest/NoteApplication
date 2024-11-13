package view;

import interface_adapter.note.WeatherViewModel;

import javax.swing.JFrame;
import java.awt.GridLayout;

public class MainView extends JFrame {
    private MapPanelView mapPanelView;
    private WeatherPanelView weatherPanelView;
    private final int frameWidth = 1200;
    private final int frameHeight = 1000;

    public MainView(WeatherViewModel weatherViewModel) {
        mapPanelView = new MapPanelView();
        weatherPanelView = new WeatherPanelView(weatherViewModel);
        this.setTitle("Weather Wizard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        // I choose to use 1X2 gridlayout so we can have both panel side by side
        this.setLayout(new GridLayout(1, 2));
        this.add(mapPanelView);
        this.add(weatherPanelView);
        // pack() optimize window size
        this.pack();
        this.setVisible(true);

    }
//    public static void man(String[] args) {
//        new MainView();
//    }

}
