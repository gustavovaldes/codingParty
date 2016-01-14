package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by gvaldes
 *
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast
 * ACCEPTED
 * A Decent Number has the following properties:

 Its digits can only be 3's and/or 5's.
 The number of 3's it contains is divisible by 5.
 The number of 5's it contains is divisible by 3.
 -1 if not possible.
 */
public class SherlockAndTheBeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();

            if (n % 3 == 0) {
                x = n;
            } else if (n >= 5 && (n - 5) % 3 == 0) {
                x = n - 5;
                y = 5;
            } else if (n >= 10 && (n - 10) % 3 == 0) {
                x = n - 10;
                y = 10;
            }
            print(x, y);
            x = 0;
            y = 0;

        }
    }

    private static void print(int x, int y) {
        System.out.println(calculate(x, y));
    }

    private static String calculate(int x, int y) {
        StringBuilder sb = new StringBuilder();
        if (x == 0 && y == 0) sb.append("-1");
        for (int i = 0; i < x; i++) {
            sb.append("5");
        }
        for (int i = 0; i < y; i++) {
            sb.append("3");
        }
        return sb.toString();
    }


    public static String execute(int n) {
        int x = 0;
        int y = 0;
        if (n % 3 == 0) {
            x = n;
        } else if (n >= 5 && (n - 5) % 3 == 0) {
            x = n - 5;
            y = 5;
        } else if (n >= 10 && (n - 10) % 3 == 0) {
            x = n - 10;
            y = 10;
        }
        return calculate(x, y);

    }

    @Test
    public void test() {
        Assert.assertEquals("-1", execute(1));
        Assert.assertEquals("555", execute(3));
        Assert.assertEquals("33333", execute(5));
        Assert.assertEquals("55555533333", execute(11));

    }
}

