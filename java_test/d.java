package java_test;

import java.util.Scanner;

public class d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;

        input = sc.nextInt();
        int answer=0;

        if(input>0){
            for(int i=1; i<=input; i++){
                answer += i;
            }
            System.out.println(answer);
        }
        else{
            System.out.println("X");
        }
        sc.close();
    }

}