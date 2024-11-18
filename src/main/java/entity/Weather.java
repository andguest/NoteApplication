package entity;

/**
 * The representation of a password-protected user for our program.
 */
public class Weather {

    private float temperature;
    private String weather;
    private final String description;
    private final String icon;
    private float windSpeed;
    private final int humidity;
    private final int visibility;
    private boolean metric;

    public Weather(float temperature, String weather, String description, String icon, float windSpeed, int humidity,
                   int visibility) {
        this.temperature = temperature;
        this.weather = weather;
        this.description = description;
        this.icon = icon;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.visibility = visibility;
        this.metric = false;
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

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public void setWeather(double weather) {
        this.weather = weather;
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
