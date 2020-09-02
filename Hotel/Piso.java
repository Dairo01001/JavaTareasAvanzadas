package JavaTareasAvanzadas.Hotel;

import java.util.Arrays;

/**
 * @author garc
 */
public class Piso {

    private int numeroPiso;
    private Habitacion[] habitaciones;
    private int cantidadHabitaciones;
    private int aux;

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

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public void setHabitacion(Habitacion habitacion) {
        if (this.aux < this.cantidadHabitaciones) {
            this.habitaciones[this.aux++] = habitacion;
        } else {
            System.out.println("Este piso no tiene habitaciones disponibles");
        }
    }

    @Override
    public String toString() {
        return "Piso [" + " NumeroPiso=" + numeroPiso + ", Habitaciones: " + Arrays.toString(habitaciones) + ']';
    }

}
