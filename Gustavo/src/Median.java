import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gustavo on 29-11-15.
 *
 * 1213
 * APPROVED
 */
public class Median {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("/Users/Gustavo/Cursos/AnalysisAlg1/Median.txt"));
        int[] array = new int[10000];
        int i = 0;
        while (s.hasNextLine()) {
            array[i] = Integer.parseInt(s.nextLine());
            i++;
        }
        int m = 0;
        long med = 0;
        for (int k = 0; k < array.length; k++) {
            //int k = 2;
            int temp[] = new int[k + 1];
            for (int j = 0; j <= k; j++) {
                temp[j] = array[j];
            }
            Arrays.sort(temp);
            if (k % 2 == 0) {
                m = k / 2;
            } else {
                m = (k - 1) / 2;
            }

            System.out.println("arrayIndex [" + k + "]: "+ array[k] +" , median index: " + m + " , median: " + array[m]);
            med = med + temp[m];
        }
        System.out.println(med % 10000);
    }
}
