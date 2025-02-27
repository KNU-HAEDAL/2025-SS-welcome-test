package java_test;

import java.util.Scanner;

public class d {
    public static void main(String[] args) {

        // 이 부분에 code를 작성해주세요!
        var sc = new Scanner(System.in);
        long n = 0;
        n = sc.nextLong();
        sc.close();

        if (n < 1) {
            System.out.println('X');
            return;
        }

        System.out.println(n * (n + 1) / 2);
    }

}