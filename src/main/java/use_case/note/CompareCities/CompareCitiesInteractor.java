package use_case.note.CompareCities;

import entity.Weather;

/*
* The Comparecities Interactor.
 */
public class CompareCitiesInteractor implements CompareCitiesInputBoundary {
    private final CompareCitiesDataAccessInterface compareCitiesDataAccessInterface;
    private final CompareCitiesOutputBoundary comparecitiesPresenter;

    public CompareCitiesInteractor(CompareCitiesDataAccessInterface compareCitiesDataAccessInterface,
                                   CompareCitiesOutputBoundary comparecitiesPresenter) {
        this.comparecitiesPresenter = comparecitiesPresenter;
        this.compareCitiesDataAccessInterface = compareCitiesDataAccessInterface;
    }

    // when execute by controller, call presenter to prepare fail or success view. If success, make a new a outputdata
    // and put it into presenter
    public void execute(CompareCitiesInputData compareCitiesInputData) {
        final String firstcityname = compareCitiesInputData.getFirstcityname();
        final String secondcityname = compareCitiesInputData.getSecondcityname();
        if (firstcityname.equals(secondcityname)) {
            comparecitiesPresenter.prepareFailView("Cannot compare the same city");
        }
        else {
            if ((!compareCitiesDataAccessInterface.citynotexist(firstcityname))
                || (!compareCitiesDataAccessInterface.citynotexist(secondcityname))) {
                comparecitiesPresenter.prepareFailView("city not found");
            }
            else {
                final Weather firstweather = compareCitiesDataAccessInterface.getWeather(firstcityname);
                final Weather secondweather = compareCitiesDataAccessInterface.getWeather(secondcityname);
                final CompareCitiesOutPutData compareCitiesOutPutData = new CompareCitiesOutPutData(firstweather, secondweather, false);
                comparecitiesPresenter.prepareSuccessView(compareCitiesOutPutData);
            }
        }
    }
}
