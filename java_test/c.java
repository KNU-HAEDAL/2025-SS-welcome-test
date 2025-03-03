package java_test;

import java.util.Scanner;

public class c {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        int height = sc.nextInt();

        if (age >= 14 || height >= 155)
            System.out.println("X");

        else
            System.out.println("O");

        sc.close();
    }

}