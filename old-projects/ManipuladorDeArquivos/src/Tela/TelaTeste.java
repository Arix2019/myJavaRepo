package Tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class TelaTeste extends JFrame {

    JTextArea jtaTexto;
    JButton btnOk, btnCancel;
    JLabel lblTitle;
    JScrollPane scroll;
    Container container,gridContainer,gridTitle;
    LocalDateTime clock;

    public TelaTeste() {
        super("Janela Teste02");
        
        javax.swing.border.Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        javax.swing.border.Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
        //LABEL
        lblTitle = new JLabel("Teste de Layout",SwingConstants.CENTER);
        lblTitle.setFont(new Font("Serif-Serif", Font.BOLD, 22));
        lblTitle.setForeground(Color.black);
        lblTitle.setBorder(BorderFactory.createCompoundBorder(loweredBevelBorder,paddingBorder));

        //JButton
        btnOk = new JButton("Ok");
        btnOk.setFont(new Font("Arial", Font.BOLD, 18));
        btnCancel = new JButton("Cancelar");
        btnCancel.setFont(new Font("Arial", Font.BOLD, 18));

        
        //JTextArea
        jtaTexto = new JTextArea();
        jtaTexto.setFont(new Font("Serif", Font.PLAIN, 18));
        jtaTexto.setLineWrap(true);
        jtaTexto.setWrapStyleWord(true);

        //JScrollPane assume o JTextArea:
        scroll = new JScrollPane(jtaTexto);
        
        //obj do conteudo principal:
        container = getContentPane();
        
        
        //layout com jlabel
        gridTitle = new JPanel();
        gridTitle.setLayout(new GridLayout()); 
        //gridTitle.setBackground(Color.WHITE);
        gridTitle.add(lblTitle);

        
        //define layout do painel com 2 botoes:
        gridContainer = new JPanel();
        gridContainer.setLayout(new GridLayout(1,2)); // 1 linha com 2 colunas
        gridContainer.add(btnOk);
        gridContainer.add(btnCancel);
        
        
        //container principal 
        container.setLayout(new BorderLayout());
        container.add(BorderLayout.CENTER,scroll); //       <-- JTextArea
        container.add(BorderLayout.SOUTH,gridContainer); // <-- Painel com botoes
        container.add(BorderLayout.NORTH,gridTitle); //      <-- Painel com Label 'Title'
        
        
        // frame        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(550, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaTeste();
    }

}
