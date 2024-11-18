package use_case.pin_weather;

public class PinWeatherOutputData {

    private final String weatherInfo;
    private final boolean useCaseFailed;

    public PinWeatherOutputData(String weatherInfo, boolean useCaseFailed) {
        this.weatherInfo = weatherInfo;
        this.useCaseFailed = useCaseFailed;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
