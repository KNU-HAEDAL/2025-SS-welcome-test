package java_test;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        int output;
        Scanner sc = new Scanner(System.in);
        output = sc.nextInt();
        String s1 = Integer.toString(output%10);
        String s2 = Integer.toString((output%100)/10);
        String s3 = Integer.toString(output/100);

        System.out.println(s1+s2+s3);
        sc.close();
    }
}