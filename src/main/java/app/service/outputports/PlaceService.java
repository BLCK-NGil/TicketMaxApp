package app.service.outputports;

import app.domain.Place;

import java.util.List;

public interface PlaceService {
    Place save(Place place);
    Place selectById(int id);
    List<Place> selectAll();
    Place updatePlace(Place place);
    void deleteById(int id);
}
