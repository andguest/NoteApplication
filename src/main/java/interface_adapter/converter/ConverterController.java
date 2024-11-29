package interface_adapter.converter;

import entity.Weather;
import use_case.note.convert_farenheit.ConvertFarenheitInputBoundary;
import use_case.note.convert_farenheit.ConvertFarenheitInputData;

/**
 * Controller for the convert case.
 */
public class ConverterController {
    private final ConvertFarenheitInputBoundary convertInteractor;

    public ConverterController(ConvertFarenheitInputBoundary cInteractor) {
        this.convertInteractor = cInteractor;
    }

    /**
     * Executes the convert case.
     * @param weather the note to be recorded
     */
    public void execute(Weather weather) {
        final ConvertFarenheitInputData inputData = new ConvertFarenheitInputData(weather);
        System.out.println("@ controller going to interactor");
        convertInteractor.executeConvert(inputData);

    }
}
