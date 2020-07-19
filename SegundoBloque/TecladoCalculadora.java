package JavaTareasAvanzadas.SegundoBloque;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Dairo García Naranjo
 */
public class TecladoCalculadora extends JPanel implements ActionListener {

    public TecladoCalculadora(Display display) {
        this.display = display;
        this.initJPanel();
        this.initComponets();
    }

    private void initJPanel() {
        this.setLayout(new GridBagLayout());
        this.setName("Calculadora");
    }

    private void initComponets() {
        this.calculadora = new Calculadora();
        ActionListener telclasEspeciales;

        telclasEspeciales = (ActionEvent e) -> {
            this.inicio = !this.inicio;
            this.numero++;
            if (this.numero == 2) {
                this.calculadora.setB(this.display.getNum());
                switch (this.aux) {
                    case SUMA:
                        this.display.setText(this.calculadora.getSuma());
                        break;
                    case RESTA:
                        this.display.setText(this.calculadora.getResta());
                        break;
                    case MULTIPLICACION:
                        this.display.setText(this.calculadora.getMultiplicacion());
                        break;
                    case DIVISION:
                        this.display.setText(this.calculadora.getDivision());
                        break;
                    default:
                        break;
                }
                this.aux = "";
                this.numero = 0;
            } else {
                this.calculadora.setA(this.display.getNum());
                this.aux = e.getActionCommand();
            }
        };
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(this.initJButton(this.SUMA, telclasEspeciales), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(this.initJButton(this.RESTA, telclasEspeciales), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(this.initJButton(this.DIVISION, telclasEspeciales), gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(this.initJButton(this.MULTIPLICACION, telclasEspeciales), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(this.initJButton("1"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(this.initJButton("2"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(this.initJButton("3"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        this.add(this.initJButton(this.PUNTO), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(this.initJButton("4"), gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(this.initJButton("5"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        this.add(this.initJButton("6"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        this.add(this.initJButton(this.LIMPIAR), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(this.initJButton("7"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(this.initJButton("8"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        this.add(this.initJButton("9"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        this.add(this.initJButton(this.IGUAL, telclasEspeciales), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(this.initJButton("0"), gbc);
    }

    private JButton initJButton(String nombre) {
        JButton jBt = new JButton(nombre);
        jBt.setFont(Ventana.FONT);
        jBt.addActionListener(this);
        return jBt;
    }

    private JButton initJButton(String nombre, ActionListener l) {
        JButton jBt = new JButton(nombre);
        jBt.setFont(Ventana.FONT);
        jBt.addActionListener(l);
        return jBt;
    }

    private final Display display;
    private boolean inicio = true;
    private int numero = 0;

    // Constantes para operaciones especiles
    private final String DIVISION = "/";
    private final String MULTIPLICACION = "X";
    private final String RESTA = "-";
    private final String SUMA = "+";
    private final String IGUAL = "=";
    private final String LIMPIAR = "AC";
    private final String PUNTO = ".";

    private String aux;
    private Calculadora calculadora;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getActionCommand().equals(this.LIMPIAR)) {
            if (this.inicio) {
                this.display.setText("");
                this.inicio = !this.inicio;
            }
            String auxl = this.display.getText();
            if (auxl.length() != 8) {
                this.display.setText(auxl + e.getActionCommand());
            }
        } else {
            this.display.setText("");
            this.calculadora.setA(0);
            this.calculadora.setB(0);
            this.inicio = true;
        }
    }
}
