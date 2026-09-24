package app.domain;

public class User extends Person {
    private String city;
    private String preferences;

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
    public void selectState(int id){ super.selectState(int id);

    }
}
