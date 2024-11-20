package interface_adapter.alert_pop;

import use_case.note.alert_pop.AlertPopInputBoundary;
import use_case.note.alert_pop.AlertPopInputData;

public class AlertPopController {
    private final AlertPopInputBoundary alertPopInputInteractor;

    public alertPopController(AlertPopInputBoundary alertPopInputInteractor) {
        this.alertPopInputInteractor = alertPopInputInteractor;
    }

    /**
     * Executes the Alert Pop Use Case.
     * @param cityName the name of the user's city.
     */
    public void execute(String cityName) {
        final AlertPopInputData alertPopInputData = new AlertPopInputData(cityName);

        alertPopInputInteractor.execute(alertPopInputData);
    }
}
