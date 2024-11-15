package entity;

public class Converter {
    public static final double KILOMETERS_MILE = 0.62;
    public static final double CELC_FAREN = 1.8;
    public static final double FAREN_ADD = 32;

    public Converter(Weather weather) {
        weather.setWindSpeed((int) (weather.getWindSpeed() * KILOMETERS_MILE));
        weather.setTemperature((int) ((weather.getTemperature() * CELC_FAREN)+ FAREN_ADD));

    }
}
