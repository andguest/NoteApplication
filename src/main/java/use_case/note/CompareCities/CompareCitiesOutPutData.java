package use_case.note.CompareCities;

public class CompareCitiesOutPutData {
    private final String firstCityname;
    private final String secondCityname;
    private final boolean useCaseFailed;

    public CompareCitiesOutPutData(String firstCityname, String secondCityname, boolean useCaseFailed) {
        this.firstCityname = firstCityname;
        this.secondCityname = secondCityname;
        this.useCaseFailed = useCaseFailed;
    }


    public String getFirstCityname() {
        return firstCityname;
    }

    public String getSecondCityname() {
        return secondCityname;
    }
}
