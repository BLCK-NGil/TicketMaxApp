package App.view;

import App.domain.enums.SelectStateEnum;

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
        String state = getUserState();
        System.out.println("Ingrese la ciudad del usuario");
        String city =sc.nextLine();
        System.out.println("Ingrese las preferencias del usuario");
        String preferences = sc.nextLine();

    }

    //Métodos helper

    public String getUserState(){
        System.out.println("Seleccion 1. Activo  2. Inactivo 3. Bloqueado" );
        int option = sc.nextInt();
        String state = "";
        sc.nextLine();
        switch (option){
            case 1:
                state = SelectStateEnum.ACTIVE.getState();
                break;
            case 2:
                state = SelectStateEnum.INACTIVE.getState();
                break;
            case 3:
                state = SelectStateEnum.INACTIVE.getState();
                break;
            default:
                System.out.println("Opción no válida");

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