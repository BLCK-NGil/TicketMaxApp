package app.domain;

public class Artist {
    private int artistId;
    private String artistName;
    private boolean available;

    public Artist() {
    }

    public Artist(int artistId, String name, boolean available) {
        this.artistId = artistId;
        this.name = name;
        this.available = available;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", artistName='" + artistName + '\'' +
                ", available=" + available +
                '}';
    }
}
