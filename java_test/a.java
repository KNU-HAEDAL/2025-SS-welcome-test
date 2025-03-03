package java_test;
import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        for(int i = str.length() - 1; i >= 0; i--)
        {
            System.out.printf("%c", str.charAt(i));
        }
        System.out.println();

        sc.close();
    }

}