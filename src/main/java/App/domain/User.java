package App.domain;

import App.domain.enums.SelectPreferencesUser;

public class User extends Person{
    private String city;
    private SelectPreferencesUser preferences;

    public User() {
        super();
    }

    public User(int id, String name, String lastName, String email, String phone, String password, String city, SelectPreferencesUser preferences) {
        super(id, name, lastName, email, phone, password);
        this.city = city;
        this.preferences = preferences;
    }

}
