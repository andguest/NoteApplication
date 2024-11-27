package entity;

/**
 * The representation of a Weather object.
 */
public class Weather {

    private float temperature;
    private String weather;
    private final String alertDescription;
    private float windSpeed;
    private final int humidity;
    private final int visibility;
    private boolean metric;
    private String cityName;
    private final double lon;
    private final double lat;

    public Weather(String city, float temperature, String weather, String alertDescription,
                   float windSpeed, int humidity, int visibility, double lon, double lat) {
        this.temperature = temperature;
        this.weather = weather;
        this.alertDescription = alertDescription;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.visibility = visibility;
        this.cityName = city;
        this.metric = false;
        this.lon = lon;
        this.lat = lat;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getCityName() {
        return cityName;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public boolean isMetric() {
        return metric;
    }

    public void setMetric(boolean metric) {
        this.metric = metric;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return alertDescription;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWeather() {
        return weather;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getVisibility() {
        return visibility;
    }
}
