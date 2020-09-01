package JavaTareasAvanzadas.Empresa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Empresa em = new Empresa();
        for (int i = 0; i < 10; i++) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            em.setEmpleado(new Empleados(nombre, (int) (Math.random() * 100)));
        }
        System.out.println(em);

        ArrayList aux;

        aux = em.getAncianos();

        System.out.println("Ancianos");
        System.out.println(Arrays.toString(aux.toArray()));
        System.out.println("");

        aux = em.getNombreA();
        System.out.println("La A");
        System.out.println(Arrays.toString(aux.toArray()));
        System.out.println("");

        aux = em.getSuperanQuinientosMill();
        System.out.println("Quinientos Mill");
        System.out.println(Arrays.toString(aux.toArray()));
        System.out.println("");

    }
}
