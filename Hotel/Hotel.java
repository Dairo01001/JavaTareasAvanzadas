package JavaTareasAvanzadas.Hotel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author garci
 */
public class Hotel {

    private Piso[] pisos;
    private final int numeroPisos;
    private int aux;

    public Hotel(int numeroPisos) {
        this.numeroPisos = numeroPisos;
        this.pisos = new Piso[numeroPisos];
        this.aux = 0;
    }

    public Piso[] getPisos() {
        return pisos;
    }

    public void setPisos(Piso[] pisos) {
        this.pisos = pisos;
    }

    public void setPiso(Piso piso) {
        if (this.aux < this.numeroPisos) {
            this.pisos[this.aux++] = piso;
        } else {
            System.out.println("Pisos no disponibles");
        }
    }
    
    public int getNumeroPisos() {
        return numeroPisos;
    }

    @Override
    public String toString() {
        return "Hotel [" + "\nPisos: " + Arrays.toString(pisos) + "\nNumero Pisos: " + numeroPisos + ']';
    }
}
