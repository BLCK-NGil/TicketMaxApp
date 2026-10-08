package app.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    private Integer eventId;
    private String eventName;
    // Un evento "tiene un" lugar y "tiene un" artista (relación entre clases)
    private Place place;
    private Artist artist;
    private LocalDate eventDate;
    private LocalTime eventTime;

    public Event() {
    }

    public Event(Integer eventId, String eventName, Place place, Artist artist, LocalDate eventDate, LocalTime eventTime) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.place = place;
        this.artist = artist;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "Evento #" + eventId + " | " + eventName
                + "\n   Artista: " + artist.getArtistName()
                + "\n   Lugar:   " + place.getPlaceName() + " (" + place.getCity() + ")"
                + "\n   Fecha:   " + eventDate + " a las " + eventTime;
    }
}
