package AppsBasicos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Arix
 */
public class Calculo extends JFrame {

    private JTextField txtnum1, txtnum2;
    private JLabel lblnum1, lblnum2, lblresultado, lblresult;
    private JButton btnCalcular;
    private JPanel jp1;

    public Calculo() {
        setLayout(null);

        txtnum1 = new JTextField();
        txtnum1.setBounds(100, 60, 60, 25);
        add(txtnum1);

        txtnum2 = new JTextField();
        txtnum2.setBounds(180, 60, 60, 25);
        add(txtnum2);
        //=====================       
        lblnum1 = new JLabel("Numero 1");
        lblnum1.setBounds(103, 30, 60, 30);
        add(lblnum1);

        lblnum2 = new JLabel("Numero 2");
        lblnum2.setBounds(180, 30, 60, 30);
        add(lblnum2);

        lblresultado = new JLabel("Resultado:");
        lblresultado.setBounds(103, 110, 80, 30);
        add(lblresultado);

        lblresult = new JLabel();
        lblresult.setBounds(180, 110, 80, 30);
        lblresult.setFont(new Font("Arial", Font.BOLD, 15));
        lblresult.setForeground(Color.blue);
        add(lblresult);

        //=====================
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(280, 45, 100, 80);
        add(btnCalcular);

        jp1 = new JPanel();
        jp1.setBorder(BorderFactory.createLineBorder(Color.blue));
        jp1.setLocation(50, 10);
        jp1.setSize(360, 150);
        add(jp1);

        //evento do botao
        MetodoBtnCalcular();

    }

    private void MetodoBtnCalcular() {
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                int num1 = Integer.parseInt(txtnum1.getText()); //converte para inteiro
                int num2 = Integer.parseInt(txtnum2.getText()); //converte para inteiro
                int calc = num1 / num2;
                lblresult.setText(String.valueOf(calc)); //converte para String             
            }
        });
    }

    public static void main(String[] args) {
        Calculo janela = new Calculo();

        janela.setTitle("Calculo Simples JFrame");
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setSize(450, 250);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setVisible(true);
    }

}
