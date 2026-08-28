package App.domain;

public class User extends Person{
    private String city;
    private String preferences;

    public User() {
        super();
    }

    public User(int id, String name, String lastName, String email, String phone, String password, String city, String preferences) {
        super(id, name, lastName, email, phone, password);
        this.city = city;
        this.preferences = preferences;
    }

}
