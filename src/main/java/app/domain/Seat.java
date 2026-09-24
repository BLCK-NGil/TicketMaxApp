package app.domain;

import app.domain.enums.SeatSectorEnum;

public class Seat {

    private Integer seatId;
    private String seatNumber;
    private SeatSectorEnum seatSector;
    private boolean available;

    public Seat() {
    }

    public Seat(Integer seatId, String seatNumber, SeatSectorEnum seatSector, boolean available) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatSector = seatSector;
        this.available = available;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatSectorEnum getSeatSector() {
        return seatSector;
    }

    public void setSeatSector(SeatSectorEnum seatSector) {
        this.seatSector = seatSector;
    }

    //El getter de un `boolean` se llama `is...`
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Seat{id=" + seatId + ", número=" + seatNumber + ", sector=" + seatSector
                + ", disponible=" + (available ? "sí" : "no") + "}";
    }
}
