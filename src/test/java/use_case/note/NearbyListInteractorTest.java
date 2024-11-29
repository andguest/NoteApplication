package use_case.note;

import org.junit.Test;
import use_case.note.nearby_list.*;

import java.io.IOException;
import java.util.List;

public class NearbyListInteractorTest {

    @Test
    public void testOutput() {
        NearbyCitiesAccessInterface cityDAO = new NearbyCitiesAccessInterface() {
            @Override
            public List<String> getNearbyCities(double latitude, double longitude) throws IOException {
                return List.of();
            }
        };

        NearbyListOutputBoundary cityOB = new NearbyListOutputBoundary() {
            @Override
            public void presentSuccessView(NearbyListOutputData nearbyListOutputData) {

            }

            @Override
            public void prepareFailView(String errorMessage) {

            }
        };

        NearbyListInteractor cityInteractor = new NearbyListInteractor(cityOB, cityDAO);
        NearbyListInputData input = new NearbyListInputData(0.0, 0.0);
        cityInteractor.execute(input);
    }
}
