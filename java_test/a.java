package java_test;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {

        int num;

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d", num % 10);
            num = num / 10;
        }

        sc.close();
    }

}