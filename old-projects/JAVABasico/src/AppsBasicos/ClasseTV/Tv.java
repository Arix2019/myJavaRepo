package AppsBasicos.ClasseTV;

/**
 * classe Tv (sem classe principal)
 * @author Arix
 */
public class Tv {    
    //atributos do Televisor
    String Fabricante = "Philco";
    String Cor = "Black";
    boolean Ligar = false;
    int Polegadas = 32;
    String Tipo = "LED";
    int Volume = 0;
    int Canal = 1;
    
    // volume maximo 80
    public void aumentarVolume() {
        if (Volume >= 5){
            return;
        }
        Volume++;
    }
    
    // volume minimo 0
    public void diminuirVolume() {
        if (Volume <= 0){
    // se volume for menor ou igual a zero então finaliza
    // se não ele diminui
            return;
        }
        Volume--;
    }
    
    public void TvDesligado() {
        Ligar = false;
    }
    
    public void TvLigado() {
        Ligar = true;
    }

    public void AumentarCanal() {
        if (Canal >= 80){
            return;
        }
        Canal++;
    }
    
    public void DiminuirCanal() {
        if (Canal <= 0){
            return;
        }
        Canal--;
    }    
    
}
