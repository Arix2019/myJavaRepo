package TesteClasses;

import java.util.Scanner;

public class test01 {
    float calc; 
    Scanner ler = new Scanner(System.in);

    public void Soma(float x, float y){
      
        calc = x + y;
        System.out.println("Resultado: " + calc);
    }
    
    public void Subtracao(float x, float y){
        calc = x - y;
        System.out.println("Resultado: " + calc);
    }

    public void Multi(float x, float y){
        calc = x * y;
        System.out.println("Resultado: " + calc);
    }
    
    public void Divisao(float x, float y){
        calc = x / y;
        System.out.println("Resultado: " + calc);
    }    

}
    
    
