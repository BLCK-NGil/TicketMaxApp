package app.domain;

import app.domain.enums.ScenaryTypeEnum;

public class Place {
    private Integer id;
    private String city;
    private String placeName;
    private ScenaryTypeEnum scenaryType;

    public Place() {
    }

    public Place(Integer id, String city, String placeName, ScenaryTypeEnum scenaryType) {
        this.id = id;
        this.city = city;
        this.placeName = placeName;
        this.scenaryType = scenaryType;
    }

    public Integer getPlaceId() {
        return id;
    }

    public void setPlaceId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public ScenaryTypeEnum getScenaryType() {
        return scenaryType;
    }

    public void setScenaryType(ScenaryTypeEnum scenaryType) {
        this.scenaryType = scenaryType;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", placeName='" + placeName + '\'' +
                ", scenaryType=" + scenaryType +
                '}';
    }
}
