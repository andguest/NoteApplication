package use_case.close_pop;

public class ClosePopOutputData {

    private final boolean useCaseFailed;

    public ClosePopOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
