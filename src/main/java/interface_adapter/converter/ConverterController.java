package interface_adapter.converter;

import entity.Weather;
import use_case.note.convert_farenheit.ConvertFarenheitInputBoundary;
import use_case.note.convert_farenheit.ConvertFarenheitInputData;

/**
 * The Controller for the Convert Units Use case.
 */

public class ConverterController {
    private static ConvertFarenheitInputBoundary convertInteractor;

    public ConverterController(ConvertFarenheitInputBoundary cInteractor) {
        convertInteractor = cInteractor;
    }

    /**
     * Executes the convert case.
     * @param weather the note to be recorded
     */
    public static void execute(Weather weather) {
        final ConvertFarenheitInputData inputData = new ConvertFarenheitInputData(weather);
        convertInteractor.executeConvert(inputData);
    }
}
