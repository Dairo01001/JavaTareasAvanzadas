package JavaTareasAvanzadas.Ejercicio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;


/**
 * @author Dairo Garcia
 */
public class Opcion1 extends JFrame {

    public Opcion1() {
        this.initJFrame();
        this.initComponets();
    }

    private void initJFrame() {
        this.setTitle("Opcion - 1");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponets() {
        jPanel1 p1 = new jPanel1();
        jPanel2 p2 = new jPanel2();
        jPanel3 p3 = new jPanel3();
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.add(p3, BorderLayout.SOUTH);
    }

    private class jPanel1 extends JPanel {

        public jPanel1() {
            this.initJPanel();
            this.initComponets();
        }

        private void initJPanel() {
            this.setBackground(Color.DARK_GRAY);
        }

        private void initComponets() {
            radioButtons = new ButtonGroup();
            this.rojo = this.initJRadioButton("Rojo");
            this.verde = this.initJRadioButton("Verde");
            this.azul = this.initJRadioButton("Azul");

            final String tipos[] = {"Courier New", "Algerian", "Arial"};
            tipoDeLetra = new JList(tipos);
            tipoDeLetra.setFont(font);
            add(tipoDeLetra);
            tipoDeLetra.addListSelectionListener((ListSelectionEvent e) -> {
                if (!e.getValueIsAdjusting()) {
                    if (flagLimpiar) {
                        tipo = tipos[tipoDeLetra.getSelectedIndex()];
                    }
                }
                if (flagLimpiar) {
                    actualizarLetra();
                }
            });

        }

        private JRadioButton initJRadioButton(String nombre) {
            JRadioButton jRb = new JRadioButton(nombre);
            radioButtons.add(jRb);
            jRb.setFont(font);
            jRb.addActionListener(this.actionListener);
            this.add(jRb);
            return jRb;
        }

        private final ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rojo.isSelected()) {
                    muestra.setForeground(Color.RED);
                } else if (verde.isSelected()) {
                    muestra.setForeground(Color.GREEN);
                } else if (azul.isSelected()) {
                    muestra.setForeground(Color.BLUE);
                }
            }
        };

        private JRadioButton rojo, verde, azul;
    }

    private class jPanel2 extends JPanel {

        public jPanel2() {
            this.initJPanel();
            this.initComponets();
        }

        private void initJPanel() {
            this.setBackground(Color.BLUE);
        }

        private void initComponets() {
            negrita = new JCheckBox("Negrita");
            negrita.setFont(font);
            negrita.addActionListener(this.actionListener);
            this.add(negrita);

            cursiva = new JCheckBox("Cursiva");
            cursiva.setFont(font);
            cursiva.addActionListener(this.actionListener);
            this.add(cursiva);
        }

        private final ActionListener actionListener = (ActionEvent e) -> {
            actualizarLetra();
        };

    }

    private class jPanel3 extends JPanel {

        public jPanel3() {
            this.initJPanel();
            this.initComponets();
        }

        private void initJPanel() {
            this.setBackground(Color.ORANGE);
        }

        private void initComponets() {
            muestra = new JLabel("¡Hola Mundo!");
            muestra.setFont(fontMuestra);
            add(muestra);

            limpiar = new JButton("Limpiar");
            limpiar.setFont(font);
            this.add(limpiar);

            limpiar.addActionListener((ActionEvent e) -> {
                flagLimpiar = false;
                negrita.setSelected(false);
                cursiva.setSelected(false);
                muestra.setForeground(Color.BLACK);
                tipoDeLetra.clearSelection();
                tipo = "Courier New";
                radioButtons.clearSelection();
                fontMuestra = new Font(tipo, Font.PLAIN, 20);
                muestra.setFont(font);
                flagLimpiar = true;
            });
        }
    }

    private void actualizarLetra() {
        if (negrita.isSelected() && cursiva.isSelected()) {
            fontMuestra = new Font(tipo, Font.BOLD | Font.ITALIC, 20);
        } else if (negrita.isSelected()) {
            fontMuestra = new Font(tipo, Font.BOLD, 20);
        } else if (cursiva.isSelected()) {
            fontMuestra = new Font(tipo, Font.ITALIC, 20);
        } else {
            fontMuestra = new Font(tipo, Font.PLAIN, 20);
        }
        muestra.setFont(fontMuestra);
    }

    private JLabel muestra;
    private JButton limpiar;
    private final Font font = new Font("Courier New", Font.BOLD, 20);

    private String tipo = "Courier New";
    private Font fontMuestra = new Font(this.tipo, Font.PLAIN, 20);
    private JCheckBox negrita;
    private JCheckBox cursiva;
    private JList tipoDeLetra;
    private ButtonGroup radioButtons;

    private boolean flagLimpiar = true;

    public static void main(String[] args) {
        Opcion1 ventana = new Opcion1();
        ventana.setVisible(true);
    }
}
