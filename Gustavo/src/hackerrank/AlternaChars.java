package hackerrank;

/**
 * Created by guga
 */

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AlternaChars {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String word = sc.nextLine();
            System.out.println(deleteCount(word));
        }
    }


    private static int deleteCount(String word){
        int count = 0;
        char[] letters = word.toCharArray();
        char last = letters[0];
        for (int j = 1; j < letters.length; j++) {
            if (letters[j - 1] == letters[j] && last == letters[j]) {
                count++;
            }
            last = letters[j];

        }
        return count;
    }

    @Test
    public void test(){
        Assert.assertEquals(3,deleteCount("AAAA"));
    }
}