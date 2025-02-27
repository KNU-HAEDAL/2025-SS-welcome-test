package java_test;

import java.util.Scanner;

public class c {
    public static void main(String[] args) {

        // 이 부분에 code를 작성해주세요!
        var sc = new Scanner(System.in);

        var age = sc.nextInt();
        var height = sc.nextInt();
        sc.close();

        if (age >= 14 || height >= 155) {
            System.out.println('X');
            return;
        }

        System.out.println('O');
    }

}