package java_test;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim(); // 문자열로 입력 받음
        
        // 문자열 뒤집기
        String reversed = new StringBuilder(input).reverse().toString();
        
        System.out.println(reversed); // 뒤집은 문자열 출력
        scanner.close();
    }
}