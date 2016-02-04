package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by guga
 */
public class CounterGame {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = 0;
        in.nextInt();
        while (in.hasNextLong()) {
            n = in.nextLong();
            long x = 63 - Long.numberOfLeadingZeros(n);
            if (Math.pow(2, x) != n) {
                x++;
            }
            if (x % 2 == 0) {
                System.out.println("Louise");
            } else {
                System.out.println("Richard");
            }
        }
    }


    public static boolean isPowerOfTwo(BigInteger n) {
        int i = 0;
        while (!n.shiftRight(i).equals(BigInteger.ZERO)) {
            i++;
        }
        if (n.equals(new BigInteger("" + (int) Math.pow(2, i - 1)))) //todo replace without Math, maybe other shift logic.
            return true;
        else
            return false;
    }

    public static boolean isPowerOfTwo(int n) {
        int x = 31 - Integer.numberOfLeadingZeros(n);
        if (Math.pow(2, x) == n) //todo replace without Math, maybe other shift logic.
            return true;
        else
            return false;
    }

    public static int nextN(int n) {
        int x = 31 - Integer.numberOfLeadingZeros(n);
        if (Math.pow(2, x) == n) //todo replace without Math, maybe other shift logic.
            return (int) Math.pow(2, x - 1);
        else
            return (int) Math.pow(2, x);
    }

    public static String winner(BigInteger n) {
        return  winner(n,false);
    }


    public static String winner(BigInteger n, boolean win) {
        int i = 0;
        while (!n.shiftRight(i).equals(BigInteger.ZERO)) {
            i++;
        }
        BigInteger x = new BigInteger("" + (int) Math.pow(2, i - 1));
        if (!n.equals(x)) {
            BigInteger y = n.subtract(x);
            if (y.equals(BigInteger.ONE)) {
                return win(win);
            } else {
                return winner(y,!win);
            }
        }
        return win(win);
    }

    public static String win(boolean win) {
        if (win)
            return "Richard";
        else
            return "Louise";
    }


    @Test
    public void testIsPowerOfTwo() {
        Assert.assertTrue(isPowerOfTwo(new BigInteger("2")));
        Assert.assertTrue(isPowerOfTwo(new BigInteger("16")));
        Assert.assertTrue(isPowerOfTwo(new BigInteger("1024")));
        Assert.assertFalse(isPowerOfTwo(new BigInteger("1023")));
        Assert.assertTrue(isPowerOfTwo(new BigInteger("1")));
        Assert.assertFalse(isPowerOfTwo(new BigInteger("12")));
        Assert.assertFalse(isPowerOfTwo(new BigInteger("3")));
    }

    @Test
    public void testWinner() {

        Assert.assertEquals("Louise", winner(new BigInteger("1")));
        Assert.assertEquals("Louise", winner(new BigInteger("2")));
        Assert.assertEquals("Louise", winner(new BigInteger("3")));
        Assert.assertEquals("Richard", winner(new BigInteger("4")));
        Assert.assertEquals("Richard", winner(new BigInteger("6")));

        Assert.assertEquals(winner(new BigInteger("137438953472")), "Louise");
        Assert.assertEquals(winner(new BigInteger("17592186044416")), "Richard");
        Assert.assertEquals(winner(new BigInteger("12538990046817067955")), "Louise");
        Assert.assertEquals(winner(new BigInteger("8")), "Louise");
        Assert.assertEquals(winner(new BigInteger("10705863057888060538")), "Richard");
        Assert.assertEquals(winner(new BigInteger("5944858545393724888")), "Louise");


    }
}
