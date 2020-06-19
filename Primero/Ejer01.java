package Primero;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author dairo
 */
public class Ejer01 extends JFrame implements ActionListener {

    private ButtonGroup operaciones;
    private JRadioButton suma;
    private JRadioButton resta;
    private JRadioButton multiplicacion;
    private JRadioButton division;
    private JButton mostrar;
    private JButton intentarDeNuevo;

    private JTextField a;
    private JTextField b;
    private JLabel ans;

    double respuesta = 0D;

    public Ejer01() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("Operaciones");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void inicializarComponentes() {

        this.operaciones = new ButtonGroup();
        this.suma = new JRadioButton("Suma");
        this.resta = new JRadioButton("Resta");
        this.multiplicacion = new JRadioButton("Multiplicacion");
        this.division = new JRadioButton("Divison");
        this.mostrar = new JButton("Mostrar");
        this.intentarDeNuevo = new JButton("Repetir");

        this.a = new JTextField("0");
        this.b = new JTextField("0");
        this.ans = new JLabel();

        this.operaciones.add(this.suma);
        this.operaciones.add(this.resta);
        this.operaciones.add(this.multiplicacion);
        this.operaciones.add(this.division);
        this.mostrar.addActionListener(this);
        this.intentarDeNuevo.addActionListener(this);

        this.suma.setBounds(50, 100, 150, 50);
        this.resta.setBounds(50, 150, 150, 50);
        this.multiplicacion.setBounds(50, 200, 150, 50);
        this.division.setBounds(50, 250, 150, 50);
        this.mostrar.setBounds(250, 200, 120, 50);
        this.intentarDeNuevo.setBounds(200, 400, 100, 50);
        this.a.setBounds(250, 100, 120, 50);
        this.b.setBounds(250, 150, 120, 50);
        this.ans.setBounds(250, 250, 300, 50);

        this.add(this.suma);
        this.add(this.resta);
        this.add(this.multiplicacion);
        this.add(this.division);
        this.add(this.mostrar);
        this.add(this.intentarDeNuevo);
        this.add(this.a);
        this.add(this.b);
        this.add(this.ans);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(this.a.getText());
        double num2 = Double.parseDouble(this.b.getText());

        double resp = 0;
        this.a.setEditable(false);
        this.b.setEditable(false);

        if (this.suma.isSelected()) {
            resp = num1 + num2;
        } else if (this.resta.isSelected()) {
            resp = num1 - num2;
        } else if (this.multiplicacion.isSelected()) {
            resp = num1 * num2;
        } else if (this.division.isSelected()) {
            if (num1 == 0 || num2 == 0) {
                resp = 0;
            } else {
                resp = num1 / num2;
            }
        }

        if (e.getSource().equals(this.mostrar)) {
            mostrar(resp);
        }

        if (e.getSource().equals(this.intentarDeNuevo)) {
            this.a.setEditable(true);
            this.b.setEditable(true);
            this.a.setText("0");
            this.b.setText("0");
            this.respuesta = 0;
            mostrar(0);
        }
    }

    private void mostrar(double ans) {
        this.ans.setText("Respuesta: " + ans);
    }
    
    public static void main(String[] args) {
        Ejer01 ejer01 = new Ejer01();
    }
}
