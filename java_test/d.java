package java_test;
import java.util.*;

public class d {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	while(true) {
    		int num=sc.nextInt();
    		if(num<=0) {
    			System.out.println("X");
    			break;
    		}
    		System.out.println(num*(num+1)/2);
    		break;
    	}
    }
}