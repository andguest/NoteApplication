package use_case.note.nearby_list;

/**
 * An input is when the map moves.
 */
public class NearbyListInputData {
    private final double longitude;
    private final double latitude;

    public NearbyListInputData(double longitude, double latitude) {
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
