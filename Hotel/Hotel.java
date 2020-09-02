package JavaTareasAvanzadas.Hotel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author garci
 */
public class Hotel {

    public Piso[] pisos;
    public final int numeroPisos;
    public int aux;

    public Hotel(int numeroPisos) {
        this.numeroPisos = numeroPisos;
        this.pisos = new Piso[numeroPisos];
        this.aux = 0;
    }

    // Retorna el vector donde estan los Pisos
    public Piso[] getPisos() {
        return pisos;
    }

    // Para cambiar los Pisos pero se nevia el vector completo
    public void setPisos(Piso[] pisos) {
        this.pisos = pisos;
    }

    // Para llenar los pisos del Hotel pero enviando piso por piso
    public void setPiso(Piso piso) {
        if (this.aux < this.numeroPisos) {
            this.pisos[this.aux++] = piso;
        } else {
            System.out.println("Pisos no disponibles");
        }
    }
    
    // retorna el numero de pisos del hotel
    public int getNumeroPisos() {
        return numeroPisos;
    }

    @Override
    public String toString() {
        return "Hotel [" + "\nPisos: " + Arrays.toString(pisos) + "\nNumero Pisos: " + numeroPisos + ']';
    }
}
