package app.service.outputports;

import app.domain.Seat;

import java.util.List;

public interface SeatRepository {

    Seat save(Seat seat);
    Seat selectById(int id);
    List<Seat> selectAll();
    Seat updateSeat(Seat seat);
    void deleteById(int id);
}
