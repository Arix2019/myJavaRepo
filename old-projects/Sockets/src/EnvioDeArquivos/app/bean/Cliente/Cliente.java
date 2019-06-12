/*  envio de arquivos cliente/servidor
*   CLIENTE
*   Este cliente envia o arquivo para tds ao mesmo tempo.
 */
package EnvioDeArquivos.app.bean.Cliente;

import EnvioDeArquivos.app.bean.FileMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Arix
 */
public class Cliente {

    //variaveis de instancia
    private Socket socket;
    private ObjectOutputStream outputStream;

    //metodo construtor
    public Cliente() throws IOException {
        this.socket = new Socket("127.0.0.1", 5555);
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());

        new Thread(new ListenerSocket(socket)).start();

        menu();
    }

    //usado para enviar mensagem
    private void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Digite seu Nome: ");
        String nome = scanner.nextLine();

        //garante que o nome seja adicionado a lista
        this.outputStream.writeObject(new FileMessage(nome));
        int option = 0;
        while (option != -1) {
            System.out.println("1 - Sair | 2 - Enviar Mensagem: ");
            option = scanner.nextInt();
            if (option == 2) {
                Send(nome);
            } else if (option == 1) {
                System.exit(0);
            }
        }
    }

    private void Send(String nome) throws IOException {
        JFileChooser fileChooser = new JFileChooser();

        int opt = fileChooser.showOpenDialog(null);
        if (opt == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            this.outputStream.writeObject(new FileMessage(nome, file));
        }
    }

    //usado para receber mensagens enviadas pelos outros clientes    
    private class ListenerSocket implements Runnable {

        private ObjectInputStream inputStream;

        public ListenerSocket(Socket socket) throws IOException {
            this.inputStream = new ObjectInputStream(socket.getInputStream());

        }

        public void run() {
            //variavel local
            FileMessage message = null;

            try {
                while ((message = (FileMessage) inputStream.readObject()) != null) {
                    // metodo que lê e recebe o conteudo do arquivo  
                    System.out.println("Você recebeu um arquivo de: " + message.getCliente());
                    System.out.println("Nome do arquivo: " + message.getFile().getName());

                    //imprime no console a mensagem recebida:
                    //imprime(message);
                    Salvar(message);
                    
                    System.out.println("1 - Sair | 2 - Enviar Mensagem: ");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void imprime(FileMessage message) {
            try {
                FileReader fileReader = new FileReader(message.getFile());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linha;
                while ((linha = bufferedReader.readLine()) != null) {
                    System.out.println(linha);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // metodo salva o arquivo no HD    
        private void Salvar(FileMessage message) {
            try {
                
                //pega um numero randomico entre 0 e 1000:
                Thread.sleep(new Random().nextInt(1000));
                
                //adiciona o horario atual e salva como parte do nome do arquivo:
                long time = System.currentTimeMillis();
                
                FileInputStream fileInputStream = new FileInputStream(message.getFile());
                FileOutputStream fileOutputStream = new FileOutputStream("c:\\z\\" + time + "_" + message.getFile().getName());
                
                //classes que facilitam a manipulação de arquivos (classe java.io.*)
                FileChannel fin = fileInputStream.getChannel();
                FileChannel fout = fileOutputStream.getChannel();
                
                //armazena o tamanho do arqivo:
                long size = fin.size();
                fin.transferTo(0, size, fout);
                
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Cliente();
     }
}
