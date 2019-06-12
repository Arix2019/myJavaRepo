package Movimento;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SpiderMove extends JFrame {

    private JLabel lblSpider,lblBack;
    private ImageIcon ImgBack, ImgSpiderMoved, ImgSpiderStatic;

    int posSpiderX = 200, posSpiderY = 200;

    public SpiderMove() {

        // ICONS (imagens)
        ImgBack = new ImageIcon(getClass().getResource("wall.jpg"));
        ImgSpiderMoved = new ImageIcon(getClass().getResource("spidermove.gif"));
        ImgSpiderStatic = new ImageIcon(getClass().getResource("spideStatic.png"));

        //lbel img spider    
        lblSpider = new JLabel(ImgSpiderStatic);
        lblSpider.setBounds(posSpiderX, posSpiderY, 103, 202);
        add(lblSpider);

        //label img background
        lblBack = new JLabel(ImgBack);
        lblBack.setBounds(0, 0, 500, 500);
        add(lblBack);

        //tecla pressionada
        addMovimento();

    }

    public void addMovimento() {
        addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                lblSpider.setIcon(ImgSpiderMoved);
                if (e.getKeyCode() == 38) {
                    posSpiderY -= 10;
                }
                if (e.getKeyCode() == 40) {
                    posSpiderY += 10;
                }
                if (e.getKeyCode() == 37) {
                    posSpiderX -= 10;
                }
                if (e.getKeyCode() == 39) {
                    posSpiderX += 10;
                }
                //atualiza a posição da label
                lblSpider.setBounds(posSpiderX, posSpiderY, 103, 202);

            }

            public void keyReleased(KeyEvent e) {
                lblSpider.setIcon(ImgSpiderStatic);

            }
        });
    }

    public static void main(String[] args) {
        SpiderMove janela = new SpiderMove();

        janela.setTitle("The Spider: ");
        //janela.setIconImage(new ImageIcon("Tecla_Shift.png").getImage());
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setSize(500, 500);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setFocusable(true); //Deixa o JFrame em "foco"
        janela.setVisible(true);

    }

}
