package datastructures;

public class ArrayOperations {
    public static final int MAX = 5;

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
    }

}
