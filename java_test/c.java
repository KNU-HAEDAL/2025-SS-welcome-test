package java_test;

import java.util.Scanner;

public class c {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int age, height;
        boolean avail = true;

        age = input.nextInt();
        height = input.nextInt();

        if(age >= 14 || height >= 155){
            avail = false;
        }

        if(avail){
            System.out.println("O");
        }else{
            System.out.println("X");
        }

        input.close();

    }

}