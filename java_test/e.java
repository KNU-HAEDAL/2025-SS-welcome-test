package java_test;

import java.util.Scanner;

public class e {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year;
        int month;

        year = sc.nextInt();
        month = sc.nextInt();
        
        if((year%4==0 && year%100!=0) || year%400==0){
            if(month == 2){
                System.out.println("29");
                sc.close();
                return;
            }
        }

        switch(month){
            case 2:
                System.out.println("28");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30");
                break;
            default:
            System.out.println("Invalid month");
            break;
        }
        
        sc.close();
    }

}