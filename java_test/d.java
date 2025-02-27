package java_test;

import java.util.Scanner;

public class d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("X");
        } else {
            int sum = (n * (n + 1)) / 2;
            System.out.println(sum);
        }
        scanner.close();
    }
}