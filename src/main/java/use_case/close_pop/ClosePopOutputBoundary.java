package use_case.close_pop;

public interface ClosePopOutputBoundary {

    void presentSuccessView(ClosePopOutputData closePopOutputData);

    void prepareFailView(String errorMessage);
}
