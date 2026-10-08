package app.repository;

import java.util.ArrayList;
import java.util.List;

public class PlaceRepositoryImplCollection implements PlaceRepository {

    private final list<Place.Place> places = new ArrayList<>();

    @Override
    public Place.Place save(Place.Place place) {
        places.add(place);
        return place;
    }

    @Override
    public Place.Place selectById(int id) {
        for (Place.Place place : places){
            if(place.getPlaceId().equals(id)){
                return place;
            }
        }
        return null;
    }

    @Override
    public List<Place.Place> selectAll() {
        return new ArrayList<>(places);
    }

    @Override
    public Place.Place updatePlace(Place.Place place) {
        for(int i = 0; i < places.size();i++){
            if(places.get(i).getPlaceId().equals(place.getPlaceId())){
                places.set(i, place);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        places.removeIf(place -> place.getPlaceId().equals(id));

    }
}
