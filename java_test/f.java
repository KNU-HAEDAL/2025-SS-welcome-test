package java_test;

import java.util.*;

public class f {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++)
                System.out.printf(" ");
            for (int j = 0; j < 1 + 2 * i; j++)
                System.out.printf("*");
            System.out.println();
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n - 1 - i; j++)
                System.out.printf(" ");
            for (int j = 0; j < 1 + 2 * i; j++)
                System.out.printf("*");
            System.out.println();
        }

        sc.close();

    }

}
