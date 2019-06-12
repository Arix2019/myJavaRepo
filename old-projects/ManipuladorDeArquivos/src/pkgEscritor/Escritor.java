package pkgEscritor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * escreve no arquivo
 *
 * @author Arix
 */
public class Escritor {
    
    public static void main(String[] args) throws IOException {
        int op;
        LocalDateTime clock = LocalDateTime.now();
        
        System.out.println("Escrevendo em um Arquivo externo:");
        try {
            do {
                //FileOutputStream responsavel por escrever no arquivo
                FileOutputStream arquivo = new FileOutputStream("C:\\TestArquivo\\file.txt", true);
                PrintWriter pw = new PrintWriter(arquivo);
                Scanner leitor = new Scanner(System.in);

                System.out.print("Nome: ");
                String nome = leitor.nextLine();
                System.out.print("Idade: ");
                String idade = leitor.nextLine();

                pw.println("Nome: " + nome );
                pw.println("Idade: " + idade);
                pw.println("Data/Hora: " + clock);
                pw.println("-------------------------------------------");

                pw.close();
                arquivo.close();
                System.out.print("\nContinuar? (1-SIM/0-NÃO): ");
                op = leitor.nextInt();
            } while (op != 0);
            if (op == 0) {
                System.out.println("\nFinalizado.");
                System.exit(0);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possivel escrever no arquivo.");
        }
    }

}
