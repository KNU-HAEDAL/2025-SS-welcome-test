package java_test;

import java.util.Scanner;

class Book {
    protected String title;
    protected int price;
    protected double rating;

    public Book(String title, int price, double rating) {
        this.title = title;
        this.price = price;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Rating: " + rating);
    }
}

class EBook extends Book {
    private int fileSize;

    public EBook(String title, int price, double rating, int fileSize) {
        super(title, price, rating);
        this.fileSize = fileSize;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("파일 크기: " + fileSize + "MB");
    }
}

class PrintedBook extends Book {
    private int pageCount;

    public PrintedBook(String title, int price, double rating, int pageCount) {
        super(title, price, rating);
        this.pageCount = pageCount;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Page Count: " + pageCount );
    }
}

public class g2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[3];
        int bookCount = 0;

        while (bookCount < 3) {
            try {
                System.out.print("책 종류(EBook 또는 PrintedBook): ");
                String bookType = scanner.nextLine().trim();

                // 책 종류가 유효한지 확인
                if (!(bookType.equals("EBook") || bookType.equals("PrintedBook"))) {
                    throw new IllegalArgumentException("Invalid book type. Please enter 'EBook' or 'PrintedBook'.");
                }

                System.out.print("제목: ");
                String title = scanner.nextLine().trim();

                // 가격 입력 처리
                System.out.print("가격: ");
                int price = Integer.parseInt(scanner.nextLine().trim());
                if (price <= 0) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 가격은 1 이상이어야 합니다.");
                }

                // 평점 입력 처리
                System.out.print("평점: ");
                double rating = Double.parseDouble(scanner.nextLine().trim());
                if (rating < 0 || rating > 5) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 평점은 0과 5.0 사이여야 합니다.");
                }

                // 추가 정보 입력 처리
                System.out.print("추가 정보: ");
                int additionalInfo = Integer.parseInt(scanner.nextLine().trim());
                if (additionalInfo <= 0) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 추가 정보는 1 이상이어야 합니다.");
                }

                if (bookType.equals("EBook")) {
                    books[bookCount] = new EBook(title, price, rating, additionalInfo);
                } else {
                    books[bookCount] = new PrintedBook(title, price, rating, additionalInfo);
                }

                bookCount++;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // 평점이 가장 높은 책을 찾기
        Book highestRatedBook = books[0];
        for (int i = 1; i < books.length; i++) {
            if (books[i].getRating() > highestRatedBook.getRating()) {
                highestRatedBook = books[i];
            }
        }

        // 가장 높은 평점의 책 정보 출력
        System.out.println("\nHighest rated book information:");
        highestRatedBook.printDetails();
        scanner.close();
    }
}