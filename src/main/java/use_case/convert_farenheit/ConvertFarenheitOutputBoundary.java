package use_case.convert_farenheit;

public interface ConvertFarenheitOutputBoundary {
    void prepareFailView(String errorMessage);

    void prepareSuccessView(ConvertFarenheitOutputData outputData);
}
