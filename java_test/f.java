package java_test;

import java.util.Scanner;

public class f {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 상단 삼각형
        for (int i = 1; i <= N; i++) {
            printLine(N - i, 2 * i - 1);
        }

        // 하단 삼각형 (맨 위 줄 제외)
        for (int i = N - 1; i >= 1; i--) {
            printLine(N - i, 2 * i - 1);
        }

        scanner.close();
    }

    private static void printLine(int spaces, int stars) {
        for (int j = 0; j < spaces; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < stars; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}