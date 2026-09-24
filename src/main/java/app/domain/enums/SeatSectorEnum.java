package app.domain.enums;

public enum SeatSectorEnum {
    VIP("VIP"),
    PLATEA("Platea"),
    PALCO("Palco"),
    GENERAL("General");

    private final String label;

    SeatSectorEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}

