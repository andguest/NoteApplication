package use_case.convert_farenheit;

public interface ConvertFarenheitInputBoundary {
    void executeConvert(ConvertFarenheitInputData convertFarenheitInputData);

    void convert(ConvertFarenheitInputData convertFarenheitInputData);
}
