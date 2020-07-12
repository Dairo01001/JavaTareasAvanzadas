package JavaTareasAvanzadas.Cuarto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class Ejer02 extends JFrame implements MouseListener {

    public Ejer02() {
        this.initJFrame();
        this.initComponets();
    }

    private void initJFrame() {
        this.setTitle("GridLayout");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponets() {
        this.initJP1();
        this.initJP2();
        this.initJP3();
    }

    private void initJP1() {
        this.jP1 = new JPanel();
        this.initJLabel("Filas:");
        this.filas = this.initJSpinner();
        this.initJLabel("Columnas:");
        this.columnas = this.initJSpinner();
        this.aplicar = this.initJButton("Aplicar");
        this.aplicar.addActionListener((ActionEvent e) -> {
            this.Aplicar();
        });
        this.jP1.add(this.aplicar);
        this.add(this.jP1, BorderLayout.NORTH);
    }

    private void initJLabel(String nombre) {
        JLabel jL = new JLabel(nombre);
        jL.setFont(this.font);
        this.jP1.add(jL);
    }

    private void Aplicar() {
        int rows = Integer.parseInt(this.filas.getValue().toString());
        int columns = Integer.parseInt(this.columnas.getValue().toString());
        this.layoutJP2.setRows(rows);
        this.layoutJP2.setColumns(columns);
        this.jP2.removeAll();
        this.jP2.setLayout(this.layoutJP2);
        this.addButtons(rows, columns);
        this.jP2.updateUI();
    }

    private void addButtons(int rows, int columns) {
        for (int i = 0; i < rows * columns; i++) {
            this.jP2.add(this.colors[i]);
        }
    }

    private JButton initJButton(String nombre) {
        JButton jBt = new JButton(nombre);
        jBt.setFont(this.font);
        return jBt;
    }

    private JSpinner initJSpinner() {
        JSpinner jS = new JSpinner(new SpinnerListModel(this.list));
        jS.setFont(this.font);
        this.jP1.add(jS);
        return jS;
    }

    private void initJP2() {
        this.initColors();
        this.layoutJP2 = new GridLayout(2, 2);
        this.jP2 = new JPanel(this.layoutJP2);
        for (int i = 0; i < 2 * 2; i++) {
            this.jP2.add(this.colors[i]);
        }
        this.add(this.jP2, BorderLayout.CENTER);
    }

    private void initJP3() {
        this.jP3 = new JPanel();
        this.jP3.setBackground(Color.BLACK);
        this.prueba = new JButton("Color seleccionado");
        this.prueba.setFont(this.font);
        this.prueba.setBorderPainted(false);
        this.prueba.setBackground(Color.BLACK);
        this.jP3.add(this.prueba);
        this.add(this.jP3, BorderLayout.SOUTH);
    }

    private void initColors() {
        this.colors = new JButton[100];
        for (int i = 0; i < this.colors.length; i++) {
            this.colors[i] = new JButton();
            this.colors[i].setBackground(this.ramdomColor());
            this.colors[i].addMouseListener(this);
        }
    }

    private Color ramdomColor() {
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);
        return new Color(R, G, B);
    }

    private JPanel jP1, jP2, jP3;
    private JButton prueba;
    private GridLayout layoutJP2;

    private JSpinner filas, columnas;
    private JButton aplicar;

    private final Font font = new Font("Courier New", Font.BOLD, 20);
    private final String[] list = {"02", "03", "04", "05", "06", "07", "08", "09", "10"};
    private JButton[] colors;

    public static void main(String[] args) {
        Ejer02 ventana = new Ejer02();
        ventana.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Color aux = e.getComponent().getBackground();
        jP3.setBackground(aux);
        this.prueba.setBackground(aux);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
