package JavaTareasAvanzadas.EmpresaLista;

import java.util.Scanner;

/**
 *
 * @author garci
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Empresa em = new Empresa();
        for (int i = 0; i < 10; i++) {
//            System.out.print("Nombre: ");
//            String nombre = sc.nextLine();
            em.setEmpleado(new Empleado("Nombre " + i, (int) (Math.random() * 100)));
        }
        System.out.println(em);

        ListaSimple aux;

        aux = em.getAncianos();
        System.out.println("Ancianos");
        System.out.println(aux.toString());
        System.out.println("");

        aux = em.getNombreA();
        System.out.println("La A");
        System.out.println(aux.toString());
        System.out.println("");

        aux = em.getSuperanQuinientosMill();
        System.out.println("Quinientos Mill");
        System.out.println(aux.toString());
        System.out.println("");

    }
}
