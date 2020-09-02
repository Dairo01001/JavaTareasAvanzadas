package JavaTareasAvanzadas.Hotel;

/**
 * @author garci
 */
public class Habitacion {

    private int numero;
    private Cliente huesped;
    private boolean reserva;
    private boolean ocupada;

    public Habitacion(int numero) {
        this.numero = numero;
        this.huesped = null;
        this.reserva = false;
        this.ocupada = false;
    }

    public boolean isLibre() {
        return this.huesped == null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getHuesped() {
        return huesped;
    }

    public void setHuesped(Cliente huesped) {
        this.reserva = true;
        this.ocupada = true;
        this.huesped = huesped;
    }

    public boolean isReserva() {
        return reserva;
    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "\nHabitacion [" + "Numero: " + numero + ", Huesped: " + huesped + ", Reserva: " + reserva + ", Ocupada: " + ocupada + ']';
    }
}
