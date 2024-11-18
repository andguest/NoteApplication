package use_case.note.convert_farenheit;

public interface ConvertFarenheitInputBoundary {
    void executeConvert(ConvertFarenheitInputData convertFarenheitInputData);

    void convert(ConvertFarenheitInputData convertFarenheitInputData);
}
