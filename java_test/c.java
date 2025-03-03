package java_test;
import java.util.Scanner;

public class c {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        
        int age = sr.nextInt();
        int height = sr.nextInt();
        boolean isPossible = true;

        if(age >= 14 || height >= 155)
            isPossible = false;

        System.out.printf("%c\n", isPossible? 'O':'X');

        sr.close();
    }

}