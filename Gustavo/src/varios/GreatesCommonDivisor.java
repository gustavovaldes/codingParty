package varios;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gvaldes
 *
 * Euclidean implementation.
 * todo Implement more efficient way when Abs(x-y) is super big
 */
public class GreatesCommonDivisor {


    public static int gcd(int x, int y){
        if(x>y){
            return gcd(x-y, y);
        }else if(x<y){
            return gcd(y-x, x);
        }else
         return x;
    }

    @Test
    public void test(){
        Assert.assertEquals(1, gcd(5,6));
        Assert.assertEquals(5, gcd(5,10));
        Assert.assertEquals(6, gcd(6,12));
        Assert.assertEquals(2, gcd(14,8));
        Assert.assertEquals(21, gcd(252,105));
    }
}
