package use_case.note;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import entity.Weather;
import use_case.note.search_result.SearchResultInputBoundary;
import use_case.note.search_result.SearchResultInputData;
import use_case.note.search_result.SearchResultOutputBoundary;
import use_case.note.search_result.SearchResultOutputData;

/**
 * The interactor for the search result use case.
 */
public class SearchResultInteractor implements SearchResultInputBoundary {
    private final SearchResultOutputBoundary outputBoundary;
    private final WeatherDataAccessInterface weatherDataAccess;
    private final HistoricalWeatherDataAccessInterface historicalWeatherDataAccessInterface;

    public SearchResultInteractor(SearchResultOutputBoundary outputBoundary, WeatherDataAccessInterface weatherDataAccess,
                                 HistoricalWeatherDataAccessInterface historicalDataInterface ) {
        this.outputBoundary = outputBoundary;
        this.weatherDataAccess = weatherDataAccess;
        this.historicalWeatherDataAccessInterface = historicalDataInterface;
    }

    @Override
    public void execute(SearchResultInputData searchReturnInputData) {
        try {
            final String city = searchReturnInputData.getCity();
            // Simulate reading weather data
            final Weather weatherData = weatherDataAccess.getWeather(city);

            // Store it in historical data
            final DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("UTC"));
            final String timestamp = formatter.format(Instant.now());

            final Weather historicalWeather = historicalWeatherDataAccessInterface.getWeather(city, timestamp);

            // Send it to the output boundary
            final SearchResultOutputData outputData =
                    new SearchResultOutputData(historicalWeather, false);
            historicalWeatherDataAccessInterface.saveWeather(weatherData, timestamp);
            outputBoundary.presentSuccessView(outputData);

        }
        catch (IOException exception) {
            // Handle exception if weather data retrieval fails and send failure view
            outputBoundary.presentFailView("Failed to retrieve weather data: " + exception.getMessage());
        }
    }

}
