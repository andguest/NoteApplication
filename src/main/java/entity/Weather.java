package entity;

/**
 * The representation of a password-protected user for our program.
 */
public class Weather {

    private double temperature;
    private String weather;
    private final String description;
    private double windSpeed;
    private final int humidity;
    private final int visibility;
    private boolean metric;
    private String cityName;
    private double lon;
    private double lat;
    private final String alertDescription;

    public Weather(String city, double temperature, String weather, String description, double windSpeed,
                   int humidity, int visibility, double lon, double lat, String alertDescription) {
        this.temperature = temperature;
        this.weather = weather;
        this.description = description;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.visibility = visibility;
        this.cityName = city;
        this.metric = false;
        this.lon = lon;
        this.lat = lat;
        this.alertDescription = alertDescription;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
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
        return description;
    }

    public String getAlertDescription() {
        return alertDescription;

    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWeather() {
        return weather;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getVisibility() {
        return visibility;
    }
}