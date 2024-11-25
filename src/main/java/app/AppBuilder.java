package app;

import javax.swing.*;

import interface_adapter.SearchResult.SearchResultController;
import interface_adapter.SearchResult.SearchResultPresenter;
import interface_adapter.alert_pop.AlertPopController;
import interface_adapter.alert_pop.AlertPopPresenter;
import interface_adapter.converter.ConverterController;
import interface_adapter.converter.ConverterPresenter;
import interface_adapter.weather.WeatherViewModel;
import use_case.note.HistoricalWeatherDataAccessInterface;
import use_case.note.SearchResultInteractor;
import use_case.note.WeatherDataAccessInterface;
import use_case.note.alert_pop.AlertPopInteractor;
import use_case.note.alert_pop.AlertPopOutputBoundary;
import use_case.note.convert_farenheit.ConvertFarenheitOutputBoundary;
import use_case.note.convert_farenheit.ConvertInteractor;
import use_case.note.search_result.SearchResultOutputBoundary;
import view.MainView;

import java.awt.*;

/**
 * Builder for the Note Application.
 */
public class AppBuilder {

    public static final int HEIGHT = 750;
    public static final int WIDTH = 1500;
    private WeatherDataAccessInterface weatherDAO;
    private HistoricalWeatherDataAccessInterface historyDAO;
    private WeatherViewModel weatherViewModel = new WeatherViewModel();
    private MainView mainView;
    private NoteInteractor interactor;

    /**
     * Sets the DAO to be used in this application.
     * @param weatherDataAccess the DAO to use
     * @return this builder
     */
    public AppBuilder addNoteDAO(WeatherDataAccessInterface weatherDataAccess) {
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

        // refresh so that the note will be visible when we start the program
        interactor.executeRefresh();

        return frame;

    }

    /**
     * Creates the objects for the Note Use Case and connects the NoteView to its
     * controller.
     * <p>This method must be called after addNoteView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addNoteView

     */

    public AppBuilder addSearchResultUseCase() {
        final SearchResultOutputBoundary outputBoundary = new SearchResultPresenter(weatherViewModel);
        final SearchResultInteractor interactor = new SearchResultInteractor(outputBoundary, weatherDAO, historyDAO);

        final SearchResultController controller = new SearchResultController(interactor);
        if (mainView == null) {
            throw new RuntimeException("addNoteView must be called before addSearchResultUseCase");
        }
        mainView.setController(controller);
        return this;
    }

    public AppBuilder addAlertPopUseCase() {
        final AlertPopOutputBoundary alertPopOutputBoundary = new AlertPopPresenter(weatherViewModel);
        final AlertPopInteractor alertPopInteractor = new AlertPopInteractor(weatherDAO, alertPopOutputBoundary);

        final AlertPopController controller = new AlertPopController(alertPopInteractor);
        if (mainView == null) {
            throw new RuntimeException("addNoteView must be called before addSearchResultUseCase");
        }
        mainView.setAlertPopController(controller);
        return this;
    }

    public AppBuilder addSearchReturnUseCase() {
        // no presenter / controller
    }

    public AppBuilder addSelectRegionUseCase() {
        // no presenter / controller
    }

    public AppBuilder addNearbyListUseCase() {
        // no presenter / controller
    }

    public AppBuilder addCompareCitiesUseCase() {
        // no controller
    }

    public AppBuilder addConvertUseCase() {
        final ConvertFarenheitOutputBoundary outputBoundary = new ConverterPresenter(weatherViewModel);
        final ConvertInteractor interactor = new ConvertInteractor(outputBoundary);

        final ConverterController controller = new ConverterController(interactor);
        if (mainView == null) {
            throw new RuntimeException("addNoteView must be called before addConvertUseCase");
        }
        mainView.setController(controller);
        return this;
    }

    public AppBuilder addCloseListUseCase() {
        // no presenter / controller
    }

    public AppBuilder addPinWeatherUseCase() {
        // no presenter / controller
    }

    public AppBuilder addClosePinUseCase() {
        // no presenter / controller
    }

    public AppBuilder addClosePopUseCase() {
        // no presenter / controller
    }

    public AppBuilder addBookmarkReturnCase() {
        // no presenter / controller
    }

    public AppBuilder addCityBookmarkUseCase() {
        // no presenter / controller
    }

    // add stuff for all the views
    public AppBuilder addSearchResultView() {
    }

    public AppBuilder addSelectRegionView() {
    }

    public AppBuilder addNearbyListView() {
    }

    public AppBuilder addPinWeatherView() {
    }

    public AppBuilder addAlertPopView() {
    }

    public AppBuilder addCityBookmarkView() {
    }

    public AppBuilder addMainView() {
        weatherViewModel = new WeatherViewModel();
        mainView = new MainView(weatherViewModel);
        return this;
    }
}
