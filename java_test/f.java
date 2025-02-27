package java_test;

import java.util.Scanner;

// 이부분에 class 선언 해도 괜찮습니다

public class f {
    public static void main(String[] args) {

        // 이 부분에 code를 작성해주세요!
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < n - i; ++j)
                System.out.print(' ');
            for (int j = 0; j < 2 * i - 1; ++j)
                System.out.print('*');
            System.out.println();
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j)
                System.out.print(' ');
            for (int j = 0; j < 2 * (n - i) - 1; ++j)
                System.out.print('*');
            System.out.println();
        }
    }

}
