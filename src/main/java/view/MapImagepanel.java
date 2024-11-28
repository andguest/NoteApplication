package view;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

import javax.swing.*;

/*
* the MapImagePanel is responsible for displaying the map file.
 */
public class MapImagepanel extends JPanel {
    private static final int ZOOM_VALUE = 15;
    private static final int NUM_THREADS = 8;

    private GeoPosition position;
    private JXMapViewer mapViewer;

    // Generates a JXMapViewer object given latitude and longitude
    public MapImagepanel(double latitude, double longitude) {
        this.mapViewer = new JXMapViewer();

        final TileFactoryInfo info = new OSMTileFactoryInfo();
        final DefaultTileFactory tileFactory = new DefaultTileFactory(info);

        this.mapViewer.setTileFactory(tileFactory);

        tileFactory.setThreadPoolSize(NUM_THREADS);

        this.position = new GeoPosition(latitude, longitude);

        this.mapViewer.setZoom(ZOOM_VALUE);
        mapViewer.setAddressLocation(position);
    }

    /**
     * Changes the map's position.
     * @param latitude the latitude of the new position
     * @param longitude the longitude of the new position
     */
    public void setPosition(double latitude, double longitude) {
        this.position = new GeoPosition(latitude, longitude);
        this.mapViewer.setAddressLocation(position);
    }

    public JXMapViewer getDisplayfield() {
        return this.mapViewer;
    }
}
