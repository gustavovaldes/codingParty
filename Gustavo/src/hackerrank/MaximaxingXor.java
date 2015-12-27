package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author guga
 * https://www.hackerrank.com/challenges/maximizing-xor/submissions/code/16035803
 */
public class MaximaxingXor {

    static int maxXor(int l, int r) {
        //todo replace integer method with shift operators
        return  (int)(   Math.pow(2,32 - Integer.numberOfLeadingZeros(l^r)) - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);
    }

    @Test
    public void test(){
        Assert.assertEquals(maxXor(10,15),7);
        Assert.assertEquals(maxXor(1,1),0);
        Assert.assertEquals(maxXor(14,678),1023);
    }
}
