/*
CLIENTE ENVIO DE ARQUIVOS
*o cliente envia o arquivo
*/
package EnvioDeArquivos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class Cliente {
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        try{
            Socket cliente = new Socket("127.0.0.1",1234);
            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
            FileInputStream file = new FileInputStream("C:\\Users\\Arix\\Desktop\\teste-envio-arquivos.rar");
            byte[] buffer = new byte[9098];
            while (true){
                int len = file.read(buffer);
                if (len == -1) break;
                out.write(buffer,0,len);                
            }
            System.out.println("Aquivo enviado com sucesso.");
        } catch (IOException e){
            System.out.println("Erro ao enviar." + e);
        }
    }
}
