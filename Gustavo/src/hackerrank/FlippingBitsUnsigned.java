package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by guga
 *
 * You will be given a list of 32 bits unsigned integers. You are required to output the
 * list of the unsigned integers you get by flipping bits in its binary representation
 * (i.e. unset bits must be set, and set bits must be unset)./
 *
 * https://www.hackerrank.com/challenges/flipping-bits/
 * ACCEPTED
 **/
public class FlippingBitsUnsigned {

    final static long x = Long.MAX_VALUE>>>31;//mask for 32 bits

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        while(sc.hasNextLong()){
            long n = sc.nextLong();
            System.out.println(flip(n));
        }
    }

    @Test
    public void test(){
        Assert.assertEquals(2147483648L, flip(2147483647));
        Assert.assertEquals(4294967294L, flip(1));
        Assert.assertEquals(4294967295L, flip(0));
        Assert.assertEquals(0L, flip(4294967295L));
    }

    /**
     * unsiggned 32 bits
     * @param n
     */
    public static long flip(long n){
        return(~n&x);
    }
}