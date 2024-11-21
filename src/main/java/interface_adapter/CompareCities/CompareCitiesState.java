package interface_adapter.CompareCities;

public class CompareCitiesState {
    private String error;
    private String firstCityName;
    private String secondCityName;

    public CompareCitiesState(CompareCitiesState copy) {
        this.error = copy.error;
        this.firstCityName = copy.firstCityName;
        this.secondCityName = copy.secondCityName;
    }

    public CompareCitiesState() {
    }

    public String getError() {
        return error;
    }

    public String getFirstCityName() {
        return firstCityName;
    }

    public String getSecondCityName() {
        return secondCityName;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setFirstCityName(String firstCityName) {
        this.firstCityName = firstCityName;
    }

    public void setSecondCityName(String secondCityName) {
        this.secondCityName = secondCityName;
    }
}
