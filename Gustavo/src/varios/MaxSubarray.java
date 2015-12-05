package varios;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;

/**
 * https://www.hackerrank.com/challenges/maxsubarray/copy-from/15400140
 * ACCEPTED
 */
public class MaxSubarray {

        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc =new Scanner(System.in);
            sc.nextLine();
            while(sc.hasNextLine()){
                int sum = 0;
                int maxSum = 0;
                int nonContinuous =0;
                int minPivot =0;
                sc.nextLine();
                String sequence = sc.nextLine();
                String[] values = sequence.split("\\s+");
                for(int i=0; i<values.length; i++){
                    int pivot = Integer.parseInt(values[i]);
                    if(pivot>0){
                        nonContinuous = nonContinuous + pivot;
                    }else{
                        if(i==0) minPivot = pivot;
                        if(minPivot<pivot){
                            minPivot=pivot;
                        }
                    }
                    sum=sum+pivot;
                    if(sum<=0){
                        sum=0;
                    }else{
                        if(sum>maxSum){
                            maxSum=sum;
                        }
                    }
                }
                System.out.print(maxSum>0?maxSum:minPivot);
                System.out.print(" ");
                System.out.println(nonContinuous>0?nonContinuous:minPivot);

            }
        }
    }