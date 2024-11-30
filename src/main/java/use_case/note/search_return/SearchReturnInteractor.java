package use_case.note.search_return;

import entity.Weather;
import use_case.note.HistoricalWeatherDataAccessInterface;
import use_case.note.WeatherDataAccessInterface;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * The interactor for the search return use case.
 */
public class SearchReturnInteractor implements SearchReturnInputBoundary {
    private final SearchReturnOutputBoundary outputBoundary;
    private final WeatherDataAccessInterface weatherDataAccess;
    private final HistoricalWeatherDataAccessInterface historicalWeatherDataAccessInterface;

    public SearchReturnInteractor(SearchReturnOutputBoundary outputBoundary,
                                  WeatherDataAccessInterface weatherDataAccess,
                                  HistoricalWeatherDataAccessInterface historicalWeatherDataAccessInterface) {
        this.outputBoundary = outputBoundary;
        this.weatherDataAccess = weatherDataAccess;
        this.historicalWeatherDataAccessInterface = historicalWeatherDataAccessInterface;
    }

    @Override
    public void execute(SearchReturnInputData searchReturnInputData) {
        try {
            final String city = searchReturnInputData.getCity();
            // Simulate reading weather data
            final Weather weatherData = weatherDataAccess.getWeather(city);

            // Store it in historical data
            final DateTimeFormatter formatter = DateTimeFormatter
                    .ofPattern("yyyy-MM-dd HH").withZone(ZoneOffset.UTC);
            final String timestamp = formatter.format(Instant.now());
            historicalWeatherDataAccessInterface.saveWeather(weatherData, timestamp);
            // Send it to the output boundary
            final SearchReturnOutputData outputData =
                    new SearchReturnOutputData(weatherData, false);
            outputBoundary.presentSuccessView(outputData);

        }
        catch (IOException exception) {
            // Handle exception if weather data retrieval fails and send failure view
            outputBoundary.prepareFailView("Failed to retrieve weather data: " + exception.getMessage());
        }

    }
}