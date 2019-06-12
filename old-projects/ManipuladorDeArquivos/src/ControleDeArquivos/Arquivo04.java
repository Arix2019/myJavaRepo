package ControleDeArquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Arquivo04 {

    public static void main(String[] args) throws IOException{
    
        Path path = Paths.get("C:\\TestArquivo\\conta01.txt");
        
        //(algumas opções de verificação de Arquivos)
        System.out.println("verifica se o arquivo existe: " + Files.exists(path));
        System.out.println("verifica se é um diretorio: " + Files.isDirectory(path));
        System.out.println("verifica se é um arquivo Convencional: " + Files.isRegularFile(path));
        System.out.println("verifica se pode ser editado: " + Files.isReadable(path));
        System.out.println("verifica se pode é executavel: " + Files.isExecutable(path));
        System.out.println("verifica o tamanho do arquivo: " + Files.size(path));
        System.out.println("verifica o dono dono do arquivo: " + Files.getOwner(path));
        System.out.println("verifica ultima modificação no arquivo: " + Files.getLastModifiedTime(path));
        System.out.println("verifica o tipo de arquivo: " + Files.probeContentType(path));
        
        
        //excusão de arquivos - DELETE
        //Files.delete(path); //apaga o arquivo se ele nao existir emitira exceções
        //Files.deleteIfExists(path); //apagaga o arquivo, em casa de erro emitira exceções
        
        
    }
    
}
