package java_test;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str;
        boolean flag = false;

        str = input.nextLine();

        if (str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u")) {
            flag = true;
        }

        if (flag) {
            System.out.println("O");

        } else {
            System.out.println("X");
        }
        input.close();

    }

}