package app.repository;

import app.domain.Seat;
import app.service.outputports.SeatRepositoryPort;

import java.util.ArrayList;
import java.util.List;

public class SeatRepositoryAdapter implements SeatRepositoryPort {

    private final List<Seat> seats = new ArrayList<>();


    @Override
    public Seat save(Seat seat) {
        seats.add(seat);
        return seat;
    }

    @Override
    public Seat selectById(int id) {
        for (Seat seat : seats) {
            if (seat.getSeatId().equals(id)) {
                return seat;
            }
        }
        return null;
    }

    @Override
    public List<Seat> selectAll() {
        return new ArrayList<>(seats);
    }

    @Override
    public Seat updateSeat(Seat seat) {
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).getSeatId().equals(seat.getSeatId())) {
                seats.set(i, seat);
                return seat;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        seats.removeIf(seat -> seat.getSeatId().equals(id));
    }
}
