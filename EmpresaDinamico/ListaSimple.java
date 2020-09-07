package JavaTareasAvanzadas.EmpresaDinamico;

/**
 * @author Dairo Garcia
 * @param <T>
 */
public class ListaSimple<T> {

    private Nodo<T> inicio;
    private int tamanio;

    public ListaSimple() {
        this.inicio = null;
        this.tamanio = 0;
    }

    public boolean isVacia() {
        return this.inicio == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void agregarInicio(T dato) {
        Nodo<T> nuevo = new Nodo();
        nuevo.setDato(dato);
        if (this.isVacia()) {
            this.inicio = nuevo;
        } else {
            nuevo.setSiguiente(this.inicio);
            this.inicio = nuevo;
        }
        this.tamanio++;
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    @Override
    public String toString() {
        String s = "ListaSimple [";
        for (Nodo aux = inicio; aux != null; aux = aux.getSiguiente()) {
            s += aux.getDato().toString() + "\n";
        }
        s += "]";
        return s;
    }
}
