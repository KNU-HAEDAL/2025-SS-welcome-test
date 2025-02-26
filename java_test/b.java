package java_test;
import java.util.*;

public class b {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	String str=sc.nextLine();
    	String[] arr= {"a", "e", "i", "o", "u"};
    	
    	for(String s : arr) {
    		if(str.contains(s)) {
    			System.out.println("O");
    			System.exit(0);
    		}
    	}
    	System.out.println("X");
    }
}