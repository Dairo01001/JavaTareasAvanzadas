package JavaTareasAvanzadas.Banco;

/**
 *
 * @author garci
 */
public class Cliente {
    
    private Persona cliente;
    private Cuenta cuenta;

    public Cliente(Persona cliente, Cuenta cuenta) {
        this.cliente = cliente;
        this.cuenta = cuenta;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "cliente=" + cliente + ", cuenta=" + cuenta + '}';
    }
    
}
