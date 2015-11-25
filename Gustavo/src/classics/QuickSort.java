package classics;

import org.junit.Assert;

public class QuickSort {


    public static void main(String[] args) {
        int[] array = new int[]{4,3,2,5,7,3,8,1};
        int pivot = 0;
        new QuickSort().quickSort(array,pivot,array.length);
        int val= 0;
        for (int i = 0; i < array.length; i++) {
            Assert.assertTrue(array[i]>=val);
            val= array[i];
            i++;
            System.out.println(val);
        }

    }

    private void quickSort(int[] array, int lo, int hi ){

    }

    private int partition(int[] array, int lo, int hi){

        return 0;
    }

    private void swap(){

    }
}
