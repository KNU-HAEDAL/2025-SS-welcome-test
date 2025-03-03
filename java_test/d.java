package java_test;
import java.util.Scanner;

public class d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        if(N <= 0)
            System.out.println("X");

        else
            System.out.printf("%d\n", (1+N)*N/2);
        

        sc.close();
    }

}