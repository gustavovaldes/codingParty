/**
 * Created by Gustavo on 29-11-15.
 * Storage size: 999752
 ----------------
 Number of target values: 427
 APPROVED
 */


import java.io.IOException;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/*
 * The goal of this problem is to implement a variant of the 2-SUM algorithm (covered in the Week 6 lecture on hash table applications).
 * The file contains 1 million integers, both positive and negative (there might be some repetitions!).
 * This is your array of integers, with the ith row of the file specifying the ith entry of the array.
 * Your task is to compute the number of target values t in the interval [-10000,10000] (inclusive) such that there are distinct numbers x,y in the input file that satisfy x+y=t.
 *
 * NOTE: ensuring distinctnss requires a one-line addition to the algorithm from lecture.
 * Write your numeric answer (an integer between 0 and 20001) in the space provided.
 *
 * OPTIONAL CHALLENGE: If this problem is too easy for you, try implementing your own hash table for it.
 * For example, you could compare performance under the chaining and open addressing approaches to resolving collisions.
 */

public class TwoSum {
    private static final String FILE_NAME = "/Users/Gustavo/Cursos/AnalysisAlg1/algo2sum.txt";

    public static void main(String[] args) {
        int counter = 0;
        String workingDir = System.getProperty("user.dir"); // path to the root of the project

        try {
            long[] originalArray = AlgorithmsUtil.fileToLongArray( FILE_NAME);
            Map<Long, Integer> storage = new Hashtable<Long, Integer>();
            for (int i = 0; i < originalArray.length; i++) {
                if (storage.containsKey(originalArray[i])) {
                    int numberOfOccurrences = storage.get(originalArray[i]);
                    storage.remove(originalArray[i]);
                    storage.put(originalArray[i], ++numberOfOccurrences);
                } else {
                    storage.put(originalArray[i], 1);
                }
            }
            System.out.println("Storage size: " + storage.size());

            for (int j = -10000; j <= 10000; j++) {
                Set<Long> keySet = storage.keySet();
                Iterator<Long> iterator = keySet.iterator();
                while(iterator.hasNext()) {
                    Long x = iterator.next();
                    if (keySet.contains(j - x)) {
                        counter++;
                        break;
                    }
                }
            }

            System.out.println("----------------");
            System.out.println("Number of target values: " + counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}