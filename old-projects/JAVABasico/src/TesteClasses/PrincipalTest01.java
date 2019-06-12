package TesteClasses;

import java.util.Scanner;

public class PrincipalTest01 {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        test01 calcular = new test01();
        float num1, num2;
        int cont;
        
        do {
            System.out.println("Calculo: 1-soma / 2-Subtração / 3-Multiplicaçao / 4-Divisão");
            int num = ler.nextInt();
            
            switch (num) {
                
                case 1:
                    System.out.printf("1o Numero: ");
                    num1 = ler.nextInt();
                    System.out.printf("2o Numero: ");
                    num2 = ler.nextInt();                    
                    calcular.Soma(num1, num2);
                    break;
                
                case 2:
                    System.out.printf("1o Numero: ");
                    num1 = ler.nextInt();
                    System.out.printf("2o Numero: ");
                    num2 = ler.nextInt();                    
                    calcular.Subtracao(num1, num2);
                    break;
                
                case 3:
                    System.out.printf("1o Numero: ");
                    num1 = ler.nextInt();
                    System.out.printf("2o Numero: ");
                    num2 = ler.nextInt();                    
                    calcular.Multi(num1, num2);
                    break;
                
                case 4:
                    System.out.printf("1o Numero: ");
                    num1 = ler.nextInt();
                    System.out.printf("2o Numero: ");
                    num2 = ler.nextInt();                    
                    calcular.Divisao(num1, num2);
                    break;                
                
                default:
                    System.out.println("ERRO!");
            }
            System.out.printf("Continuar? 1-Sim / 0-Não: ");
            cont = ler.nextInt();
        } while (cont != 0);
        if (cont == 0) {
            System.exit(0);
        }
        
    }
    
}
