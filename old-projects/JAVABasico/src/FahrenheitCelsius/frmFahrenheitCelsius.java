package FahrenheitCelsius;

import com.lowagie.text.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class frmFahrenheitCelsius extends JFrame {
    
    JLabel lblFah, lblCel, lblTitle;
    JButton btnConverte, btnLimpar;
    JTextField txtFah, txtCel;
    Container conteiner, gridTxt, gridLbl, gridBtn;
    
    public void converte() {
        try {
            double f, c;
            
            if (txtFah.getText().isEmpty() && txtCel.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha algum dos Campos!");
            } else if (txtFah.getText().isEmpty()) {
                //se o textField Fahrenheit estiver vazio, faz o calculo de Celsius                   
                f = (Double.parseDouble(txtCel.getText().replace(",", ".")) * 1.8) + 32;
                /* formata as casas decimais*/
                String resultFormat = String.format("%.1f", f);
                txtFah.setText(resultFormat);
            } else if (txtCel.getText().isEmpty()) {
                //se o textField Celsius estiver vazio, faz o calculo de Fahrenheit
                c = (Double.parseDouble(txtFah.getText().replace(",", ".")) - 32) / 1.8;
                /* formata as casas decimais*/
                String resultFormat2 = String.format("%.1f", c);
                txtCel.setText(resultFormat2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Informe apenas valores numéricos.");
            txtCel.setText(null);
            txtFah.setText(null);
        }
    }
    
    public frmFahrenheitCelsius() {
        
        super("Conversor Fahrenheit para Celsius - by: @rix");

        /* BUTTON */
        btnConverte = new JButton("Converter");
        btnConverte.setFont(new java.awt.Font("Serif", Font.BOLD, 20));
        btnLimpar = new JButton("Limpar");
        btnLimpar.setFont(new java.awt.Font("Serif", Font.BOLD, 20));

        /*define espaços entre os objetos*/
        javax.swing.border.Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        javax.swing.border.Border loweredBevelBorder = BorderFactory.createEmptyBorder();

        /* JLABEL */
        lblTitle = new JLabel("Fahrenheit para Celsius", SwingConstants.CENTER);
        lblTitle.setFont(new java.awt.Font("Serif", Font.ITALIC, 22));
        lblFah = new JLabel("Fahrenheit: ");
        lblFah.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
        lblFah.setBorder(BorderFactory.createCompoundBorder(loweredBevelBorder, paddingBorder));
        lblCel = new JLabel("Celsius: ");
        lblCel.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
        lblCel.setBorder(BorderFactory.createCompoundBorder(loweredBevelBorder, paddingBorder));

        /* JTEXTFIELD */
        txtFah = new JTextField();
        txtFah.setFont(new java.awt.Font("Arial", Font.HELVETICA, 24));
        txtFah.setForeground(Color.blue);
        txtCel = new JTextField();
        txtCel.setFont(new java.awt.Font("Arial", Font.HELVETICA, 24));
        txtCel.setForeground(Color.blue);
        
        conteiner = getContentPane();

        /* grid textfield */
        gridTxt = new JPanel();
        gridTxt.setLayout(new GridLayout(2, 1));
        gridTxt.add(txtCel);
        gridTxt.add(txtFah);

        /* grid lbl */
        gridLbl = new JPanel();
        gridLbl.setLayout(new GridLayout(2, 1));
        gridLbl.add(lblCel);
        gridLbl.add(lblFah);

        /* grid btn */
        gridBtn = new JPanel();
        gridBtn.setLayout(new GridLayout(1, 2));
        gridBtn.add(btnConverte);
        gridBtn.add(btnLimpar);

        /* CONTAINER PRINCIPAL */
        conteiner.setLayout(new BorderLayout(5, 20));
        conteiner.add(BorderLayout.CENTER, gridTxt);
        conteiner.add(BorderLayout.WEST, gridLbl);
        conteiner.add(BorderLayout.SOUTH, gridBtn);
        conteiner.add(BorderLayout.NORTH, lblTitle);

        /* evento btnConverte */
        btnConverte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converte();
            }
        });

        /* evento btnLimpar*/
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCel.setText(null);
                txtFah.setText(null);
            }
            
        });
        
        txtFah.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                
                txtCel.setText("");
            }
        });
        
        txtCel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                
                txtFah.setText("");
            }
        });
        
    } //fim da classe

    public static void main(String[] args) {
        
        frmFahrenheitCelsius janela = new frmFahrenheitCelsius();
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setSize(400, 250);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        
    }
    
}
