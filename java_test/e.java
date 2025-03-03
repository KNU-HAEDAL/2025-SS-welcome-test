package java_test;

import java.util.Scanner;

public class e {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int year, month;

        year = input.nextInt();
        month = input.nextInt();

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println(30);

        } else if (month == 2) {
            boolean flag = isLeapYear(year);
            if (flag) {
                System.out.println(29);
            } else {
                System.out.println(28);
            }
        } else {
            System.out.println(31);
        }

        input.close();

    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {

            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return true;

            }

        }
        return false;
    }

}