package AppsBasicos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CapturaTeclado extends JFrame implements KeyListener {

    public CapturaTeclado() {

        addKeyListener(this);

    }

    public static void main(String[] args) {

        CapturaTeclado janela = new CapturaTeclado();

        janela.setTitle("Detector de Teclas: ");
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setSize(400, 200);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        //jl1.setText("Tecla Pressionanda: " + e.getKeyChar());
        //jl2.setText("Código numérico: " + e.getKeyCode());
        System.out.println(e.getKeyChar());
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
       
    }

}
