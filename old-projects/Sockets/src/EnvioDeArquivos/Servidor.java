/*
*SERVIDOR ENVIO DE ARQUIVOS
*o servidor recebe o arquivo
*/
package EnvioDeArquivos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;


public class Servidor {
    
    public static void main(String[] args) throws IOException{
        try{
            ServerSocket servidor = new ServerSocket(1234);
            Socket av = servidor.accept();
            ObjectInputStream out = new ObjectInputStream(av.getInputStream());
            FileOutputStream file = new FileOutputStream("C:\\Users\\Arix\\Desktop\\new.rar");
            byte[] buffer = new byte[9098];
            while (true){
                int len = out.read(buffer);
                if (len == -1) break;
                file.write(buffer,0,len);
            }
                System.out.println("Aquivo recebido com sucesso.");
        } catch (IOException e){
            System.out.println("Erro ao receber o Arquivo." + e);
        }
    }
}
