package use_case.convert_farenheit;

import entity.Weather;

public class ConvertFarenheitInputData {
    public Weather weather;

    public ConvertFarenheitInputData(Weather weather) {
        this.weather = weather;
    }
}
