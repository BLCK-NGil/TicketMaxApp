package domain;

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

    @Override
    public void create() {
        super.create();
    }

     @Override
    public void selectAll(){

        super.selectAll();
    }

    @Override
    public void selectById(int id){
        super.selectById(id);
    }

    @Override
    public void update(){
        super.update();
    }

    @Override
    public void delete(int id) {

        super.delete(id);
    }

    @Override
    public void selectState(int id){
        super.selectState();

    }
}
