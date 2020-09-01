package JavaTareasAvanzadas.Empresa;

/**
 * @author Dairo Garcia Naranjo
 */
public class Empleados extends Persona {

    private final double ventas[];
    private final double suma;

    public Empleados(String nombre, int edad) {
        super(nombre, edad);
        this.ventas = this.generarVentas();
        this.suma = this.getSumas();
    }

    public double[] getVentas() {
        return ventas;
    }

    public double getSumas() {
        double sum = 0;
        for (int i = 0; i < this.ventas.length; i++) {
            sum += this.ventas[i];
        }
        return sum;
    }

    private double[] generarVentas() {
        double aux[] = new double[12];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = Math.random() * 100000;
        }
        return aux;
    }

    public double getSuma() {
        return suma;
    }

    @Override
    public String toString() {
        String aux = super.toString() + "\n";
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Novienbre", "Diciembre"};
        for (int i = 0; i < meses.length; i++) {
            aux += meses[i] + ": " + this.ventas[i] + "\n";
        }
        aux += "Sumatoria: " + this.suma;
        return "Empleados [" + "Ventas: \n" + aux + "\n";
    }
}
