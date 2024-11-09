package entity;

/**
 * The representation of a password-protected user for our program.
 */
public class weather {

    private final String city;
    private final int longitude;
    private final int latitude;

    public weather(String city, int longitude, int latitude) {
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return city;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }
}
