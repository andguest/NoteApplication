package use_case.note.alert_pop;

public class AlertPopOutputData {

    private final String alert;
    private final boolean useCaseFailed;

    public AlertPopOutputData(String alert, boolean useCaseFailed) {
        this.alert = alert;
        this.useCaseFailed = useCaseFailed;
    }

    public String getAlert() {
        return alert;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
