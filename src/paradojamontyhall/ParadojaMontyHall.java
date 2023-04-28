package paradojamontyhall;

import java.util.Random;
import java.util.Scanner;


public class ParadojaMontyHall {
    
    static Boolean[] puertas=new Boolean[3];
    static final int NUMEROINTENTOS=10000000;

    public static void main(String[] args) {
        int aciertos=0;
        int intentos=0;
        int opcionCambioPuerta=0;
        int opcionVariabilidadDeEleccionDePuerta=0;
        Boolean validacion=false;
        Scanner entrada = new Scanner(System.in);
        while(!validacion){
            System.out.println("Elige una opción para elección de puerta (fija o aleatoria):");
            System.out.println("\n1. Elegir puerta 1");
            System.out.println("2. Elegir puerta 2");
            System.out.println("3. Elegir puerta 3");
            System.out.println("4. Elección aleatoria de puerta en cada intento\n\n");
            try{
                opcionVariabilidadDeEleccionDePuerta=entrada.nextInt();
                validacion=true;
                if(opcionVariabilidadDeEleccionDePuerta<1 || opcionVariabilidadDeEleccionDePuerta>4){
                    validacion=false;
                    System.out.println("\n\n\nOpción inválida");
                }
            }catch(Exception e){System.out.println("\n\n\nOpción inválida");}
        }
        validacion=false;
        while(!validacion){
            System.out.println("\n\n\nElige una opción para cambio de elección:");
            System.out.println("\n1. Cambiar de puerta");
            System.out.println("2. No cambiar de puerta\n\n");
            try{
                opcionCambioPuerta=entrada.nextInt();
                validacion=true;
                if(!(opcionCambioPuerta==1 || opcionCambioPuerta==2)){
                    validacion=false;
                    System.out.println("\n\n\nOpción inválida");
                }
            }catch(Exception e){System.out.println("\n\n\nOpción inválida");}
        }
        
        
        
        while(intentos<=NUMEROINTENTOS){
            for(int i=0; i<3; i++){puertas[i]=false;}
            Random rd = new Random();
            puertas[rd.nextInt(3)]=true;
            int eleccion=0;
            if(opcionVariabilidadDeEleccionDePuerta==4) eleccion=rd.nextInt(3);
            else eleccion=opcionVariabilidadDeEleccionDePuerta;
            Boolean abrir=false;
            int primeraAbierta=0;
            while(!abrir){
                primeraAbierta=rd.nextInt(3);
                abrir= !(puertas[primeraAbierta] || primeraAbierta==eleccion);
            }
            if(opcionCambioPuerta==1){
                for(int i=0; i<3; i++){
                    if(!(i==primeraAbierta || i==eleccion)) eleccion=i;
                }
            }
            /////////////////////////////////
            if(puertas[eleccion]) aciertos++;
            /////////////////////////////////
            intentos++;
        }
        System.out.println("\n\nAciertos: "+aciertos+"\nIntentos: "+(intentos-1));
    }
    
}
