package interface_adapter.CompareCities;

import use_case.note.CompareCities.CompareCitiesInputBoundary;
import use_case.note.CompareCities.CompareCitiesInputData;

public class CompareCitiesController {
    private final CompareCitiesInputBoundary interactor;
    public CompareCitiesController(CompareCitiesInputBoundary interactor) {
        this.interactor = interactor;
    }
    public void execute(String firstcityName, String secondcityName) {
        final CompareCitiesInputData compareCitiesInputData = new CompareCitiesInputData(firstcityName, secondcityName);
        interactor.execute(compareCitiesInputData);
    }
}
