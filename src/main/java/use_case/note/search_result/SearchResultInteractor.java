package use_case.note.search_result;

import java.io.IOException;

import entity.Weather;
import use_case.note.HistoricalWeatherDataAccessInterface;
import use_case.note.WeatherDataAccessInterface;

/**
 * The interactor for the search result use case.
 */
public class SearchResultInteractor implements SearchResultInputBoundary {
    private final SearchResultOutputBoundary outputBoundary;
    private final WeatherDataAccessInterface weatherDataAccess;
    private final HistoricalWeatherDataAccessInterface historicalWeatherDataAccessInterface;

    public SearchResultInteractor(SearchResultOutputBoundary outputBoundary,
                                  WeatherDataAccessInterface weatherDataAccess, HistoricalWeatherDataAccessInterface
                                          historicalDataInterface) {
        this.outputBoundary = outputBoundary;
        this.weatherDataAccess = weatherDataAccess;
        this.historicalWeatherDataAccessInterface = historicalDataInterface;
    }

    @Override
    public void execute(SearchResultInputData searchReturnInputData) {
        try {
            final String city = searchReturnInputData.getCity();
            final String timestamp = searchReturnInputData.getDate();
            // Simulate reading weather data
//            final Weather weatherData = weatherDataAccess.getWeather(city);

            final Weather historicalWeather = historicalWeatherDataAccessInterface.getWeather(city.toLowerCase(), timestamp);

            // Send it to the output boundary
            final SearchResultOutputData outputData =
                    new SearchResultOutputData(historicalWeather, false);
            historicalWeatherDataAccessInterface.saveWeather(historicalWeather, timestamp);
            outputBoundary.presentSuccessView(outputData);

        }
        catch (IOException exception) {
            // Handle exception if weather data retrieval fails and send failure view
            outputBoundary.presentFailView("Failed to retrieve weather data: " + exception.getMessage());
        }
    }

}
