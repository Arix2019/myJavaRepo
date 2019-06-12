package vetor;

public class Vetor {

    public static void main(String[] args) {
        
        int vet[] = {5,6,7,8,12};
        
        //for each
        for (int c: vet){
            System.out.print(c + " ");  
        }
        
        System.out.println("\n");
        
        //for tradicional
        for (int x = 0; x < vet.length; x++){
            System.out.print(vet[x] + " ");
        }
        

    }
    
}
