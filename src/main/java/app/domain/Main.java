package app.domain;

import app.repository.PlaceRepositoryImplCollection;
import app.service.inputports.PlaceService;
import app.view.PlaceView;

public class Main {
    public static void main(String[] args) {
        // 1. La despensa
        PlaceRepository placeRepository = new PlaceRepositoryImplCollection();

        // 2. El chef, al que le entregamos su despensa
        PlaceService placeService = new PlaceServiceImpl(placeRepository);

        // 3. El mesero, al que le entregamos su chef
        PlaceView placeView = new PlaceView(placeService);

        // 4. Abrir el restaurante
        placeView.showMenu();
    }

}
