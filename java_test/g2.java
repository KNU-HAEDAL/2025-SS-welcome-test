package java_test;

import java.util.*;

class Book {
    String title;
    int price;
    double rating;

    // getter
    public String gettitle(){
        return title;
    }
    public int getprice(){
        return price;
    }
    public double getrating(){
        return rating;
    }

    // setter
    public void settitle(String title){
        this.title = title;
    }
    public void setprice(int price){
        this.price = price;
    }
    public void setrating(double rating){
        this.rating = rating;
    }

    @Override
    public String toString(){
        return "Title: " + title + "\nPrice: " + price + "\nRating: " + rating;
    }


}

class EBook extends Book {
    int fileSize;

    public int getFileSize(){
        return fileSize;
    }
    public void setFileSize(int fileSize){
        this.fileSize = fileSize;
    }

    @Override
    public String toString(){
        return super.toString() + "\nFileSize: " + fileSize;
    }



}

class PrintedBook extends Book {
    int pageCount;
    public int getPageCount(){
        return pageCount;
    }
    public void setPageCount(int pageCount){
        this.pageCount = pageCount;
}

    @Override
    public String toString(){
        return super.toString() + "\nPage Count: " + pageCount;
    }
}
public class g2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 책을 담을 리스트 생성
        ArrayList<Book> books = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            while (true) {
                try {
                    String category = sc.nextLine();
                    if (!category.equals("EBook") && !category.equals("PrintedBook")) {
                        System.out.println("Invalid book type. Please enter 'EBook' or 'PrintedBook'.");
                        continue;
                    }

                    Book book;

                    if (category.equals("EBook")) {
                        book = new EBook();
                    } else book = new PrintedBook();

                    book.settitle(sc.nextLine());
                    book.setprice(Integer.parseInt(sc.nextLine()));
                    book.setrating(Double.parseDouble(sc.nextLine()));

                    // 다운캐스팅해서 코드 추가
                    if (book instanceof EBook) {
                        ((EBook) book).setFileSize(Integer.parseInt(sc.nextLine()));
                    } else {
                        ((PrintedBook) book).setPageCount(Integer.parseInt(sc.nextLine()));
                    }

                    // List에 입력받은 책 추가
                    books.add(book);
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");

                }
            }

        }
        sc.close();
        
        System.out.println("Highest rated book information:");
        Book max = Collections.max(books, Comparator.comparingDouble(Book::getrating));
        System.out.println(max);

    }
}
