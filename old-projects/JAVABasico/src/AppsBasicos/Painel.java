package AppsBasicos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class Painel extends JFrame {
    private JLabel lblImg;
    private JButton btn01,btn02;
    private JPanel jPainel,jpImg;
    private ImageIcon IconJava;
    
    public Painel() {
        setLayout(null);
      
        //Label de imagem lblImg
        IconJava = new ImageIcon(getClass().getResource("career-java.png"));
        lblImg = new JLabel(IconJava);
        lblImg.setBounds(85,40,216,215);
        add(lblImg);
        
        //botao btn01 
        btn01 = new JButton("Sair");
        btn01.setBounds(70, 310, 100, 35);
        btn01.setMnemonic('0');
        btn01.setToolTipText("Sair");
        add(btn01);
        
        //botao btn02
        btn02 = new JButton("Mensagem");
        btn02.setBounds(220, 310, 100, 35);
        btn02.setMnemonic('0');
        btn02.setToolTipText("JButton");
        add(btn02);        
        
        //Painel dos botoes
        jPainel = new JPanel();
        //jPainel.setBackground(Color.CYAN);
        jPainel.setSize(375,70);
        jPainel.setLocation(10,290);
        jPainel.setBorder(BorderFactory.createRaisedBevelBorder());
        add(jPainel);
        //setVisible(true);
        
        //painel com titulo ImgIcon
        jpImg = new JPanel();
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Icone do Java");
        jpImg.setBorder(title);
        jpImg.setSize(370,270);
        jpImg.setLocation(10,10);
        add(jpImg);
        
        btn01.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){                
               System.exit(0);
            }
        });
        
    }
      

    public static void main(String[] args) {
        Painel janela = new Painel();

        janela.setTitle("Java Painel - by @rix");
        janela.setSize(400, 400);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);        
    }

}
