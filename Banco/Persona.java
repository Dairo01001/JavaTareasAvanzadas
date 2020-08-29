package JavaTareasAvanzadas.Banco;

/**
 * @author garci
 */
public class Persona {

    public static int ID = 0;

    private String nombre;
    private char genero;
    private final int id;

    public Persona(String nombre, char genero) {
        this.id = Persona.ID++;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", genero=" + genero + ", id=" + id + '}';
    }
}
