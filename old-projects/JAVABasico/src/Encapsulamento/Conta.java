package Encapsulamento;

public class Conta {

    private String cliente;
    private double saldo;
    private double limite;

    public Conta(String cliente, double saldo, double limite) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.limite = limite;
    }

    //gets / sets
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    //----------

    public void exibeSaldo() {
        System.out.println(cliente + " saldo atual: [R$ " + saldo + "]");
    }

    public void saca(double valor) {
        if (valor > limite) {
            System.out.println("Erro ao efetuar o Saque! \n"
                    + "Você tentou efetuar um saque superior ao limite de: [R$ " + limite + "]");
            exibeSaldo();
            System.exit(0);            
        } else {
            saldo = saldo - valor;
        }
    }

    public void depoisita(double valor) {
        //saldo += valor;
        saldo = saldo + valor;
    }

    public void transferePara(Conta destino, double valor) {
        this.saca(valor);
        destino.depoisita(valor);
    }

}
