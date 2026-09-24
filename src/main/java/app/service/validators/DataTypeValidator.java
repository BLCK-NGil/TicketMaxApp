package app.service.validators;

import javax.lang.model.SourceVersion;
import java.util.Scanner;

public class DataTypeValidator {
    private static final Scanner sc = new Scanner(System.in);

    public static int validateInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String text = sc.nextLine().trim();
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Solo se aceptan números enteros.");
            }
        }
    }

    public static String validateString(String prompt){
        while (true) {
            System.out.println(prompt);
            String text = sc.nextLine().trim();
            if (!text.isEmpty()){
                return text;
            }
            System.out.println("Este campo no puede estar vacío");
        }
    }
}
