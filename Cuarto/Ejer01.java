package JavaTareasAvanzadas.Cuarto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class Ejer01 extends JFrame {
    
    public Ejer01() {
        this.initJFrame();
        this.initComponets();
    }
    
    private void initJFrame() {
        this.setTitle("BorderLayout");
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(2, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initComponets() {
        this.initJP1();
        this.initJP2();
    }
    
    private void initJP1() {
        this.jP1 = new JPanel(new GridLayout(4, 1));
        this.jP1.add(this.initJLabel("Vgap"));
        this.vgap = this.initJSlider();
        this.vgap.addChangeListener((ChangeEvent e) -> {
            this.boderLayout.setVgap(this.vgap.getValue());
            this.jP2.updateUI();
        });
        this.jP1.add(this.vgap);
        this.jP1.add(this.initJLabel("Hgap"));
        this.hgap = this.initJSlider();
        this.hgap.addChangeListener((ChangeEvent e) -> {
            this.boderLayout.setHgap(this.hgap.getValue());
            this.jP2.updateUI();
        });
        this.jP1.add(this.hgap);
        this.add(this.jP1);
    }
    
    private JSlider initJSlider() {
        JSlider jSl = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        jSl.setFont(this.font);
        jSl.setMajorTickSpacing(10);
        jSl.setMinorTickSpacing(1);
        jSl.setPaintTicks(true);
        jSl.setPaintLabels(true);
        return jSl;
    }
    
    private JLabel initJLabel(String nombre) {
        JLabel jL = new JLabel(nombre);
        jL.setFont(this.font);
        return jL;
    }
    
    private void initJP2() {
        this.jP2 = new JPanel();
        this.boderLayout = new BorderLayout();
        this.jP2.setLayout(this.boderLayout);
        this.jP2.add(this.initJButton("JButton (NORTH)"), BorderLayout.NORTH);
        this.jP2.add(this.initJButton("JButton (SOUTH)"), BorderLayout.SOUTH);
        this.jP2.add(this.initJButton("JButton (WEST)"), BorderLayout.WEST);
        this.jP2.add(this.initJButton("JButton (EAST)"), BorderLayout.EAST);
        this.jP2.add(this.initJButton("JButton (CENTER)"), BorderLayout.CENTER);
        this.add(this.jP2);
    }
    
    private JButton initJButton(String nombre) {
        JButton jBt = new JButton(nombre);
        jBt.setFont(this.font);
        return jBt;
    }
    
    private JPanel jP1, jP2;
    private JSlider hgap, vgap;
    private BorderLayout boderLayout;
    
    private final Font font = new Font("Courier New", Font.BOLD, 20);
    
    public static void main(String[] args) {
        Ejer01 ventana = new Ejer01();
        ventana.setVisible(true);
    }
}
