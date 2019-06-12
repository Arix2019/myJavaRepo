package AppsBasicos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

public class TeclaDetector extends JFrame implements KeyListener {

    JLabel jl1 = new JLabel("Tecla Pressionada: ");
    JLabel jl2 = new JLabel("Código da Numérico: ");

    public TeclaDetector() {
        
        add(jl1, BorderLayout.NORTH);
        add(jl2, BorderLayout.SOUTH);
        addKeyListener(this);
    }

    public static void main(String[] args) {
        TeclaDetector Frame = new TeclaDetector();

        Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Frame.setSize(500, 150);
        Frame.setVisible(true);
        Frame.setLocationRelativeTo(null);

    } //metodo principal

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        jl1.setText("Tecla Pressionanda: " + e.getKeyChar());
        jl2.setText("Código numérico: " + e.getKeyCode());
        System.out.println(e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) {

    }

}// fim TeclaDetector
