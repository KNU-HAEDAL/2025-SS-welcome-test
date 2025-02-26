package java_test;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {

        // 이 부분에 code를 작성해주세요!
        var sc = new Scanner(System.in);
        for (char t : sc.nextLine().toCharArray()) {
            if (t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u') {
                System.out.println('O');
                sc.close();
                return;
            }
        }
        System.out.println('X');
        sc.close();
    }

}