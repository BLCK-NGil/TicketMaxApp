package app.domain;

public class Artist {

    private Integer artistId;
    private String artistName;
    private boolean isAvailable;


    public Artist() {
    }

    public Artist(Integer artistId, String artistName, boolean isAvailable) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.isAvailable = isAvailable;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Los métodos create/select/update/delete se movieron al service (ArtistServiceImpl)

    @Override
    public String toString() {
        String availability = isAvailable ? "Disponible" : "No disponible";
        return "Artista #" + artistId + " | " + artistName + " | " + availability;
    }
}
