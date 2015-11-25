package varios;

import java.util.*;

public class Primus {

    static Vector<Integer> primos = new Vector<>();

    public static void main(String[] args) {
        new Primus().run();

    }
    public void run( ) {
        long t1 = 0;
        long t2 = 0;
        Primus calculator = new Primus();
        t1 = Calendar.getInstance().getTimeInMillis();
       // for (int i = 2; i <10 ; i++) {
            //if(calculator.isPrimo(i)){
            //     primos.add(i);
            //}
        new MyHilo(2,1000000).start();
        new MyHilo(2000001,3000000).start();
        new MyHilo(3000001,4000000).start();
        new MyHilo(4000001,5000000).start();
            //System.out.println(i);
        //}

        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( primos);
        t2 = Calendar.getInstance().getTimeInMillis();
        System.out.println(t2-t1);
    }

    public boolean isPrimo(int number){

            for (int primo : primos) {
                if(number%primo==0) return false;
                if(number<2*primo) break;
            }
            return true;

    }


     class MyHilo extends Thread{

        private int inicio ;
         private int fin ;
        MyHilo(int inicio, int fin){
            this.inicio = inicio;
            this.fin = fin;
        }
        @Override
        public void run() {
            super.run();
            for (int i = inicio; i <fin ; i++) {
                process(i);
            }

        }

         private void process(int i){

             for (int primo : primos) {
                 if(i%primo==0) return;
                 if(i<2*primo) break;
             }

             //synchronized (""+i){primos.add(i);}



         }
    }
}
