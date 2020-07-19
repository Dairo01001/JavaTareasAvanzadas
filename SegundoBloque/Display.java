package JavaTareasAvanzadas.SegundoBloque;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * @author Dairo García Naranjo
 */
public class Display extends JButton {

    public Display() {
        this.initJButton();
    }

    private void initJButton() {
        this.setFont(new Font("Courier New", Font.BOLD, 30));
        this.setEnabled(false);
        this.setText("0");
        this.setHorizontalAlignment(SwingConstants.RIGHT);
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLUE);
    }

    public double getNum() {
        return Double.parseDouble(this.getText());
    }
    
    public void setText(double num){
        this.setText("" + num);
    }
}
