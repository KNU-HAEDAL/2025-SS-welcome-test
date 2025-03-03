package java_test;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num, tmp;

        num = input.nextInt();

        while (true) {
            if(num == 0) break;

            tmp = num % 10;
            num = num / 10;
            System.out.print(tmp);
        }
        

        input.close();

    }

}