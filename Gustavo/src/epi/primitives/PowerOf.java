package epi.primitives;

import org.junit.Assert;

import java.util.Calendar;

/**
 * Created by Gustavo on 08-12-15.
 *
 * Compute x^y
 */
public class PowerOf {

    public static void main(String[] args) {
        System.out.println("Start Test");
        long t1= Calendar.getInstance().getTimeInMillis();
        long t2=0;
        long t3=0;
        long t4=0;

        for (int i = 0; i <2000000; i++) {
            Assert.assertEquals(8, PowerOf.calculate1(2d, 3),0);
            Assert.assertEquals(105413504, PowerOf.calculate1(14d, 7),0);
            Assert.assertEquals(Math.pow(3d,41), PowerOf.calculate1(3d, 41),0);
        }
        t2 = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i <2000000; i++) {
            Assert.assertEquals(8, PowerOf.calculate2(2, 3),0);
            Assert.assertEquals(105413504, PowerOf.calculate2(14, 7),0);
            Assert.assertEquals(Math.pow(3d,41), PowerOf.calculate2(3, 41),0);
        }
        t3 = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i <2000000; i++) {
            Assert.assertEquals(8, PowerOf.calculate3(2, 3),0d);
            Assert.assertEquals(105413504, PowerOf.calculate3(14, 7),0d);
            Assert.assertEquals(Math.pow(3d,41), PowerOf.calculate3(3, 41), 0d);
        }
        t4 = Calendar.getInstance().getTimeInMillis();
        System.out.println("Impl1:"+(t2-t1));
        System.out.println("Impl2:"+(t3-t2));
        System.out.println("Impl3:"+(t4-t3));
        System.out.println("End Test");
    }


    /**
     * first attempt, brute force O(y)
     * @param x
     * @param y
     * @return
     */
    public static double calculate1(double x, int y){
        double result = 1;
        while(y>0){
            result*=x;
            y--;
        }
        return result;
    }

    /*in progress..*/
    public static double calculate2(double x, int y){
        double result = 1;
        int div = y;
        int pivot = y/2;
        while(pivot>0){
            result*=x;
            pivot--;
        }
        result*=result;
        if(y%2>0){
            result*=x;
        }
        return result;
    }

    /**
     * book solution, worst than brute force ¿? todo review multiplication costs
     * @param x
     * @param y
     * @return
     */
    public static double calculate3(double x, int y){
        double result = 1.0;
        long power = y;
        /*if (y < 0) {
            power = -power;
            x = 1.0 / x;
        }*/
        while (power != 0) {
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }
}
