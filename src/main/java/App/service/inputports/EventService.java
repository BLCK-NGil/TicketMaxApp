package app.service.inputports;

import app.domain.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EventService {
    // Recibe los ids del lugar y del artista; el service se encarga de buscarlos
    Event create(Integer eventId, String eventName, int placeId, int artistId, LocalDate eventDate, LocalTime eventTime);
    Event selectById(int id);
    List<Event> selectEvents();
    Event update(Integer eventId, String eventName, int placeId, int artistId, LocalDate eventDate, LocalTime eventTime);
    void deleteEvent(int id);
}
