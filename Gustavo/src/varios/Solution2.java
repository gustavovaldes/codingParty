package varios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        boolean exit = false;
        char[] word = "ab".toCharArray();
        int size = word.length;





        for (int i = size - 1; i >= 1; i--) {
            //if(exit) break;
            //for(int j= i-1; j>=i; j--){


            if (word[i - 1] < word[i]) {
                int x = selectMinimal(word[i-1],new String(word).substring(i))+i;
                char pivot = word[x];
                word[x] = word[i-1];
                word[i-1] = pivot;
                System.out.println(order(new String(word), i));
                exit = true;
                break;
                //  }
            }


        }

        if (!exit) {
            System.out.println("no answer");

        }
        exit = false;

    }

    public static int selectMinimal(char val, String word){
        char[] newWord = word.toCharArray();
        Arrays.sort(newWord);
        for (int i = 0; i < word.length(); i++) {
            if(val<newWord[i]){
                return word.indexOf(newWord[i]);
            }
        }
        return -1;
    }


    public static String order(String word, int index) {

        char[] newWord = word.substring(index).toCharArray();
        Arrays.sort(newWord);
        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(0, index));
        for (char c : newWord) {
            sb.append(c);
        }
        return sb.toString();
    }
}