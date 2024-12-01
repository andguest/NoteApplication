package use_case.note.convert_farenheit;

public class ConvertInteractor implements ConvertFarenheitInputBoundary {
    public static final double KILOMETERS_MILE = 0.62;
    public static final double CELC_FAREN = 1.8;
    public static final double FAREN_ADD = 32;
    private static final int ABSOLUTEZERO = -500;

    private final ConvertFarenheitOutputBoundary oBounds;

    public ConvertInteractor(ConvertFarenheitOutputBoundary convertFarenheitOutputBoundary) {
        this.oBounds = convertFarenheitOutputBoundary;
    }

    @Override
    public void executeConvert(ConvertFarenheitInputData cInputData) {

        if (cInputData.weather != null) {

            convert(cInputData);
            System.out.println(" @ the interactor about to show view");

            final ConvertFarenheitOutputData outputData = new ConvertFarenheitOutputData(cInputData.weather, false);
            oBounds.prepareSuccessView(outputData);
        }
        else {

            oBounds.prepareFailView("UNABLE TO CONVERT");
        }
    }

    @Override
    public void convert(ConvertFarenheitInputData cInputData) {

        final int temp = (int) Math.floor(cInputData.weather.getTemperature() * CELC_FAREN + FAREN_ADD);

        final int speed = (int) Math.floor(cInputData.weather.getWindSpeed() * KILOMETERS_MILE);

        if (cInputData.weather.getfaren() == ABSOLUTEZERO) {
            // set instance variables
            System.out.println("intial setting");
            cInputData.weather.setfarenheit(temp);
            cInputData.weather.setMiles(speed);

            // update view
            System.out.println("updated view");
            cInputData.weather.setWindSpeed(speed);
            cInputData.weather.setTemperature(temp);

            cInputData.weather.setMetric(false);
        }
        else if (cInputData.weather.isMetric()) {

            cInputData.weather.setWindSpeed(cInputData.weather.getMiles());
            cInputData.weather.setTemperature(cInputData.weather.getfaren());
            cInputData.weather.setMetric(false);
        }
        else {
            cInputData.weather.setWindSpeed(cInputData.weather.getKilometers());
            cInputData.weather.setTemperature(cInputData.weather.getCelcius());
            cInputData.weather.setMetric(true);
        }
    }

}

