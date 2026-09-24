package App.domain;

public class Seat {
    private int idSeat;
    private String seatNumber;
    private String seatSector;
    private boolean isAvailable;

    public Seat() {
    }

    public Seat(int idSeat, String seatNumber, String seatSector, boolean state) {
        this.idSeat = idSeat;
        this.seatNumber = seatNumber;
        this.seatSector = seatSector;
        this.state = state;
    }

    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatSector() {
        return seatSector;
    }

    public void setSeatSector(String seatSector) {
        this.seatSector = seatSector;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void createSeat(String type){
    }
    public void SelectAllSeats(){

    }
    public void selectSeatById(int id){

    }
    public void updateSeat(int id){

    }
    public void deleteSeat(int id){

    }

}
