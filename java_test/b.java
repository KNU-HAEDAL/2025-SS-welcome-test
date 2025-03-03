package java_test;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        String str = new String();
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        
        if(str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u")){
            System.out.println("O");
        }
        else{
            System.out.println("X");
        }
        sc.close();
    }

}