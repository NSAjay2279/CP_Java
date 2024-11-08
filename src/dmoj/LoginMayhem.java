package dmoj;

import java.util.Scanner;

public class LoginMayhem {
    private static final int MAX_USERS = 2;
    private static final int MAX_PASSWORD = 10;
    private static final char[][] users = new char[MAX_USERS][MAX_PASSWORD + 1];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] users = new char[MAX_USERS][MAX_PASSWORD + 1];
        int numOps = scanner.nextInt();
        int numUsers = 0;

        for (int op = 0; op < numOps; op++) {
            int opType = scanner.nextInt();
            String inputPassword = scanner.next();
            char[] password = inputPassword.toCharArray();

            if (opType == 1) {
                copyArray(users[numUsers], password);
                numUsers++;
            } else {
                int total = 0;
                for (int j = 0; j < numUsers; j++)
                    if (containsSubstring(users[j], password)) {
                        total++;
                    }
                System.out.println(total);
            }
        }
    }

    private static void copyArray(char[] destination, char[] source) {
        int i = 0;
        while (i < source.length && i < destination.length - 1) {
            destination[i] = source[i];
            i++;
        }
        destination[i] = '\0';
    }

    private static boolean containsSubstring(char[] userPassword, char[] searchPassword) {
        for (int i = 0; i <= userPassword.length - searchPassword.length; i++) {
            boolean match = true;
            for (int j = 0; j < searchPassword.length; j++) {
                if (userPassword[i + j] != searchPassword[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
