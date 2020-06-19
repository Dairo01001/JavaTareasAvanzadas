package Primero;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author dairo
 */
public class Ejer02 extends JFrame implements ItemListener {

    private static final long serialVersionUID = 2L;

    private JComboBox<String> operaciones;
    private JTextField a;
    private JTextField b;
    private JLabel ans;

    public Ejer02() {
        this.setLayout(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        String opera[] = {"", "Suma", "Resta", "Multiplicacion", "Division", "Reiniciar"};
        this.operaciones = new JComboBox<String>();
        this.operaciones.setBounds(100, 100, 100, 50);
        this.add(this.operaciones);
        for (String operacion : opera) {
            this.operaciones.addItem(operacion);
        }
        operaciones.addItemListener(this);

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

    public void itemStateChanged(ItemEvent e) {
        double num1 = Double.parseDouble(this.a.getText());
        double num2 = Double.parseDouble(this.b.getText());

        this.a.setEditable(false);
        this.b.setEditable(false);

        if (e.getSource().equals(this.operaciones)) {
            String op = (String) this.operaciones.getSelectedItem();
            this.setTitle(op);
            switch (op) {
                case "Suma":
                    this.ans.setText("Respuesta: " + (num1 + num2));
                    break;
                case "Resta":
                    this.ans.setText("Respuesta: " + (num1 - num2));
                    break;
                case "Multiplicacion":
                    this.ans.setText("Respuesta: " + (num1 * num2));
                    break;
                case "Division":
                    if (num1 == 0 || num2 == 0) {
                        this.ans.setText("Respuesta: " + 0);
                    } else {
                        this.ans.setText("Respuesta: " + (num1 / num2));
                    }
                    break;
                case "Reiniciar":
                    this.a.setEditable(true);
                    this.b.setEditable(true);
                    this.a.setText("0");
                    this.b.setText("0");
                    this.ans.setText("Respuesta: " + 0);
                    break;
            }
        }
    }

    public static void main(String[] ar) {
        Ejer01 operaciones = new Ejer01();
        operaciones.setBounds(0, 0, 500, 500);
        operaciones.setLocationRelativeTo(null);
        operaciones.setVisible(true);
        operaciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
