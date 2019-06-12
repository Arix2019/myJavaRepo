package AppsBasicos;

public class classPessoas {

     public String nome;
     public int idade;
     public String cidade;

    public classPessoas(String nome, int idade, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(){
       this.nome = nome;
    }    
    
    public int getIdade(){
        return idade;
    }
    
    public void setIdade(){
        this.idade = idade;
    }
    
    public String getCidade(){
        return cidade;
    }
    
    public void setCidade(){
        this.cidade = cidade;
    }

}
