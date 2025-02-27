package java_test;
import java.util.*;

public class e {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int num1=sc.nextInt();
    	int num2=sc.nextInt();
    	
    	if(num2==4 || num2==6 || num2==9 || num2==11) {
    		System.out.println("30");
    	}else if(num1%4==0 && (num1%100!=0 || num1%400==0) && num2==2) {
    		System.out.println("29");
    	}else if(num2==2) {
    		System.out.println("28");
    	}else {
    		System.out.println("31");
    	}
    }
}