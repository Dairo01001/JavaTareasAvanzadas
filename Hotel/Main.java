package JavaTareasAvanzadas.Hotel;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author garci
 */
public class Main {

    private static void Menu(Hotel hotel, Scanner sc) {
        System.out.println("<----- HOTEL ----->");
        System.out.println(hotel);
        System.out.println("Registro de Pisos: ");
        int aux = 0;
        for (int i = 0; i < hotel.getNumeroPisos(); i++) {
            System.out.print("Digita la cantidad de habitaciones para el piso #" + i + ": ");
            int cantidadHabitaciones = sc.nextInt();
            hotel.setPiso(new Piso(cantidadHabitaciones, i));
            for (int j = 0; j < cantidadHabitaciones; j++) {
                hotel.getPisos()[i].setHabitacion(new Habitacion(aux++));
            }
        }
        System.out.println(hotel);
        while (true) {
            System.out.println("<--- MENU --->");
            System.out.println("1: Hacer reserva");
            int reserva = sc.nextInt();
            if (reserva == 1) {
                System.out.println(hotel);
                System.out.println("<-- LISTA PISOS -->");
                for (int i = 0; i < hotel.getNumeroPisos(); i++) {
                    System.out.println(hotel.getPisos()[i]);
                    mostrarHabitacionesDisponibles(hotel.getPisos()[i]);
                }
                System.out.print("QUE PISO DESEA? ");
                int piso = sc.nextInt();
                mostrarHabitacionesDisponibles(hotel.getPisos()[piso]);
                System.out.print("QUE HABITACION DESEA? ");
                int habitacion = sc.nextInt();
                Habitacion auxH = hotel.getPisos()[piso].getHabitacion(habitacion);
                if (auxH == null) {
                    System.out.println("Numero de habitacion herrado");
                } else {
                    System.out.println("<-- REGISTRO DE HUESPED -->");
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("EDAD: ");
                    int edad = sc.nextInt();
                    System.out.print("NOMBRE: ");
                    sc.skip("\n");
                    String nombre = sc.nextLine();
                    System.out.print("APELLIDO: ");
                    String apellido = sc.nextLine();
                    System.out.print("PROCENDENCIA: ");
                    String procedencia = sc.nextLine();
                    auxH.setHuesped(new Cliente(id, nombre, apellido, procedencia, edad));
                }
                System.out.println(hotel.getPisos()[piso]);
                System.out.println("HABITACIONES OCUPADAS: ");
                System.out.println(Arrays.toString(hotel.getPisos()[piso].getHabitacionesOcupadas().toArray()));
            }

        }
    }

    private static void mostrarHabitacionesDisponibles(Piso piso) {
        System.out.println("<-- Habitaciones Disponibles -->");
        for (int j = 0; j < piso.getCantidadHabitaciones(); j++) {
            if (piso.getHabitaciones()[j].isLibre()) {
                System.out.println(piso.getHabitaciones()[j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<----- HOTEL ----->");
        System.out.print("Digita la cantidad de pisos: ");
        int cantidadPisos = sc.nextInt();
        Hotel h = new Hotel(cantidadPisos);
        Menu(h, sc);
    }
}
