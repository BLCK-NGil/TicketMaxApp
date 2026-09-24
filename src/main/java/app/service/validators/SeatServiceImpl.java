package app.service;

import app.domain.Seat;
import app.domain.enums.SeatSectorEnum;
import app.service.exceptions.DuplicateEntityException;
import app.service.exceptions.EntityNotFoundException;
import app.service.inputports.SeatService;
import app.service.outputports.SeatRepository;

import java.util.List;

public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat create(Integer seatId, String seatNumber, String seatSector, boolean available) {
        if (seatRepository.selectById(seatId) != null) {
            throw new DuplicateEntityException("una silla", seatId);
        }
        Seat seat = new Seat(seatId, seatNumber, SeatSectorEnum.valueOf(seatSector), available);
        return seatRepository.save(seat);
    }

    @Override
    public Seat selectById(int id) {
        Seat seat = seatRepository.selectById(id);
        if (seat == null) {
            throw new EntityNotFoundException("una silla", id);
        }
        return seat;
    }

    @Override
    public List<Seat> selectSeats() {
        return seatRepository.selectAll();
    }

    @Override
    public Seat update(Integer seatId, String seatNumber, String seatSector, boolean available) {
        selectById(seatId);
        Seat seat = new Seat(seatId, seatNumber, SeatSectorEnum.valueOf(seatSector), available);
        return seatRepository.updateSeat(seat);
    }

    @Override
    public void deleteSeat(int id) {
        selectById(id);
        seatRepository.deleteById(id);
    }
}
