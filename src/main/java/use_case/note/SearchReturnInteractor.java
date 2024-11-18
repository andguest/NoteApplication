import entity.Weather;
import use_case.note.WeatherDataAccessInterface;
import use_case.note.search_result.SearchResultOutputBoundary;
import use_case.note.search_return.SearchReturnInputBoundary;
import use_case.note.search_return.SearchReturnInputData;
import use_case.note.search_return.SearchReturnOutputBoundary;
import use_case.note.search_return.SearchReturnOutputData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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