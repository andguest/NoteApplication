package use_case.note;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import entity.Weather;
import use_case.note.search_result.SearchResultInputBoundary;
import use_case.note.search_result.SearchResultInputData;
import use_case.note.search_result.SearchResultOutputBoundary;
import use_case.note.search_result.SearchResultOutputData;

/**
 * The interactor for the search result use case..
 */
public class SearchResultInteractor implements SearchResultInputBoundary {
    private final SearchResultOutputBoundary outputBoundary;
    private final WeatherDataAccessInterface weatherDataAccess;
    private final Map<String, Weather> historicalWeatherData;

    public SearchResultInteractor(SearchResultOutputBoundary outputBoundary, WeatherDataAccessInterface weatherDataAccess) {
        this.outputBoundary = outputBoundary;
        this.weatherDataAccess = weatherDataAccess;
        this.historicalWeatherData = new HashMap<>();
    }

    @Override
    public void execute(SearchResultInputData searchReturnInputData) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable weatherTask = () -> {
            fetchWeatherData();
        };

        // Schedule the task to run every hour
        scheduler.scheduleAtFixedRate(weatherTask, 0, 1, TimeUnit.HOURS);
    }

    private void fetchWeatherData() {
        try {
            final String city = SearchResultInputData.getCity();
            // Simulate reading weather data
            final Weather weatherData = weatherDataAccess.getWeather(city);

            // Store it in historical data
            final String timestamp = String.valueOf(System.currentTimeMillis());
            historicalWeatherData.put(timestamp, weatherData);

            // Send it to the output boundary
            final SearchResultOutputData outputData =
                    new SearchResultOutputData(city, weatherData, false);
            outputBoundary.presentSuccessView(outputData);
        }
        catch (IOException exception) {
            // Handle exception if weather data retrieval fails and send failure view
            outputBoundary.presentFailView("Failed to retrieve weather data: " + exception.getMessage());
        }
    }

}
