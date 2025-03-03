package java_test;

import java.util.Scanner;

public class d {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num, sum = 0;

        num = input.nextInt();
        if(num <= 0){
            System.out.println("X");
            input.close();
            return;
        }

        for(int i=1;i<=num;i++){
            sum = sum + i;
        }
        
        System.out.println(sum);

        input.close();
        
    }

}