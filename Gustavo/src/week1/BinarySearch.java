package week1;

import org.junit.Test;

public class BinarySearch {

    int[] array;

    public int find(int x) {

        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (x > array[mid]) lo = mid + 1;
            else if (x < array[mid]) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    @Test
    public void test(){
        array = new int[]{1,3, 5, 7, 9, 11, 15};
        System.out.println(find(5));
        System.out.println(find(10));
    }
}
