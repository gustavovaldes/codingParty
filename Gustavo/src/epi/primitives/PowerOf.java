package epi.primitives;

import org.junit.Assert;

/**
 * Created by Gustavo on 08-12-15.
 *
 * Compute x^y
 */
public class PowerOf {

    public static void main(String[] args) {
        Assert.assertEquals(8, PowerOf.calculate1(2,3));
        Assert.assertEquals(105413504, PowerOf.calculate1(14,7));

        Assert.assertEquals(8, PowerOf.calculate2(2, 3));
        Assert.assertEquals(105413504, PowerOf.calculate2(14, 7));
    }


    /**
     * first attempt, O(y)
     * @param x
     * @param y
     * @return
     */
    public static int calculate1(int x, int y){
        int result = 1;
        while(y>0){
            result*=x;
            y--;
        }
        return result;
    }

    /*in progress..*/
    public static int calculate2(int x, int y){
        int result = 1;
        int count = 1;
        while(y>0){
            if(count*2<y){
                result *= result;
                count *=2;
                y-=y-count*2;
            }else{
                result*=x;
                count++;
                y--;
            }
        }
        return result;
    }
}
