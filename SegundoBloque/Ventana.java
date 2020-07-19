package JavaTareasAvanzadas.SegundoBloque;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Dairo García Naranjo
 */
public class Ventana extends JFrame {
    
    public Ventana() {
        this.initJFrame();
        this.initComponets();
    }
    
    private void initJFrame() {
        this.setTitle("Calculadora-Comvertidor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private void initComponets() {
        this.initJPanelNort();
        this.convertidor = new TecladoConvertidor(this.display);
        this.calculadora = new TecladoCalculadora(this.display);
        
        this.add(this.convertidor, BorderLayout.CENTER);
        this.pack();
    }
    
    private void initJPanelNort() {
        ActionListener actionListener = (ActionEvent e) -> {
            this.display.setText("0");
            if (e.getActionCommand().equals("Convertidor")) {
                this.accionActual.setText(e.getActionCommand());
                this.convertidor.setVisible(true);
                this.calculadora.setVisible(false);
                this.add(this.convertidor, BorderLayout.CENTER);
            } else {
                this.accionActual.setText(e.getActionCommand());
                this.calculadora.setVisible(true);
                this.convertidor.setVisible(false);
                this.add(this.calculadora, BorderLayout.CENTER);
            }
        };
        this.display = new Display();
        
        JPanel jPanelNort = new JPanel(new GridLayout(3, 1));
        
        this.accionActual = new JLabel("Convertidor");
        this.accionActual.setFont(new Font("Courier New", Font.BOLD, 30));
        jPanelNort.add(this.accionActual);
        jPanelNort.add(this.display);
        
        ButtonGroup bg = new ButtonGroup();
        JPanel jP = new JPanel(new GridLayout());
        JRadioButton jRb = new JRadioButton("Convertidor");
        jRb.setFont(new Font("Courier New", Font.BOLD, 14));
        bg.add(jRb);
        jRb.setSelected(true);
        jRb.addActionListener(actionListener);
        jP.add(jRb);
        
        JRadioButton jRb1 = new JRadioButton("Calculadora");
        jRb1.setFont(new Font("Courier New", Font.BOLD, 14));
        bg.add(jRb1);
        jRb1.addActionListener(actionListener);
        jP.add(jRb1);
        jPanelNort.add(jP);
        
        this.add(jPanelNort, BorderLayout.NORTH);
    }
    
    private TecladoCalculadora calculadora;
    private TecladoConvertidor convertidor;
    
    private Display display;
    
    private JLabel accionActual;
    
    public static boolean inicio = true;
    public static final Font FONT = new Font("Courier New", Font.BOLD, 20);
    
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
