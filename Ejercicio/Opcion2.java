package JavaTareasAvanzadas.Ejercicio;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Dairo Garcia
 */
public class Opcion2 extends JFrame {
    
    public Opcion2() {
        this.initJFrame();
        this.initComponets();
    }
    
    private void initJFrame() {
        this.setTitle("Opcion - 2");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));
        this.setLocationRelativeTo(null);
    }
    
    private void initComponets() {
        this.aux = new JPanel();
        this.aux.add(this.jP, BorderLayout.CENTER);
        this.initJButton();
        this.add(this.aux);
        this.add(this.jP2);
        
    }
    
    private void initJButton() {
        this.guardar = new JButton("GUARDAR");
        this.guardar.setFont(this.font);
        this.aux.add(this.guardar, BorderLayout.SOUTH);
        this.guardar.addActionListener((ActionEvent e) -> {
            this.update();
        });
    }
    
    private void update() {
        this.jP.update(this.jP2);
        this.jP2.update();
    }
    
    private class jPanel extends JPanel {
        
        public jPanel() {
            this.initJPanel();
            this.initComponets();
        }
        
        private void initJPanel() {
            this.setLayout(new GridLayout(5, 3));
        }
        
        private void initComponets() {
            this.initJLabel("Nombre: ");
            this.initJLabel("Primer: ");
            this.initJLabel("Segundo: ");
            
            this.tNombre = initJTextField();
            this.tPrimerApellido = initJTextField();
            this.tSegundoApellido = initJTextField();
            
            this.initJComboBoxDia();
            this.initJComboBoxMeses();
            this.initJComboBoxAnio();
            
            this.groupBebidas = new ButtonGroup();
            this.gaseosa = this.initJRadioButton("Gaseosa");
            this.agua = this.initJRadioButton("Agua");
            this.jugo = this.initJRadioButton("Jugo");
            
            this.mango = this.initJCheckBox("Mango");
            this.fresa = this.initJCheckBox("Fresa");
            this.manzana = this.initJCheckBox("Manzana");
        }
        
        private void initJLabel(String nombre) {
            JLabel jL = new JLabel(nombre);
            jL.setFont(font);
            this.add(jL);
        }
        
        private JTextField initJTextField() {
            JTextField jTf = new JTextField();
            jTf.setFont(font);
            this.add(jTf);
            return jTf;
        }
        
        private void initJComboBoxDia() {
            this.dias = new String[30];
            for (int i = 0; i < dias.length; i++) {
                dias[i] = (i + 1) + "";
            }
            this.dia = new JComboBox(this.dias);
            this.dia.setFont(font);
            this.add(this.dia);
        }
        
        private void initJComboBoxMeses() {
            this.mes = new JComboBox(this.meses);
            this.mes.setFont(font);
            this.add(this.mes);
        }
        
        private void initJComboBoxAnio() {
            this.anios = new String[2020 - 1980 + 1];
            int aux = 1980;
            for (int i = 0; i < anios.length; i++) {
                this.anios[i] = aux + "";
                aux++;
            }
            this.anio = new JComboBox(this.anios);
            this.anio.setFont(font);
            this.add(this.anio);
        }
        
        private JRadioButton initJRadioButton(String nombre) {
            JRadioButton jRb = new JRadioButton(nombre);
            jRb.setFont(font);
            this.groupBebidas.add(jRb);
            this.add(jRb);
            return jRb;
        }
        
        private JCheckBox initJCheckBox(String nombre) {
            JCheckBox jCb = new JCheckBox(nombre);
            jCb.setFont(font);
            this.add(jCb);
            return jCb;
        }
        
        public void update(jPanel2 jPanel) {
            String data = "Nombre: " + this.tNombre.getText() + "\n";
            this.tNombre.setText(null);
            data += "Primer: " + this.tPrimerApellido.getText() + "\n";
            this.tPrimerApellido.setText(null);
            data += "Segundo: " + this.tSegundoApellido.getText() + "\n";
            this.tSegundoApellido.setText(null);
            data += "Dia: " + this.dias[this.dia.getSelectedIndex()] + " ";
            this.dia.setSelectedIndex(0);
            data += "Mes: " + this.meses[this.mes.getSelectedIndex()] + " ";
            this.mes.setSelectedIndex(0);
            data += "Año: " + this.anios[this.anio.getSelectedIndex()] + "\n";
            this.anio.setSelectedIndex(0);
            jPanel.setData(data);
            
            if (this.gaseosa.isSelected()) {
                jPanel.setContG(jPanel.getContG() + 1);
            } else if (this.agua.isSelected()) {
                jPanel.setContA(jPanel.getContA() + 1);
            } else if (this.jugo.isSelected()) {
                jPanel.setContJ(jPanel.getContJ() + 1);
            }
            this.groupBebidas.clearSelection();
            if (this.mango.isSelected()) {
                jPanel.setContM(jPanel.getContM() + 1);
                this.mango.setSelected(false);
            }
            
            if (this.fresa.isSelected()) {
                jPanel.setContF(jPanel.getContF() + 1);
                this.fresa.setSelected(false);
            }
            
            if (this.manzana.isSelected()) {
                jPanel.setContMa(jPanel.getContMa() + 1);
                this.manzana.setSelected(false);
            }
        }
        
        private JTextField tNombre, tPrimerApellido, tSegundoApellido;
        private JComboBox dia, mes, anio;
        private JRadioButton gaseosa, agua, jugo;
        private JCheckBox mango, fresa, manzana;
        private String[] dias;
        private final String[] meses = {
            "Enero", "Febrero", "Marzo",
            "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre",
            "Optubre", "Noviembre", "Diciembre"
        };
        private String[] anios;
        private ButtonGroup groupBebidas;
    }
    
    private class jPanel2 extends JPanel {
        
        public jPanel2() {
            this.initJPanel();
            this.initComponets();
        }
        
        private void initJPanel() {
            this.setLayout(new BorderLayout());
        }
        
        private void initComponets() {
            this.resultados = new JTextArea();
            this.resultados.setFont(font);
            this.resultados.setEditable(false);
            
            JScrollPane jScrollPane = new JScrollPane(this.resultados, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            
            this.add(jScrollPane, BorderLayout.CENTER);
            
            this.initJPanelFrutas();
            this.initJPanelBebidas();
        }
        
        private JLabel initJLabel(String nombre) {
            JLabel jL = new JLabel(nombre);
            jL.setFont(font);
            return jL;
        }
        
        private void initJPanelFrutas() {
            this.frutas = new JPanel();
            this.mango = initJLabel("Mango -> 0");
            this.fresa = initJLabel("Fresa -> 0");
            this.manzana = initJLabel("Manzana-> 0");
            
            this.frutas.add(this.mango);
            this.frutas.add(this.fresa);
            this.frutas.add(this.manzana);
            
            this.add(this.frutas, BorderLayout.NORTH);
        }
        
        private void initJPanelBebidas() {
            this.bebidas = new JPanel();
            this.gaseosa = initJLabel("Gaseosa -> 0");
            this.agua = initJLabel("Agua -> 0");
            this.jugo = initJLabel("Jugo -> 0");
            
            this.bebidas.add(this.gaseosa);
            this.bebidas.add(this.agua);
            this.bebidas.add(this.jugo);
            
            this.add(this.bebidas, BorderLayout.SOUTH);
        }
        
        public void update() {
            this.gaseosa.setText("Gaseosa -> " + this.contG);
            this.agua.setText("Agua -> " + this.contA);
            this.jugo.setText("Jugo -> " + this.contJ);
            
            this.mango.setText("Mango -> " + this.contM);
            this.fresa.setText("Fresa -> " + this.contF);
            this.manzana.setText("Manzana -> " + this.contMa);
            
            this.resultados.append(data + "\n");
        }
        
        public int getContG() {
            return contG;
        }
        
        public void setContG(int contG) {
            this.contG = contG;
        }
        
        public int getContA() {
            return contA;
        }
        
        public void setContA(int contA) {
            this.contA = contA;
        }
        
        public int getContJ() {
            return contJ;
        }
        
        public void setContJ(int contJ) {
            this.contJ = contJ;
        }
        
        public int getContM() {
            return contM;
        }
        
        public void setContM(int contM) {
            this.contM = contM;
        }
        
        public int getContF() {
            return contF;
        }
        
        public void setContF(int contF) {
            this.contF = contF;
        }
        
        public int getContMa() {
            return contMa;
        }
        
        public void setContMa(int contMa) {
            this.contMa = contMa;
        }
        
        public String getData() {
            return data;
        }
        
        public void setData(String data) {
            this.data = data;
        }
        
        private JTextArea resultados;
        private JPanel frutas;
        private JPanel bebidas;
        private JLabel gaseosa, agua, jugo, mango, fresa, manzana;
        
        private int contG, contA, contJ, contM, contF, contMa;
        private String data;
        
    }
    
    private JButton guardar;
    private final Font font = new Font("Courier New", Font.BOLD, 20);
    private JPanel aux;
    private final jPanel jP = new jPanel();
    private final jPanel2 jP2 = new jPanel2();
    
    public static void main(String[] args) {
        Opcion2 ventana = new Opcion2();
        ventana.setVisible(true);
    }
}
