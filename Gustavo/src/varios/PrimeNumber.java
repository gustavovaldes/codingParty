package varios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class PrimeNumber {

    public static void main(String[] args) {

        long t1 = 0;
        long t2 = 0;

        // int[] numbers = {2, 3, 4, 5, 6, 7};
        ArrayList<Integer> primos = new ArrayList<Integer>();

        t1 = Calendar.getInstance().getTimeInMillis();
        for (int i = 2; i < 5000000; i++) {

            //int divisor = i - 1;

            //while ((divisor > 1) && ((i % divisor) != 0)) divisor--;
            int sizePrimos= primos.size();
            int indPrimos=0;
            int primoTope=i/2;
            while ( sizePrimos > 0  && indPrimos < sizePrimos &&
                    ((i % primos.get(indPrimos)) != 0) ) indPrimos++;

            if (indPrimos == sizePrimos) {
               // System.out.println(i);
                primos.add(i);
            }


        }
        t2 = Calendar.getInstance().getTimeInMillis();
        System.out.println(t2-t1);
    }
}