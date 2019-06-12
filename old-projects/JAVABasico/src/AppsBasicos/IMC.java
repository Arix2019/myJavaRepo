/*JAVA App
 *calculo de indice de Massa Corporea(IMC) by: ARB PRODUCTIONS 
 */
package AppsBasicos;

import java.util.Scanner;
import java.text.DecimalFormat;

public class IMC{

	static public void main(String[] args){
            
            try{
            System.out.println("\n\t***Calculo IMC***  (0 para sair)\n");
            System.out.println("Menu: ");
            System.out.println("-----");            
            System.out.printf("Idade: ");
            Scanner ler = new Scanner(System.in);
            int idade = ler.nextInt();
            
            if (idade < 6){
                System.out.println("Muito jovem, aconcelhavel procurar em especialista.");
                SAIR();
            }
            if ((idade >=6) && (idade <= 15)){
                //IMCInfantil();
                IMCInfantil();       
            }
            if ((idade > 15) && (idade <= 65)){
                //IMCPadrao();
                IMCPadrao();
                
            }
            if (idade > 65){
                //IMCIdosos();
            }
            if (idade == 0){
                SAIR();
            }
            } catch(Exception e){
                System.out.println("Ocorreu um erro, certifique-se que os dados foram corretamente inseridos e tente novamente.");
            }   
	}
	
	//Abaixo todas as FUNCOES:
        public static void IMCInfantil(){
            System.out.println("\n\t***IMC Para Jovens entre 6 e 15 anos***\n");
            System.out.println("(1) IMC para Meninos");
            System.out.println("(2) IMC para Meninas");
            System.out.println("(3) SAIR");
            System.out.printf("Opcao: ");
            Scanner ler = new Scanner(System.in);
            int op = ler.nextInt();
                switch(op){
                    case 1:
                        IMCMenino();
                        break; 
                   // case 2:
                   //     IMCMenina();
                   //     break;   
                    case 3:
                        SAIR();
                        break;  
                    default:
                        System.out.println("ERRO!");
                }
        }
        public static void IMCMenino(){
                        double altura,peso;
			double calc;
			Scanner ler = new Scanner(System.in);
                    try{
			System.out.println("\n\t***IMC (Infantil) Para Meninos entre 6 e 15 anos***\n");
                        System.out.printf("\tIdade: ");
                        int idade = ler.nextInt();  
                        
                        //if ((idade < 6) || (idade > 15)){
                        //    System.out.println("ERRO! Idade entre 6 e 15 anos");
                        //    SAIR();
                        //}
                        
                        if (idade < 6){
                            System.out.println("ERRO");
                        }
                        if ((idade >=15) && (idade <= 65)){
                            IMCPadrao();
                        }
                        if (idade > 65){
                            //IMCIdosos
                        }
                        
			System.out.printf("\tAltura: ");	
			altura = ler.nextDouble();
			System.out.printf("\tPeso: ");
			peso = ler.nextDouble();
			
			calc = peso / (altura * altura);
			
			DecimalFormat df = new DecimalFormat("0.##");
			String result = df.format(calc);
			
                        //tomada de decisao menino 6 anos
                        if (idade == 6){
                            if ( calc < 14.5){
                                System.out.println("Abaixo do Peso!");
                            }
                            if ((calc >= 14.5 ) && (calc <= 16.6)){
                                System.out.println("Peso Normal!");
                            }
                            if ((calc > 16.6 ) && (calc <= 18.0)){
                                System.out.println("Sobrepeso!");
                            }
                            if (calc > 18.0){
                                System.out.println("Obesidade!");
                            }

                        }
                        
                        //tomada de decisao menino 7 anos
                        if (idade == 7){
                            if ( calc < 15.0){
                                System.out.println("Abaixo do Peso!");
                            }
                            if ((calc >= 15.0 ) && (calc <= 17.3)){
                                System.out.println("Peso Normal!");
                            }
                            if ((calc > 17.3 ) && (calc <= 19.1)){
                                System.out.println("Sobrepeso!");
                            }
                            if (calc > 19.1){
                                System.out.println("Obesidade!");
                            }

                        }
                        
                        //tomada de decisao menino 8 anos
                        if (idade == 8){
                            if ( calc < 15.6){
                                System.out.println("Abaixo do Peso!");
                            }
                            if ((calc >= 15.6 ) && (calc <= 16.7)){
                                System.out.println("Peso Normal!");
                            }
                            if ((calc > 16.7 ) && (calc <= 20.3)){
                                System.out.println("Sobrepeso!");
                            }
                            if (calc > 20.3){
                                System.out.println("Obesidade!");
                            }

                        }   
                        
                        //tomada de decisao menino 9 anos
                        if (idade == 9){
                            if ( calc < 16.1){
                                System.out.println("Abaixo do Peso!");
                            }
                            if ((calc >= 16.1 ) && (calc <= 18.8)){
                                System.out.println("Peso Normal!");
                            }
                            if ((calc > 18.8 ) && (calc <= 21.4)){
                                System.out.println("Sobrepeso!");
                            }
                            if (calc > 21.4){
                                System.out.println("Obesidade!");
                            }

                        }  
                        //tomada de decisao menino 10 anos    
                        if (idade == 10){
                            if ( calc < 16.7){
                                System.out.println("Abaixo do Peso!");
                            }
                            if ((calc >= 16.7 ) && (calc <= 19.6)){
                                System.out.println("Peso Normal!");
                            }
                            if ((calc > 19.6 ) && (calc <= 22.5)){
                                System.out.println("Sobrepeso!");
                            }
                            if (calc > 22.5){
                                System.out.println("Obesidade!");
                            }

                        } 
                        
                        //tomada de decisao menino 11 anos    
                        if (idade == 11){
                            if ( calc < 17.2){
                                System.out.println("Abaixo do Peso!");
                            }
                            if ((calc >= 17.2 ) && (calc <= 20.3)){
                                System.out.println("Peso Normal!");
                            }
                            if ((calc > 20.3 ) && (calc <= 23.7)){
                                System.out.println("Sobrepeso!");
                            }
                            if (calc > 23.7){
                                System.out.println("Obesidade!");
                            }

                        }
                        
                        //tomada de decisao menino 12 anos    
                        if (idade == 12){
                            if ( calc < 17.8){
                                System.out.println("Abaixo do Peso!");
                            }
                            if ((calc >= 17.8 ) && (calc <= 21.1)){
                                System.out.println("Peso Normal!");
                            }
                            if ((calc > 21.1 ) && (calc <= 24.8)){
                                System.out.println("Sobrepeso!");
                            }
                            if (calc > 24.8){
                                System.out.println("Obesidade!");
                            }

                           } 
                        //tomada de decisao menino 13 anos    
                        if (idade == 13){
                            if ( calc < 18.5){
                                System.out.println("Abaixo do Peso!");
                            }
                            if ((calc >= 18.5 ) && (calc <= 21.9)){
                                System.out.println("Peso Normal!");
                            }
                            if ((calc > 21.9 ) && (calc <= 25.9)){
                                System.out.println("Sobrepeso!");
                            }
                            if (calc > 25.9){
                                System.out.println("Obesidade!");
                            }

                        } 
                        
                        //tomada de decisao menino 14 anos    
                        if (idade == 14){
                            if ( calc < 19.2){
                                System.out.println("Abaixo do Peso!");
                            }
                            if ((calc >= 19.2 ) && (calc <= 22.7)){
                                System.out.println("Peso Normal!");
                            }
                            if ((calc > 22.7 ) && (calc <= 26.9)){
                                System.out.println("Sobrepeso!");
                            }
                            if (calc > 26.9){
                                System.out.println("Obesidade!");
                            }

                        }
                        
                        //tomada de decisao menino 15 anos    
                        if (idade == 15){
                            if ( calc < 19.9){
                                System.out.println("Abaixo do Peso!");
                            }
                            if ((calc >= 19.9 ) && (calc <= 23.6)){
                                System.out.println("Peso Normal!");
                            }
                            if ((calc > 23.6 ) && (calc <= 27.7)){
                                System.out.println("Sobrepeso!");
                            }
                            if (calc > 27.7){
                                System.out.println("Obesidade!");
                            }

                        }                         
  
                    } catch(Exception e){
			System.out.println(">>Ocorreu um Erro!\n Informe corretamente a Altura e Peso. EX:\n ALTURA: 1,80 - PESO: 80 ");
                    }           
                } //fim funcao IMCMenino
        
