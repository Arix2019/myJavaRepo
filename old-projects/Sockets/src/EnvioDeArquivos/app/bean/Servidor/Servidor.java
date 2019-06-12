/*  envio de arquivos cliente/servidor
*
*   SERÁ CONSTRUIDO TUDO O QUE FOR NECESSÁRIO PARA O SERVIDOR
*/
package EnvioDeArquivos.app.bean.Servidor;

import java.io.*;
import java.net.*;
import java.util.*;
import EnvioDeArquivos.app.bean.FileMessage; // responsavel pelo metodo FileMessage
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Arix
 */
public class Servidor {
    
    //criando os atributos de conexao Cliente/Servidor
    private ServerSocket serversocket;
    private Socket socket;
    //atributo do tipo Map com chave tipo String Valor do tipo ObjectOutputStream 
    //String vai conter a lista de nomes dos usuarios e o ObjectOutputStream vai 
    //conter o fluxo das mensagens.
    private Map<String, ObjectOutputStream> streamMap = new HashMap<String, ObjectOutputStream>();
    
    //adicionar o metodo construtor padrão
    public Servidor(){
        try {
            serversocket = new ServerSocket(5555);
            System.out.println("Servidor Ativo...");
           
            while (true){
                socket = serversocket.accept();
            
                new Thread(new ListenerSocket(socket)).start();
            }
            
        } catch (IOException e) {
            System.out.println("Não foi possivel inicializar o Servidor." + e);
            //e.printStackTrace();
        }
    }

    private class ListenerSocket implements Runnable {
        private ObjectOutputStream outputStream; //responsavel pelo envio das mensagens ao servidor
        private ObjectInputStream inputStream; // responsavel por receber as mesagens
        
        //construtor
        public ListenerSocket(Socket socket) throws IOException {
            this.outputStream = new ObjectOutputStream(socket.getOutputStream());
            this.inputStream = new ObjectInputStream(socket.getInputStream());
        }
        //construtor run
        @Override
        public void run(){
            //variavel local
           FileMessage message = null;
           
            try {
                while ((message = (FileMessage) inputStream.readObject()) != null){
                    //coloca na lista o cliente que se conectou
                    streamMap.put(message.getCliente(), outputStream);
                    if (message.getFile() != null){ //se for diferente de null, o cliente esta enviando um mensagem 
                        for (Map.Entry<String, ObjectOutputStream> kv : streamMap.entrySet() ){
                            //evita que o cliente receba sua propria mensagen
                            if (!message.getCliente().equals(kv.getKey())){
                                kv.getValue().writeObject(message);
                            }
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                //caso o cliente se desconecte
                streamMap.remove(message.getCliente());
                System.out.println(message.getCliente() + " se Desconectou!");
            }
            
        }
    }
    
    public static void main(String[] args){
        new Servidor();    
    }
}
