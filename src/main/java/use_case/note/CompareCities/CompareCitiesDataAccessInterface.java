package use_case.note.CompareCities;

import entity.Weather;

public interface CompareCitiesDataAccessInterface {
    boolean citynotexist(String cityname);
    Weather getWeather(String cityname);
    void saveWeather(String cityname);
    String getCurrentCity();
    void setCurrentCity(String cityname);
}
