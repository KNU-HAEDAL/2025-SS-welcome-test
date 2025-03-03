package java_test;
import java.util.Scanner;

public class e {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();
        int month = sc.nextInt();

        if(month == 4 | month == 6 || month == 9 || month == 11)
            System.out.println("30");
        else if(month == 2)
        {
            if(year % 4 == 0 && year % 100 != 0)
                System.out.println("29");
            else if(year % 400 == 0)
                System.out.println("29");
            else
                System.out.println("28");
        }
        else
            System.out.println("31");
        
        sc.close();
    }

}