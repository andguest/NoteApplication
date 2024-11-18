package use_case.close_list;

public interface CloseListOutputBoundary {

    void presentSuccessView(CloseListOutputData closeListOutputData);

    void prepareFailView(String errorMessage);
}
