package app.repository;

import app.domain.Place;
import app.service.outputports.PlaceRepository;

import java.util.ArrayList;
import java.util.List;

public class PlaceRepositoryImplCollection implements PlaceRepository {

    private final list<Place> places = new ArrayList<>();

    @Override
    public Place save(Place place) {
        places.add(place);
        return place;
    }

    @Override
    public Place selectById(int id) {
        for (Place place : places){
            if(place.getPlaceId().equals(id)){
                return place;
            }
        }
        return null;
    }

    @Override
    public List<Place> selectAll() {
        return new ArrayList<>(places);
    }

    @Override
    public Place updatePlace(Place place) {
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
