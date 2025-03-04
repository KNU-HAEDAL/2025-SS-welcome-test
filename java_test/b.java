package java_test;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if (str.indexOf("a") != -1) {
            System.out.println("O");
        }

        else if (str.indexOf("e") != -1) {
            System.out.println("O");
        }

        else if (str.indexOf("i") != -1) {
            System.out.println("O");
        }

        else if (str.indexOf("o") != -1) {
            System.out.println("O");
        }

        else if (str.indexOf("u") != -1) {
            System.out.println("O");
        }

        else {
            System.out.println("X");
        }

        sc.close();
    }

}