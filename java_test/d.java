package java_test;

import java.util.Scanner;

public class d {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("X");
        }
        else {
            int sum = 0;
            int i = 1;
            while (i <= n) {
                sum += i;
                i++;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}