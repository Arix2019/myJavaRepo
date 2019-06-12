package TesteClasses;

import java.util.Scanner;

public class principalAluno {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        AvaliacaoAluno mediaAluno = new AvaliacaoAluno();
        String nomeAluno;
        int matricula;

        System.out.println("\tInforme as Notas:");
        System.out.printf("Nome do Aluno: ");
        nomeAluno = ler.nextLine();
        System.out.printf("Numero da Matricula: ");
        matricula = ler.nextInt();

        System.out.printf("Nota1: ");
        double nota01 = ler.nextFloat();
        System.out.printf("Nota2: ");
        double nota02 = ler.nextFloat();
        System.out.printf("Nota3: ");
        double nota03 = ler.nextFloat();
        System.out.printf("Nota4: ");
        double nota04 = ler.nextFloat();
        System.out.printf("Nota5: ");
        double nota05 = ler.nextFloat();
        System.out.printf("Nota6: ");
        double nota06 = ler.nextDouble();

        mediaAluno.nomeAluno = nomeAluno;
        mediaAluno.numMatriAluno = matricula;

        System.out.println("\nNome do Aluno: " + mediaAluno.nomeAluno + "\n" + "Numero da Matricula: " + mediaAluno.numMatriAluno);
        mediaAluno.avaliaAluno(nota01, nota02, nota03, nota04, nota05, nota06);

    }

}
