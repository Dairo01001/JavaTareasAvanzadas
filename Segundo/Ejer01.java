package Segundo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author dairo
 */
public class Ejer01 extends JFrame implements ActionListener {

    private Font font;
    private ButtonGroup frutas;
    private JRadioButton[] jRadioButtonfrutas;
    private JTextArea seleccion;
    private JScrollPane scrollPane;

    public Ejer01() {
        this.initVentana();
        this.initComponentes();
    }

    private void initVentana() {
        this.setTitle("Frutas JTextArea");
        this.setSize(600, 500);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponentes() {
        String[] listFrutas = {
            "Melon", "Sandia", "Banana", "Fresa",
            "Mora", "Piña", "Pera", "Manzana"
        };
        this.jRadioButtonfrutas = new JRadioButton[listFrutas.length];
        this.font = new Font("freemono", Font.BOLD, 25);
        this.frutas = new ButtonGroup();

        int x = 1;
        for (JRadioButton jRadioButtonfruta : this.jRadioButtonfrutas) {
            jRadioButtonfruta = new JRadioButton(listFrutas[x - 1]);
            jRadioButtonfruta.setFont(this.font);
            jRadioButtonfruta.setBounds(50, x++ * 50, 150, 50);
            jRadioButtonfruta.addActionListener(this);
            this.add(jRadioButtonfruta);
            this.frutas.add(jRadioButtonfruta);
        }

        this.seleccion = new JTextArea();
        this.seleccion.setFont(this.font);
        this.seleccion.setEditable(false);
        
        this.scrollPane = new JScrollPane(this.seleccion, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        this.scrollPane.setBounds(200, 50, 350, 50 * listFrutas.length);
        
        this.add(this.scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String selec = ((JRadioButton) ae.getSource()).getText();
        this.seleccion.append(selec + "\n");
    }
}
