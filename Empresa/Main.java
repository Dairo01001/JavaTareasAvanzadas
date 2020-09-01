package JavaTareasAvanzadas.Empresa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author user
 */

/*
Realice una implementación en donde represente un equipo de fútbol. Para esto creará una clase denominada Jugador, 
los cual tendrán como atributos (privados), nombre, número y posición. Luego realice una clase llamada equipo, 
en esta tendrá como atributos, el nombre del equipo y un arreglo de 11 posiciones de objetos (jugadores) (privados). 
Por último, realice en la clase Main, cree dos equipos y agregue jugadores al equipo, adicionalmente, 
cree un método que le permita saber si el equipo esta complejo, en caso que el equipo de fútbol le haga falta jugadores, 
el método debe informar cuántos restan para completar el equipo.
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
