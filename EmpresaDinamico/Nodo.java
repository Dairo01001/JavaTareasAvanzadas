package JavaTareasAvanzadas.EmpresaDinamico;

/**
 *
 * @author Dairo Garcia
 * @param <T>
 */
public class Nodo<T> {

    private T dato;
    private Nodo<T> siguiente;

    public Nodo() {
        this.dato = null;
        this.siguiente = null;
    }

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Nodo(T dato, Nodo<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodo [" + "Dato: " + dato + ", Siguiente: " + siguiente + ']';
    }
}
