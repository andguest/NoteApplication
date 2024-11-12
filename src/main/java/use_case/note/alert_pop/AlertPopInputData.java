package use_case.note.alert_pop;

// No input because alertpop is automatic.
public class AlertPopInputData {
    private final String cityName;

    public AlertPopInputData(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
