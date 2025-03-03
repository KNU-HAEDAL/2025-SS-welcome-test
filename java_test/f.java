package java_test;
import java.util.Scanner;

public class f {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int k=1;
        int j = N-1;
        int g=1;
        int t= 2*N-3;

        for(int i=0; i<N; i++,k=k+2,j--){
            System.out.print(" ".repeat(j));
            System.out.print("*".repeat(k));

            System.out.println();
        }
        for(int m=0; m<N-1; m++,g++,t=t-2){
            System.out.print(" ".repeat(g));
            System.out.print("*".repeat(t));
            System.out.println();
        }

        sc.close();
    }

}
