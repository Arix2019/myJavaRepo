package pkgLeitor;

import java.io.IOException;

/**
 * lê o arquivo
 *
 * @author Arix
 */
public class Leitor {

    public static void main(String[] args) throws IOException{
        classeLeitor abrirArquivo = new classeLeitor();
        abrirArquivo.lerArquivo("C:\\TestArquivo\\file.txt");
 
    }
}
