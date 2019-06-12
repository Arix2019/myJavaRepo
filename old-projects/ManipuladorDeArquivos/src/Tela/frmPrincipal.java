package Tela;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class frmPrincipal extends JFrame {
    JTextArea texto;
    JButton btn,btn2;
    JScrollPane barraRolagem;
    Container conteudo;
    
    
    public frmPrincipal() {
        super("Teste Tela");      
       
        //TextArea
        texto = new JTextArea();
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        texto.setFont(new Font("Arial", Font.BOLD,18));
        
        barraRolagem = new JScrollPane(texto);

        
        //botoes
        btn = new JButton("North");
        btn.setFont(new Font("Serif", Font.PLAIN,20));
        btn2 = new JButton("South");
        btn2.setFont(new Font("Serif", Font.PLAIN,20));        

        texto = new JTextArea();
        texto.setFont(new Font("Arial", Font.BOLD,18));

        
        //layout padrão:
        conteudo = getContentPane();
        conteudo.setLayout(new BorderLayout());
          //define layout p o container
        //conteudo.setLayout(new BorderLayout(5,5));        
        //conteudo.add(BorderLayout.SOUTH,btn2);
        //conteudo.add(BorderLayout.CENTER,barraRolagem);
        
        //grid layout - recebe como parametros a qt de linhas e colunas (2 linhas - 3 colunas)
        //conteudo.setLayout(new GridLayout(2,3));
        //conteudo.add(new JButton("1"));
        //conteudo.add(new JButton("2"));
        //conteudo.add(new JButton("3"));
        //conteudo.add(new JButton("4"));
        //conteudo.add(new JButton("5"));
        //conteudo.add(new JButton("6"));
        
        
        //utlizando 2 layouts:
        Container c2 = new JPanel();
        c2.setLayout(new GridLayout(4,1));
        c2.add(new JButton("OK"));
        c2.add(new JButton("CANCEL"));
        c2.add(new JButton("SETUP"));
        c2.add(new JButton("HELP"));
        
        conteudo.add(BorderLayout.CENTER, new JButton("CENTER"));
        conteudo.add(BorderLayout.EAST, c2);        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);
        setSize(550, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new frmPrincipal();
    }

}
