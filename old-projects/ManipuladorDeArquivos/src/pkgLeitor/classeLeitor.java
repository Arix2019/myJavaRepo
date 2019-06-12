package pkgLeitor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class classeLeitor {

    public void lerArquivo(String pathFile) throws IOException {
        String readLine;
        try {
            FileInputStream lerArquivo = new FileInputStream(pathFile);
            InputStreamReader input = new InputStreamReader(lerArquivo);
            BufferedReader bfr = new BufferedReader(input);
            
            do {                
                readLine = bfr.readLine();
                if (readLine != null){
                    System.out.println(readLine);
                }
            } while (readLine != null);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possivel ler o arquivo.");
        }        
    }

}
