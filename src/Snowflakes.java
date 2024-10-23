import java.util.Scanner;

public class Snowflakes {
    static int[][] snowflakes = new int[100000][6];

    public static int identical_right(int[] snow1, int[] snow2, int start) {
        int offset;
        for (offset = 0; offset < 6; offset++) {
            if (snow1[offset] != snow2[(start + offset) % 6])
                return 0;
        }
        return 1;
    }

    public static int identical_left(int[] snow1, int[] snow2, int start) {
        int offset, snow2_index;
        for (offset = 0; offset < 6; offset++) {
            snow2_index = start - offset;
            if (snow2_index <= -1)
                snow2_index = snow2_index + 6;
            if (snow1[offset] != snow2[snow2_index])
                return 0;
        }
        return 1;
    }

    public static int are_identical(int[] snow1, int[] snow2) {
        int start;
        for (start = 0; start < 6; start++) {
            if (identical_right(snow1, snow2, start) == 1)
                return 1;
            if (identical_left(snow1, snow2, start) == 1)
                return 1;
        }
        return 0;
    }

    public static void identify_identical(int[][] snowflakes, int n) {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (are_identical(snowflakes[i], snowflakes[j]) == 1) {
                    System.out.println("Twin snowflakes found.");
                    return;
                }
            }
        }
        System.out.println("No two snowflakes are alike.");
    }

    public static void main(String[] args) {
        int n, i, j;
        Scanner keyboard = new Scanner(System.in);
        n = keyboard.nextInt();
        for (i = 0; i < n; i++)
            for (j = 0; j < 6; j++)
                snowflakes[i][j] = keyboard.nextInt();
        identify_identical(snowflakes, n);
        return;
    }
}

