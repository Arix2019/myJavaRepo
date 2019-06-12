// servidor
package Chat;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class ChatServer {

    ArrayList<PrintWriter> escritores = new ArrayList<>();

    public ChatServer() {
        ServerSocket server;
        try {
            server = new ServerSocket(5000);
            while (true) {
                Socket socket = server.accept();
                new Thread(new escutaCliente(socket)).start();
                PrintWriter p = new PrintWriter(socket.getOutputStream());
                escritores.add(p);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void encaminhaParaTodos(String texto) {
        for (PrintWriter w : escritores) {
            try {
                w.println(texto);
                w.flush();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private class escutaCliente implements Runnable {

        Scanner leitor;

        public escutaCliente(Socket socket) {
            try {
                //recebe o socket do cliente
                leitor = new Scanner(socket.getInputStream());

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

        @Override
        public void run() {
            try {
                String texto;
                //monitora o que estiver sendo escrito pelos clientes
                while ((texto = leitor.nextLine()) != null) {
                    System.out.println(texto);
                    encaminhaParaTodos(texto);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    public static void main(String[] args) {
        new ChatServer();
    }

}
