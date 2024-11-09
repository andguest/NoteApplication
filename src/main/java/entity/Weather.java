package entity;

/**
 * The representation of a password-protected user for our program.
 */
public class Weather {

    private final float temperature;
    private final String weather;
    private final String description;
    private final String icon;
    private final float windSpeed;
    private final int humidity;
    private final int visibility;


    public Weather(float temperature, String weather, String description, String icon, float windSpeed, int humidity,
                   int visibility) {
        this.temperature = temperature;
        this.weather = weather;
        this.description = description;
        this.icon = icon;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.visibility = visibility;
    }

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
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
