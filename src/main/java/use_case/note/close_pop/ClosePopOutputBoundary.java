package use_case.note.close_pop;

public interface ClosePopOutputBoundary {

    void presentSuccessView(ClosePopOutputData closePopOutputData);

    void prepareFailView(String errorMessage);
}
