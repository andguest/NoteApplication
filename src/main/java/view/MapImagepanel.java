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
    private static final int ZOOM_VALUE = 7;
    private static final int NUM_THREADS = 8;

    private double[] coords;
    private JXMapViewer mapViewer;

    // Generates a JXMapViewer object given latitude and longitude
    public MapImagepanel(double latitude, double longitude) {
        this.coords = new double[] {latitude, longitude};
        this.mapViewer = new JXMapViewer();

        final TileFactoryInfo info = new OSMTileFactoryInfo();
        final DefaultTileFactory tileFactory = new DefaultTileFactory(info);

        this.mapViewer.setTileFactory(tileFactory);

        tileFactory.setThreadPoolSize(NUM_THREADS);

        final GeoPosition position = new GeoPosition(this.coords);

        this.mapViewer.setZoom(ZOOM_VALUE);
        mapViewer.setAddressLocation(position);
    }

    public JXMapViewer getDisplayfield() {
        return this.mapViewer;
    }
}
