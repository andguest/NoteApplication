package use_case.note.return_home;

public interface ReturnHomeOutputBoundary {

    void presentSuccessView(ReturnHomeOutputData returnHomeOutputData);

    void prepareFailView(String errorMessage);
}
