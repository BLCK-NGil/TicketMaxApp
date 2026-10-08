package app.service.outputports;

import java.util.List;

public interface PlaceService {
    Place.Place save(Place.Place place);
    Place.Place selectById(int id);
    List<Place.Place> selectAll();
    Place.Place updatePlace(Place.Place place);
    void deleteById(int id);
}
