package varios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/gvaldes/Cursos/hackerRank/input01.txt");
        StringBuilder sb = new StringBuilder();
        Scanner sc=new Scanner(file);
        sc.next();

        boolean exit=false;
        while(sc.hasNext()){
            char[] word = sc.next().toCharArray();
            int size = word.length;
            int minimal = size-1;
            for (int i = size - 1; i >= 1; i--) {
                //if(exit) break;
                //for(int j= i-1; j>=i; j--){
                if (word[i - 1] < word[i]) {
                    int x = selectMinimal(word[i-1],new String(word).substring(i))+i;
                    char pivot = word[x];
                    word[x] = word[i - 1];
                    word[i - 1] = pivot;
                    sb.append(order(new String(word), i));
                    sb.append(System.getProperty("line.separator"));
                    exit = true;
                    break;
                    //  }
                }


            }
            if(!exit) {
                sb.append("no answer");
                sb.append(System.getProperty("line.separator"));
            }
            exit=false;

        }

        new FileWriter("/Users/gvaldes/Cursos/hackerRank/output3.txt").write(sb.toString());
    }

    public static int selectMinimal(char val, String word){
        char[] newWord = word.toCharArray();
        Arrays.sort(newWord);
        for (int i = 0; i < word.length(); i++) {
            if(val<newWord[i]){
                return i;
            }
        }
        return -1;
    }

    public static String order(String word, int index){

        char[] newWord = word.substring(index).toCharArray();
        Arrays.sort(newWord);
        StringBuilder sb =  new StringBuilder();
        sb.append(word.substring(0,index));
        for (char c : newWord) {
            sb.append(c);
        }
        return sb.toString();
    }
}