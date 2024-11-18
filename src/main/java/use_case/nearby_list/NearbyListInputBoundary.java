package use_case.nearby_list;

// This one only has the input of clicking "open list," whereas the centre of the location is chosen prior to that.
public interface NearbyListInputBoundary {

    void execute(NearbyListInputData nearbyListInputData);
}
