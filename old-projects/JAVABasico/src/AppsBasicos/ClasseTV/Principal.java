package AppsBasicos.ClasseTV;

public class Principal {
    
    public static void main(String[] args){
        Tv televisor = new Tv();
        
       // System.out.println("O Televisor está " + 
        //    (televisor.Ligar == true ? "Ligado":"Deslido"));
        
        televisor.TvLigado();
        televisor.aumentarVolume();
        televisor.aumentarVolume();
        televisor.AumentarCanal();
        televisor.AumentarCanal();
        
        System.out.println("O Televisor " + televisor.Fabricante + " está " + 
            (televisor.Ligar == true ? "Ligado ":"Deslido ") + "com um volume de " + televisor.Volume + 
                " e sintonizado no canal " + televisor.Canal + ".");    
        
        
    }
}
