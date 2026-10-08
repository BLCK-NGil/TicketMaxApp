package app.repository;

import app.domain.Artist;
import app.service.outputports.ArtistRepository;

import java.util.ArrayList;
import java.util.List;

// La "bodega" de artistas: los guarda en una lista en memoria
public class ArtistRepositoryImplCollection implements ArtistRepository {

    private final List<Artist> artists = new ArrayList<>();

    @Override
    public Artist save(Artist artist) {
        artists.add(artist);
        return artist;
    }

    @Override
    public Artist selectById(int id) {
        for (Artist artist : artists) {
            if (artist.getArtistId().equals(id)) {
                return artist;
            }
        }
        return null; // si no lo encuentra, devuelve null y el service decide qué hacer
    }

    @Override
    public List<Artist> selectAll() {
        // Devolvemos una copia para que nadie modifique la lista original desde afuera
        return new ArrayList<>(artists);
    }

    @Override
    public Artist updateArtist(Artist artist) {
        for (int i = 0; i < artists.size(); i++) {
            if (artists.get(i).getArtistId().equals(artist.getArtistId())) {
                artists.set(i, artist);
                return artist;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        artists.removeIf(artist -> artist.getArtistId().equals(id));
    }
}
