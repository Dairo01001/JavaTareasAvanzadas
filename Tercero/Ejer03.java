package JavaTareasAvanzadas.Tercero;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejer03 extends JFrame implements ActionListener {
    
    private JPanel buttons, color, letreros;
    private JButton colorAleatorio, salir;
    private JLabel rojo, verde, azul;
    private int r, g, b;
    
    public Ejer03() {
        initVentana();
        initComponentes();
    }
    
    private void initVentana() {
        this.setTitle("Color aleatorio");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }
    
    private void initComponentes() {
        buttons = new JPanel();
        buttons.setBounds(50, 50, 400, 100);
        buttons.setLayout(null);
        this.add(buttons);
        
        colorAleatorio = new JButton("Color");
        colorAleatorio.setBounds(25, 10, 150, 50);
        colorAleatorio.addActionListener(this);
        buttons.add(colorAleatorio);
        
        salir = new JButton("Salir");
        salir.setBounds(225, 10, 150, 50);
        salir.addActionListener(this);
        buttons.add(salir);
        
        color = new JPanel();
        color.setBounds(50, 200, 400, 100);
        color.setBackground(new Color(r, g, b));
        this.add(color);
        
        letreros = new JPanel();
        letreros.setBounds(50, 350, 400, 100);
        letreros.setLayout(null);
        this.add(letreros);
        
        rojo = new JLabel("Red: " + r);
        rojo.setBounds(0, 10, 133, 50);
        letreros.add(rojo);
        
        verde = new JLabel("Green: " + g);
        verde.setBounds(133, 10, 133, 50);
        letreros.add(verde);
        
        azul = new JLabel("Blue: " + b);
        azul.setBounds(266, 10, 133, 50);
        letreros.add(azul);
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(salir)) {
            System.exit(0);
        } else {
            generarColor();
            color.setBackground(new Color(r, g, b));
            rojo.setText("Red: " + r);
            verde.setText("Green: " + g);
            azul.setText("Blue: " + b);
        }
    }
    
    private void generarColor() {
        r = range();
        g = range();
        b = range();
    }
    
    private int range() {
        return (int) (Math.random() * 256);
    }
}
