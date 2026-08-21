package domain;

public class Admin extends Person{
    private String role;
    private String area;

    public Admin(){

        super();
    }

    public Admin(int id, String name, String lastName, String email, String phone, String password, String role, String area) {
        super(id, name, lastName, email, phone, password);
        this.role = role;
        this.area = area;
    }

    @Override
    public void createAdm() {

        super.create();
    }

    @Override
    public void selectAllAdm(){

        super.selectAll();
    }

    @Override
    public void selectAdmById(int id) {

        super.selectById(id);
    }

    @Override
    public void Adm(){

        super.update();
    }

    @Override
    public void deleteAdm(int id) {

        super.delete(id);
    }

    @Override
    public void selectState(int id) {

        super.selectState(id);
    }
}
