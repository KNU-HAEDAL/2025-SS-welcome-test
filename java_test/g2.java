package java_test;
import java.util.Scanner;

// 이부분에 class 선언 해도 괜찮습니다

public class g2 {

    static boolean isDigit(String str)
    {
        if(str.matches("^[0-9]*$"))
            return false;
        return true;
    }

    static boolean isDouble(String str)
    {
        if(str.matches("^[0-9]*[.]?[0-9]*$"))
            return false;
        return true;
    }

    static Book compareRating(Book A, Book B)
    {
        if(Double.parseDouble(A.rating) > Double.parseDouble(B.rating))
            return A;
        return B;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type, title;
        String price, other;
        String rating;
        Book[] Books = new Book[3];
        Book highestBook;

        for(int i = 0; i < 3; i++)
        {
            type = sc.nextLine();
            if(!type.equals("EBook") && !type.equals("PrintedBook"))
            {
                System.out.println("Invalid book type. Please enter 'EBook' or 'PrintedBook'.");
                i--;
                continue;
            }
            

            if(type == "EBook")
                Books[i] = new EBook();
            else
                Books[i] = new PrintedBook();

            title = sc.nextLine();

            price = sc.nextLine();
            if(isDigit(price))
            {
                System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
                i--;
                continue;
            }

            rating = sc.nextLine();
            if(isDouble(rating))
            {
                System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
                i--;
                continue;
            }

            other = sc.nextLine();
            if(isDigit(other))
            {
                System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
                i--;
                continue;
            }

            Books[i].title = title;
            Books[i].price = price;
            Books[i].rating = rating;
            Books[i].setOther(other);
        }
        highestBook = compareRating(compareRating(Books[0], Books[1]), Books[2]);
        System.out.println("Highest rated book information:");
        System.out.printf("Title: %s\n", highestBook.title);
        System.out.printf("Price: %s\n", highestBook.price);
        System.out.printf("Rating: %s\n", highestBook.rating);
        System.out.printf("%s: %s\n", highestBook.getType().equals("EBook")?"FileSize":"Page Count", highestBook.getOther());

        sc.close();
    }
}

class Book
{
    String title;
    String price;
    String rating;

    void setOther(String str){return;}
    String getOther(){return null;}
    String getType(){return null;}
}

class EBook extends Book
{
    String fileSize;

    void setOther(String str)
    {
        this.fileSize = str;
    }
    
    String getOther()
    {
        return this.fileSize;
    }

    String getType()
    {
        return "EBook";
    }
}

class PrintedBook extends Book
{
    String pageCount;

    void setOther(String str)
    {
        this.pageCount = str;
    }

    String getOther()
    {
        return this.pageCount;
    }

    String getType()
    {
        return "PrintedBook";
    }
}