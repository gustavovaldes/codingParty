package varios;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gvaldes
 *
 * Euclidean implementation.
 */
public class GreatesCommonDivisor {


    /**
     *
     * original
     */
    public static int gcd(int x, int y){
        if(x>y){
            return gcd(x-y, y);
        }else if(x<y){
            return gcd(y-x, x);
        }else
         return x;
    }

    /**
     *
     * improved with mod.  when abs(x-y) is to big, it's better apply the %  instead all the subtraction steps
     * (  25 and 5 -> 25-5-5-5-5=5 (4 steps)  better 25%5=0  (1step) then 5 is the result.
     *
     */
    public static int gcd2(int x, int y){
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        if(y==0) return x;
        return gcd2(y, x%y);
    }

    @Test
    public void test(){
        Assert.assertEquals(1, gcd(5,6));
        Assert.assertEquals(5, gcd(5,10));
        Assert.assertEquals(6, gcd(6,12));
        Assert.assertEquals(6, gcd(6,6));
        Assert.assertEquals(5, gcd(10,45));
        Assert.assertEquals(2, gcd(14,8));
        Assert.assertEquals(21, gcd(252,105));
        Assert.assertEquals(3, gcd(1701, 3768));

        Assert.assertEquals(1, gcd2(5, 6));
        Assert.assertEquals(5, gcd2(5, 10));
        Assert.assertEquals(6, gcd2(6, 12));
        Assert.assertEquals(6, gcd2(6, 6));
        Assert.assertEquals(5, gcd2(10, 45));
        Assert.assertEquals(2, gcd2(14, 8));
        Assert.assertEquals(21, gcd2(252, 105));
        Assert.assertEquals(3, gcd2(1701,3768));
    }
}
