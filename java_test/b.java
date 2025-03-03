package java_test;
import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = {"a", "e", "i", "o", "u"};
        boolean check = false;

        String str = sc.nextLine();

        for(int i = 0; i < arr.length; i++)
        {
            if(str.contains(arr[i]))
            {
                check = true;
                break;
            }
        }
        
        System.out.printf("%c\n",check? 'O':'X');
        sc.close();
    }

}