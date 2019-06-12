package ControleDeArquivos;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListarDiretorios {
    
    public static void main(String[] args){
        
        //lista tds as raizes dos diretorios:
        Iterable<Path> diretorios = FileSystems.getDefault().getRootDirectories();
        for (Path listaDiretorios : diretorios) {
            System.out.println(listaDiretorios);
        }
        
        // lista o conteudo de um diretorio especifico:
        Path pathDir = Paths.get("C:\\TestArquivo\\");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(pathDir)) {
            System.out.println("\nArquivos dentro do diretório: [" + pathDir + "]");
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
            
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
    }
    
}
