package use_case.alert_pop;

public interface AlertPopOutputBoundary {

    void prepareSuccessView(AlertPopOutputData alertPopOutputData);

    void prepareFailView(String errorMessage);
}
