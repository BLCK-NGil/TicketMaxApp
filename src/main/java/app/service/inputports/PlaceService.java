package app.service.inputports;

import app.domain.Place;

import java.util.List;

public interface PlaceService {
    Place create(Integer placeId, String city, String placeName, String scenaryType);
    Place selectById(int id);
    List<Place> selectPlaces();
    Place update(Integer placeId, String city, String placeName, String scenaryType);
    void deletePlace(int id);
}
