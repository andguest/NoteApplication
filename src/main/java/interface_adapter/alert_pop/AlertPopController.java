package interface_adapter.alert_pop;

import use_case.note.alert_pop.AlertPopInputBoundary;
import use_case.note.alert_pop.AlertPopInputData;

/**
 * The controller for the Alert Pop Use Case.
 */
public class AlertPopController {
    private final AlertPopInputBoundary alertPopInteractor;

    public AlertPopController(AlertPopInputBoundary alertPopInteractor) {
        this.alertPopInteractor = alertPopInteractor;
    }

    /**
     * Executes the Alert Pop Use Case.
     * @param cityName the name of the user's city.
     */
    public void execute(String cityName) {
        final AlertPopInputData alertPopInputData = new AlertPopInputData(cityName);

        alertPopInteractor.execute(alertPopInputData);
    }
}
