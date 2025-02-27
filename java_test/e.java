package java_test;

import java.util.Scanner;

public class e {
    public static void main(String[] args) {

        // 이 부분에 code를 작성해주세요!
        var sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        sc.close();

        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                System.out.println(29);
            else
                System.out.println(28);
        } else {
            if (month == 4 || month == 6 || month == 9 || month == 11)
                System.out.println(30);
            else
                System.out.println(31);
        }
    }

}