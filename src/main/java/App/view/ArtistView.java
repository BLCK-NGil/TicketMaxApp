package app.view;

import app.domain.Artist;
import app.service.exceptions.TicketMaxException;
import app.service.inputports.ArtistService;
import app.service.validators.DataTypeValidator;

import java.util.List;

// El "mesero" de artistas: le pregunta al usuario y le lleva el pedido al service
public class ArtistView {

    private final ArtistService artistService;

    public ArtistView(ArtistService artistService) {
        this.artistService = artistService;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println();
            System.out.println("===== ARTISTAS =====");
            System.out.println("1. Crear");
            System.out.println("2. Listar todos");
            System.out.println("3. Buscar por id");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Volver");
            option = DataTypeValidator.validateInt("Seleccione una opción: ");

            // Si el service lanza un error (id repetido, no existe...), lo atrapamos aquí
            // y mostramos el mensaje en vez de que se caiga el programa
            try {
                switch (option) {
                    case 1:
                        fillForm(false);
                        break;
                    case 2:
                        showAllArtists();
                        break;
                    case 3:
                        showArtistById();
                        break;
                    case 4:
                        fillForm(true);
                        break;
                    case 5:
                        deleteArtist();
                        break;
                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (TicketMaxException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }

    // Un solo formulario sirve para crear y para actualizar (DRY)
    private void fillForm(boolean isUpdate) {
        int id = DataTypeValidator.validateInt("Id del artista: ");
        if (isUpdate) {
            artistService.selectById(id); // verifica que exista antes de pedir los demás datos
        }
        String name = DataTypeValidator.validateString("Nombre del artista: ");
        boolean available = selectAvailability();

        if (isUpdate) {
            artistService.update(id, name, available);
            System.out.println("Artista actualizado.");
        } else {
            artistService.create(id, name, available);
            System.out.println("Artista creado.");
        }
    }

    private void showAllArtists() {
        List<Artist> artists = artistService.selectArtists();
        if (artists.isEmpty()) {
            System.out.println("No hay artistas registrados.");
            return;
        }
        for (Artist artist : artists) {
            System.out.println(artist);
        }
    }

    private void showArtistById() {
        int id = DataTypeValidator.validateInt("Id del artista: ");
        Artist artist = artistService.selectById(id);
        System.out.println(artist);
    }

    private void deleteArtist() {
        int id = DataTypeValidator.validateInt("Id del artista a eliminar: ");
        artistService.deleteArtist(id);
        System.out.println("Artista eliminado.");
    }

    private boolean selectAvailability() {
        while (true) {
            int option = DataTypeValidator.validateInt("¿Está disponible? 1. Sí  2. No");
            if (option == 1) {
                return true;
            }
            if (option == 2) {
                return false;
            }
            System.out.println("Opción no válida, intente de nuevo.");
        }
    }
}
