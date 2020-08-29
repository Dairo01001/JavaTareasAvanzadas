package JavaTareasAvanzadas.Banco;

/**
 *
 * @author garci
 */
public class Main {
    public static void main(String[] args) {
        Banco b = new Banco(5);
        
        Persona p1 = new Persona("Pedro", 'M');
        Cuenta cu1 = new Cuenta();
        
        Persona p2 = new Persona("Yudy", 'F');
        Cuenta cu2 = new Cuenta();
        
        Persona p3 = new Persona("Dairo", 'M');
        Cuenta cu3 = new Cuenta();
        
        Persona p4 = new Persona("Chingal", 'M');
        Cuenta cu4 = new Cuenta();
        
        Persona p5 = new Persona("Kevin", 'M');
        Cuenta cu5 = new Cuenta();
        
        
        
        Cliente c1 = new Cliente(p1, cu1);
        Cliente c2 = new Cliente(p2, cu2);
        Cliente c3 = new Cliente(p3, cu3);
        Cliente c4 = new Cliente(p4, cu4);
        Cliente c5 = new Cliente(p5, cu5);
        
        
        
        b.setCliente(c1);
        b.setCliente(c2);
        b.setCliente(c3);
        b.setCliente(c4);
        b.setCliente(c5);
        
        
        
        System.out.println(b);
        
        
        b.getCliente(0).getCuenta().setSaldo(500000);
        
        System.out.println(b);
        
        b.getCliente(0).getCuenta().retirar(45000);
        
        System.out.println(b);
        
        b.getCliente(0).getCuenta().setClave(1234);
        
        System.out.println(b);
        
        b.getCliente(0).getCuenta().setActiva(false);
        
        System.out.println(b);
        
        // System.out.println(b.getClientes()[0].toString());
        
        
   }
}
