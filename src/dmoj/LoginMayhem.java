package dmoj;

import java.util.Scanner;

public class LoginMayhem {
    private static final int MAX_USERS = 10;
    private static final int MAX_PASSWORD = 10;
    private static final char[][] users = new char[MAX_USERS][MAX_PASSWORD + 1];

    public static void main(String[] args) {
        int num_ops, op, op_type, total, j;
        Scanner keyboard = new Scanner(System.in);
        char[] password = new char[MAX_PASSWORD + 1];
        int num_users = 0;
        num_ops = keyboard.nextInt();
        for (op = 0; op < num_ops; op++) {
            op_type = keyboard.nextInt();
            password = keyboard.nextLine().trim().toCharArray();

            if (op_type == 1) {
                int i = 0;
                int n = password.length;
                while(i < password.length) {
                    users[num_users][i] = password[i];
                    i++;
                }
                num_users++;
            } /* else {
                total = 0;
                for (j = 0; j < num_users; j++)
                    if (users[][j].contains(password[i])

            } */

        }
    }

}
