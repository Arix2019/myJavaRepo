package TesteClasses;

/**
 *
 * @author Arix
 */
public class ClasseArray {
    String nomeCli;
    int numeroConta;
    double saldoCli;
    double limiteCli;
    
    public void saldo(double valor){
        if (valor > limiteCli){
            System.out.println("Saque Indisponivel! Limite ultrapassado.");
        } else {
            saldoCli = saldoCli - valor;
            System.out.println("Saldo atual: " + saldoCli);
        }
    }
    
}
