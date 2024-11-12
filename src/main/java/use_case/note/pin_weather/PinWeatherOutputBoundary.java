package use_case.note.pin_weather;

public interface PinWeatherOutputBoundary {

    void presentSuccessView(PinWeatherOutputData pinWeatherOutputData);

    void prepareFailView(String errorMessage);
}
