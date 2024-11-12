package use_case.note.close_pin;

public class ClosePinOutputData {

    private final boolean useCaseFailed;

    public ClosePinOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
