package java_test;
import java.util.*;

public class f {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int num=sc.nextInt(), p=1;
    	
    	for(int i=1, j=num-1; i>0 ;i+=p*2, j-=p) {
    		if(i>num*2) {
    			p*=-1;
    			i+=p*2; j-=p;
    			continue;
    		}
    		for(int k=0; k<j ;k++) System.out.print(" ");
    		for(int k=0; k<i ;k++) System.out.print("*");
    		System.out.println();
    	}
    }
}
