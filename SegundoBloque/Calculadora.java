package JavaTareasAvanzadas.SegundoBloque;

/**
 * @author Dairo García Naranjo
 */
public class Calculadora {

    public Calculadora() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getSuma() {
        return a + b;
    }

    public double getResta() {
        return a - b;
    }

    public double getDivision() {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            return a / b;
        }
    }

    public double getMultiplicacion() {
        return a * b;
    }

    private double a;
    private double b;
}
