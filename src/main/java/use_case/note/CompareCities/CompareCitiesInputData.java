package use_case.note.CompareCities;

public class CompareCitiesInputData {

    private final String firstcityname;
    private final String secondcityname;

    public CompareCitiesInputData(String firstcityname, String secondcityname) {
        this.firstcityname = firstcityname;
        this.secondcityname = secondcityname;
    }

    public String getFirstcityname() {
        return firstcityname;
    }

    public String getSecondcityname() {
        return secondcityname;
    }
}
