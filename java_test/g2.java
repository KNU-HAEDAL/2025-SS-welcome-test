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
        System.out.println("���� ũ��: " + fileSize + "MB");
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
                System.out.print("å ����(EBook �Ǵ� PrintedBook): ");
                String bookType = scanner.nextLine().trim();

                // å ������ ��ȿ���� Ȯ��
                if (!(bookType.equals("EBook") || bookType.equals("PrintedBook"))) {
                    throw new IllegalArgumentException("Invalid book type. Please enter 'EBook' or 'PrintedBook'.");
                }

                System.out.print("����: ");
                String title = scanner.nextLine().trim();

                // ���� �Է� ó��
                System.out.print("����: ");
                int price = Integer.parseInt(scanner.nextLine().trim());
                if (price <= 0) {
                    throw new IllegalArgumentException("�߸��� �Է��Դϴ�. ������ 1 �̻��̾�� �մϴ�.");
                }

                // ���� �Է� ó��
                System.out.print("����: ");
                double rating = Double.parseDouble(scanner.nextLine().trim());
                if (rating < 0 || rating > 5) {
                    throw new IllegalArgumentException("�߸��� �Է��Դϴ�. ������ 0�� 5.0 ���̿��� �մϴ�.");
                }

                // �߰� ���� �Է� ó��
                System.out.print("�߰� ����: ");
                int additionalInfo = Integer.parseInt(scanner.nextLine().trim());
                if (additionalInfo <= 0) {
                    throw new IllegalArgumentException("�߸��� �Է��Դϴ�. �߰� ������ 1 �̻��̾�� �մϴ�.");
                }

                if (bookType.equals("EBook")) {
                    books[bookCount] = new EBook(title, price, rating, additionalInfo);
                } else {
                    books[bookCount] = new PrintedBook(title, price, rating, additionalInfo);
                }

                bookCount++;
            } catch (NumberFormatException e) {
                System.out.println("�߸��� �Է��Դϴ�. ó������ �ٽ� �Է��ϼ���.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // ������ ���� ���� å�� ã��
        Book highestRatedBook = books[0];
        for (int i = 1; i < books.length; i++) {
            if (books[i].getRating() > highestRatedBook.getRating()) {
                highestRatedBook = books[i];
            }
        }

        // ���� ���� ������ å ���� ���
        System.out.println("\nHighest rated book information:");
        highestRatedBook.printDetails();
        scanner.close();
    }
}