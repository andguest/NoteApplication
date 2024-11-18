package use_case.note.convert_farenheit;

import entity.Weather;

public class ConvertFarenheitOutputData {
    private final boolean useCaseFailed;
    private final Weather weather;

    public ConvertFarenheitOutputData(Weather weather, boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
        this.weather = weather;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public Weather getWeather() {
        return weather;
    }
}
