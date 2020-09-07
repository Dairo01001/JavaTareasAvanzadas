package JavaTareasAvanzadas.EmpresaDinamico;

/**
 * @author Dairo Garcia Naranjo
 */
public class Empresa {

    private ListaSimple<Empleado> empleados;

    public Empresa() {
        this.empleados = new ListaSimple();
    }

    public ListaSimple<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ListaSimple<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleados.agregarInicio(empleado);
    }

    public ListaSimple<Empleado> getSuperanQuinientosMill() {
        ListaSimple<Empleado> au = new ListaSimple();
        for (Nodo aux = this.empleados.getInicio(); aux != null; aux = aux.getSiguiente()) {
            Empleado e = (Empleado) aux.getDato();
            if (e.getSuma() > 500000) {
                au.agregarInicio(e);
            }
        }
        return au;
    }

    public ListaSimple getNombreA() {
        ListaSimple au = new ListaSimple();
        for (Nodo aux = this.empleados.getInicio(); aux != null; aux = aux.getSiguiente()) {
            Empleado e = (Empleado) aux.getDato();
            char auxC = e.getNombre().charAt(0);
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
            Empleado e = (Empleado) aux.getDato();
            if (e.getEdad() > 60) {
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
