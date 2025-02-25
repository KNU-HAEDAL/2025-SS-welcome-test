package java_test;

import java.util.*;

// 이부분에 class 선언 해도 괜찮습니다

class Book {
    protected String title;
    protected int price;
    protected double rating;

    public Book(String title, int price, double rating) {
        this.title = title;
        this.price = price;
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public void showInfo() {
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Rating: " + rating);
    }
}

// 📖 종이책 (PrintedBook) 클래스
class PrintedBook extends Book {
    private int pageCount;

    public PrintedBook(String title, int price, double rating, int pageCount) {
        super(title, price, rating);
        this.pageCount = pageCount;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Page Count: " + pageCount);
    }
}

// 📱 전자책 (EBook) 클래스
class EBook extends Book {
    private int fileSize; // 단위: MB

    public EBook(String title, int price, double rating, int fileSize) {
        super(title, price, rating);
        this.fileSize = fileSize;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("File Size: " + fileSize + "MB");
    }
}

public class g2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        // System.out.println("Hello");

        // 3권의 책 정보 입력받기
        for (int i = 0; i < 3; i++) {
            try {
                String bookType = scanner.next(); // "EBook" 또는 "PrintedBook"
                scanner.nextLine(); // 버퍼 정리

                // 잘못된 책 종류 입력 처리
                if (!(bookType.equals("EBook") || bookType.equals("PrintedBook"))) {
                    throw new IllegalArgumentException("Invalid book type. Please enter 'EBook' or 'PrintedBook'.");
                }

                String title = scanner.nextLine(); // 책 제목 입력

                int price = scanner.nextInt(); // 가격 입력

                double rating = scanner.nextDouble(); // 평점 입력

                int extraInfo = scanner.nextInt(); // 파일 크기 또는 페이지 수 입력
                // scanner.nextLine(); // 버퍼 정리

                if (bookType.equals("EBook")) {
                    books.add(new EBook(title, price, rating, extraInfo));
                } else {
                    books.add(new PrintedBook(title, price, rating, extraInfo));
                }

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
                scanner.nextLine(); // 버퍼 비우기
                i--; // 다시 입력받도록 인덱스 감소
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--; // 다시 입력받도록 인덱스 감소
            }
        }

        books.sort(Comparator.comparingDouble(Book::getRating).reversed());

        // 결과 출력
        System.out.println("Highest rated book information:");
        books.get(0).showInfo();
    }
}
