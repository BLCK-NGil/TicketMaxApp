package App.domain.enums;

public enum SelectPreferencesUser {
    GENERAL("General"),
    VIP("VIP"),
    PREFERENCIAL("Preferencial");

    private final String preference;
    SelectPreferencesUser(String preference) {
        this.preference = preference;
    }

}
