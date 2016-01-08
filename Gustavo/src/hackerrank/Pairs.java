package hackerrank;

/**
 * Created by guga
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * https://www.hackerrank.com/challenges/pairs
 * ACCEPTED
 * Given N integers, count the number of pairs of integers whose difference is K.
 *
 *
 * Solution:
 * 1.- sort first
 * 2.- avoid unnecesary iterations
 */
public class Pairs {
    static int pairs(int[] a, int k) {
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + k == a[j]) {
                    count++;
                    break;
                } else if (a[i] + k < a[j]) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String n = in.nextLine();
        String[] n_split = n.split(" ");

        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);

        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = pairs(_a, _k);
        System.out.println(res);
    }

    @Test
    public void test(){
        Assert.assertEquals(3, pairs(new int[]{1 ,5, 3, 4, 2, 100, 200, 300}, 2));
    }
}

