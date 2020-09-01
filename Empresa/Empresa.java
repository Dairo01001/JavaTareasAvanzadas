package JavaTareasAvanzadas.Empresa;

import java.util.ArrayList;

/**
 * @author Dairo Garcia Naranjo
 */
public class Empresa {

    private ArrayList<Empleados> empleados;

    public Empresa() {
        this.empleados = new ArrayList();
    }

    public ArrayList<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleados> empleados) {
        this.empleados = empleados;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleados.add(empleado);
    }

    public ArrayList<Empleados> getSuperanQuinientosMill() {
        ArrayList<Empleados> aux = new ArrayList();
        for (Empleados empleado : empleados) {
            if (empleado.getSuma() > 500000) {
                aux.add(empleado);
            }
        }
        return aux;
    }

    public ArrayList<Empleados> getNombreA() {
        ArrayList<Empleados> aux = new ArrayList();
        for (Empleados empleado : empleados) {
            char auxC = empleado.getNombre().charAt(0);
            auxC = Character.toLowerCase(auxC);
            if (auxC == 'a') {
                aux.add(empleado);
            }
        }
        return aux;
    }

    public ArrayList<Empleados> getAncianos() {
        ArrayList<Empleados> aux = new ArrayList();
        for (Empleados empleado : empleados) {
            if (empleado.getEdad() > 60) {
                aux.add(empleado);
            }
        }
        return aux;
    }

    @Override
    public String toString() {
        String aux = "";
        for (Empleados empleado : empleados) {
            aux += empleado.toString() + "\n";
        }
        return "Empresa [" + "Empleados: \n" + aux + "\n]";
    }

}
