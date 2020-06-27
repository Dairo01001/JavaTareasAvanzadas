package Segundo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author dairo
 */
public class Ejer03 extends JFrame implements ActionListener {

    private JLabel resultado;
    private JButton jBtnDerecho;
    private JButton jBtnCentro;
    private JButton jBtnIzquierda;

    public Ejer03() {
        this.initVentana();
        this.initComponentes();
    }

    private void initVentana() {
        this.setTitle("Numeros Aleatorios");
        this.setSize(500, 200);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponentes() {
        Font font = new Font("freemono", Font.BOLD, 20);
        Font fontLabel = new Font("freemono", Font.BOLD, 30);

        this.resultado = new JLabel("0");
        this.jBtnDerecho = new JButton("Derecha");
        this.jBtnCentro = new JButton("Centro");
        this.jBtnIzquierda = new JButton("Izquierdo");

        this.resultado.setFont(fontLabel);
        this.jBtnDerecho.setFont(font);
        this.jBtnCentro.setFont(font);
        this.jBtnIzquierda.setFont(font);

        this.resultado.setBounds(200, 10, 100, 80);
        this.resultado.setHorizontalAlignment(SwingConstants.CENTER);
        this.resultado.setVerticalAlignment(SwingConstants.CENTER);

        this.jBtnIzquierda.setBounds(40, 100, 150, 50);
        this.jBtnCentro.setBounds(190, 100, 120, 50);
        this.jBtnDerecho.setBounds(310, 100, 150, 50);

        this.jBtnDerecho.addActionListener(this);
        this.jBtnCentro.addActionListener(this);
        this.jBtnIzquierda.addActionListener(this);

        this.add(this.resultado);
        this.add(this.jBtnDerecho);
        this.add(this.jBtnCentro);
        this.add(this.jBtnIzquierda);

        this.jBtnCentro.setEnabled(false);
        this.jBtnIzquierda.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(this.jBtnDerecho)) {
            this.jBtnDerecho.setEnabled(false);
            this.jBtnCentro.setEnabled(true);
            this.jBtnIzquierda.setEnabled(true);
        } else if (ae.getSource().equals(this.jBtnCentro)) {
            this.resultado.setText("" + ((int) (Math.random() * 101)));
        } else {
            this.jBtnCentro.setEnabled(false);
            this.jBtnDerecho.setEnabled(true);
            this.jBtnIzquierda.setEnabled(false);
        }
    }

}
