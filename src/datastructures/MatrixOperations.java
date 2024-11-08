package datastructures;

import java.util.Scanner;

public class MatrixOperations {

    public static final int MAX = 3;
    static Scanner keyboard = new Scanner(System.in);

    public static void transpose(int[][] m1, int[][] m2) {
        int i,j;
        for (i = 0; i < MAX; i++)
            for (j = 0; j < MAX; j++)
                m2[i][j] = m1[j][i];
    }

    public static void matrixMultiplication(int[][] m1, int[][] m2, int[][] m3) {
        int i,j,k;
        for (k = 0; k < MAX; k++)
            for ( i = 0; i < MAX; i++) {
                m3[k][i] = 0;
                for (j = 0; j < MAX; j++)
                    m3[k][i] += m1[k][j] * m2[j][i];
            }
    }

    public static void matAdd(int[][] m1, int[][] m2, int[][] m3) {
        int i,j;
        for (i = 0; i < MAX; i++)
            for (j = 0; j < MAX; j++)
                m3[i][j] = m1[i][j] + m2[i][j];
    }

    public static void display(int[][] mat) {
        int i,j;
        for (i = 0; i < MAX; i++) {
            for (j = 0; j < MAX; j++)
                System.out.print(mat[i][j] + "\t");
            System.out.println();
        }
    }

    public static void createList(int[][] mat) {
        int i, j;
        for (i = 0; i < MAX; i++)
            for (j = 0; j < MAX; j++) {
                System.out.print("Enter the elements: ");
                mat[i][j] = keyboard.nextInt();
            }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] mat1 = new int[3][3];
        int[][] mat2 = new int[3][3];
        int[][] mat3 = new int[3][3];
        int[][] mat4 = new int[3][3];
        int[][] mat5 = new int[3][3];
        System.out.println("Enter elements for first array:");
        createList(mat1);
        System.out.println("Enter elements for second array:");
        createList(mat2);
        System.out.println("First Array:");
        display(mat1);
        System.out.println("Second Array:");
        display(mat1);
        matAdd(mat1, mat2, mat3) ;
        System.out.println( "After Addition:");
        display(mat3);
        matrixMultiplication(mat1, mat2, mat4);
        System.out.println( "After Multiplication:");
        display(mat4);
        transpose(mat1, mat5);
        System.out.println("Transpose of first matrix:");
        display(mat5);
    }
}