	public static void IMCPadrao(){ 	
			double altura,peso;
			double calc;
			Scanner ler = new Scanner(System.in);
                    try{
			System.out.println("\n\t***IMC Para Pessoas entre 15 e 65 anos***\n");
			System.out.printf("\tAltura: ");	
			altura = ler.nextDouble();
			System.out.printf("\tPeso: ");
			peso = ler.nextDouble();
			
			calc = peso / (altura * altura);
			
			DecimalFormat df = new DecimalFormat("0.##");
			String result = df.format(calc);
			
			if (calc < 17.0){
				System.out.println("\n>>Altura: "+altura+"m "+" Peso: "+peso+"Kg "+"IMC: "+result+"\n\n\tMuito abaixo do Peso!\n\n");
			}                                          
			if ((calc >= 17.0) && (calc <= 18.49)){    
				System.out.println("\n>>Altura: "+altura+"m "+" Peso: "+peso+"Kg "+"IMC: "+result+"\n\n\tAbaixo do Peso!\n\n");
			}                                          
			if ((calc >= 18.5) && (calc <= 24.99)){    
				System.out.println("\n>>Altura: "+altura+"m "+" Peso: "+peso+"Kg "+"IMC: "+result+"\nPeso Normal!");
			}                                          
			if ((calc >= 25.0) && (calc <= 29.99)){    
				System.out.println("\n>>Altura: "+altura+"m "+" Peso: "+peso+"Kg "+"IMC: "+result+"\nAcima do Peso!");
			}                                          
			if ((calc >= 30.0) && (calc <= 34.99)){    
				System.out.println("\n>>Altura: "+altura+"m "+" Peso: "+peso+"Kg "+"IMC: "+result+"\nObesidade Grau I!");
			}		                                   
			if ((calc >= 35.0) && (calc <= 39.99)){    
				System.out.println("\n>>Altura: "+altura+"m "+" Peso: "+peso+"Kg "+"IMC: "+result+"\nObesidade Grau II (Severa)!");
			}		                                   
			if (calc > 40.0){                          
				System.out.println("\n>>Altura: "+altura+"m "+" Peso: "+peso+"Kg "+"IMC: "+result+"\nObesidade Grau III (M\u00F3rbida)!");
			}
                    } catch(Exception e){
			System.out.println(">>Ocorreu um Erro!\n Informe corretamente a Altura e Peso. EX:\n ALTURA: 1,80 - PESO: 80 ");
                    }
	}// fim funcao IMPadrao();	
	
        //funcao SAIR
	public static void SAIR(){
		System.exit(0);
	}
        //fim funcao SAIR
        
}
