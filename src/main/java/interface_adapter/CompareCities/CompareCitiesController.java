package interface_adapter.CompareCities;

import use_case.note.CompareCities.CompareCitiesInputBoundary;
import use_case.note.CompareCities.CompareCitiesInputData;
/**
 * The Controller for teh Compare Cities Use case.
 */

public class CompareCitiesController {
    private final CompareCitiesInputBoundary interactor;

    public CompareCitiesController(CompareCitiesInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * The execute method.
     * @param firstcityName is the first city to compare.
     * @param secondcityName  is the second city.
     */
    public void execute(String firstcityName, String secondcityName) {
        final CompareCitiesInputData compareCitiesInputData = new CompareCitiesInputData(firstcityName, secondcityName);
        interactor.execute(compareCitiesInputData);
    }
}
