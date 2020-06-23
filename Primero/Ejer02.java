package Primero;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author dairo
 */
public class Ejer02 extends JFrame implements ItemListener {

    private JComboBox<String> operaciones;
    private JTextField a;
    private JTextField b;
    private JLabel ans;

    private Calculadora calculadora;
    private boolean bandera = true;

    public Ejer02() {
        this.initEjer02();
        this.inicializarComponentes();
    }

    private void initEjer02() {
        this.setLayout(null);
        this.setBounds(0, 0, 500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        String opera[] = {"", "Suma", "Resta", "Multiplicacion", "Division", "Reiniciar"};
        this.operaciones = new JComboBox<>();
        this.operaciones.setBounds(100, 100, 100, 50);
        this.add(this.operaciones);
        for (String operacion : opera) {
            this.operaciones.addItem(operacion);
        }
        operaciones.addItemListener(this);
        this.calculadora = new Calculadora();

        this.a = new JTextField("0");
        this.b = new JTextField("0");
        this.ans = new JLabel("Respuesta: ");

        this.a.setBounds(250, 100, 100, 50);
        this.b.setBounds(250, 150, 100, 50);
        this.ans.setBounds(250, 200, 200, 50);

        this.add(this.a);
        this.add(this.b);
        this.add(this.ans);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (this.bandera) {
            this.calculadora.setNum1(Double.parseDouble(this.a.getText()));
            this.calculadora.setNum2(Double.parseDouble(this.b.getText()));
            this.bandera = false;
            this.a.setEditable(false);
            this.b.setEditable(false);
        }

        if (e.getSource().equals(this.operaciones)) {
            String op = (String) this.operaciones.getSelectedItem();
            this.setTitle(op);
            switch (op) {
                case "Suma":
                    this.ans.setText("Respuesta: " + this.calculadora.suma());
                    break;
                case "Resta":
                    this.ans.setText("Respuesta: " + this.calculadora.resta());
                    break;
                case "Multiplicacion":
                    this.ans.setText("Respuesta: " + this.calculadora.multiplicacion());
                    break;
                case "Division":
                    this.ans.setText("Respuesta: " + this.calculadora.division());
                    break;
                case "Reiniciar":
                    this.a.setEditable(true);
                    this.b.setEditable(true);
                    this.a.setText("0");
                    this.b.setText("0");
                    this.ans.setText("Respuesta: " + 0);
                    this.bandera = true;
                    break;
            }
        }
    }
}
