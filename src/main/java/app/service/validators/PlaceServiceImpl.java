package app.service;

import app.domain.enums.ScenaryTypeEnum;
import app.service.exceptions.DuplicateEntityException;
import app.service.exceptions.EntityNotFoundException;
import app.service.inputports.PlaceService;
import app.service.outputports.PlaceRepository;

import java.util.List;

public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Place.Place create(Integer placeId, String city, String placeName, String scenaryType) {
        if (placeRepository.selectById(placeId) != null) {
            throw new DuplicateEntityException("un lugar", placeId);
        }
        Place.Place place = new Place.Place(placeId, city, placeName, ScenaryTypeEnum.valueOf(scenaryType));
        return placeRepository.save(place);
    }

    @Override
    public Place.Place selectById(int id) {
        Place.Place place = placeRepository.selectById(id);
        if (place == null) {
            throw new EntityNotFoundException("un lugar", id);
        }
        return place;
    }

    @Override
    public List<Place.Place> selectPlaces() {
        return placeRepository.selectAll();
    }

    @Override
    public Place.Place update(Integer placeId, String city, String placeName, String scenaryType) {
        selectById(placeId);
        Place.Place place = new Place.Place(placeId, city, placeName, ScenaryTypeEnum.valueOf(scenaryType));
        return placeRepository.updatePlace(place);
    }

    @Override
    public void deletePlace(int id) {
        selectById(id);
        placeRepository.deleteById(id);
    }
}
