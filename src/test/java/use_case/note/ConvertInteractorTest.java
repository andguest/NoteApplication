//package use_case.note;
//
//import data_access.WeatherDataAccessObject;
//import entity.Weather;
//import org.junit.Test;
//import use_case.note.convert_farenheit.ConvertFarenheitInputData;
//import use_case.note.convert_farenheit.ConvertFarenheitOutputBoundary;
//import use_case.note.convert_farenheit.ConvertFarenheitOutputData;
//import use_case.note.convert_farenheit.ConvertInteractor;
//
//import java.io.DataOutput;
//import java.io.IOException;
//
//import static org.junit.Assert.*;
//
//public class ConvertInteractorTest {
//
//    /**
//     * Checks Lines 1 - 14.
//     */
//    @Test
//    public void TestIfWeatherDNE() {
//        WeatherDataAccessInterface Dao = new WeatherDataAccessInterface() {
//            @Override
//            public Weather getWeather(String city) throws IOException {
//
//                return new WeatherDataAccessObject().getWeather(city);
//            }
//        };
//        ConvertFarenheitOutputBoundary boundary = new ConvertFarenheitOutputBoundary() {
//            @Override
//            public void prepareFailView(String errorMessage) {
//                assertEquals(errorMessage,"UNABLE TO CONVERT");
//            }
//
//            @Override
//            public void prepareSuccessView(ConvertFarenheitOutputData outputData) {
//                fail("this is unexpected");
//            }
//        };
//        Weather weather = Dao.getWeather("trn");
//
//        ConvertFarenheitInputData inputData = new ConvertFarenheitInputData(weather);
//
//        ConvertInteractor interactor = new ConvertInteractor(boundary);
//        interactor.executeConvert(inputData);
//    }
//
//    /**
//     * Convert to Fahrenheit.
//     * Checks Lines 28 - 36 and lines 15 - 22.
//     */
//    @Test
//    public void TestIfMetricConversion() {
//        WeatherDataAccessInterface Dao = new WeatherDataAccessInterface() {
//            @Override
//            public Weather getWeather(String city) throws IOException {
//                return WeatherDataAccessObject.getWeather(city);
//            }
//        };
//        ConvertFarenheitOutputBoundary boundary = new ConvertFarenheitOutputBoundary() {
//            @Override
//            public void prepareFailView(String errorMessage) {
//                fail(errorMessage);
//            }
//
//            @Override
//            public void prepareSuccessView(ConvertFarenheitOutputData outputData) {
//                assertEquals(false, outputData.getWeather().isMetric());
//
//            }
//        };
//
//        Weather weather = Dao.getWeather("Toronto");
//
//        ConvertFarenheitInputData inputData = new ConvertFarenheitInputData(weather);
//
//        ConvertInteractor interactor = new ConvertInteractor(boundary);
//        interactor.executeConvert(inputData);
//
//
//    }
//
//    /**
//     * Convert to Metric.
//     * Checks Lines 37 - end and lines 15 - 22.
//     */
//    @Test
//    public void TestIfFahrenheitConversion() {
//        WeatherDataAccessInterface Dao = new WeatherDataAccessInterface() {
//            @Override
//            public Weather getWeather(String city) throws IOException {
//                return WeatherDataAccessObject.getWeather(city);
//            }
//        };
//        ConvertFarenheitOutputBoundary boundary = new ConvertFarenheitOutputBoundary() {
//            @Override
//            public void prepareFailView(String errorMessage) {
//                fail(errorMessage);
//            }
//
//            @Override
//            public void prepareSuccessView(ConvertFarenheitOutputData outputData) {
//                assertTrue(outputData.getWeather().isMetric());
//
//            }
//        };
//
//        Weather weather = Dao.getWeather("Toronto");
//        weather.setMetric(false);
//
//        ConvertFarenheitInputData inputData = new ConvertFarenheitInputData(weather);
//
//        ConvertInteractor interactor = new ConvertInteractor(boundary);
//        interactor.executeConvert(inputData);
//
//    }
//}
