package Tela;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.swing.*;

public class frmLeitor extends JFrame {

    JTextArea jtaTexto;
    JButton btnTexto;
    JScrollPane scroll;
    Container conteiner;
    LocalDateTime clock;
    
    public frmLeitor() {
        super("Teste Leitor de arquivo");

        clock = LocalDateTime.now();
        
        //JButton
        btnTexto = new JButton("Ler");
        btnTexto.setFont(new Font("Arial", Font.BOLD, 18));
        
        //JTextArea
        jtaTexto = new JTextArea();
        jtaTexto.setFont(new Font("Serif", Font.PLAIN, 18));
        jtaTexto.setLineWrap(true);
        jtaTexto.setWrapStyleWord(true);
        jtaTexto.setEditable(false);
        
        
        scroll = new JScrollPane(jtaTexto);
        
        conteiner = getContentPane();
        conteiner.setLayout(new BorderLayout());
        conteiner.add(BorderLayout.CENTER,scroll);
        conteiner.add(BorderLayout.SOUTH,btnTexto);


        //evento do botão
        btnTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lerArquivo("C:\\TestArquivo\\file.txt");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });


        // frame        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(550, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void lerArquivo(String pathFile) throws IOException {
        String readLine;
        try {
            FileInputStream lerArquivo = new FileInputStream(pathFile);
            InputStreamReader input = new InputStreamReader(lerArquivo);
            BufferedReader bfr = new BufferedReader(input);

            do {
                readLine = bfr.readLine();
                if (readLine != null) {
                    //System.out.println(readLine);
                    jtaTexto.append(readLine + "\n");
                }
            } while (readLine != null);

        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possivel ler o arquivo.");
        }
    }    

    public static void main(String[] args) {
        new frmLeitor();

    }
}
