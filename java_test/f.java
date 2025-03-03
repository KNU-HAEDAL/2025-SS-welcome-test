package java_test;
import java.util.Scanner;

public class f {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        Tree tree = new Tree(N);

        tree.print();

        sc.close();
    }

}

class Tree
{
    int N;
    public Tree(int N){
        this.N = N;
    }

    public void print()
    {
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N-i; j++)
                System.out.print(" ");
            for(int j = 1; j <= i; j++)
                System.out.print("*");
            for(int j = 1; j < i; j++)
                System.out.print("*");
            System.out.println();
        }

        for(int i = N-1; i > 0; i--)
        {
            for(int j = 1; j <= N-i; j++)
                System.out.print(" ");
            for(int j = 1; j <= i; j++)
                System.out.print("*");
            for(int j = 1; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
