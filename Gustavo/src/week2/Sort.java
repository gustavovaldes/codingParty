package week2;

import java.util.Random;

public class Sort {


    public static void main(String[] args){

        StringBuffer a = new StringBuffer("20");
        StringBuffer b = new StringBuffer("10");
        StringBuffer c = a;
        a=b;

        System.out.println(a+" "+b+" "+c);

        Character[] seq25 = generateSequence(2500);
        Character[] seq50 = generateSequence(50);
        Character[] seq100 = generateSequence(100);
        long t1 = System.currentTimeMillis();
        Sort.shellSort(seq25);
        long t2 = System.currentTimeMillis();
        Sort.selectionSort(seq25);
        long t3 = System.currentTimeMillis();

        System.out.println("Shell: " + (t2-t1));
        System.out.println("Selection: " + (t3 - t1));
    }

    public static void shellSort( Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, ...
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }

            h = h / 3;
        }
        System.out.println(a);
    }

    public static void selectionSort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        if (v.compareTo(w) < 0) return true;
        else return false;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    private static Character[] generateSequence( int size ) {

        Random r = new Random();
        Character[] array = new Character[size];
        for (int i = 0; i < size ; i++) {
            array[i] = (char)(r.nextInt(26) + 'a');
        }
        return array;
    }
}
