package use_case.note.nearby_cities;

/**
 * An input is when the map moves.
 */
public class NearbyCitiesInputData {
    private final double longitude;
    private final double latitude;

    public NearbyCitiesInputData(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
