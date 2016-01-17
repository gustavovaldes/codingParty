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
import java.util.stream.Collectors;

/**
 *
 * https://www.hackerrank.com/challenges/pangrams
 * ACCEPTED
 *
 * Solution:
 * ascci a: 97
 * ascci z: 122
 * number of letters (english) 26
 * first sort, then remove duplicated. Just stop if reached 26 letters.
 */
public class Pangram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        if(isPagram(word)){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }
    }

    private static boolean isPagram(String word){
        char[] letras = word.toLowerCase().toCharArray();
        Arrays.sort(letras);
        Set<Character> letters = new HashSet<Character>();
        for (int i = 0; i < letras.length; i++) {
            if(letras[i]>= 97 && letras[i]<=122)
            letters.add(letras[i]);
            if(letters.size()==26) break;
        }
        if(letters.size()==26){
            return true;
        }else{
            return false;
        }
    }


    @Test
    public void test(){
        Assert.assertEquals(true , isPagram("We promptly judged antique ivory buckles for the next prize"));
        Assert.assertEquals(false , isPagram("We promptly judged antique ivory buckles for the next prie"));
    }
}