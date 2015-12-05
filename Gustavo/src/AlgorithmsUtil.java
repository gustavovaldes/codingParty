/**
 * Created by Gustavo on 29-11-15.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class AlgorithmsUtil {

    public static int[] fileToIntArray(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> numbers = new ArrayList<Integer>();
        String line = null;
        int number;
        while ((line = bufferedReader.readLine()) != null) {
            number = Integer.parseInt(line);
            numbers.add(number);
        }
        bufferedReader.close();
        return ArrayUtils.toPrimitive(numbers.toArray(new Integer[numbers.size()]));
    }

    public static long[] fileToLongArray(String fileName) throws NumberFormatException, IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Long> numbers = new ArrayList<Long>();
        String line = null;
        long number;
        while ((line = bufferedReader.readLine()) != null) {
            number = Long.parseLong(line);
            numbers.add(number);
        }
        bufferedReader.close();
        return ArrayUtils.toPrimitive(numbers.toArray(new Long[numbers.size()]));
    }
}
