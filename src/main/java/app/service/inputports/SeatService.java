package app.service.inputports;

import app.domain.Seat;

import java.util.List;

public interface SeatService {

    Seat create(Integer seatId, String seatNumber, String seatSector, boolean available);
    Seat selectById(int id);
    List<Seat> selectSeats();
    Seat update(Integer seatId, String seatNumber, String seatSector, boolean available);
    void deleteSeat(int id);
}
