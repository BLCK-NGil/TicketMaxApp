package app.service.inputports;

import java.util.List;

public interface PlaceService {
    Place.Place create(Integer placeId, String city, String placeName, String scenaryType);
    Place.Place selectById(int id);
    List<Place.Place> selectPlaces();
    Place.Place update(Integer placeId, String city, String placeName, String scenaryType);
    void deletePlace(int id);
}
