package app.service;

import app.domain.Artist;
import app.service.exceptions.DuplicateEntityException;
import app.service.exceptions.EntityNotFoundException;
import app.service.inputports.ArtistService;
import app.service.outputports.ArtistRepository;

import java.util.List;

// El "cocinero" de artistas: aplica las reglas antes de guardar o buscar
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    // Inyección de dependencias: el repositorio llega desde afuera (desde Config)
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist create(Integer artistId, String artistName, boolean isAvailable) {
        // Regla: no puede haber dos artistas con el mismo id
        if (artistRepository.selectById(artistId) != null) {
            throw new DuplicateEntityException("un artista", artistId);
        }
        Artist artist = new Artist(artistId, artistName, isAvailable);
        return artistRepository.save(artist);
    }

    @Override
    public Artist selectById(int id) {
        Artist artist = artistRepository.selectById(id);
        if (artist == null) {
            throw new EntityNotFoundException("un artista", id);
        }
        return artist;
    }

    @Override
    public List<Artist> selectArtists() {
        return artistRepository.selectAll();
    }

    @Override
    public Artist update(Integer artistId, String artistName, boolean isAvailable) {
        selectById(artistId); // si no existe, lanza la excepción y no sigue
        Artist artist = new Artist(artistId, artistName, isAvailable);
        return artistRepository.updateArtist(artist);
    }

    @Override
    public void deleteArtist(int id) {
        selectById(id);
        artistRepository.deleteById(id);
    }
}
