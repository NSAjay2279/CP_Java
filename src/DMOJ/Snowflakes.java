package DMOJ;

import java.util.*;

public class Snowflakes {

    static final int SIZE = 100000;

    public static class Snowflake_Node {
        int[] snowflake = new int[6];
        Snowflake_Node next;
    }

    public static int code(int[] snowflake) {
        return (snowflake[0] + snowflake[1] + snowflake[2]
                + snowflake[3] + snowflake[4] + snowflake[5]) % SIZE;
    }

    public static boolean identicalRight(int[] snow1, int[] snow2, int start) {
        for (int offset = 0; offset < 6; offset++) {
            if (snow1[offset] != snow2[(start + offset) % 6]) {
                return false;
            }
        }
        return true;
    }

    public static boolean identicalLeft(int[] snow1, int[] snow2, int start) {
        for (int offset = 0; offset < 6; offset++) {
            int snow2Index = (start - offset + 6) % 6;
            if (snow1[offset] != snow2[snow2Index]) {
                return false;
            }
        }
        return true;
    }

    public static boolean areIdentical(int[] snow1, int[] snow2) {
        for (int start = 0; start < 6; start++) {
            if (identicalRight(snow1, snow2, start) || identicalLeft(snow1, snow2, start)) {
                return true;
            }
        }
        return false;
    }

    public static void identifyIdentical(Snowflake_Node[] snowflakes) {
        for (int i = 0; i < SIZE; i++) {
            Snowflake_Node node1 = snowflakes[i];
            while (node1 != null) {
                Snowflake_Node node2 = node1.next;
                while (node2 != null) {
                    if (areIdentical(node1.snowflake, node2.snowflake)) {
                        System.out.println("Twin snowflakes found.");
                        return;
                    }
                    node2 = node2.next;
                }
                node1 = node1.next;
            }
        }
        System.out.println("No two snowflakes are alike.");
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Snowflake_Node[] snowflakes = new Snowflake_Node[SIZE];
        int n = keyboard.nextInt();
        for (int i = 0; i < n; i++) {
            Snowflake_Node snow = new Snowflake_Node();
            for (int j = 0; j < 6; j++) {
                snow.snowflake[j] = keyboard.nextInt();
            }
            int snowflakeCode = code(snow.snowflake);
            snow.next = snowflakes[snowflakeCode];
            snowflakes[snowflakeCode] = snow;
        }
        identifyIdentical(snowflakes);
        keyboard.close();
    }
}
