package entity;

/**
 * The representation of a password-protected user for our program.
 */
public class Weather {

    private float temperature;
    private String weather;
    private final String description;
    private float windSpeed;
    private final int humidity;
    private final int visibility;
    private boolean metric;
    private String cityName;
    private int lon;
    private int lat;

    public Weather(String city, float temperature, String weather, String description,
                   float windSpeed, int humidity, int visibility, int lon, int lat) {
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

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
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
