package JavaTareasAvanzadas.Tercero;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ejer01 extends JFrame implements ChangeListener {
    
    private final int ANCHO = 500;
    private final int ALTO = 500;
    
    private final Font FONT = new Font("freemono", Font.BOLD, 20);
    
    private JLabel red, green, blue;
    private JSlider r, g, b;
    private JPanel color;
    private int rojo = 0, verde = 0, azul = 0;
    
    public Ejer01() {
        initVentana();
        initComponentes();
    }
    
    private void initVentana() {
        this.setTitle("RGB Slider");
        this.setSize(ANCHO, ALTO);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }
    
    private void initComponentes() {
        r = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        r.setMajorTickSpacing(50);
        r.setMinorTickSpacing(5);
        r.setPaintTicks(true);
        r.setPaintLabels(true);
        r.setBounds(50, 60, 400, 50);
        r.addChangeListener(this);
        this.add(r);
        
        g = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        g.setMajorTickSpacing(50);
        g.setMinorTickSpacing(5);
        g.setPaintTicks(true);
        g.setPaintLabels(true);
        g.setBounds(50, 120, 400, 50);
        g.addChangeListener(this);
        this.add(g);
        
        b = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        b.setMajorTickSpacing(50);
        b.setMinorTickSpacing(5);
        b.setPaintTicks(true);
        b.setPaintLabels(true);
        b.setBounds(50, 180, 400, 50);
        b.addChangeListener(this);
        this.add(b);
        
        color = new JPanel();
        color.setBounds(50, 250, 400, 100);
        color.setBackground(new Color(rojo, verde, azul));
        this.add(color);
        
        red = new JLabel("R: " + rojo);
        red.setFont(FONT);
        red.setBounds(50, 400, 100, 50);
        this.add(red);
        
        green = new JLabel("G: " + verde);
        green.setFont(FONT);
        green.setBounds(200, 400, 100, 50);
        this.add(green);
        
        blue = new JLabel("B: " + azul);
        blue.setFont(FONT);
        blue.setBounds(350, 400, 100, 50);
        this.add(blue);
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(r)) {
            rojo = r.getValue();
            red.setText("R: " + rojo);
        } else if (e.getSource().equals(g)) {
            verde = g.getValue();
            green.setText("G: " + verde);
        } else {
            azul = b.getValue();
            blue.setText("B: " + azul);
        }
        color.setBackground(new Color(rojo, verde, azul));   
    }
}
