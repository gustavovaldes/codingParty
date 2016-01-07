package hackerrank;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
 * ACCEPTED
 *
 * You are given a 2D matrix, a, of dimension MxN and a positive integer R. You have to rotate the matrix R times
 * and print the resultant matrix. Rotation should be in anti-clockwise direction.
 */
public class MatrixRotation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        int rotations = sc.nextInt();
        int pivot = rotations;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int levels = (rows < cols) ? rows / 2 : cols / 2;

        for (int l = 0; l < levels; l++) {
            rotations = pivot % (2 * (rows - l * 2) + 2 * (cols - l * 2) - 4);
            for (int x = 0; x < (rotations); x++) {
                rotate(l, matrix, rows, cols);
            }
        }
        print(matrix);
    }

    private static void rotate(int level, int[][] matrix, int rows, int cols) {
        int initial = matrix[level][level];
        for (int i = level; i < cols - 1 - level; i++) {
            matrix[level][i] = matrix[level][i + 1];
        }
        for (int i = level; i < rows - 1 - level; i++) {
            matrix[i][cols - 1 - level] = matrix[i + 1][cols - 1 - level];
        }

        for (int i = cols - 1 - level; i > level; i--) {
            matrix[rows - 1 - level][i] = matrix[rows - 1 - level][i - 1];
        }

        for (int i = rows - 1 - level; i > level; i--) {
            matrix[i][level] = matrix[i - 1][level];
        }

        matrix[level + 1][level] = initial;
    }

    public static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

