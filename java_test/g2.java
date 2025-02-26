package java_test;

import java.util.Scanner;

// 이부분에 class 선언 해도 괜찮습니다
abstract class Book {
    private String title;
    private int price;
    private double rating;

    public double getRating() {
        return rating;
    }

    public Book(String title, int price, double rating) {
        this.title = title;
        this.price = price;
        this.rating = rating;
    }

    public void printData() {
        System.out.println("Highest rated book information:");
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Rating: " + rating);
    }

    public Book compareHigherRating(Book other) {
        return rating < other.getRating() ? other : this;
    }
}

class EBook extends Book {
    private int fileSize;

    public EBook(String title, int price, double rating, int fileSize) {
        super(title, price, rating);
        this.fileSize = fileSize;
    }

    @Override
    public void printData() {
        super.printData();
        System.out.println("File Size: " + fileSize);
    }
}

class PrintedBook extends Book {
    private int pageCount;

    public PrintedBook(String title, int price, double rating, int pageCount) {
        super(title, price, rating);
        this.pageCount = pageCount;
    }

    @Override
    public void printData() {
        super.printData();
        System.out.println("Page Count: " + pageCount);
    }
}

class BookManager {
    Book highest;

    public void scanBook(Scanner input) {
        while (true) {
            String type = input.nextLine();

            if (!EBook.class.getSimpleName().equals(type) &&
                    !PrintedBook.class.getSimpleName().equals(type)) {
                System.out.println("Invalid book type. Please enter 'EBook' or 'PrintedBook'.");
                continue;
            }

            try {
                String title = input.nextLine();
                int price = Integer.parseInt(input.nextLine());
                double rating = Double.parseDouble(input.nextLine());
                int other = Integer.parseInt(input.nextLine());

                if (EBook.class.getSimpleName().equals(type))
                    this.compare(new EBook(title, price, rating, other));

                if (PrintedBook.class.getSimpleName().equals(type))
                    this.compare(new PrintedBook(title, price, rating, other));
                break;

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
                continue;
            }
        }
    }

    public Book getHighest() {
        return highest;
    }

    public void compare(Book book) {
        if (highest == null)
            highest = book;
        else
            highest = highest.compareHigherRating(book);
    }
}

public class g2 {
    public static void main(String[] args) {

        // 이 부분에 code를 작성해주세요!
        var sc = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        for (int i = 0; i < 3; ++i)
            bookManager.scanBook(sc);
        sc.close();
        bookManager.getHighest().printData();
    }

}