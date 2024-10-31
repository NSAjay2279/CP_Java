package dmoj;

import java.util.Scanner;

public class FoodLines {

    public static int shortestLinesIndex(int[] lines, int n) {
        int j;
        int shortest = 0;
        for (j = 1; j < n; j++)
            if (lines[j] < lines[shortest])
                shortest = j;
        return shortest;
    }

    public static void solve(int[] lines, int n, int m) {
        int i, shortest;
        for (i = 0; i < m; i++) {
            shortest = shortestLinesIndex(lines, n);
            System.out.println(lines[shortest]);
            lines[shortest]++;
        }
    }

    public static void main(String[] args) {
        int[] lines = new int[100];
        int n, m, i;
        Scanner keyboard = new Scanner(System.in);
        n = keyboard.nextInt();
        m = keyboard.nextInt();
        for (i = 0; i < n; i++)
            lines[i] = keyboard.nextInt();
        solve(lines, n, m);
    }
}