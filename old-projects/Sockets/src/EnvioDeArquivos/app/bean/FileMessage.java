/*  envio de arquivos cliente/servidor
*
*   CLASSE RESPONSÁVEL PELO CONTEÚDO DA MENSAGEM
*/
package EnvioDeArquivos.app.bean;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Arix
 */
public class FileMessage implements Serializable{
    
    private String cliente; // nome de quem enviará a mensagem
    private File file; //contem o arquivo que sera enviado
    
    
    // abaixo os métodos construtores
    public FileMessage(String cliente, File file){
        this.cliente = cliente;
        this.file = file;
    }
    
    public FileMessage(String cliente){
        this.cliente = cliente;
    }

    public FileMessage(){
        
    }
    
    public String getCliente(){
        return cliente;   
    }
    
    public File getFile(){
        return file;
    }
    
    //  apartir daqui os objetos podem ser enviados contendo o nome do cliente e
    // do arquivo que o cliente esta enviando
    
}
