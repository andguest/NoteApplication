package use_case.note.nearby_list;

/**
 * This one only has the input of clicking "open list," whereas the centre of the location is chosen prior to that.
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
