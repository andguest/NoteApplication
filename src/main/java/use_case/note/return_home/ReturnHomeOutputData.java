package use_case.note.return_home;

public class ReturnHomeOutputData {

    private final boolean useCaseFailed;

    public ReturnHomeOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
