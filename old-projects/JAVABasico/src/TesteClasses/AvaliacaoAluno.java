/*
1. Implemente um classe que represente um aluno da FIC, contendo três membros: 
    a. O nome do aluno 
    b. O número de matrícula do aluno 
    c. Um objeto da classe Avaliacao 

2. Depois implemente o método principal dessa classe com o seguinte comportamento: 
    Perguntar ao usuário o nome, número de matrícula e as  
    seis notas de um aluno. Depois, imprima a identificação e a média do aluno, 
    dizendo se ele foi: 
*   aprovado (média > 6.9) 
    dependente de prova final (3.9 < média <7.0) 
    reprovado: (média < 4.0) 
 */
package TesteClasses;

public class AvaliacaoAluno {

    String nomeAluno;
    int numMatriAluno;

    boolean avaliaAluno(double nt01, double nt02, double nt03, double nt04, double nt05, double nt06) {
        double media;
        media = (nt01 + nt02 + nt03 + nt04 + nt05 + nt06) / 6;
        if (media >= 6.9) {
            System.out.println("Média do Aluno: " + media);
            System.out.println("Aluno Aprovado!");
            return true;

        } else if (media < 4.0) {
            System.out.println("Média do Aluno: " + media);
            System.out.println("Aluno Reprovado!");
            return true;
        } else {
            System.out.println("Média do Aluno: " + media);
            System.out.println("Aluno depende da Prova Final!");
            return false;
        }

    }
    //public void avaliaAluno(double nt01, double nt02, double nt03, double nt04, double nt05, double nt06){
    //    double media;
    //    media = (nt01 + nt02 + nt03 + nt04 + nt05 + nt06) / 6;
    //    
    //    System.out.println("Média do Aluno: " + media);

    //}
}
