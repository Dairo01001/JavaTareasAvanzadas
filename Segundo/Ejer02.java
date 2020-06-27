package Segundo;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author dairo
 */
public class Ejer02 extends JFrame implements ActionListener {

    private final String url = "src/data/";
    private Font font;
    private ButtonGroup frutas;
    private JRadioButton[] jRadioButtonFrutas;
    private final HashMap <String, ImageIcon> imgMap = new HashMap <>();
    private JLabel jLabel;

    public Ejer02() {
        this.initVentana();
        this.initComponentes();
    }

    private void initVentana() {
        this.setTitle("Frutas Imagenes");
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
        this.jRadioButtonFrutas = new JRadioButton[listFrutas.length];
        this.font = new Font("freemono", Font.BOLD, 25);
        this.frutas = new ButtonGroup();

        this.jLabel = new JLabel(); 
        this.jLabel.setBounds(200, 50, 350, 50 * listFrutas.length);
        
        
        int ancho = this.jLabel.getWidth();
        int alto = this.jLabel.getHeight();
        
        int x = 1;
        for (JRadioButton jRadioButtonFruta : this.jRadioButtonFrutas) {
            jRadioButtonFruta = new JRadioButton(listFrutas[x - 1]);
            
            this.imgMap.put(listFrutas[x - 1], new ImageIcon(new ImageIcon(this.url + listFrutas[x - 1] + ".png").getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
            jRadioButtonFruta.setFont(this.font);
            jRadioButtonFruta.setBounds(50, x++ * 50, 150, 50);
            jRadioButtonFruta.addActionListener(this);
            this.add(jRadioButtonFruta);
            this.frutas.add(jRadioButtonFruta);
        }
        
        this.add(this.jLabel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String selec = ((JRadioButton) ae.getSource()).getText();
        this.jLabel.setIcon(this.imgMap.get(selec));
    }
}
