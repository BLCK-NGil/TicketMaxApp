package app.service;

import app.domain.Artist;
import app.domain.Event;
import app.domain.Place;
import app.service.exceptions.DuplicateEntityException;
import app.service.exceptions.EntityNotFoundException;
import app.service.exceptions.TicketMaxException;
import app.service.inputports.ArtistService;
import app.service.inputports.EventService;
import app.service.inputports.PlaceService;
import app.service.outputports.EventRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    // El evento necesita buscar lugares y artistas, así que recibe sus services
    private final PlaceService placeService;
    private final ArtistService artistService;

    public EventServiceImpl(EventRepository eventRepository, PlaceService placeService, ArtistService artistService) {
        this.eventRepository = eventRepository;
        this.placeService = placeService;
        this.artistService = artistService;
    }

    @Override
    public Event create(Integer eventId, String eventName, int placeId, int artistId, LocalDate eventDate, LocalTime eventTime) {
        if (eventRepository.selectById(eventId) != null) {
            throw new DuplicateEntityException("un evento", eventId);
        }
        Event event = buildEvent(eventId, eventName, placeId, artistId, eventDate, eventTime);
        return eventRepository.save(event);
    }

    @Override
    public Event selectById(int id) {
        Event event = eventRepository.selectById(id);
        if (event == null) {
            throw new EntityNotFoundException("un evento", id);
        }
        return event;
    }

    @Override
    public List<Event> selectEvents() {
        return eventRepository.selectAll();
    }

    @Override
    public Event update(Integer eventId, String eventName, int placeId, int artistId, LocalDate eventDate, LocalTime eventTime) {
        selectById(eventId);
        Event event = buildEvent(eventId, eventName, placeId, artistId, eventDate, eventTime);
        return eventRepository.updateEvent(event);
    }

    @Override
    public void deleteEvent(int id) {
        selectById(id);
        eventRepository.deleteById(id);
    }

    // Método de ayuda (DRY): create y update arman el evento igual, así que se hace en un solo lugar
    private Event buildEvent(Integer eventId, String eventName, int placeId, int artistId, LocalDate eventDate, LocalTime eventTime) {
        // Si el lugar o el artista no existen, estos métodos ya lanzan EntityNotFoundException
        Place place = placeService.selectById(placeId);
        Artist artist = artistService.selectById(artistId);

        // Reglas de negocio del evento
        if (!artist.isAvailable()) {
            throw new TicketMaxException("El artista " + artist.getArtistName() + " no está disponible");
        }
        if (eventDate.isBefore(LocalDate.now())) {
            throw new TicketMaxException("La fecha del evento no puede ser en el pasado");
        }

        return new Event(eventId, eventName, place, artist, eventDate, eventTime);
    }
}
