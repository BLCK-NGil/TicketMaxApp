package App.domain;

public class Place {
    private Integer id;
    private String city;
    private String placeName;
    private String scenaryType;

    public Place() {

    }

    public Place(Integer id, String city, String placeName, String scenaryType) {
        this.id = id;
        this.city = city;
        this.placeName = placeName;
        this.scenaryType = scenaryType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getScenaryType() {
        return scenaryType;
    }

    public void setScenaryType(String scenaryType) {
        this.scenaryType = scenaryType;
    }
}
//Por ahora porque después los moveremos de carpeta al service

    public void create() {

    }
    public void selectAllPlaces() {

    }
    public void selectByPlaceId(int id) {

    }
    public void updatePlace(){

    }
    public void deletePlace(int id){

    }
    public void selectPlaceState(int id){

    }

}
