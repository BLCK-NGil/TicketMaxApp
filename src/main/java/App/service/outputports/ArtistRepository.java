package app.service.outputports;

import app.domain.Artist;

import java.util.List;

// Puerto de SALIDA: lo que el service le puede pedir a la "bodega" (repositorio)
public interface ArtistRepository {
    Artist save(Artist artist);
    Artist selectById(int id);
    List<Artist> selectAll();
    Artist updateArtist(Artist artist);
    void deleteById(int id);
}
