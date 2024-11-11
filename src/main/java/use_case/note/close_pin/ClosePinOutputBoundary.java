package use_case.note.close_pin;

public interface ClosePinOutputBoundary {

    void presentSuccessView(ClosePinOutputData closePinOutputData);

    void prepareFailView(String errorMessage);
}
