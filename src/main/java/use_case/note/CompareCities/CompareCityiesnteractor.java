package use_case.note.CompareCities;
import entity.Weather;
/*
* The Comparecities Interactor.
 */
public class CompareCityiesnteractor implements CompareCitiesInputBoundary {
    private final CompareCitiesDataAccessInterface compareCitiesDataAccessInterface;
    private final CompareCitiesOutputBoundary comparecitiesPresenter;

    public CompareCityiesnteractor(CompareCitiesDataAccessInterface compareCitiesDataAccessInterface,
                                   CompareCitiesOutputBoundary comparecitiesPresenter) {
        this.comparecitiesPresenter = comparecitiesPresenter;
        this.compareCitiesDataAccessInterface = compareCitiesDataAccessInterface;
    }

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
