package ControleDeArquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CriacaoDeArquivos {
    
    public static void main(String[] args) throws IOException{
        
        Path path = Paths.get("C:\\TestArquivo\\fonte.txt");
        
        //criar arquivo - CREATE -
        //deleta o arquivo
        Files.deleteIfExists(path);
        //cria um arquivo (.txt) em branco:
        Files.createFile(path);
        //escreve no arquivo
        Files.write(path, "-Escrendo no arquivo criado...".getBytes());
        
        
        //  --COPY--
        Path copiaPath = Paths.get("C:\\TestArquivo\\fonte_copia.txt");
        Files.copy(path, copiaPath,StandardCopyOption.REPLACE_EXISTING);
        
        // --MOVE--
        Path mover = Paths.get("C:\\TestArquivo\\Diretorio_Criado\\fonte.txt");
        Files.createDirectories(mover.getParent());
        Files.move(path, mover, StandardCopyOption.REPLACE_EXISTING);
    }
    
}
