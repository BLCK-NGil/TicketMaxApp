package app.view;

import app.domain.Seat;
import app.domain.enums.SeatSectorEnum;
import app.service.exceptions.TicketMaxException;
import app.service.inputports.SeatService;
import app.service.validators.DataTypeValidator;

import java.util.List;

public class SeatView {

    private final SeatService seatService;

    public SeatView(SeatService seatService) {
        this.seatService = seatService;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println();
            System.out.println("===== SILLAS =====");
            System.out.println("1. Crear");
            System.out.println("2. Listar todas");
            System.out.println("3. Buscar por id");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Volver");
            option = DataTypeValidator.validateInt("Seleccione una opción: ");

            try {
                switch (option) {
                    case 1:
                        fillForm(false);
                        break;
                    case 2:
                        showAllSeats();
                        break;
                    case 3:
                        showSeatById();
                        break;
                    case 4:
                        fillForm(true);
                        break;
                    case 5:
                        deleteSeat();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (TicketMaxException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }

    private void fillForm(boolean isUpdate) {
        int id = DataTypeValidator.validateInt("Id de la silla: ");
        if (isUpdate) {
            seatService.selectById(id);
        }
        String seatNumber = DataTypeValidator.validateString("Número de la silla: ");
        SeatSectorEnum sector = selectSeatSector();
        boolean available = DataTypeValidator.validateboolean("¿Está disponible?");

        if (isUpdate) {
            seatService.update(id, seatNumber, sector.name(), available);
            System.out.println("Silla actualizada.");
        } else {
            seatService.create(id, seatNumber, sector.name(), available);
            System.out.println("Silla creada.");
        }
    }

    private void showAllSeats() {
        List<Seat> seats = seatService.selectSeats();
        if (seats.isEmpty()) {
            System.out.println("No hay sillas registradas.");
            return;
        }
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }

    private void showSeatById() {
        int id = DataTypeValidator.validateInt("Id de la silla: ");
        Seat seat = seatService.selectById(id);
        System.out.println(seat);
    }

    private void deleteSeat() {
        int id = DataTypeValidator.validateInt("Id de la silla a eliminar: ");
        seatService.deleteSeat(id);
        System.out.println("Silla eliminada.");
    }

    private SeatSectorEnum selectSeatSector() {
        while (true) {
            System.out.println("Sector:");
            System.out.println("  1. VIP");
            System.out.println("  2. Platea");
            System.out.println("  3. Palco");
            System.out.println("  4. General");
            int option = DataTypeValidator.validateInt("Opción: ");
            switch (option) {
                case 1:
                    return SeatSectorEnum.VIP;
                case 2:
                    return SeatSectorEnum.PLATEA;
                case 3:
                    return SeatSectorEnum.PALCO;
                case 4:
                    return SeatSectorEnum.GENERAL;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}
