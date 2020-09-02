package JavaTareasAvanzadas.Hotel;

/**
 * @author garci
 */
public class Cliente {

    private int id;
    private String nombre;
    private String procedencia;
    private int edad;

    public Cliente(int id, String nombre, String procedencia, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.procedencia = procedencia;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona [" + "Id: " + id + ", Nombre: " + nombre + ", Procedencia: " + procedencia + ", Edad: " + edad + ']';
    }
}
