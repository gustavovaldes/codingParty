package epi.primitives;

import org.junit.Assert;

/**
 * Created by Gustavo on 07-12-15.
 *
 * Calculate parity of words/numbers
 *  11 -> parity 0
 *  10000101 -> parity 1
 *
 *  parity 1 if number of 1s is odd
 *
 *
 *  5.1
 */
public class Parity {

    public static void main(String[] args) {

        System.out.println("Start");
        Assert.assertEquals(0, Parity.parity1(123l));//01111011
        Assert.assertEquals(1, Parity.parity1(456343535l));//11011001100110011111111101110

        Assert.assertEquals(0, Parity.parity2(123l));
        Assert.assertEquals(1,Parity.parity2(456343535l));

        Assert.assertEquals(0, Parity.parity3(123l));
        Assert.assertEquals(1,Parity.parity3(456343535l));

        System.out.println("End");
    }

    /**
     * brute force  O(n)
     * @param num
     * @return
     */
    public static short parity1(long num){
        short result =0;
        while(num!=0){
            result ^= (num & 1);
            num>>=1;
        }
        return result;
    }

    /**
     * O(k) where k number of 1s in num.
     *  the key is num&=(num-1) , it goes to zero in only k iterations!!!
     *  sample: start in 9 -> 1001
     *  9&=8  => 8  (1001&1000)=1001
     *  8&=7  => 0  (1001&0111)=0000
     *
     * @param num
     * @return
     */
    public static short parity2(long num){
        short result =0;
        while(num!=0){
            result^= 1;
            num&=(num-1);//drop lowest set bit
        }
        return result;
    }

    /**
     * O(logN)
     *
     * the key is: parity of firstHalfOfWord xor secondHalfWord = parity of Word
     * sample:  11010011
     *  parity of 11010011 = parity of (1101) XOR (0011)
     * @return
     */
    public static short parity3(long num){
        num ^= num >>>32;
        num ^= num >>>16;
        num ^= num >>>8;
        num ^= num >>>4;
        num ^= num >>>2;
        num ^= num >>>1;
        return (short)(num & 0x1);//todo why 0x1 and not only 1?
    }
}
