package java_test;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        // 이 부분에 code를 작성해주세요!

        var sc = new Scanner(System.in);
        System.out.println(new StringBuilder(String.valueOf(sc.nextInt())).reverse());
        sc.close();
    }

}