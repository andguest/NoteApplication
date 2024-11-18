package use_case.convert_farenheit;

public class ConvertInteractor implements ConvertFarenheitInputBoundary {
    public static final double KILOMETERS_MILE = 0.62;
    public static final double CELC_FAREN = 1.8;
    public static final double FAREN_ADD = 32;

    private final ConvertFarenheitOutputBoundary oBounds;

    public ConvertInteractor(ConvertFarenheitOutputBoundary convertFarenheitOutputBoundary) {
        this.oBounds = convertFarenheitOutputBoundary;
    }

    @Override
    public void executeConvert(ConvertFarenheitInputData cInputData) {
        if (cInputData.weather != null) {

            convert(cInputData);

            final ConvertFarenheitOutputData outputData = new ConvertFarenheitOutputData(cInputData.weather, true);
            oBounds.prepareSuccessView(outputData);
        }
        else {

            oBounds.prepareFailView("UNABLE TO CONVERT");
        }
    }

    @Override
    public void convert(ConvertFarenheitInputData cInputData) {

        if (cInputData.weather.isMetric()) {
            cInputData.weather.setWindSpeed((int) (cInputData.weather.getWindSpeed() * KILOMETERS_MILE));
            cInputData.weather.setTemperature((float) ((cInputData.weather.getTemperature() * CELC_FAREN) + FAREN_ADD));
            cInputData.weather.setMetric(false);
        }
        else {
            cInputData.weather.setWindSpeed((int) (cInputData.weather.getWindSpeed() / KILOMETERS_MILE));
            cInputData.weather.setTemperature((int) ((cInputData.weather.getTemperature() - FAREN_ADD) / CELC_FAREN));
            cInputData.weather.setMetric(true);
        }
    }

}

