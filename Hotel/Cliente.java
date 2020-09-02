package JavaTareasAvanzadas.Hotel;

/**
 * @author garci
 */
public class Cliente {

    public int id;
    public String nombre;
    public String apellido;
    public String procedencia;
    public int edad;

    public Cliente(int id, String nombre, String apellido, String procedencia, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.procedencia = procedencia;
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        return "Cliente [" + "Id: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Procedencia: " + procedencia + ", Edad: " + edad + ']';
    }
}
