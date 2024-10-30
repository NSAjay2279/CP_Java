package datastructures;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ArrayOperations {
    public static final int MAX = 5;

    public static void search(int[] arr, int num) {
        int i;
        for (i = 0; i < MAX; i++)
            if (arr[i] == num)
                System.out.println("Element " + num + " is at " + (i + 1) + "th position");
    }

    public static void reverse(int[] arr) {
        int i;
        for (i = 0; i < MAX/2; i++) {
            int temp = arr[i];
            arr[i] = arr[MAX-1-i];
            arr[MAX-1-i] = temp;
        }
    }

    public static void del(int[] arr, int pos) {
        arr[pos-1] = 0;
    }

    public static void display(int[] arr) {
        int i;
        for (i = 0; i < MAX; i++)
            System.out.print(arr[i] + "\t");
        System.out.println();
    }


    public static void insert(int[] arr, int pos, int num) {
        arr[pos-1] = num;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{90, 54, 23, 25, 76};
        insert(arr, 1, 11);
        insert(arr, 2, 12);
        insert ( arr, 3, 13 ) ;
        insert ( arr, 4, 14 ) ;
        insert ( arr, 5, 15 ) ;
        System.out.println("Elements of Array:");
        display(arr);
        del(arr, 5);
        reverse(arr);
        System.out.println("After reversing");
        display(arr);
        search(arr, 0);
        search(arr, 11);
    }

}
