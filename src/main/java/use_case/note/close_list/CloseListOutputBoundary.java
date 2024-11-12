package use_case.note.close_list;

public interface CloseListOutputBoundary {

    void presentSuccessView(CloseListOutputData closeListOutputData);

    void prepareFailView(String errorMessage);
}
