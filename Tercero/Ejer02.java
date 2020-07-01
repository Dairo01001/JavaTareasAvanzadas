package JavaTareasAvanzadas.Tercero;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ejer02 extends JFrame implements ChangeListener, ActionListener {

    private JSlider r, g, b;
    private ButtonGroup jRadioButtons;
    private JRadioButton primerJRadioButton, segundoJRadioButton, tercerJRadioButton;
    private JPanel primerJPanel, segundoJPanel, tercerJPanel;
    private int red, green, blue;
    private JButton limpiar;

    public Ejer02() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {
        this.setTitle("RGB RadioButton");
        this.setSize(700, 500);
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

        jRadioButtons = new ButtonGroup();

        primerJRadioButton = new JRadioButton("1° JPanel");
        primerJRadioButton.setBounds(500, 60, 150, 50);
        jRadioButtons.add(primerJRadioButton);
        this.add(primerJRadioButton);

        segundoJRadioButton = new JRadioButton("2° JPanel");
        segundoJRadioButton.setBounds(500, 120, 150, 50);
        jRadioButtons.add(segundoJRadioButton);
        this.add(segundoJRadioButton);

        tercerJRadioButton = new JRadioButton("3° JPanel");
        tercerJRadioButton.setBounds(500, 180, 150, 50);
        jRadioButtons.add(tercerJRadioButton);
        this.add(tercerJRadioButton);

        primerJPanel = new JPanel();
        primerJPanel.setBounds(50, 250, 180, 100);
        primerJPanel.setBackground(Color.BLACK);
        this.add(primerJPanel);

        segundoJPanel = new JPanel();
        segundoJPanel.setBounds(265, 250, 180, 100);
        segundoJPanel.setBackground(Color.BLACK);
        this.add(segundoJPanel);

        tercerJPanel = new JPanel();
        tercerJPanel.setBounds(485, 250, 180, 100);
        tercerJPanel.setBackground(Color.BLACK);
        this.add(tercerJPanel);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(265, 400, 180, 50);
        limpiar.addActionListener(this);
        this.add(limpiar);

        this.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(r)) {
            red = r.getValue();
        } else if (e.getSource().equals(g)) {
            green = g.getValue();
        } else {
            blue = b.getValue();
        }

        if (primerJRadioButton.isSelected()) {
            primerJPanel.setBackground(new Color(red, green, blue));
        }

        if (segundoJRadioButton.isSelected()) {
            segundoJPanel.setBackground(new Color(red, green, blue));
        }

        if (tercerJRadioButton.isSelected()) {
            tercerJPanel.setBackground(new Color(red, green, blue));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jRadioButtons.clearSelection();
        r.setValue(0);
        g.setValue(0);
        b.setValue(0);
        primerJPanel.setBackground(Color.BLACK);
        segundoJPanel.setBackground(Color.BLACK);
        tercerJPanel.setBackground(Color.BLACK);
    }
}
