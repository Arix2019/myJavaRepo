package ControleDeArquivos;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class ParticoesDoPc {
    
    public static void main(String[] args) throws IOException{
        
        //retorna unidades que estão acessiveis
        FileSystem fs = FileSystems.getDefault();
        for (FileStore store : fs.getFileStores()) { 
            System.out.println("Unidade: " + store.toString());
            //retorna o espaço nas unidades (em Bytes):
            System.out.println("Tamanho da Unidade: " + store.getTotalSpace());
            System.out.println("Espaço disponivel: " + store.getUsableSpace());
            System.out.println("Espaço Utilizado: " + (store.getTotalSpace() - store.getUsableSpace()) );
            System.out.println("");
        }
    }
}
