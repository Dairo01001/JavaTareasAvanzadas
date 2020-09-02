package JavaTareasAvanzadas.Hotel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author garc
 */
public class Piso {

    public int numeroPiso;
    public Habitacion[] habitaciones;
    public int cantidadHabitaciones;
    public int aux;

    // Constructor con parametros
    public Piso(int cantidadHabitaciones, int numeroPiso) {
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.numeroPiso = numeroPiso;
        this.habitaciones = new Habitacion[cantidadHabitaciones];
        this.aux = 0;
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    // Busca una habitacion y la retorna por el numero de habitacion
    public Habitacion getHabitacion(int numeroHabitacion) {
        for (int i = 0; i < this.cantidadHabitaciones; i++) {
            if (numeroHabitacion == this.habitaciones[i].getNumero()) {
                return this.habitaciones[i];
            }
        }
        return null;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    // Llena las habiaticones por cada habitacion
    public void setHabitacion(Habitacion habitacion) {
        if (this.aux < this.cantidadHabitaciones) {
            this.habitaciones[this.aux++] = habitacion;
        } else {
            System.out.println("Este piso no tiene habitaciones disponibles");
        }
    }

    // retorna un arraylist de la habitaciones ocupadas ordenadas por apellido
    public ArrayList<Habitacion> getHabitacionesOcupadas() {
        ArrayList<Habitacion> auxH = new ArrayList();
        // si la habiatcion esta ocupada la agrega al array list
        for (Habitacion habitacione : this.habitaciones) {
            if (!habitacione.isLibre()) {
                auxH.add(habitacione);
            }
        }
        
        // metodo de ordenamiento
        Habitacion auxC;
        for (int i = 1; i < auxH.size(); i++) {
            auxC = auxH.get(i);
            int j = i - 1;
            while ((j >= 0) && (auxC.getHuesped().getApellido().compareTo(auxH.get(i).getHuesped().getApellido()) < 0)) {
                auxH.set(j + 1, auxH.get(j));
                j--;
            }
            auxH.set(j + 1, auxC);
        }
        return auxH;
    }

    @Override
    public String toString() {
        return "\nPiso [" + " NumeroPiso=" + numeroPiso + ", Habitaciones: " + Arrays.toString(habitaciones) + ']';
    }

}
