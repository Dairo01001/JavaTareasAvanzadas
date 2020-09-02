package JavaTareasAvanzadas.Hotel;

import java.util.Scanner;

/**
 * @author garci
 */
public class Main {

    private static void Menu(Hotel hotel, Scanner sc) {
        System.out.println("<----- HOTEL ----->");
        System.out.println(hotel);
        while(true){
            System.out.println("Registro de Pisos: ");
            for (int i = 0; i < hotel.getNumeroPisos(); i++) {
                System.out.println("Numero");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel h = new Hotel(10);
        Menu(h, sc);
    }
}
