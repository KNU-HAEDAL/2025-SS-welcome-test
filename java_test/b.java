package java_test;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toLowerCase();
        String vowels = "aeiou";
        
        boolean hasVowel = false;
        for (char c : word.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                hasVowel = true;
                break;
            }
        }
        
        System.out.println(hasVowel ? "O" : "X");
        scanner.close();
    }
}