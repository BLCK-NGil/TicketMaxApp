package App.view;

import java.sql.SQLOutput;

public class UserView {
    Scanner sc = new Scanner(System.in);

    public void create() {

    }

    public void selectAll(){
        System.out.println("Ingrese el ID del usuario: ");
        int id = sc.nextInt();
        sc.nextLIne();

        System.out.println("Ingrese el nombre del usuario: ");
        String name = sc.nextline();
        System.out.println("Ingrese el apellido del usuariio: ");
        String lastName  = sc.nextline();
        System.out.println("Ingrese el email del usuario: ");
        String email = sc.nextLine();
        System.out.println("Ingrese el telefono del usuario:");
        String phone = sc.nextLine();
        System.out.println("Ingrese la contraseña del usuario: ");
        String password = sc.nextLine();

    }

    public void selectById(int id){

    }

    public void update(){

    }

    public void delete(int id) {

    }

    public void selectState(int id) {
    }

}