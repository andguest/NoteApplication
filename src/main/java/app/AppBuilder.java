package app;

import javax.swing.*;

import data_access.WeatherDataAccessObject;
import entity.Weather;
import interface_adapter.CompareCities.CompareCitiesController;
import interface_adapter.CompareCities.CompareCitiesPresenter;
import interface_adapter.CompareCities.CompareCitiesViewModel;
import interface_adapter.SearchResult.SearchResultController;
import interface_adapter.SearchResult.SearchResultPresenter;
import interface_adapter.SearchResult.SearchResultViewModel;
import interface_adapter.alert_pop.AlertPopController;
import interface_adapter.alert_pop.AlertPopPresenter;
import interface_adapter.converter.ConverterController;
import interface_adapter.converter.ConverterPresenter;
import interface_adapter.nearby_list.NearbyListController;
import interface_adapter.nearby_list.NearbyListPresenter;
import interface_adapter.nearby_list.NearbyListViewModel;
import interface_adapter.weather.WeatherController;
import interface_adapter.weather.WeatherPresenter;
import interface_adapter.weather.WeatherState;
import interface_adapter.weather.WeatherViewModel;
import use_case.note.CompareCities.CompareCitiesDataAccessInterface;
import use_case.note.CompareCities.CompareCitiesInteractor;
import use_case.note.CompareCities.CompareCitiesOutputBoundary;
import use_case.note.HistoricalWeatherDataAccessInterface;
import use_case.note.search_result.SearchResultInteractor;
import use_case.note.search_return.SearchReturnInteractor;
import use_case.note.WeatherDataAccessInterface;
import use_case.note.alert_pop.AlertPopInteractor;
import use_case.note.alert_pop.AlertPopOutputBoundary;
import use_case.note.convert_farenheit.ConvertFarenheitOutputBoundary;
import use_case.note.convert_farenheit.ConvertInteractor;
import use_case.note.nearby_list.NearbyCitiesAccessInterface;
import use_case.note.nearby_list.NearbyListInteractor;
import use_case.note.nearby_list.NearbyListOutputBoundary;
import use_case.note.search_result.SearchResultOutputBoundary;
import use_case.note.search_return.SearchReturnOutputBoundary;
import view.MainView;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * Builder for the Note Application.
 */
public class AppBuilder {

    public static final int HEIGHT = 750;
    public static final int WIDTH = 1500;
    private WeatherDataAccessInterface weatherDAO;
    private HistoricalWeatherDataAccessInterface historyDAO;
    private WeatherViewModel weatherViewModel = new WeatherViewModel();
    private SearchResultViewModel searchResultViewModel = new SearchResultViewModel();
    private CompareCitiesViewModel compareCitiesViewModel = new CompareCitiesViewModel();
    private NearbyListViewModel nearbyListViewModel = new NearbyListViewModel();
    private MainView mainView;
    private PropertyChangeEvent evt;

    /**
     * Sets the DAO to be used in this application.
     * @param weatherDataAccess the DAO to use
     * @return this builder
     */
    public AppBuilder addDAO(WeatherDataAccessInterface weatherDataAccess) {
        weatherDAO = weatherDataAccess;
        return this;
    }

    /**
     * Builds the application.
     * @return the JFrame for the application
     */
    public JFrame build() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Weather Wizard");
        frame.setSize(WIDTH, HEIGHT);

        frame.add(mainView);

        return frame;

    }

    /**
     * Creates the objects for the Note Use Case and connects the NoteView to its
     * controller.
     * <p>This method must be called after addNoteView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addNoteView

     **/
    public AppBuilder addAlertPopUseCase() {
        final AlertPopOutputBoundary outputBoundary = new AlertPopPresenter(weatherViewModel);
        final WeatherDataAccessInterface accessInterface = new WeatherDataAccessInterface() {
            @Override
            public Weather getWeather(String city) throws IOException {
                return WeatherDataAccessObject.getWeather(city);
            }

        };

        final AlertPopInteractor interactor = new AlertPopInteractor(accessInterface, outputBoundary);

        final AlertPopController controller = new AlertPopController(interactor);
        if (mainView == null) {
            throw new RuntimeException("Error");
        }
        return this;
    }


    public AppBuilder addCompareCitiesUseCase() {
        final CompareCitiesOutputBoundary outputBoundary = new CompareCitiesPresenter(compareCitiesViewModel);
        final CompareCitiesDataAccessInterface dai = new CompareCitiesDataAccessInterface() {
            @Override
            public boolean isCityexist(String cityname) {
                return false;
            }
            @Override
            public Weather getWeather(String cityname) throws IOException {
                return null;
            }

            @Override
            public void saveWeatherinfor(Weather weather) {

            }

            @Override
            public Map getcitytoweather() {
                return Map.of();
            }

            @Override
            public boolean isCityExist(String cityname) {
                return false;
            }

            @Override
            public void clearcitytoweather() {

            }
        };

        final CompareCitiesInteractor interactor = new CompareCitiesInteractor(dai, outputBoundary);

        final CompareCitiesController controller = new CompareCitiesController(interactor);
        if (mainView == null) {
            throw new RuntimeException("Error");
        }
        return this;
    }

    public AppBuilder addConvertUseCase() {
        final ConvertFarenheitOutputBoundary outputBoundary = new ConverterPresenter(weatherViewModel);
        final ConvertInteractor interactor = new ConvertInteractor(outputBoundary);

        final ConverterController controller = new ConverterController(interactor);
        if (mainView == null) {
            throw new RuntimeException("Error");
        }
        return this;
    }
    public AppBuilder addNearbyListUseCase() {
        final NearbyListOutputBoundary outputBoundary = new NearbyListPresenter(nearbyListViewModel);
        final NearbyCitiesAccessInterface dai = new NearbyCitiesAccessInterface() {
            @Override
            public List<String> getNearbyCities(Float latitude, Float longitude) throws IOException {
                return List.of();
            }
        };

        final NearbyListInteractor interactor = new NearbyListInteractor(outputBoundary, dai);

        final NearbyListController controller = new NearbyListController(interactor);
        if (mainView == null) {
            throw new RuntimeException("Error");
        }
        return this;
    }

    public AppBuilder addSearchReturnUseCase() {
        final SearchReturnOutputBoundary outputBoundary = new WeatherPresenter(weatherViewModel);
        final SearchReturnInteractor interactor = new SearchReturnInteractor(outputBoundary, weatherDAO);

        final WeatherController controller = new WeatherController(interactor);
        if (mainView == null) {
            throw new RuntimeException("Error");
        }
        return this;
    }

    public AppBuilder addSearchResultUseCase() {
        final SearchResultOutputBoundary outputBoundary = new SearchResultPresenter(searchResultViewModel);
        final SearchResultInteractor interactor = new SearchResultInteractor(outputBoundary, weatherDAO, historyDAO);

        final SearchResultController controller = new SearchResultController(interactor);
        if (mainView == null) {
            throw new RuntimeException("Error");
        }
        return this;
    }

    // add stuff for all the views
    public AppBuilder addMainView() {
        weatherViewModel = new WeatherViewModel();
        searchResultViewModel = new SearchResultViewModel();
        evt = new PropertyChangeEvent(weatherViewModel,"Weather", null, new WeatherState());
        mainView = new MainView(weatherViewModel, searchResultViewModel, evt);
        return this;
    }
}
