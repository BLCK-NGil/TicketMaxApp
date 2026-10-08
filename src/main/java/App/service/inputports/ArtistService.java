package app.service.inputports;

import app.domain.Artist;

import java.util.List;

// Puerto de ENTRADA: lo que la vista le puede pedir al service
public interface ArtistService {
    Artist create(Integer artistId, String artistName, boolean isAvailable);
    Artist selectById(int id);
    List<Artist> selectArtists();
    Artist update(Integer artistId, String artistName, boolean isAvailable);
    void deleteArtist(int id);
}
