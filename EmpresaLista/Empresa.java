package JavaTareasAvanzadas.EmpresaLista;

/**
 * @author Dairo Garcia Naranjo
 */
public class Empresa {

    private ListaSimple empleados;

    public Empresa() {
        this.empleados = new ListaSimple();
    }

    public ListaSimple getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ListaSimple empleados) {
        this.empleados = empleados;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleados.agregarInicio(empleado);
    }

    public ListaSimple getSuperanQuinientosMill() {
        ListaSimple au = new ListaSimple();
        for (Nodo aux = this.empleados.getInicio(); aux != null; aux = aux.getSiguiente()) {
            if (aux.getDato().getSuma() > 500000) {
                au.agregarInicio(aux.getDato());
            }
        }
        return au;
    }

    public ListaSimple getNombreA() {
        ListaSimple au = new ListaSimple();
        for (Nodo aux = this.empleados.getInicio(); aux != null; aux = aux.getSiguiente()) {
            char auxC = aux.getDato().getNombre().charAt(0);
            auxC = Character.toLowerCase(auxC);
            if (auxC == 'a') {
                au.agregarInicio(aux.getDato());
            }
        }
        return au;
    }

    public ListaSimple getAncianos() {
        ListaSimple au = new ListaSimple();
        for (Nodo aux = this.empleados.getInicio(); aux != null; aux = aux.getSiguiente()) {
            if (aux.getDato().getEdad() > 60) {
                au.agregarInicio(aux.getDato());
            }
        }
        return au;
    }

    @Override
    public String toString() {
        String au = "";
        for (Nodo aux = this.empleados.getInicio(); aux != null; aux = aux.getSiguiente()) {
            au += aux.getDato().toString() + "\n";
        }
        return "Empresa [" + "Empleados: \n" + au + "\n]";
    }

}
