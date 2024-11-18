package use_case.return_home;

public interface ReturnHomeOutputBoundary {

    void presentSuccessView(ReturnHomeOutputData returnHomeOutputData);

    void prepareFailView(String errorMessage);
}
