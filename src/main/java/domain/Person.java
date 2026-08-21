package domain;

public class Person {
    protected int id;
    protected String name;
    protected String lastName;
    protected String email;
    protected String phone;
    protected String password;
    protected boolean state;

    public Person() {

    }

    public Person(int id, String name, String lastName, String phone, String email, String password, boolean state) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.state = state;
    }

    public Person(String email, String password) {

    }

    public Person(boolean state){
        this.state = state;
    }

    public Person(int id){
        this.id = id;
    }
    public Person(int id, String name, String lastName, String email, String phone, String password) {

    }
    public void create() {

    }
    public void selectAll() {

    }
    public void selectById(int id) {

    }
    public void update(){

    }
    public void delete(int id){

    }
    public void selectState(int id){

    }
}

