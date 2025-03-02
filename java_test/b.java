package java_test;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String word = sc.nextLine();

        for(char s : word.toCharArray()) {
            if("aeiou".indexOf(s) > 0){ // a 0 ~ u 4, 다른 문자는 -1반환
                flag = true;
                break;
            }
        }
    if(flag){
        System.out.print("O");
    }
    else System.out.print("X");
    
    sc.close();
    }
}