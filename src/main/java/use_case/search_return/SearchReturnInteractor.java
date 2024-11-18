package use_case.search_return;

import entity.Weather;
import use_case.WeatherDataAccessInterface;
import use_case.search_result.SearchResultOutputBoundary;

import java.util.HashMap;
import java.util.Map;

public class SearchReturnInteractor implements SearchReturnInputBoundary {
    private final SearchResultOutputBoundary outputBoundary;
    private final WeatherDataAccessInterface weatherDataAccess;
    private final Map<String, Weather> historicalWeatherData;

    public SearchReturnInteractor(SearchResultOutputBoundary outputBoundary, WeatherDataAccessInterface weatherDataAccess) {
        this.outputBoundary = outputBoundary;
        this.weatherDataAccess = weatherDataAccess;
        this.historicalWeatherData = new HashMap<>();
    }

    @Override
    public void execute(SearchReturnInputData searchReturnInputData) {

    }
}