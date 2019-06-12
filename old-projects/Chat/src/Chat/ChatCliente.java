// Chat Cliente
package Chat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.*;

public class ChatCliente extends JFrame {

    JButton btnEnviar;
    JTextField txtTextoEnviar;
    Container cntEnvio;
    Socket socket;
    PrintWriter escritor;
    String nome;
    JTextArea textoRecebido;
    JScrollPane barraRolagem;
    Scanner leitor = null;

    public class escutaServidor implements Runnable {

        @Override
        public void run() {
            try {
                String texto;
                while ((texto = leitor.nextLine()) != null) {
                    textoRecebido.append(texto + "\n");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    public ChatCliente(String nome) {
        super("Chat Cliente: " + nome);
        this.nome = nome;

        txtTextoEnviar = new JTextField();
        txtTextoEnviar.setFont(new Font("Serif", Font.PLAIN, 22));
        btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(new Font("Arial", Font.BOLD, 22));
        btnEnviar.addActionListener(new enviarListener());
        //container
        cntEnvio = new JPanel();
        cntEnvio.setLayout(new BorderLayout());
        cntEnvio.add(BorderLayout.CENTER, txtTextoEnviar);
        cntEnvio.add(BorderLayout.EAST, btnEnviar);
        //adicionando Container(cntEnvio) dentro do container principal da janela:
        getContentPane().add(BorderLayout.SOUTH, cntEnvio);

        // texto recebido
        textoRecebido = new JTextArea();
        textoRecebido.setFont(new Font("Serif", Font.PLAIN, 24));
        barraRolagem = new JScrollPane(textoRecebido);
        getContentPane().add(BorderLayout.CENTER, barraRolagem);
        getContentPane().add(BorderLayout.SOUTH, cntEnvio);

        configurarRede();

        // janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    } //fim public ChatCliente()

    private class enviarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            escritor.println(nome + ": " + txtTextoEnviar.getText());
            escritor.flush();
            txtTextoEnviar.setText(null);
            txtTextoEnviar.requestFocus();

        }
    }

    private void configurarRede() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            //envia(escreve) dados ao servidor
            escritor = new PrintWriter(socket.getOutputStream());
            leitor = new Scanner(socket.getInputStream());
            new Thread(new escutaServidor()).start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public static void main(String[] args) {
        String setName = JOptionPane.showInputDialog(null, "Informe seu NickName:", "");
        try {
            if (setName.isEmpty()) {
                System.exit(0);
            } else {
                new ChatCliente(setName);
            }
        } catch (Exception e) {

        }
    }

}
