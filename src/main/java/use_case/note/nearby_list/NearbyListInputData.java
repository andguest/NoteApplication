package use_case.note.nearby_list;

/**
 * An input is when the map moves.
 */
public class NearbyListInputData {
    private final float longitude;
    private final float latitude;

    public NearbyListInputData(float longitude, float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }
}
