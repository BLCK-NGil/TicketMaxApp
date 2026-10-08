package app.service.validators;

import app.domain.Place;
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
    public Place create(Integer placeId, String city, String placeName, String scenaryType) {
        if (placeRepository.selectById(placeId) != null) {
            throw new DuplicateEntityException("un lugar", placeId);
        }
        Place place = new Place(placeId, city, placeName, ScenaryTypeEnum.valueOf(scenaryType));
        return placeRepository.save(place);
    }

    @Override
    public Place selectById(int id) {
        Place place = placeRepository.selectById(id);
        if (place == null) {
            throw new EntityNotFoundException("un lugar", id);
        }
        return place;
    }

    @Override
    public List<Place> selectPlaces() {
        return placeRepository.selectAll();
    }

    @Override
    public Place update(Integer placeId, String city, String placeName, String scenaryType) {
        selectById(placeId);
        Place place = new Place(placeId, city, placeName, ScenaryTypeEnum.valueOf(scenaryType));
        return placeRepository.updatePlace(place);
    }

    @Override
    public void deletePlace(int id) {
        selectById(id);
        placeRepository.deleteById(id);
    }
}
