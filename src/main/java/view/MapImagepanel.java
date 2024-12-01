package view;

import interface_adapter.weather.WeatherState;
import interface_adapter.weather.WeatherViewModel;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/*
* the MapImagePanel is responsible for displaying the map file.
 */
public class MapImagepanel extends JPanel implements PropertyChangeListener {
    private static final int ZOOM_VALUE = 13;
    private static final int NUM_THREADS = 8;

    private final WeatherViewModel weatherViewModel;
    private GeoPosition position;
    private JXMapViewer mapViewer;

    // Generates a JXMapViewer object given latitude and longitude
    public MapImagepanel(WeatherViewModel weatherViewModel, double latitude, double longitude) {
        this.weatherViewModel = weatherViewModel;
        this.weatherViewModel.addPropertyChangeListener(this);

        this.mapViewer = new JXMapViewer();

        final TileFactoryInfo info = new OSMTileFactoryInfo();
        final DefaultTileFactory tileFactory = new DefaultTileFactory(info);

        this.mapViewer.setTileFactory(tileFactory);

        tileFactory.setThreadPoolSize(NUM_THREADS);

        this.position = new GeoPosition(latitude, longitude);

        this.mapViewer.setZoom(ZOOM_VALUE);
        mapViewer.setAddressLocation(position);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final WeatherState weatherState = (WeatherState) evt.getNewValue();
        setPosition(weatherState.getWeather().getLat(), weatherState.getWeather().getLon());

    }

    private void setPosition(double latitude, double longitude) {
        this.position = new GeoPosition(latitude, longitude);
        this.mapViewer.setAddressLocation(position);
    }

    public JXMapViewer getDisplayfield() {
        return this.mapViewer;
    }
}
