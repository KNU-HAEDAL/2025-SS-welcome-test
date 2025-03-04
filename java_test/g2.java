package java_test;

import java.util.*;

class Book {
    public String title;
    public int price;
    public double rating;

    public void displayinfo() {
        System.out.println("Tilte: " + title);
        System.out.println("Price: " + price);
        System.out.println("Rating: " + rating);
    }
}

class EBook extends Book {
    public int fileSize;

    @Override
    public void displayinfo() {
        super.displayinfo();
        System.out.println("File Size: " + fileSize);
    }
}

class PrintedBook extends Book {
    public int pageCount;

    @Override
    public void displayinfo() {
        super.displayinfo();
        System.out.println("Page Count: " + pageCount);
    }
}

public class g2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[3];

        for (int i = 0; i < 3; i++) {

            try {
                String bookClass = sc.nextLine().trim();
                if (bookClass.equals("EBook")) {
                    books[i] = new EBook();
                    books[i].title = sc.nextLine();
                    books[i].price = sc.nextInt();
                    books[i].rating = sc.nextDouble();
                    ((EBook) books[i]).fileSize = sc.nextInt();
                    sc.nextLine();
                }

                else if (bookClass.equals("PrintedBook")) {
                    books[i] = new PrintedBook();
                    books[i].title = sc.nextLine();
                    books[i].price = sc.nextInt();
                    books[i].rating = sc.nextDouble();
                    ((PrintedBook) books[i]).pageCount = sc.nextInt();
                    sc.nextLine();
                }

                else {
                    System.out.println("Invalid book type. Please enter 'EBook' or 'PrintedBook'.");
                    // i--;
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.처음부터 다시 입력하세요.");
                sc.nextLine();
                i--;
            }

        }
        Book maxRatingbook = books[0];
        for (int i = 1; i < 3; i++) {
            if (maxRatingbook.rating < books[i].rating) {
                maxRatingbook = books[i];
            }
        }

        System.out.println();
        System.out.println("Highest rated book information:");
        maxRatingbook.displayinfo();

        sc.close();
    }
}