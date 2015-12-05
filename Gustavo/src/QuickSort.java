import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gustavo on 01-11-15.
 */
public class QuickSort {

    static int count =0;
    public static void main(String[] args) {

        File file = new File("/Users/Gustavo/Cursos/AnalysisAlg1/10.txt");
        int read = 0;
        int[] x = new int[10];
        Scanner sc;
        try {
            sc = new Scanner(file);
            for (int i = 0; i < 10; i++) {
                x[i] = sc.nextInt();
            }
            while(sc.hasNext()){
                sc.nextInt();
                read++;
            }
            System.out.println("READ:"+x[10-1]);
            System.out.println(read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println(Arrays.toString(x));
        System.out.println(count);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;


        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[low];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j){
            count= count + (j - low );
            quickSort(arr, low, j);
        }

        if (high > i){
            count= count + (high - i );
            quickSort(arr, i, high);
        }
    }


    public static void quickSort2(int A[], int izq, int der) {


        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de izquierda a derecha
        int j=der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i<j){            // mientras no se crucen las búsquedas
            while(A[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
            while(A[j]>pivote) j--;         // busca elemento menor que pivote
            if (i<j) {                      // si no se han cruzado
                aux= A[i];                  // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }
        A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) {
            count= count + (j - izq - 1);
            quickSort2(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if(j + 1 < der) {
            count= count + (der - j + 1 - 1);
            quickSort2(A, j + 1, der); // ordenamos subarray derecho
        }
    }

    public static void quickSort3(int[] array ,int lowerIndex, int higherIndex) {


        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(array, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j){
            count= count + (j - lowerIndex - 1);
            quickSort3(array, lowerIndex, j);
        }
        if (i < higherIndex) {
            count= count + (higherIndex - i - 1);
            quickSort3(array, i, higherIndex);
        }
    }

    public static void exchangeNumbers(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
