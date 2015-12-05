package varios;

import java.util.Calendar;

/**
 * Created by cgonzalez on 11/20/15.
 */
public class Primus2 {

    //Mejor tiempo 17 segundo
    static int tope = 1000000;
    static int[] primos = new int[tope];
    static int totalPrimos = 1;

    static void listarPrimos(){
        for(int i = 3; i < tope; i++){

            if(esPrimo(i)){
                primos[totalPrimos] = i;
                totalPrimos++;
            }
        }
    }

    static boolean esPrimo(int valor){

        for(int i = 0; i < primos.length; i++){
            if(valor/2 >= primos[i]){
                if(valor%primos[i] == 0){
                    return false;
                }

            }else{
                break;
            }
        }

        return true;
    }

    static void imprimirPrimos(){

        for(int i = 0; i < totalPrimos; i++){
            System.out.print("\t" + primos[i]);
        }

    }

    public static void main(String args[]){

        long tiempoInicio = Calendar.getInstance().getTimeInMillis();
        //System.out.println("inicio:" + Calendar.getInstance().getTimeInMillis());
        primos[0] = 2;
        listarPrimos();
        imprimirPrimos();
        long tiempoTermino = Calendar.getInstance().getTimeInMillis();
        //System.out.println("termino:" + Calendar.getInstance().getTimeInMillis());
        System.out.println("Tiempo:" + (tiempoTermino - tiempoInicio));
    }
}