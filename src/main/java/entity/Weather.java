package entity;

/**
 * The representation of a password-protected user for our program.
 */
public class Weather {

    private final String name;

    public Weather(String cityname) {
        this.name = cityname;
    }

    public String getName() {
        return name;
    }

}
