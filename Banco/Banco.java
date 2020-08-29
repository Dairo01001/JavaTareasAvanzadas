package JavaTareasAvanzadas.Banco;

/**
 * @author Dairo
 */
public class Banco {

    private final Cliente[] clientes;
    private final int cantidad;
    private int aux = 0;

    public Banco(int cantidad) {
        this.clientes = new Cliente[cantidad];
        this.cantidad = cantidad;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Cliente getCliente(int idCliente) {
        if (idCliente > this.cantidad) {
            System.out.println("Cliente No Existe");
            return null;
        } else {
            return this.clientes[idCliente];
        }
    }

    public void setCliente(Cliente cliente) {
        if (this.cantidad > this.aux) {
            this.clientes[this.aux++] = cliente;
        } else {
            System.out.println("Clientes completos");
        }
    }

    public void ordenarNombres() {
        Cliente auxC;
        for (int i = 1; i < this.clientes.length; i++) {
            auxC = this.clientes[i];
            int j = i - 1;
            while ((j >= 0) && (auxC.getCliente().getNombre().compareTo(this.clientes[j].getCliente().getNombre()) < 0)) {
                this.clientes[j + 1] = this.clientes[j];
                j--;
            }
            this.clientes[j + 1] = auxC;
        }
    }

    public void ordenarSaldo() {
        Cliente auxC;
        for (int i = 1; i < this.clientes.length; i++) {
            auxC = this.clientes[i];
            int j = i - 1;
            while ((j >= 0) && (auxC.getCuenta().getSaldo() < this.clientes[j].getCuenta().getSaldo())) {
                this.clientes[j + 1] = this.clientes[j];
                j--;
            }
            this.clientes[j + 1] = auxC;
        }
    }

    public void ordenarNumeroCuenta() {
        Cliente auxC;
        for (int i = 1; i < this.clientes.length; i++) {
            auxC = this.clientes[i];
            int j = i - 1;
            while ((j >= 0) && (auxC.getCuenta().getID() < this.clientes[j].getCuenta().getID())) {
                this.clientes[j + 1] = this.clientes[j];
                j--;
            }
            this.clientes[j + 1] = auxC;
        }
    }

    @Override
    public String toString() {
        String s = "Banco \n";
        for (int i = 0; i < this.aux; i++) {
            s += this.clientes[i].toString() + '\n';
        }
        return s;
    }

}
