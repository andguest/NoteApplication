package use_case.note.convert_farenheit;

public interface ConvertFarenheitOutputBoundary {
    void presentSuccessView(ConvertFarenheitOutputData data);

    void prepareFailView(String errorMessage);
}
