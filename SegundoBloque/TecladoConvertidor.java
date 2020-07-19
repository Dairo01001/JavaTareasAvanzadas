package JavaTareasAvanzadas.SegundoBloque;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Dairo García Naranjo
 */
public class TecladoConvertidor extends JPanel {

    public TecladoConvertidor(Display display) {
        this.display = display;
        this.initJPanel();
        this.initComponets();
    }

    private void initJPanel() {
        this.setLayout(new BorderLayout());
        this.setName("Convertidor");
    }

    private void initComponets() {
        this.initJPanelDecimal();
        this.initJPanelBinario();
        this.initJButtonComvertidor();
        this.limpiar();
    }

    private void limpiar() {
        this.limpiar = new JButton("Limpiar");
        this.limpiar.setFont(Ventana.FONT);
        this.limpiar.addActionListener((ActionEvent e) -> {
            this.display.setText("");
        });
        this.add(this.limpiar, BorderLayout.SOUTH);
    }

    private void initJPanelDecimal() {
        ActionListener actionListener = (ActionEvent e) -> {
            if (this.inicio) {
                this.display.setText("");
                this.inicio = !this.inicio;
            }
            this.display.setText(this.display.getText() + e.getActionCommand());
        };
        this.decimal = new JPanel();
        this.decimal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.decimal.add(this.initButtonDecimal("1", actionListener), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.decimal.add(this.initButtonDecimal("2", actionListener), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.decimal.add(this.initButtonDecimal("3", actionListener), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        this.decimal.add(this.initButtonDecimal("4", actionListener), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;

        this.decimal.add(this.initButtonDecimal("5", actionListener), gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        this.decimal.add(this.initButtonDecimal("6", actionListener), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.decimal.add(this.initButtonDecimal("7", actionListener), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.decimal.add(this.initButtonDecimal("8", actionListener), gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        this.decimal.add(this.initButtonDecimal("9", actionListener), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.decimal.add(this.initButtonDecimal("0", actionListener), gbc);

        this.add(this.decimal, BorderLayout.CENTER);
    }

    private JButton initButtonDecimal(String nombre, ActionListener actionListener) {
        JButton jBt = new JButton(nombre);
        jBt.setFont(Ventana.FONT);
        jBt.addActionListener(actionListener);
        return jBt;
    }

    private void initJPanelBinario() {
        ActionListener actionListener = (ActionEvent e) -> {
            this.display.setText(this.display.getText() + e.getActionCommand());
        };
        this.binario = new JPanel();
        this.binario.setLayout(new GridLayout());

        JButton jBt0 = new JButton("0");
        jBt0.setFont(Ventana.FONT);
        jBt0.addActionListener(actionListener);
        this.binario.add(jBt0);

        JButton jBt1 = new JButton("1");
        jBt1.setFont(Ventana.FONT);
        jBt1.addActionListener(actionListener);
        this.binario.add(jBt1);
    }

    private void initJButtonComvertidor() {
        this.convertidor = new Convertidor();
        ActionListener actionListener = (ActionEvent e) -> {
            if (e.getSource().equals(this.getBinario)) {
                this.decimal.setVisible(false);
                this.binario.setVisible(true);
                this.getBinario.setEnabled(false);
                this.getDecimal.setEnabled(true);
                this.display.setText(this.convertidor.getBinario(this.display.getText()));
                this.add(this.binario, BorderLayout.CENTER);
            } else {
                this.binario.setVisible(false);
                this.decimal.setVisible(true);
                this.getDecimal.setEnabled(false);
                this.getBinario.setEnabled(true);
                this.display.setText(this.convertidor.getDecimal(this.display.getText()));
                this.add(this.decimal, BorderLayout.CENTER);
            }
        };

        JPanel jP = new JPanel(new GridLayout(2, 1));

        this.getDecimal = new JButton("Decimal");
        this.getDecimal.setFont(Ventana.FONT);
        this.getDecimal.addActionListener(actionListener);
        this.getDecimal.setEnabled(false);
        jP.add(this.getDecimal);

        this.getBinario = new JButton("Binario");
        this.getBinario.setFont(Ventana.FONT);
        this.getBinario.addActionListener(actionListener);
        jP.add(this.getBinario);

        this.add(jP, BorderLayout.NORTH);
    }

    public JButton getGetBinario() {
        return getBinario;
    }

    public JButton getGetDecimal() {
        return getDecimal;
    }

    private JPanel decimal;
    private JPanel binario;

    private JButton getBinario;
    private JButton getDecimal;

    private JButton limpiar;

    private boolean inicio = true;
    private Convertidor convertidor;

    private final Display display;
}
