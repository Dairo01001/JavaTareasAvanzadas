package JavaTareasAvanzadas.Banco;

/**
 *
 * @author garci
 */
public class Cuenta {

    private String tipo;
    private final long ID;
    private double saldo;
    private int clave;
    private boolean activa;

    public Cuenta() {
        this.ID = this.crearID();
        this.saldo = 50000;
        this.activa = true;
    }

    public Cuenta(String tipo, int clave) {
        this.tipo = tipo;
        this.ID = this.crearID();
        this.saldo = 50000;
        this.clave = clave;
        this.activa = true;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getID() {
        return ID;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo += saldo;
    }

    public void retirar(double retirar) {
        double aux = this.saldo - retirar;
        if (aux < 50000) {
            System.out.println("Saldo Insuficiente");
        } else {
            this.saldo -= retirar;
        }
    }

    private long crearID() {
        long menor = 100000000;
        long mayor = 1000000000;
        return (long) (Math.random() * menor) + mayor;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "tipo=" + tipo + ", ID=" + ID + ", saldo=" + saldo + ", clave=" + clave + ", activa=" + activa + '}';
    }
}
