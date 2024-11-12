package use_case.note.alert_pop;

public interface AlertPopOutputBoundary {

    void prepareSuccessView(AlertPopOutputData alertPopOutputData);

    void prepareFailView(String errorMessage);
}
