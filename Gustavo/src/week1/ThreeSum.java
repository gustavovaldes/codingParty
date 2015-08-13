package week1;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSum {

    int[] array;

    public ThreeSum(){

    }

   /* public ThreeSum(int[] values){
        this.array= values;
    }*/

    public int v1(){
        int result = 0;
        int n = array.length;
        for (int i=0; i< n; i++) {
            for (int i1=i+1; i1< n; i1++) {
                for (int i2=i1+1; i2< n; i2++) {
                    if(array[i]+array[i1]+array[i2]==0){
                        result++;
                        //System.out.println(array[i]+ " , " + array[i1] + " , " +array[i2]);
                    }
                }
            }
        }

        return result;
    }

    @Test
    public void testV1(){
        int[] values = {30, -40, -20, -10, 40, 0, 10, 5};
        ThreeSum t = new ThreeSum();
        t.array = values;
        int result = t.v1();
        Assert.assertEquals(4, result);


        initializeArray(2000);
        long t1 = System.currentTimeMillis();
        v1();
        long t2 = System.currentTimeMillis();
        initializeArray(4000);
        long t3 = System.currentTimeMillis();
        v1();
        long t4 = System.currentTimeMillis();
        initializeArray(8000);
        long t5 = System.currentTimeMillis();
        v1();
        long t6 = System.currentTimeMillis();

        System.out.println("5000 : " + (t2 - t1));
        System.out.println("10000 : " + (t4 - t3));
        System.out.println("20000 : " + (t6 - t5));
    }

    private void initializeArray(int N){
        int x = 1;
        array = new int[N];
        for (int i= 0; i<N; i++) {
            array[i] = (int)Math.ceil(Math.random()*30*x);
            x = -x;
        }
    }

}

