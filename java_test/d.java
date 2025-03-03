package java_test;

import java.util.*;

public class d {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num <= 0)
            System.out.println("X");

        else {
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += i;
            }

            System.out.println(sum);
        }

        sc.close();

    }

}