package app.view;

import app.domain.Place;
import app.domain.enums.ScenaryTypeEnum;
import app.service.exceptions.TicketMaxException;
import app.service.inputports.PlaceService;
import app.service.validators.DataTypeValidator;

import java.util.List;

public class PlaceView {

    private final PlaceService placeService;

    public PlaceView(PlaceService placeService) {
        this.placeService = placeService;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println();
            System.out.println("===== LUGARES =====");
            System.out.println("1. Crear");
            System.out.println("2. Listar todos");
            System.out.println("3. Buscar por id");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Salir");
            option = DataTypeValidator.validateInt("Seleccione una opción: ");

            try {
                switch (option) {
                    case 1:
                        fillForm(false);
                        break;
                    case 2:
                        showAllPlaces();
                        break;
                    case 3:
                        showPlaceById();
                        break;
                    case 4:
                        fillForm(true);
                        break;
                    case 5:
                        deletePlace();
                        break;
                    case 0:
                        System.out.println("¡Hasta pronto!");
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
        int id = DataTypeValidator.validateInt("Id del lugar: ");
        if (isUpdate) {
            placeService.selectById(id);
        }
        String city = DataTypeValidator.validateString("Ciudad: ");
        String placeName = DataTypeValidator.validateString("Nombre del lugar: ");
        ScenaryTypeEnum type = selectScenaryType();

        if (isUpdate) {
            placeService.update(id, city, placeName, type.name());
            System.out.println("Lugar actualizado.");
        } else {
            placeService.create(id, city, placeName, type.name());
            System.out.println("Lugar creado.");
        }
    }

    private void showAllPlaces() {
        List<Place> places = placeService.selectPlaces();
        if (places.isEmpty()) {
            System.out.println("No hay lugares registrados.");
            return;
        }
        for (Place place : places) {
            System.out.println(place);
        }
    }

    private void showPlaceById() {
        int id = DataTypeValidator.validateInt("Id del lugar: ");
        Place place = placeService.selectById(id);
        System.out.println(place);
    }

    private void deletePlace() {
        int id = DataTypeValidator.validateInt("Id del lugar a eliminar: ");
        placeService.deletePlace(id);
        System.out.println("Lugar eliminado.");
    }

    private ScenaryTypeEnum selectScenaryType() {
        while (true) {
            System.out.println("Tipo de escenario:");
            System.out.println("  1. Estadio");
            System.out.println("  2. Teatro");
            System.out.println("  3. Coliseo");
            System.out.println("  4. Aire libre");
            int option = DataTypeValidator.validateInt("Opción: ");
            switch (option) {
                case 1:
                    return ScenaryTypeEnum.STADIUM;
                case 2:
                    return ScenaryTypeEnum.THEATER;
                case 3:
                    return ScenaryTypeEnum.ARENA;
                case 4:
                    return ScenaryTypeEnum.OPEN_AIR;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}
