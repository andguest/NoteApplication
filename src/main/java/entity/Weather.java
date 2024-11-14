package entity;

/**
 * The representation of a Weather Information Package.
 */
public class Weather {
    private final String city;
    private final int longitude;
    private final int latitude;

    private final int temperature;
    private final String looks;
    private final String alertDescription;
    private final int humidity;
    private final int windSpeed;

    public Weather(String city, int longitude, int latitude, int temperature, String looks, String alertDescription, int humidity, int windSpeed) {
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temperature = temperature;
        this.looks = looks;
        this.alertDescription = alertDescription;
        this.humidity = humidity;
        this.windSpeed = windSpeed;

    }

    public int getHumidity() {
        return humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public String getCity() {
        return city;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getLooks() {
        return looks;
    }

    public String getAlertDescription() {
        return alertDescription;
    }

}
